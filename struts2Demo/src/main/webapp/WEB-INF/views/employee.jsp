<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
	<h1>Struts 2 Json example</h1>

	<h2>Add employee</h2>
	<s:form id="form" action="">
		<s:textfield id="name" name="name" label="Name" value="" />
		<s:textfield id="address" name="address" label="Address" value="" />
		<s:textfield id="age" name="age" label="Age" value="" />
		<s:submit id="submit"/>
	</s:form>

	<h2>All employee</h2>
	<div id="output"></div>

	<br />
	<script>
		function fillTable(obj) {
        	var html = '<table class="info">';
            html += '<tr><th>User Id</th><th>Name</th><th>Address</th><th>Age</th><th>Operate</th></tr>';
            var $btnDel = '<span><button type="button" class="btn-del">删除</button></span>';
            for (var key in obj){
                html += '<tr><td>' + obj[key].id + '</td>';
                html += '<td>' + obj[key].name + '</td>';
                html += '<td>' + obj[key].address + '</td>';
                html += '<td>' + obj[key].age + '</td>';
                html += '<td>' + $btnDel +'</td></tr>';
            }
            html += '</table>';
            $("#output").empty().append(html);
        }
		
        function add() {
            var $btn = $("#submit");
            $btn.bind("click", function() {
            	var formData = new FormData($("#form")[0]); 
            	ajaxFormRequest("POST", "rest/employee/addEmployee", formData, function(data) {
                    var obj = JSON.parse(data);
                    $("#name").val('');
                    $("#address").val('');
                    $("#age").val('');
                    ajaxJsonRequest("GET", "rest/employee/listEmployee", null, function(data) {
                        fillTable(JSON.parse(data));
                    });
                });
            	return false;
            });
        };
        $(document).ready(function() {
        	add();
            ajaxJsonRequest("GET", "rest/employee/listEmployee", null, function(data) {
            	fillTable(JSON.parse(data));
            });
           
        });
        $(document).on('click','.btn-del', function (){
        	var item = $(this).parents('tr').children('td').eq(0).text();
        	if(item) {
        		var formData = new FormData();
        		formData.append("id", item);
        		ajaxFormRequest("POST", "rest/employee/deleteEmployee", formData, function() {
        			ajaxJsonRequest("GET", "rest/employee/listEmployee", null, function(data) {
                    	fillTable(JSON.parse(data));
                    });
        		});
        	}
        });
    </script>
</body>
</html>