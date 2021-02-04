<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Good Night Board!!</title>
</head>
<body>
<form id="frm" method="post" action="/board/writeok">
	<input type="hidden" name="no" value="${vo.no }">
	<table style="margin:auto; text-align:center;">
		<tr>
			<td><h1>Good Night Board!!</h1></td>
		</tr>
		<tr>
			<td>
				<table border="1" style="margin:auto; text-align:center;">
					<tr>
						<th>제목</th>
						<td colspan="5"><input type="text" name="title" value="${vo.title}"></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><input type="text" name="writer" value="${vo.writer}"></td>
						<th>등록일</th>
						<td>${vo.wdate}</td>
						<th>조회수</th>
						<td>${vo.hit}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="5">
							<textarea name="body">${vo.body}</textarea>
						</td> 
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td style="text-align:right;">
				<button type="button" onclick="location.href='/board/list'" >취소</button>
				<button type="submit">등록</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>