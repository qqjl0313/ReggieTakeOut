package com.qqjl.reggie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qqjl.reggie.common.R;
import com.qqjl.reggie.entity.Category;
import com.qqjl.reggie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author QQJL
 * @since 2022/4/20 19:38
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 新增分类
     */
    @PostMapping
    public R<String> save(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    /**
     * 分页查询
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize) {
        return categoryService.pageCategory(page, pageSize);
    }

    /**
     * 根据id删除分类
     */
    @DeleteMapping
    public R<String> delete(Long id) {
        return categoryService.deleteCategory(id);
    }

    /**
     * 根据id修改分类信息
     */
    @PutMapping
    public R<String> update(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    /**
     * 根据条件查询分类数据
     */
    @GetMapping("/list")
    public R<List<Category>> list(Category category) {
        return categoryService.listCategory(category);
    }
}
