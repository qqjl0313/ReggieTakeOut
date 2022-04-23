package com.qqjl.reggie.entity;

import java.time.LocalDateTime;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 菜品口味关系表(DishFlavor)表实体类
 *
 * @author QQJL
 * @since 2022-04-22 15:36:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("dish_flavor")
public class DishFlavor implements Serializable {

    private static final long serialVersionUID = 1L;

    //主键
    private Long id;
    //菜品
    private Long dishId;
    //口味名称
    private String name;
    //口味数据list
    private String value;
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
    //是否删除
    private Integer isDeleted;
}
