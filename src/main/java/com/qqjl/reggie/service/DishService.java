package com.qqjl.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qqjl.reggie.common.R;
import com.qqjl.reggie.dto.DishDto;
import com.qqjl.reggie.entity.Dish;


/**
 * 菜品管理(Dish)表服务接口
 *
 * @author QQJL
 * @since 2022-04-20 20:12:38
 */
public interface DishService extends IService<Dish> {

    R<String> saveDishWithFlavor(DishDto dishDto);
}
