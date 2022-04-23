package com.qqjl.reggie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qqjl.reggie.common.R;
import com.qqjl.reggie.entity.Category;

import java.util.List;

/**
 * @author QQJL
 * @since 2022/4/20 19:36
 */
public interface CategoryService extends IService<Category> {
    R<String> saveCategory(Category category);

    R<Page> pageCategory(int page, int pageSize);

    R<String> deleteCategory(Long id);

    R<String> updateCategory(Category category);

    R<List<Category>> listCategory(Category category);
}
