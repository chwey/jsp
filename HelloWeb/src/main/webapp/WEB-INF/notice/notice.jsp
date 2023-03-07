<%@page import="co.dev.vo.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../includes/sidebar.jsp" %>
<%@ include file="../includes/top.jsp" %>
 <%
 NoticeVO vo = (NoticeVO) request.getAttribute("notice");
 %>
	<table class="table">
	
		<tr>
			<td>글번호</td>
			<td><input type="text" name="nid" readonly value="<%=vo.getNoticeId() %>"></td>
			<td>조회수 <%=vo.getHitCount() %></td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan=2><input type="text" name="title" value="<%=vo.getNoticeTitle() %>"></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td colspan=2><input type="text" name="writer" value="<%=vo.getNoticeWriter() %>"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td colspan=2><textarea cols="30" rows="5" name="subject"><%=vo.getNoticeSubject() %></textarea></td>
		</tr>
		<tr>
			<td>파일</td>
			<td>
			<%if(vo.getAttach() != null){ %>
			<input type="text" name="attach" value="<%=vo.getAttach() %>">
			<%}else{ %>
			<input type="text" name="attach">
			<%} %>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="저장">
			</td>
		</tr>
	</table>

<%@ include file="../includes/footer.jsp" %>
