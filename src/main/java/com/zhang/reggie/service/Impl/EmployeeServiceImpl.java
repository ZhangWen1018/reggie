package com.zhang.reggie.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.reggie.entity.Employee;
import com.zhang.reggie.mapper.EmployeeMapper;
import com.zhang.reggie.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @author ZhangLi
 * @version 1.0
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
