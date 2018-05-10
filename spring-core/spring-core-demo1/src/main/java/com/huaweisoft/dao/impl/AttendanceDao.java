package com.huaweisoft.dao.impl;

import java.util.List;

import com.huaweisoft.dao.BaseDao;
import com.huaweisoft.entity.Attendance;

/**
 * 考勤
 */
public class AttendanceDao implements BaseDao<Attendance> {

    private BaseDao baseDao;
    
    @Override
    public void insert(Attendance object) {
        baseDao.insert(object);
    }

    @Override
    public int update(Attendance object) {
        return baseDao.update(object);
    }

    @Override
    public int deleteById(Object id) {
        return baseDao.deleteById(id);
    }

    @Override
    public Attendance getOne(int id) {
        return (Attendance) baseDao.getOne(id);
    }

    @Override
    public List<Attendance> getAll() {
        return baseDao.getAll();
    }

}