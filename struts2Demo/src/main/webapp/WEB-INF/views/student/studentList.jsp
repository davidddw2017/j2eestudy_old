<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/student/preSave">添加学生</a>
<table>
	<tr>
		<th>编号</th>
		<th>姓名</th>
		<th>地址</th>
		<th>年龄</th>
		<th>操作</th>
	</tr>
	<c:forEach var="student" items="${studentList}">
	<tr>
		<td>${student.id }</td>
		<td>${student.name }</td>
		<td>${student.address }</td>
		<td>${student.age }</td>
		<td><a href="${pageContext.request.contextPath}/student/preSave?id=${student.id }">修改学生</a>|
		<a href="${pageContext.request.contextPath}/student/delete?id=${student.id }">刪除学生</a></td>
	</tr>
	</c:forEach>
</table>

</body>
</html>