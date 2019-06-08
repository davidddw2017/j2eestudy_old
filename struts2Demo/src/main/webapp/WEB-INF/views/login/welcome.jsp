<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title><s:text name="succPage" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
  <s:text name="succTip">
    <s:param>${sessionScope.user}</s:param>
  </s:text>
  <br />
</body>
</html>