package cn.fetosoft;

import cn.fetosoft.multi.data.dbone.TbOne;
import cn.fetosoft.multi.data.dbone.TbOneMapper;
import cn.fetosoft.multi.data.dbthree.TbThree;
import cn.fetosoft.multi.data.dbthree.TbThreeMapper;
import cn.fetosoft.multi.data.dbtwo.TbTwo;
import cn.fetosoft.multi.data.dbtwo.TbTwoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * @author guobingbing
 * @version 1.0
 * @wechat t_gbinb
 * @create 2021/6/1 14:17
 */
@SpringBootApplication
public class ApplicationStart implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationStart.class);
	@Autowired
	private TbOneMapper tbOneMapper;
	@Autowired
	private TbTwoMapper tbTwoMapper;
	@Autowired
	private TbThreeMapper tbThreeMapper;

	@Override
	public void run(String... args) throws Exception {
		TbOne tbOne = tbOneMapper.selectByPrimaryKey(1);
		logger.info(tbOne.getName());

		TbTwo tbTwo = tbTwoMapper.selectByPrimaryKey(1);
		logger.info(tbTwo.getName());

		TbThree tbThree = tbThreeMapper.selectByPrimaryKey(1);
		logger.info(tbThree.getName());
	}

	public static void main(String[] args) {
		SpringApplication.run(ApplicationStart.class, args);
		logger.info("The server is start!!!");
	}
}
