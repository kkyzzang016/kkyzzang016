<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String [] movieList = {"타이타닉","시네마 천국","혹성 탈출","킹콩"};
		pageContext.setAttribute("movieList", movieList);
	%>
	<table border=1>
	<tr>
	<td>&nbsp;&nbsp;index&nbsp;&nbsp;</td>
	<td>&nbsp;&nbsp;count&nbsp;&nbsp;</td>
	<td>&nbsp;&nbsp;title&nbsp;&nbsp;</td>
	</tr>
	<c:forEach var="movie" items="${movieList }" varStatus="s">
		<tr>
		<td>${s.index}</td>
		<td>${s.count}</td>
		<td>${movie }</td>
		</tr>
	</c:forEach>
	</table>
		
		<hr>
		
	<ul>
	<c:forEach var = "movie" items="${movieList }" varStatus="status">
		<c:choose>
			<c:when test="${status.first }">
				<li style="font-weight:bold; color:red;">${movie}</li>
			</c:when>
			<c:otherwise>
				<li>${movie}</li>
			</c:otherwise>
		</c:choose>
	</c:forEach>
		</ul>
		
		<hr>
		
		<c:forEach var = "movie" items="${movieList }" varStatus="status">${movie}<c:if test="${not status.last}">, </c:if>
		</c:forEach>
</body>
</html>