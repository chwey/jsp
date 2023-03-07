<%@page import="co.dev.vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%@ include file="../includes/sidebar.jsp" %>
	<%@ include file="../includes/top.jsp" %>
	
	<%
	List<NoticeVO> notices = (List<NoticeVO>)request.getAttribute("list");
	//공지사항 목록 table 형식으로 화면출력
	%>
	<table class="table">
	<thead>
		<tr><th>글번호</th><th>작성자</th><th>제목</th><th>조회수</th><th>작성일자</th></tr>
	</thead>
	<tbody>
		<% for(NoticeVO notice : notices) {%>
		<tr><td><%=notice.getNoticeId() %></td>
			<td><%=notice.getNoticeWriter() %></td>
			<td><a href="noticeSearch.do?nid=<%=notice.getNoticeId() %>"><%=notice.getNoticeTitle() %></td>
			<td><%=notice.getHitCount() %></td>
			<td><%=notice.getCreateDate() %></td>
		</tr>
		<%} %>
	</tbody>
	</table>
	
	
	
	<%@ include file="../includes/footer.jsp" %>