package com.qqjl.reggie.dto;

import com.qqjl.reggie.entity.Dish;
import com.qqjl.reggie.entity.DishFlavor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author QQJL
 * @since 2022/4/22 21:11
 */
@Data
public class DishDto extends Dish {
    private List<DishFlavor> flavors = new ArrayList<>();
    private String categoryName;
    private Integer copies;
}
