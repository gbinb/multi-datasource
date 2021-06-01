package cn.fetosoft.multi.data.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * dbone datasource
 * @author guobingbing
 * @version 1.0
 * @wechat t_gbinb
 * @create 2021/6/1 13:52
 */
@Configuration
@MapperScan(basePackages = {"cn.fetosoft.multi.data.dbtwo"},
		sqlSessionFactoryRef = "dbtwoSqlSessionFactory")
public class DbtwoDatasourceConfig {

	@Autowired
	private DruidConfig druidConfig;

	/**
	 * 数据源配置
	 * @return
	 */
	@Bean(name = "dbtwoConfig")
	@ConfigurationProperties(prefix = "spring.datasource.dbtwo")
	public DbConfig buildDbConfig(){
		return new DbConfig();
	}

	/**
	 * 系统数据源
	 * @return
	 */
	@Bean(name = "dbtwoDataSource")
	public DruidDataSource sysDataSource(@Qualifier("dbtwoConfig") DbConfig dbConfig){
		return new DruidDataSourceWrapper(dbConfig, druidConfig);
	}

	/**
	 * 创建SqlSessionFactory
	 * @return
	 * @throws Exception
	 */
	@Bean("dbtwoSqlSessionFactory")
	public SqlSessionFactory buildSqlSessionFactory(@Qualifier("dbtwoDataSource") DruidDataSource dataSource) throws Exception{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
		factoryBean.setMapperLocations(patternResolver.getResources("classpath:cn/fetosoft/multi/data/mapper/dbtwo/*.xml"));
		factoryBean.setConfigLocation(patternResolver.getResource("classpath:mybatis-config.xml"));
		return factoryBean.getObject();
	}
}
