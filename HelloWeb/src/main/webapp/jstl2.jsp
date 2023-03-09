<%@page import="co.dev.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl2.jsp</title>
</head>
<body>
	<%
	for(int i=1; i<=5; i++){
		System.out.print("i의 값: " + i);
	}
	List<String> fruits = new ArrayList<>();
	for(String fruit : fruits){
		System.out.print(fruit);
	}
	%>
	
	<c:forEach begin="1" end="5" step="1" var="i">
		<p>i의 값은 ${i }</p>
	</c:forEach>
	<%
	List<MemberVO> list = (List<MemberVO>) request.getAttribute("list");
	for(MemberVO member : list){
		System.out.print("Member: " + member.getId() + "," + member.getName());
	}
	%>
	<c:forEach var="member" items="${list }">
		<p>Member: ${member.id }, ${member.name }</p>
	</c:forEach>
	
</body>
</html>