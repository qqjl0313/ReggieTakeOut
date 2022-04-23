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
 * 套餐(Setmeal)表实体类
 *
 * @author QQJL
 * @since 2022-04-20 20:14:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("setmeal")
public class Setmeal implements Serializable {

    private static final long serialVersionUID = 1L;

    //主键
    private Long id;
    //菜品分类id
    private Long categoryId;
    //套餐名称
    private String name;
    //套餐价格
    private Double price;
    //状态 0:停用 1:启用
    private Integer status;
    //编码
    private String code;
    //描述信息
    private String description;
    //图片
    private String image;
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
