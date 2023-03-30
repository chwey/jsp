<%@page import="co.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%@ include file="../includes/sidebar.jsp" %>
	<%@ include file="../includes/top.jsp" %>
	
	<%
	MemberVO member = (MemberVO) request.getAttribute("vo");
	%>
	<h3>조회결과(memberSearchOutput.jsp)</h3>
	<p>아이디: <%=member.getId() %></p>
	<p>이름: <%=member.getName() %></p>
	<p>비번: <%=member.getPasswd() %></p>
	<p>메일: <%=member.getMail() %></p>
	
	<a href="memberSearchForm.do">회원조회화면으로</a>
	
	<%@ include file="../includes/footer.jsp" %>