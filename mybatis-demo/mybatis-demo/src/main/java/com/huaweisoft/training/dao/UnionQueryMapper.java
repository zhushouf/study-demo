package com.huaweisoft.training.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huaweisoft.training.entity.Student;
import com.huaweisoft.training.entity.UnionQuery;

public interface UnionQueryMapper {
    
    public List<Student> findstudentInfo();
    
    public UnionQuery findByStudnetId(int id);
    
    public UnionQuery findByStudnetId2(int id);
    
    public List<UnionQuery> findByStudnetId3(@Param("cid")int cid,@Param("score")int score);
    
    public UnionQuery findstudyByName(@Param("name")String name,@Param("cname")String cname);
    
    public List<UnionQuery> findByStudnetId4(int id);
    
    
}
