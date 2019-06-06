<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:useBean id="command" class="org.cloud.springmvcDemo.model.User" scope="request" ></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="loginPage"/></title>
</head>
<body>
  <a href="?lang=zh_CN"><spring:message code="language.cn" /></a>
  <a href="?lang=ja_JP"><spring:message code="language.ja" /></a>
  <a href="?lang=en_US"><spring:message code="language.en" /></a>
  <br />
  <form:form method="post" action="login">
    <table>
      <tr>
        <td><spring:message code="user" />:</td>
        <td><form:input path="username" /></td>
      </tr>
      <tr>
        <td><spring:message code="pass" />:</td>
        <td><form:password path="password" /></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="<spring:message code="login" />" /></td>
      </tr>
    </table>
  </form:form>
</body>
</html>