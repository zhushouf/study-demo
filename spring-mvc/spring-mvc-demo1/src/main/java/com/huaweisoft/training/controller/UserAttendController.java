package com.huaweisoft.training.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.huaweisoft.training.common.JsonResult;
import com.huaweisoft.training.dto.request.UserAttendReq;
import com.huaweisoft.training.entity.Attendance;
import com.huaweisoft.training.entity.Employee;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
@RequestMapping("/attendance")
public class UserAttendController {

    private final Logger logger =  Logger.getLogger(UserAttendController.class);
    
    @RequestMapping(value = "/get" , method = RequestMethod.GET)
    public String getAttendance(){
        logger.info("进入员工考勤详细信息查询!");
        return "attendance/list";
    }
    
    @RequestMapping(value = "/get_list" , method = RequestMethod.GET)
    public String getAttendanceList(Model model) throws ParseException{
        logger.info("进入员工考勤信息列表查询!");
     // 模拟数据返回
        List<Attendance> list = new ArrayList<Attendance>();
        list.add(new Attendance(1,1, "2018-04-18","08:01:25","17:59:25"));
        list.add(new Attendance(2,2,"2018-04-18","08:01:25","17:59:25"));
        // 设置在model返回给页面
        model.addAttribute("list", list);

        return "attendance/list";
    }
    
    
    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public JsonResult saveAttendance(@RequestParam("id") Integer id, @RequestParam("username") String username,
                    @RequestParam("workDate") Integer workDate, @RequestParam("arrivalTime") String arrivalTime,
                    @RequestParam("leaveTime") String leaveTime){
      logger.info("保存员工考勤信息!");

      logger.info("id=" + id);
      logger.info("username=" + username);
      logger.info("workDate=" + workDate);
      logger.info("arrivalTime=" + arrivalTime);
      logger.info("leaveTime=" + leaveTime);
      
      return JsonResult.success("保存成功");
    }
    
    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public String addAttendance(){
     
        logger.info("进入添加员工考勤信息!");
        return "attendance/add";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult deleteEmployee(@RequestParam("id") Integer id) {
        logger.info("员工考勤信息删除");

        logger.info("id=" + id);

        return JsonResult.success("删除成功");
    }
    

    @RequestMapping(value = "edit" , method = RequestMethod.GET)
    public String updateAttendance(){
        logger.info("更新员工考勤信息!");
        return "attendance/edit";
    }
    
}
