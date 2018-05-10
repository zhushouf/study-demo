package com.huaweisoft.entity;

import java.util.Date;

/**
 * 考勤
 */
public class Attendance {

	private Integer id; // 考勤ID
	private Integer employeeId; // 员工ID
	private Date workDate; // 工作日期
	private Date arrivalTime; // 上班时间
	private Date leaveTime; // 下班时间	
	
	public Attendance() {
        super();
    }
	
    public Attendance(Integer id, Integer employeeId, Date workDate, Date arrivalTime, Date leaveTime) {
        super();
        this.id = id;
        this.employeeId = employeeId;
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

}