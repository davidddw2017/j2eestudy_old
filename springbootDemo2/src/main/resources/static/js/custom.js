function ajaxJsonRequest(method, url, jsonData, handleData) {
    $.ajax({
        type : method,
        url : url,
        data : jsonData,
        dataType : "json",
        contentType : "application/json; charset=utf-8",
        success : handleData,
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
    return false;
}

function ajaxFormRequest(method, url, formData, handleData) {
    $.ajax({
        type : method,
        url : url,
        data : formData,
        contentType : false,
        processData : false,
        cache : false,
        success : handleData,
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
    return false;
}

function fillTable(obj) {
    var html = '<table class="table table-condensed"><tbody>';
    html += '<tr><th>编号</th><th>姓名</th><th>地址</th><th>年龄</th><th>操作</th></tr>';
    var $btnDel = '<button type="button" class="btn btn-info btn-xs btn-change">修改</button>&nbsp;&nbsp;';
    $btnDel += '<button type="button" class="btn btn-danger btn-xs btn-del">删除</button>';
    for ( var key in obj) {
        html += '<tr><td>' + obj[key].id + '</td>';
        html += '<td>' + obj[key].name + '</td>';
        html += '<td>' + obj[key].address + '</td>';
        html += '<td>' + obj[key].age + '</td>';
        html += '<td>' + $btnDel + '</td></tr>';
    }
    html += '</tbody></table>';
    $("#output").empty().append(html);
}

function add() {
    var $btn = $("#submit");
    $btn.bind("click", function() {
        var formData = new FormData($("#form")[0]);
        ajaxFormRequest("POST", "rest/employee/addEmployee", formData, function(data) {
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
    $('#updateModal').on('shown.bs.modal', function (e) { 
        var $this = $(this);
        var dialog = $this.find('.modal-dialog');
        var top = ($(window).height() - dialog.height()) / 2;
        dialog.css({
            marginTop:top
        });
    });
    
    $("#updateInfo").bind("click", function() {
        var formData = new FormData($("#updateForm")[0]);
        ajaxFormRequest("PUT", "rest/employee/updateEmployee", formData, function(data) {
            ajaxJsonRequest("GET", "rest/employee/listEmployee", null, function(data) {
            	$('#updateModal').modal('toggle');
                fillTable(data);
            });
        });
        return false;
    });
});

$(document).on('click', '.btn-del', function() {
    var item = $(this).parents('tr').children('td').eq(0).text();
    if (item) {
    	ajaxFormRequest("DELETE", "rest/employee/deleteEmployee/" + item, null, function() {
            ajaxJsonRequest("GET", "rest/employee/listEmployee", null, function(data) {
                fillTable(data);
            });
        });
    }
});

$(document).on('click', '.btn-change', function() {
    var item = $(this).parents('tr').children('td').eq(0).text();
    if (item) {
        ajaxFormRequest("GET", "rest/employee/getEmployee/" + item, null, function(data) {
        	$('#updateModal').modal('toggle');
        	$('#c_id').val(data.id);
        	$('#c_name').val(data.name);
        	$('#c_address').val(data.address);
        	$('#c_age').val(data.age);
        });
        
    }
});

function jsOpenModal2() {
    $('#myModal2').modal('toggle');//手动切换模态框。   还有一个modal('hide')   手动隐藏模态框。
}

