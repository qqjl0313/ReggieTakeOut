package com.qqjl.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qqjl.reggie.common.R;
import com.qqjl.reggie.service.EmployeeService;
import com.qqjl.reggie.entity.Employee;
import com.qqjl.reggie.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author QQJL
 * @since 2022/4/20 12:41
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Override
    public R<Employee> login(HttpServletRequest request, Employee employee) {
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername, employee.getUsername());
        Employee emp = getOne(queryWrapper);
        if (ObjectUtils.isEmpty(emp)) {
            return R.error("用户名不存在");
        }
        if (!emp.getPassword().equals(password)) {
            return R.error("密码错误");
        }
        if (emp.getStatus() == 0) {
            return R.error("账号已禁用");
        }
        request.getSession().setAttribute("employee", emp.getId());
        return R.success(emp);
    }

    @Override
    public R<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("employee");
        return R.success("退出成功");
    }

    @Override
    public R<String> saveEmployee(Employee employee) {
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));

        save(employee);
        return R.success("新增员工成功");
    }

    @Override
    public R<Page> pageEmployee(int page, int pageSize, String name) {
        Page<Employee> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(name), Employee::getName, name);
        queryWrapper.orderByDesc(Employee::getUpdateTime);
        page(pageInfo, queryWrapper);
        return R.success(pageInfo);
    }

    @Override
    public R<String> updateEmployee(Employee employee) {

        updateById(employee);

        return R.success("员工信息修改成功");
    }

    @Override
    public R<Employee> getEmployeeById(Long id) {
        Employee employee = getById(id);
        if (ObjectUtils.isNotEmpty(employee)) {
            return R.success(employee);
        }
        return R.error("该员工信息不存在");
    }

}
