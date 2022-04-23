package com.qqjl.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qqjl.reggie.entity.Setmeal;
import org.apache.ibatis.annotations.Mapper;


/**
 * 套餐(Setmeal)表数据库访问层
 *
 * @author QQJL
 * @since 2022-04-20 20:14:13
 */
@Mapper
public interface SetmealMapper extends BaseMapper<Setmeal> {

}
