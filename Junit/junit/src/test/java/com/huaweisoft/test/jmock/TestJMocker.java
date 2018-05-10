package com.huaweisoft.test.jmock;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Assert;
import org.junit.Test;

import com.huaweisoft.UserResource;
import com.huaweisoft.UserService;

public class TestJMocker {

    @Test
    public void testMocker(){
        
        Mockery content = new Mockery();
        final UserService userService = content.mock(UserService.class);
        
        content.checking(new Expectations(){
            {
                oneOf(userService).getAddress(5);
                will(returnValue("GZ"));
                
                oneOf(userService).getAddress(6);
                will(returnValue("FS"));
           
            }
        });
        
        UserResource resource = new UserResource();
        resource.setUserService(userService);
        
        assertEquals("GZ",resource.getAddressById(5));
        assertEquals("FS",resource.getAddressById(6));
    }
    
}
