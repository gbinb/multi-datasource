package cn.fetosoft.multi.data.dbthree;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author guobingbing
 * @version 1.0
 * @wechat t_gbinb
 * @create 2021/6/1 14:50
 */
@Mapper
public interface TbThreeMapper {

	TbThree selectByPrimaryKey(Integer id);
}
