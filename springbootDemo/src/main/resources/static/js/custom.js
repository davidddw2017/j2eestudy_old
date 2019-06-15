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
    html += '<tr><th>User Id</th><th>Name</th><th>Address</th><th>Age</th><th>Operate</th></tr>';
    var $btnDel = '<span><button type="button" class="btn-del">删除</button></span>';
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