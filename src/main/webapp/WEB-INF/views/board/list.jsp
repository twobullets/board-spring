<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				<form name="frm" action="/board/list" method="get">
				<select name="searchType">
					<option value="writer">작성자</option>
					<option value="title">제목</option>
				</select>
				<input type="text" name="searchText">
				<input type="submit" value="검색">
		</form>
			</td>
		</tr>
		<tr>
			<td>
				<table border="1" style="margin:auto; text-align:center;">
						<tr>
							<th>순번</th>
							<th width="60%">제목</th>
							<th>작성자</th>
							<th>등록일</th>
							<th>조회수</th>
						</tr>
					<c:forEach items="${list}" var="list" varStatus="status">
						<tr>
							<td><c:out value="${status.count}"/></td>
							<td><a href="/board/detail?no=<c:out value='${list.no}'/>"><c:out value="${list.title}"/></a></td>
							<td><c:out value="${list.writer}"/></td>
							<td><c:out value="${list.wdate}"/></td>
							<td><c:out value="${list.hit}"/></td>
						</tr>
			</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
			<td style="text-align:right;">
				<button type="button" onclick="location.href='/board/write'" >작성</button>
			</td>
		</tr>
	</table>
	<div style="display:block; text-align: center;">
			
			<!-- 현재 열린 페이징의 5개중 첫페이지가 맨 처음페이지(1페이지)가 아니면 이전페이지 버튼 생성 -->
			<c:if test="${paging.startPage !=1 }">
				<a href="/board/list?nowPage=${paging.startPage - 1}&cntPerPage=${paging.cntPerPage }">&lt;</a>
				<!-- 1대신 cntPerPage를 빼면 5개 전 페이지로 이동 but 조건이 더 필요 -->
			</c:if>
			
			<!-- 페이징 for문 -->
			<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
				<c:choose>
					<c:when test="${paging.nowPage == p }">
					<b>${p }</b>
					</c:when>
					<c:otherwise>
						<a href="/board/list?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
					</c:otherwise>
				</c:choose>
				
			</c:forEach>
			
			<!-- 현재 열린 페이징의 5개중 끝페이지가 맨마지막페이지가 아니면 다음 페이지 버튼 생성 -->
			<c:if test="${paging.endPage != paging.lastPage}">
				<a href="/board/list?nowPage=${paging.endPage+1}&cntPerPage=${paging.cntPerPage}">&gt;</a>
			</c:if>
	</div>
</body>
</html>