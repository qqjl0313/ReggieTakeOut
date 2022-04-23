package com.qqjl.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qqjl.reggie.common.R;
import com.qqjl.reggie.dto.DishDto;
import com.qqjl.reggie.entity.Dish;
import com.qqjl.reggie.entity.DishFlavor;
import com.qqjl.reggie.mapper.DishMapper;
import com.qqjl.reggie.service.DishFlavorService;
import com.qqjl.reggie.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 菜品管理(Dish)表服务实现类
 *
 * @author QQJL
 * @since 2022-04-20 20:12:38
 */
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

    @Autowired
    private DishFlavorService dishFlavorService;

    /**
     * 新增菜品，同时保存对应的口味数据
     */
    @Override
    @Transactional
    public R<String> saveDishWithFlavor(DishDto dishDto) {
        save(dishDto);

        Long dishId = dishDto.getId();
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors = flavors.stream().map(item -> {
            item.setDishId(dishId);
            return item;
        }).collect(Collectors.toList());
        dishFlavorService.saveBatch(flavors);
        return R.success("新增菜品成功");
    }
}
