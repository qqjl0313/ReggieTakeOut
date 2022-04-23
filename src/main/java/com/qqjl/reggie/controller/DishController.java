package com.qqjl.reggie.controller;

import com.qqjl.reggie.common.R;
import com.qqjl.reggie.dto.DishDto;
import com.qqjl.reggie.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author QQJL
 * @since 2022/4/22 15:40
 */
@RestController
@RequestMapping("/dish")
public class DishController {

    @Autowired
    private DishService dishService;

    /**
     * 新增菜品同时保存对应的口味
     */
    @PostMapping
    public R<String> save(@RequestBody DishDto dishDto) {
        return dishService.saveDishWithFlavor(dishDto);
    }
}
