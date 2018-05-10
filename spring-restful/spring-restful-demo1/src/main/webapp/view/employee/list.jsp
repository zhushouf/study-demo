<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		<table class="searchContent">
			<tr>
				<td>
					员工姓名：<input type="text" name="employeeName" />
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="<%=request.getContextPath()%>/employee/add" target="dialog"><span>添加</span></a></li>
			<li><a class="delete" href="<%=request.getContextPath()%>/employee/delete?id={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="<%=request.getContextPath()%>/employee/edit?id={sid_user}" target="dialog"><span>修改</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="80">员工ID</th>
				<th width="100">员工姓名</th>
				<th width="100">性别</th>
				<th width="100">联系电话</th>
				<th width="100">出生日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${list}" varStatus="status">
				<tr target="sid_user" rel="${item.id}">
					<td>${item.id}</td>  
					<td>${item.name}</td>
					<td>
						<c:if test="${item.gender eq 1}">男</c:if>
						<c:if test="${item.gender eq 2}">女</c:if>
					</td>
					<td>${item.phone}</td>
					<td>
						<fmt:formatDate value="${item.birthday}" pattern="yyyy-MM-dd" />
					</td>
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
			</select>
			<span>条，共${totalCount}条</span>
		</div>
		<div class="pagination" targetType="navTab" totalCount="10" numPerPage="20" pageNumShown="10" currentPage="1"></div>
	</div>
</div>

</body>
</html>