<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정결과</title>
</head>
<body>
	<%
	String message = (String) request.getAttribute("message");  //Object
	%>
	<%
	if(message != null){
	%>
	<p>처리결과: <%=message %></p>
	<%
	}
	%>
	<p>회원목록으로 이동</p>
	<a href = memberList.do>목록이동</a>
</body>
</html>