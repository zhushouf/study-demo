package com.huaweisoft.training;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huaweisoft.training.dao.TeacherMapper;
import com.huaweisoft.training.entity.Teacher;
import com.huaweisoft.training.entity.TeacherExample;
import com.huaweisoft.training.entity.TeacherExample.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class TestMybatis {

	private static final Logger log = Logger.getLogger(TestMybatis.class);

	@Autowired
	private TeacherMapper teacherMapper;

	@Test
	public void test1() {
		Teacher teacher = teacherMapper.selectByPrimaryKey(1);
		if (teacher != null) {
			log.info(JSON.toJSONString(teacher, true));
		}
	}

	/**
	 * 按查询条件
	 */
	@Test
	public void test2() {
		TeacherExample example = new TeacherExample();
		Criteria criteria = example.createCriteria();
		criteria.andTIdEqualTo(1);
		criteria.andTNameLike("张%");
		List<Teacher> list = teacherMapper.selectByExample(example);
		if (list != null) {
			log.info(JSON.toJSONString(list, true));
		}
	}

	/**
	 * 分页插件
	 */
	@Test
	public void test3() {
		int pageNum = 2;
		int pageSize = 2;
		PageHelper.startPage(pageNum, pageSize);

		TeacherExample example = new TeacherExample();
		List<Teacher> list = teacherMapper.selectByExample(example);
		if (list != null) {
			log.info(JSON.toJSONString(list, true));
		}
		
		PageInfo<Teacher> info = new PageInfo<>(list);
		log.info(JSON.toJSONString(info, true));
	}

	@Test
	public void test4() {
		Teacher teacher = teacherMapper.selectByPrimaryKey(1);
		if (teacher != null) {
			log.info(JSON.toJSONString(teacher, true));
		}
	}
}
