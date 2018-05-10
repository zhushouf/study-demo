package com.huaweisoft.service;

import java.util.List;

import com.huaweisoft.entity.Employee;

public interface EmployeeService {

    public void insert(Employee object);

    public int update(Employee object);

    public int deleteById(Object id);	
    
    List<Employee> getPage(int pageNo, int pageSize);
}
