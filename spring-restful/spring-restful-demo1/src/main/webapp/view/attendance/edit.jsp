<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>员工考勤信息编辑</title>
</head>
<body>
	<div class="pageContent">
		<form method="post" action="<%=request.getContextPath()%>/attendance/save" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)">
			<div class="pageFormContent" layoutH="58">
				<div class="unit">
					<label>考勤号：</label>
					<input type="text" name="id" size="30" class="required" value="${attendence.id}" />
				</div>
				<div class="unit">
					<label>员工编号：</label>
					<input type="text" name="name" size="30" class="required" value="${attendence.employeeId}" />
				</div>
				
				<div class="unit">
					<label>工作日期：</label>
					<input type="text" name="phone" size="30" class="required" value="${attendence.workDate}" />
				</div>
				<div class="unit">
					<label>上班时间：</label>
					<input type="text" name="phone" size="30" class="required" value="${attendence.arrivalTime}" />
				</div>
				<div class="unit">
					<label>下班时间：</label>
					<input type="text" name="phone" size="30" class="required" value="${attendence.leaveTime}" />
				</div>
				
			</div>
			<div class="formBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
					<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
				</ul>
			</div>
		</form>
</body>
</html>