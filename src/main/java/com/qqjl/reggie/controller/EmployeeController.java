package com.qqjl.reggie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qqjl.reggie.common.R;
import com.qqjl.reggie.entity.Employee;
import com.qqjl.reggie.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author QQJL
 * @since 2022/4/20 12:43
 */
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 员工登录
     */
    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee) {
        return employeeService.login(request, employee);
    }

    /**
     * 员工退出登录
     */
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        return employeeService.logout(request);
    }

    /**
     * 添加员工
     */
    @PostMapping
    public R<String> save(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    /**
     * 员工信息分页查询
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name) {
        return employeeService.pageEmployee(page, pageSize, name);
    }

    /**
     * 根据id修改员工信息
     */
    @PutMapping
    public R<String> update(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @GetMapping("/{id}")
    public R<Employee> getById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }
}
