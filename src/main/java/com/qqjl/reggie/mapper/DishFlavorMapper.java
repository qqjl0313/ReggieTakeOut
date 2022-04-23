package com.qqjl.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qqjl.reggie.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;


/**
 * 菜品口味关系表(DishFlavor)表数据库访问层
 *
 * @author QQJL
 * @since 2022-04-22 15:35:59
 */
@Mapper
public interface DishFlavorMapper extends BaseMapper<DishFlavor> {

}
