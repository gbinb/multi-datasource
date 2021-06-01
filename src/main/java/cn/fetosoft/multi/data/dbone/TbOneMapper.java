package cn.fetosoft.multi.data.dbone;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author guobingbing
 * @version 1.0
 * @wechat t_gbinb
 * @create 2021/6/1 14:05
 */
@Mapper
public interface TbOneMapper {

	TbOne selectByPrimaryKey(Integer id);
}
