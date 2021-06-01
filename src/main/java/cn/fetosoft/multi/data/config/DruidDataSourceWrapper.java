package cn.fetosoft.multi.data.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 用于替代Druid-starter中的DruidDataSourceWrapper
 * 便于将公共的连接池配置传进来
 * @author guobingbing
 * @version 1.0
 * @wechat t_gbinb
 * @create 2021/3/23 11:09
 */
public class DruidDataSourceWrapper extends DruidDataSource implements InitializingBean {

	private DruidConfig druidConfig;
	private DbConfig dbConfig;

	public DruidDataSourceWrapper(DbConfig dbConfig, DruidConfig druidConfig){
		this.dbConfig = dbConfig;
		this.druidConfig = druidConfig;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		//if not found prefix 'spring.datasource.druid' jdbc properties ,'spring.datasource' prefix jdbc properties will be used.
		if (super.getUsername() == null) {
			super.setUsername(dbConfig.getUsername());
		}
		if (super.getPassword() == null) {
			super.setPassword(dbConfig.getPassword());
		}
		if (super.getUrl() == null) {
			super.setUrl(dbConfig.getUrl());
		}
		if (super.getDriverClassName() == null) {
			super.setDriverClassName(dbConfig.getDriverClassName());
		}
		if(druidConfig!=null){
			this.setInitialSize(druidConfig.getInitialSize());
			this.setMaxActive(druidConfig.getMaxActive());
			this.setMinIdle(druidConfig.getMinIdle());
			this.setMaxWait(druidConfig.getMaxWait());
			this.setTimeBetweenEvictionRunsMillis(druidConfig.getTimeBetweenEvictionRunsMillis());
			this.setMinEvictableIdleTimeMillis(druidConfig.getMinEvictableIdleTimeMillis());
			this.setValidationQuery(druidConfig.getValidationQuery());
			this.setTestWhileIdle(druidConfig.isTestWhileIdle());
			this.setTestOnBorrow(druidConfig.isTestOnBorrow());
			this.setTestOnReturn(druidConfig.isTestOnReturn());
			this.setPoolPreparedStatements(druidConfig.isPoolPreparedStatements());
			this.setMaxPoolPreparedStatementPerConnectionSize(druidConfig.getMaxPoolPreparedStatementPerConnectionSize());
			this.setFilters(druidConfig.getFilters());
		}
	}

	@Autowired(required = false)
	public void autoAddFilters(List<Filter> filters){
		super.filters.addAll(filters);
	}

	/**
	 * Ignore the 'maxEvictableIdleTimeMillis < minEvictableIdleTimeMillis' validate,
	 * it will be validated again in {@link DruidDataSource#init()}.
	 *
	 * for fix issue #3084, #2763
	 *
	 * @since 1.1.14
	 */
	@Override
	public void setMaxEvictableIdleTimeMillis(long maxEvictableIdleTimeMillis) {
		try {
			super.setMaxEvictableIdleTimeMillis(maxEvictableIdleTimeMillis);
		} catch (IllegalArgumentException ignore) {
			super.maxEvictableIdleTimeMillis = maxEvictableIdleTimeMillis;
		}
	}
}
