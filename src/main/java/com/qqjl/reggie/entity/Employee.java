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
 * 员工信息(Employee)表实体类
 *
 * @author QQJL
 * @since 2022-04-20 12:19:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    //主键
    private Long id;
    //姓名
    private String name;
    //用户名
    private String username;
    //密码
    private String password;
    //手机号
    private String phone;
    //性别
    private String sex;
    //身份证号
    private String idNumber;
    //状态 0:禁用，1:正常
    private Integer status;
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
