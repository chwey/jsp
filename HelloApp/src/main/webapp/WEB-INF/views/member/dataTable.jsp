<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="//cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css" rel="stylesheet">
<script src="jQuery/jquery-3.6.4.min.js"></script>
<script src="//cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<script>
	$(document).ready(function () {
	    $('#example').DataTable({
	        ajax: 'dataTableAjax.do',
	    });
	    var t = $('#example').DataTable();
	    var counter = 1;
	 
	    $('#addRow').on('click', function () {
	    	$.ajax({
	    		url:"dataTableAddAjax.do",
	    		data: {first:$("#first").val(),
	    			last:$("#last").val(),
	    			email:$("#email").val(),
	    			jobid:$("#jobid").val(),
	    			hireDate:$("#hireDate").val(),
	    			salary:$("#salary").val(),
	    		},
	    		method: "POST",                                    
			    dataType: "json",
			    success: function(result){
			    	if(result.retCode == 'Success'){
			    		let data = result.reply;
			    		console.log(data)
			    		alert("성공");
				        t.row.add([data.employeeId, data.firstName, data.lastName, data.email, data.hireDate, data.salary]).draw(false);
			    		
			    	}else if(result.retCode == 'Fail'){
			    		alert("실패");
			    	}else{
			    		alert("retCode를 확인하세요");
			    	}
			    	
			    }
	    	})
	        counter++;
	    });
	    
	    $('#example').on('click', 'tr', function () {
	        if ($(this).hasClass('selected')) {
	            $(this).removeClass('selected');
	        } else {
	            table.$('tr.selected').removeClass('selected');
	            $(this).addClass('selected');
	        }
	    });
	 
	    $('#delRow').click(function () {
	        table.row('.selected').remove().draw(false);
	    });
	
	});
	
	
</script>
</head>
<body>
	<p>dataTable</p>
	<input type="text" id="first"><br>
	<input type="text" id="last"><br>
	<input type="email" id="email"><br>
	<input type="date" id="hireDate"><br>
	<input type="number" id="salary"><br>
	<button id="addRow">등록</button><br>	
	<button id="delRow">삭제</button><br>	
	<br>
	
	<table id="example" class="display" style="width:100%">
        <thead>
            <tr>
                <th>사원번호</th>
                <th>FirstName</th>
                <th>lastName</th>
                <th>Email</th>
                <th>jobId</th>
                <th>HireDate</th>
                <th>Salary</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>사원번호</th>
                <th>FirstName</th>
                <th>lastName</th>
                <th>Email</th>
                <th>jobId</th>
                <th>HireDate</th>
                <th>Salary</th>
            </tr>
        </tfoot>
    </table>
</body>
</html>