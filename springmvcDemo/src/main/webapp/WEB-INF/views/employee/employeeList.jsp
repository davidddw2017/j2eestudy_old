<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/employee/preSave">添加学生</a>
<table>
	<tr>
		<th>编号</th>
		<th>姓名</th>
		<th>地址</th>
		<th>年龄</th>
		<th>操作</th>
	</tr>
	<c:forEach var="employee" items="${employeeList}">
	<tr>
		<td>${employee.id }</td>
		<td>${employee.name }</td>
		<td>${employee.address }</td>
		<td>${employee.age }</td>
		<td><a href="${pageContext.request.contextPath}/employee/preSave?id=${employee.id }">修改学生</a>|
		<a href="${pageContext.request.contextPath}/employee/delete?id=${employee.id }">刪除学生</a></td>
	</tr>
	</c:forEach>
</table>

</body>
</html>