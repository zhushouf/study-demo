package com.huaweisoft.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.huaweisoft.dao.BaseDao;
import com.huaweisoft.entity.Employee;

/**
 * 员工
 */
public class EmployeeDao implements BaseDao<Employee> {

    @Autowired
    private BaseDao baseDao;
    
    @Override
    public void insert(Employee object) {
        baseDao.insert(object);
    }
    
    @Override
    public int update(Employee object) {
        return baseDao.update(object);
    }

    @Override
    public int deleteById(Object id) {
        return baseDao.deleteById(id);
    }

    @Override
    public Employee getOne(int id) {
        return (Employee) baseDao.getOne(id);
    }

    @Override
    public List<Employee> getAll() {
        return baseDao.getAll();
    }

	
}
