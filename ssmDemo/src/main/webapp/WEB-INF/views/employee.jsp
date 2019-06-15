<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="command" class="org.cloud.ssm.entity.Employee" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/x-icon" href="static/favicon.ico">
<script src="static/js/jquery-3.3.1.min.js"></script>
<script src="static/js/custom.js"></script>
<style>
button{background:none; border:none;}
.btn-del{ float:right; margin-right:10px; color:#000; font-weight:normal;}
table.info { border-collapse:collapse;}
table.info tr, table.info td, table.info th { border:1px solid #999;}
table.info td, table.info th { padding:5px 10px;}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <h2 class="center-align">Spring MVC Json example</h2>

      <h2 class="center-align">Add Employee</h2>
      <form:form id="form" action="" class="col s12 m6">
        <table>
          <tr>
            <td><form:label path="name">Name：</form:label></td>
            <td><form:input path="name" /></td>
          </tr>
          <tr>
            <td><form:label path="address">Address：</form:label></td>
            <td><form:input path="address" /></td>
          </tr>
          <tr>
            <td><form:label path="age">Age：</form:label></td>
            <td><form:input path="age" value="" /></td>
          </tr>
          <tr>
            <td colspan="2"><input type="submit" id="submit"
              value="Submit" /></td>
          </tr>
        </table>
      </form:form>
    </div>
    <div class="row">
      <h2>All Employee</h2>
      <div id="output"></div>
    </div>
    <br />
  </div>
  <script>
      function fillTable(obj) {
        var html = '<table class="info">';
        html += '<tr><th>User Id</th><th>Name</th><th>Address</th><th>Age</th><th>Operate</th></tr>';
        var $btnDel = '<span><button type="button" class="btn-del">删除</button></span>';
        for ( var key in obj) {
          html += '<tr><td>' + obj[key].id + '</td>';
          html += '<td>' + obj[key].name + '</td>';
          html += '<td>' + obj[key].address + '</td>';
          html += '<td>' + obj[key].age + '</td>';
          html += '<td>' + $btnDel + '</td></tr>';
        }
        html += '</table>';
        $("#output").empty().append(html);
      }

      function add() {
        var $btn = $("#submit");
        $btn.bind("click", function() {
          var formData = new FormData($("#form")[0]);
          ajaxFormRequest("POST", "rest/employee/addEmployee", formData, function(data) {
            var obj = data;
            $("#name").val('');
            $("#address").val('');
            $("#age").val('');
            ajaxJsonRequest("GET", "rest/employee/listEmployee", null, function(data) {
              fillTable(data);
            });
          });
          return false;
        });
      };
      $(document).ready(function() {
        add();
        ajaxJsonRequest("GET", "rest/employee/listEmployee", null, function(data) {
          fillTable(data);
        });

      });
      $(document).on('click', '.btn-del', function() {
        var item = $(this).parents('tr').children('td').eq(0).text();
        if (item) {
          var formData = new FormData();
          formData.append("id", item);
          ajaxFormRequest("POST", "rest/employee/deleteEmployee", formData, function() {
            ajaxJsonRequest("GET", "rest/employee/listEmployee", null, function(data) {
              fillTable(data);
            });
          });
        }
      });
    </script>
</body>
</html>