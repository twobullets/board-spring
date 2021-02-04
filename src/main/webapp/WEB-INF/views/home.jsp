<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Good Night Board!!
</h1>

<P>  지금은 ${serverTime} 입니다. <br>잘 자요!! </P>
<a href="/join">회원가입!</a>
<a href="/board/list">굿나잇 게시판!</a>
<a href="/fileUpload">파일업로드!</a>
<p/>
<img src="/image/Lighthouse.jpg" width="200">
<p/>
<%-- <table border="1">
		<tr>
			<th>순번</th>
			<th>이름</th>
			<th>거주지</th>
			<th>전화번호</th>
		</tr>
	<c:forEach items="${list}" var="list" varStatus="status">
		<tr>
			<td><c:out value="${status.count}"/></td>
			<td><a href="/join?no=<c:out value='${list.no}'/>"><c:out value="${list.name}"/></td>
			<td><c:out value="${list.addr}"/></td>
			<td><c:out value="${list.phone}"/></td>
		</tr>
	</c:forEach>
</table> --%>
</body>
</html>
