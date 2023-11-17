<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 페이지</title>
<style>
	#container { width: 700px; margin: auto; }
	h1,h3, p { text-align: center; }
	table { border-collapse: collapse; } 
	table, th, td {
		border: 1px solid black;
		margin: 0 auto;
	}
	th { background-color: pink; }
	.center { text-align: center; }
		.border-none, .border-none td { border: none; }
</style>
</head>
<body>
<div id="container">
	<h1>상세페이지</h1>
	<p><a href="logout.do">로그아웃</a></p>
	
	<form action="updateBoard.do" method="post"> <!-- 수정도 할 수 있게하기 위해 form 사용  -->
		<!-- 작업 중인 글번호를 통해 where 조건으로 데이터 찾아서 수정하기 위함  -->
		<input type="hidden" name="seq" value="${board.seq }">
	<table>
			<tr>
				<th width="100">제목</th>
				<td>
					<input type="text" name="title" value="${board.title }">
				</td>
			</tr>
			<tr>
				<th width="100">작성자</th>
				<td>
					<input type="text" name="writer" value="${board.writer }">
				</td>
			</tr>
			<tr>
				<th width="100">내용</th>
				<td>
					<textarea rows="10" cols="40" name="content">${board.content }</textarea>
				</td>
			</tr>
			<tr>
				<th width="100">작성일</th>
				<td>${board.regdate }</td>
			</tr>
			<tr>
				<th width="100">조회수</th>
				<td>${board.cnt }</td>
			</tr>
			<tr>
				<td colspan="2" class="center">
					<input type="submit" value="글 수정">
				</td>
			</tr>
		</table>
	</form>
	<p>
		<a href="insertBoard.jsp">글 등록</a>
		<a href="deleteBoard.do?seq=${board.seq }">글 삭제</a>
		<a href="getBoardList.do">글목록</a>
	</p>
</div>
</body>
</html>