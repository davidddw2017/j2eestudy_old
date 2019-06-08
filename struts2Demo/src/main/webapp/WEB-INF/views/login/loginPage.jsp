<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><s:text name="loginPage" /></title>
</head>
<body>
  <a href="loginPage?request_locale=zh_CN"><s:text name="language.cn"/></a>
  <a href="loginPage?request_locale=ja_JP"><s:text name="language.ja"/></a>
  <a href="loginPage?request_locale=en_US"><s:text name="language.en"/></a>
  <br />
  <s:form action="login">
    <s:textfield name="username" key="user" />
    <s:password name="password" key="pass" />
    <s:submit name="" key="login" />
  </s:form>
</body>
</html>