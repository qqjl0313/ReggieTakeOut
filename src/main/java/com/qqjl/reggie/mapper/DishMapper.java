package com.qqjl.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qqjl.reggie.entity.Dish;
import org.apache.ibatis.annotations.Mapper;


/**
 * 菜品管理(Dish)表数据库访问层
 *
 * @author QQJL
 * @since 2022-04-20 20:12:38
 */
@Mapper
public interface DishMapper extends BaseMapper<Dish> {

}
