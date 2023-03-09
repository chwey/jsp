<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="../includes/sidebar.jsp"></jsp:include>
<jsp:include page="../includes/top.jsp"></jsp:include>

	
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
	
	<table class="table">
	<thead>
		<tr><th>글번호</th><th>작성자</th><th>제목</th><th>조회수</th><th>작성일자</th></tr>
	</thead>
	<tbody>
		<c:forEach var="notice" items="${list }">
		<tr><td>${notice.noticeId }</td>
			<td>${notice.noticeWriter }</td>
			<td><a href="noticeSearch.do?nid=${notice.noticeId }">${notice.noticeTitle }</td>
			<td>${notice.hitCount }</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${notice.createDate }" /></td>
		</tr>	
		</c:forEach>
	</tbody>
	</table>
	
	<div class="center">
  		<div class="pagination">
  		<c:if test="${page.prev }">
  			<a href="noticeList.do?page=${page.startPage - 1 }"> &laquo; </a>
  		</c:if>
		<c:forEach begin="${page.startPage }" end="${page.endPage }" var="i">
			<c:choose>
				<c:when test="${i == page.page }">
					<a class="active" href ="noticeList.do?page=${i }"> ${i } </a>
				</c:when>
				<c:otherwise>
					<a href="noticeList.do?page=${i }"> ${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${page.next }">
			<a href="noticeList.do?page=${page.endPage + 1 }"> &raquo; </a>
		</c:if>
		</div>
	</div>
	
	<%@ include file="../includes/footer.jsp" %>