package com.huaweisoft.training;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.huaweisoft.training.dao.UnionQueryMapper;
import com.huaweisoft.training.entity.Student;
import com.huaweisoft.training.entity.UnionQuery;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class TestUnionQuery {
    
    private static final Logger log = Logger.getLogger(TestMybatis.class);

    @Autowired
    private UnionQueryMapper unionQueryMapper;
    
    /*查询选修了全部课程的学生信息 */
    @Test
    public void testfindByStudnetInfo() {
        
        List<Student> stuInfo = unionQueryMapper.findstudentInfo();
        if(stuInfo != null){
            for(Student stu :stuInfo){
                log.info(JSON.toJSONString(stu,true));
            }  
        }     
        
    }
    
    /*根据学生的id查询学生选修的课程，每个课程的成绩以及每门课程的任课老师*/
    @Test
    public void testfindByStudnetId() {
        
        UnionQuery stuInfo = unionQueryMapper.findByStudnetId(1);
        if(stuInfo != null){
            log.info(JSON.toJSONString(stuInfo,true));
        }     
        
    }
    
    /*根据学生的id查询学生选修的课程，所有课程的成绩*/
    @Test
    public void testfindById() {
        
        UnionQuery stuInfo = unionQueryMapper.findByStudnetId2(2);
        if(stuInfo != null){
            log.info(JSON.toJSONString(stuInfo,true));
        }     
        
    }
    
    /*查询课程编号为01且课程成绩在80分以上的学生的所有信息和课程成绩*/
    @Test
    public void testfindById3() {
        
        List<UnionQuery> stuInfo2 = unionQueryMapper.findByStudnetId3(2,60);
        if(stuInfo2 != null){
            for(UnionQuery st :stuInfo2){
                log.info(JSON.toJSONString(st,true));
            }  
        }     
        
    }
    
    /*根据某个学生的名字查询某个课程的成绩*/
    @Test
    public void testfindstudyByName() {
        
        UnionQuery stuInfo1 = unionQueryMapper.findstudyByName("赵雷","数学");
        if(stuInfo1 != null){
            log.info(JSON.toJSONString(stuInfo1,true));
        }     
        
    }
    
    /*根据学生的id查询学生的所有信息和所选修的课程*/
    @Test
    public void testfindById6() {
        
        List<UnionQuery> stuInfo2 = unionQueryMapper.findByStudnetId4(2);
        if(stuInfo2 != null){
            for(UnionQuery st :stuInfo2){
                log.info(JSON.toJSONString(st,true));
            }  
        }     
        
    }
    
}
