<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%@ include file="../includes/sidebar.jsp" %>
	<%@ include file="../includes/top.jsp" %>
	
	<%
	Object obj = request.getAttribute("message");  //Object
	String result = (String) obj;
	//String id = (String) request.getAttribute("id");//String
	%>
	<p>처리결과: <%=result %></p>
	<p><%=id %>님의 가입을 환영합니다!</p>
	
	<p>회원목록으로 이동</p>
	<a href="memberList.do">회원목록으로 이동</a>

	<%@ include file="../includes/footer.jsp" %>