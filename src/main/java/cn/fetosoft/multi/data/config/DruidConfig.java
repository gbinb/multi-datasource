package cn.fetosoft.multi.data.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author guobingbing
 * @version 1.0
 * @wechat t_gbinb
 * @create 2021/3/23 14:10
 */
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DruidConfig {

	private String driverClassName;
	private int initialSize = 5;
	private int maxActive = 100;
	private int minIdle = 5;
	private long maxWait = 60000;
	private long timeBetweenEvictionRunsMillis = 60000;
	private long minEvictableIdleTimeMillis = 300000;
	private String validationQuery = "SELECT 'x'";
	private boolean testWhileIdle = true;
	private boolean testOnBorrow = false;
	private boolean testOnReturn = false;
	private boolean poolPreparedStatements = true;
	private int maxPoolPreparedStatementPerConnectionSize = 30;
	private String filters = "stat";
}
