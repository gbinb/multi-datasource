package cn.fetosoft.multi.data.config;

import lombok.Getter;
import lombok.Setter;

/**
 * 数据源配置
 * @author guobingbing
 * @version 1.0
 * @wechat t_gbinb
 * @create 2021/3/23 10:52
 */
@Setter
@Getter
public class DbConfig {

	private String url;
	private String username;
	private String password;
}
