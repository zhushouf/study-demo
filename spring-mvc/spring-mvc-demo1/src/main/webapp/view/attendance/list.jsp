<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>员工列表页</title>
</head>
<body>

<form id="pagerForm" method="post" action="<%=request.getContextPath()%>/employee/get_list">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
</form>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="<%=request.getContextPath()%>/employee/get_list" method="post" onreset="$(this).find('select.combox').comboxReset()">
	<div class="searchBar">
		<!--<ul class="searchContent">
			<li>
				<label>我的客户：</label>
				<input type="text"/>
			</li>
			<li>
			<select class="combox" name="province">
				<option value="">所有省市</option>
				<option value="北京">北京</option>
				<option value="上海">上海</option>
				<option value="天津">天津</option>
				<option value="重庆">重庆</option>
				<option value="广东">广东</option>
			</select>
			</li>
		</ul>
		-->
		<table class="searchContent">
			<tr>
				<td>
					我的客户：<input type="text" name="keyword" />
				</td>
			</tr>
		</table>
		<!-- <div class="subBar">
			<ul>
				<li><div class="button"><div class="buttonContent"><button type="reset">重置</button></div></div></li>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
				<li><a class="button" href="demo_page6.html" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
			</ul>
		</div> -->
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="<%=request.getContextPath()%>/attendance/add" target="dialog"><span>添加</span></a></li>
			<li><a class="delete" href="<%=request.getContextPath()%>/attendance/delete?id={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="<%=request.getContextPath()%>/attendance/edit?id={sid_user}" target="dialog"><span>修改</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<!-- <th width="80"></th> -->
				<th width="120">考勤号</th>
				<th width="80">员工编号</th>
				<th width="80">工作日期</th>
				<th width="80">上班时间</th>
				<th width="80">下班时间</th>
				<!-- <th width="100"></th> -->
			</tr>
		</thead>
		<tbody>
			 <c:forEach var="item" items="${list}" varStatus="status">
				<tr target="sid_user" rel="${item.id}">
					<td>${item.id}</td>  
					<td>${item.employeeId	}</td>		
					<td>${item.workDate}</td>
					<td>${item.arrivalTime}</td>
					<td>${item.leaveTime}</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="20">20</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="150">150</option>
				<option value="200">200</option>
				<option value="250">250</option>
			</select>
			<span>条，共${totalCount}条</span>
		</div>

		<div class="pagination" targetType="navTab" totalCount="200" numPerPage="20" pageNumShown="10" currentPage="1"></div>

	</div>
</div>

</body>
</html>