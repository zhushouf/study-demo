package com.huaweisoft.training.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.huaweisoft.training.common.JsonResult;
import com.huaweisoft.training.entity.Employee;

@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private final Logger log = Logger.getLogger(EmployeeController.class);

	/**
	 * 跳转员工添加页面
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addEmployee() {
		log.info("跳转员工添加页面");

		return "employee/add";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getEmployee(@RequestParam("id") Integer id, Model model) {
		log.info("跳转员工编辑页面");

		Map<Integer, Employee> map = new HashMap<Integer, Employee>();
		try {
			map.put(1, new Employee(1, "张三", 1, "13625645875", new SimpleDateFormat("yyyy-MM-dd").parse("1990-09-12")));
			map.put(2, new Employee(2, "李四", 2, "13598654585", new SimpleDateFormat("yyyy-MM-dd").parse("1995-01-15")));
		} catch (ParseException e) {
			log.error("日期转换异常");
		}

		// 从模拟数据取值并返回
		Employee employee = map.get(id);
		if (employee != null) {
			// 设置在model返回给页面
			model.addAttribute("employee", employee);
		}

		return "employee/edit";
	}

	@RequestMapping(value = "/get_list")
	public String getEmployeeList(Model model) {
		log.info("进入员工列表信息查询");

		// 模拟数据返回
		List<Employee> list = new ArrayList<Employee>();
		try {
			list.add(new Employee(1, "张三", 1, "13625645875", new SimpleDateFormat("yyyy-MM-dd").parse("1990-09-12")));
			list.add(new Employee(2, "李四", 2, "13598654585", new SimpleDateFormat("yyyy-MM-dd").parse("1995-01-15")));
		} catch (ParseException e) {
			log.error("日期转换异常");
		}
		// 设置在model返回给页面
		model.addAttribute("list", list);

		return "employee/list";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult saveEmployee(@RequestParam("id") Integer id, @RequestParam("name") String name,
			@RequestParam("gender") Integer gender, @RequestParam("phone") String phone,
			@RequestParam("birthday") String birthday) {
		log.info("进入员工信息保存");

		log.info("id=" + id);
		log.info("name=" + name);
		log.info("gender=" + gender);
		log.info("phone=" + phone);
		log.info("birthday=" + birthday);

		return JsonResult.success("保存成功");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult deleteEmployee(@RequestParam("id") Integer id) {
		log.info("进入员工信息删除");

		log.info("id=" + id);

		return JsonResult.success("删除成功");
	}
}
