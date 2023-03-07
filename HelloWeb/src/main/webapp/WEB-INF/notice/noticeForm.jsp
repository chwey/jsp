<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../includes/sidebar.jsp" %>
<%@ include file="../includes/top.jsp" %>
	
<form action="noticeAdd.do" method="post" enctype="multipart/form-data">
	<table class="table">
		<tr>
			<td>제목</td><td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>작성자</td><td><input type="text" name="writer"></td>
		</tr>
		<tr>
			<td>내용</td><td><textarea cols="30" rows="5" name="subject"></textarea></td>
		</tr>
		<tr>
			<td>파일</td><td><input type="file" name="attach"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="저장">
			</td>
		</tr>
	</table>
</form>
	

<%@ include file="../includes/footer.jsp" %>