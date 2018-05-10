package com.huaweisoft.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaweisoft.dao.impl.EmployeeDao;
import com.huaweisoft.entity.Employee;
import com.huaweisoft.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void insert(Employee object) {
        employeeDao.insert(object);
    }

    @Override
    public int update(Employee object) {
        return employeeDao.update(object);
    }

    @Override
    public int deleteById(Object id) {
        return employeeDao.deleteById(id);
    }
    
    @Override
    public List<Employee> getPage(int pageNo, int pageSize) {
        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee(1, "张三", 1, "13612345678", new Date()));
        return list;
    }

	
}
