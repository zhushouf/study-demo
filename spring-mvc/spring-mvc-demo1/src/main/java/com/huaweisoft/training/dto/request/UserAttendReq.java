package com.huaweisoft.training.dto.request;

import java.util.Date;

public class UserAttendReq {

    private Integer id; // 考勤ID
    private Integer employeeId; // 员工ID
    private String username;
    private Date workDate; // 工作日期
    private Date arrivalTime; // 上班时间
    private Date leaveTime; // 下班时间       
    
    public UserAttendReq() {
        super();
    }
        
    public UserAttendReq(Integer id, Integer employeeId,String username, Date workDate, Date arrivalTime, Date leaveTime) {
        super();
        this.id = id;
        this.employeeId = employeeId;
        this.username =  username;
        this.workDate = workDate;
        this.arrivalTime = arrivalTime;
        this.leaveTime = leaveTime;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
    public Date getWorkDate() {
        return workDate;
    }
    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }
    public Date getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public Date getLeaveTime() {
        return leaveTime;
    }
    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
}
