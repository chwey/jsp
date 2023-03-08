<%@page import="co.dev.vo.PageDTO"%>
<%@page import="co.dev.vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%@ include file="../includes/sidebar.jsp" %>
	<%@ include file="../includes/top.jsp" %>
	
	<style>
.center {
  text-align: center;
}

.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
  border: 1px solid #ddd;
  margin: 0 4px;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
  border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
</style>
	
	<%
	List<NoticeVO> notices = (List<NoticeVO>)request.getAttribute("list");
	PageDTO paging = (PageDTO) request.getAttribute("page");
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
	
	<div class="center">
  		<div class="pagination">
		<% if (paging.isPrev()){ %>
			<a href="noticeList.do?page=<%=paging.getStartPage()-1 %>"> &laquo; </a>
		<%} %>
		<%for (int i=paging.getStartPage(); i<=paging.getEndPage(); i++){ %>
			<%if (i == paging.getPage()){ %>
				<a class="active" href ="noticeList.do?page=<%=i %>"> <%=i %> </a>
			<%}else{ %>
				<a href="noticeList.do?page=<%=i %>"> <%=i %></a>
			<%} %>
		<%} %>
		<% if (paging.isNext()){ %>
			<a href="noticeList.do?page=<%=paging.getEndPage()+1 %>"> &raquo; </a>
		<%} %>
		</div>
	</div>
	
	
	<%@ include file="../includes/footer.jsp" %>