package cn.fetosoft.multi.data.dbtwo;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author guobingbing
 * @version 1.0
 * @wechat t_gbinb
 * @create 2021/6/1 14:34
 */
@Mapper
public interface TbTwoMapper {

	TbTwo selectByPrimaryKey(Integer id);
}
