package com.huaweisoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huaweisoft.entity.Employee;
import com.huaweisoft.service.EmployeeService;
import com.huaweisoft.service.impl.EmployeeServiceImpl;

@Controller
public class EmployeeController {

    @Autowired
	private EmployeeService employeeService = new EmployeeServiceImpl();

    @GetMapping("/employee/updateEmployeeInfo")
    public String updateEmployeeInfo(Employee employee){
        
        int count = employeeService.update(employee);
        
        return "";
    }
    
	@GetMapping("/employee/get_list")
	public void getManuList() {

	}
//
//	@PostMapping("/employee/get_list")
//	public void getManuLiqst() {
//
//	}
//
//	@PostMapping("/employee/get_list")
//	public void getManuList() {
//
//	}
//
//	@PostMapping("/employee/get_list")
//	public void getManuList() {
//
//	}
}
