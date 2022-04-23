package com.qqjl.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qqjl.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author QQJL
 * @since 2022/4/20 12:39
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
