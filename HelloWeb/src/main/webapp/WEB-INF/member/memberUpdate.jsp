<%@page import="co.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>
</head>
<body>
	<h3>회원수정조회(memberUpdate.jsp)</h3>
	<%
	MemberVO member = (MemberVO) request.getAttribute("vo");
	String message = (String) request.getAttribute("message");
	if(message != null){
	%>
	<p><%=message %></p>
	<%
	}
	%>
	<form action="memberSearch.do">
		<input type="hidden" name = "job" value ="update">
		찾을 ID: <input type="text" name="id">
		<input type="submit" value="찾기">
	</form>
	
	<p></p>
	<%
	if(member != null){ //조회된 정보가 있으면 화면 결과 표시
	%>
	<h3>회원수정정보</h3>
	<form action="memberUpdate.do">
	ID: <input type="text" name="id" value="<%=member.getId() %>" readonly><br>
	PW: <input type="text" name="pass" value="<%=member.getPasswd() %>"><br>
	Name: <input type="text" name="name" value="<%=member.getName() %>"><br>
	Mail: <input type="text" name="mail" value="<%=member.getMail() %>"><br>
	<input type="submit" value = "수정">
	</form>
	<%
	}
	%>
</body>
</html>