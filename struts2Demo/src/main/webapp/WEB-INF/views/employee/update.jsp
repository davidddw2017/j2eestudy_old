<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更改学生</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/employee/save" method="post">
<table>
	<tr>
		<th colspan="2"></th>
	</tr>
	<tr>
		<td>姓名</td>
		<td><input type="text" name="name" value="${employee.name}"/></td>
	</tr>
	<tr>
		<td>住址</td>
		<td><input type="text" name="address" value="${employee.address}"/></td>
	</tr>
	<tr>
		<td>年龄</td>
		<td><input type="text" name="age" value="${employee.age}" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="hidden" name="id" value="${employee.id}" />
			<input type="submit" value="提交">
		</td>
	</tr>
</table>
</form>
</body>
</html>