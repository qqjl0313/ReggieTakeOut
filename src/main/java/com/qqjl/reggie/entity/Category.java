package com.qqjl.reggie.entity;

import java.time.LocalDateTime;
import java.util.Date;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 菜品及套餐分类(Category)表实体类
 *
 * @author QQJL
 * @since 2022-04-20 19:32:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    //主键
    private Long id;
    //类型   1 菜品分类 2 套餐分类
    private Integer type;
    //分类名称
    private String name;
    //顺序
    private Integer sort;
    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    //更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    //创建人
    @TableField(fill = FieldFill.INSERT)
    private Long createUser;
    //修改人
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;
}
