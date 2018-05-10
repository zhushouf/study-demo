<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function dialogAjaxDone(response) {
		alertMsg.correct(response.msg);
		$.pdialog.closeCurrent();
		navTab.reload("<%=request.getContextPath()%>/attendance/get_list", "");
	}
</script>
<body>
		<div class="pageContent">
		<form method="post" action="<%=request.getContextPath()%>/attendance/save" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)">
			<div class="pageFormContent" layoutH="58">
				<div class="unit">
					<label>考勤号：</label>
					<input type="text" name="id" size="30" class="required" />
				</div>
				<div class="unit">
					<label>员工编号：</label>
					<input type="text" name="employeeId" size="30" class="required"/>
				</div>
				<div class="unit">
					<label>员工姓名：</label>
					<input type="text" name="username" size="30" class="required"/>
				</div>			
				<div class="unit">
					<label>上班日期：</label>
					<input type="text" name="workDate" size="30" class="required"/>
				</div>
				<div class="unit">
					<label>上班时间：</label>
					<input type="text" name="arrivalTime" size="30" class="required"/>
				</div>
				<div class="unit">
					<label>下班时间：</label>
					<input type="text" name="leaveTime" size="30" class="required"/>
				</div>
			</div>
			<div class="formBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
					<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
				</ul>
			</div>
		</form>
	</div>
</body>
</html>