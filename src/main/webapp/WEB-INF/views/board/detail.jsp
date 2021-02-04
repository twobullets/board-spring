<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Good Night Board!!</title>
</head>
<body>
	<table style="margin:auto; text-align:center;">
		<tr>
			<td><h1>Good Night Board!!</h1></td>
		</tr>
		<tr>
			<td>
				<table border="1" style="margin:auto; text-align:center;">
					<tr>
						<th>제목</th>
						<td colspan="5">${vo.title}</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>${vo.writer}</td>
						<th>등록일</th>
						<td>${vo.wdate}</td>
						<th>조회수</th>
						<td>${vo.hit}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="5">${vo.body}</td> 
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td style="text-align:right;">
				<button type="button" onclick="location.href='/board/list'" >목록</button>
				<button type="button" onclick="location.href='/board/write?no=${vo.no}'" >수정</button>
				<button type="button" onclick="location.href='/board/delete?no=${vo.no}'" >삭제</button>
			</td>
		</tr>
	</table>
</body>
</html>