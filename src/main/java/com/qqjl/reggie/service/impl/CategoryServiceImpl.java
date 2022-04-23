package com.qqjl.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qqjl.reggie.common.CustomException;
import com.qqjl.reggie.common.R;
import com.qqjl.reggie.entity.Category;
import com.qqjl.reggie.entity.Dish;
import com.qqjl.reggie.entity.Setmeal;
import com.qqjl.reggie.mapper.CategoryMapper;
import com.qqjl.reggie.service.CategoryService;
import com.qqjl.reggie.service.DishService;
import com.qqjl.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author QQJL
 * @since 2022/4/20 19:37
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;

    @Override
    public R<String> saveCategory(Category category) {
        save(category);
        return R.success("新增分类成功");
    }

    @Override
    public R<Page> pageCategory(int page, int pageSize) {
        Page<Category> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Category::getSort);
        page(pageInfo, queryWrapper);
        return R.success(pageInfo);
    }

    @Override
    public R<String> deleteCategory(Long id) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, id);
        int count = dishService.count(dishLambdaQueryWrapper);
        if (count > 0) {
            throw new CustomException("当前分类下关联了菜品，不能删除");
        }

        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
        int setmealCount = setmealService.count(setmealLambdaQueryWrapper);
        if (setmealCount > 0) {
            throw new CustomException("当前分类下关联了套餐，不能删除");
        }
        removeById(id);
        return R.success("删除分类成功");
    }

    @Override
    public R<String> updateCategory(Category category) {
        updateById(category);
        return R.success("更新分类成功");
    }

    @Override
    public R<List<Category>> listCategory(Category category) {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(category.getType() != null, Category::getType, category.getType());
        queryWrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);
        List<Category> list = list(queryWrapper);
        return R.success(list);
    }


}
