<%@page import="co.dev.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//자바영역
		List<MemberVO> list = (List<MemberVO>) request.getAttribute("members"); //list 주소값
		System.out.print(list);
	%>
	<ul>
	<%
		for(MemberVO member : list){
			
	%>
		<li>id: <%=member.getId() %>, name: <%=member.getName() %></li>
	<%
		}
	
	%>
	</ul>
</body>
</html>