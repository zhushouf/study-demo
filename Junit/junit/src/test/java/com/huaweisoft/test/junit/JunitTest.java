package com.huaweisoft.test.junit;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Junit单元测试
 * @author zhusf
 *
 */
public class JunitTest {

    @Before
    public void testFirstName(){
        System.out.println("朱");
    }
    
    @Test
    public void testDate(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMDD");
        System.out.println(sdf.format(date));
    }
    
    @After
    public void testLastName(){
        System.out.println("寿丰");
    }
    
}
