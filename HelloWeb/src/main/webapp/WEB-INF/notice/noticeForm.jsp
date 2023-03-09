<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../includes/sidebar.jsp"></jsp:include>
<jsp:include page="../includes/top.jsp"></jsp:include>

<form action="noticeAdd.do" method="post" enctype="multipart/form-data">
	<table class="table">
		<tr>
			<td>제목</td>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer" readonly value="${id }"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea cols="30" rows="5" name="subject"></textarea></td>
		</tr>
		<tr>
			<td>파일</td>
			<td><input type="file" name="attach"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="저장">
			</td>
		</tr>
	</table>
</form>

<script>
	document.querySelector('form').addEventListener('submit', function (e) {
		e.preventDefault(); //기본 기능 차단
		let title = document.querySelector('input[name="title"]').value;
		let writer = document.querySelector('input[name="writer"]').value;
		let subject = document.querySelector('textarea[name="subject"]').textContent;

		let isOK = true;
		if (title == '' || title == 'null') {
			isOK = false;
		}
		if (writer == '' || writer == 'null') {
			isOK = false;
		}
		if (subject == '' || subject == 'null') {
			isOK = false;
		}
		if (!isOK) {
			alert('입력항목을 확인하세요');
			return false;
		}

		//이벤트의 콜백함수에서 this는 이벤트가 발생하는 대상 element
		console.log(this);
		//this.submit();
	})
</script>

<%@ include file="../includes/footer.jsp" %>