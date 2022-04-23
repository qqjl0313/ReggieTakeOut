package com.qqjl.reggie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qqjl.reggie.common.R;
import com.qqjl.reggie.entity.Employee;

import javax.servlet.http.HttpServletRequest;

/**
 * @author QQJL
 * @since 2022/4/20 12:40
 */
public interface EmployeeService extends IService<Employee> {
    R<Employee> login(HttpServletRequest request, Employee employee);

    R<String> logout(HttpServletRequest request);

    R<String> saveEmployee(Employee employee);

    R<Page> pageEmployee(int page, int pageSize, String name);

    R<String> updateEmployee(Employee employee);

    R<Employee> getEmployeeById(Long id);
}
