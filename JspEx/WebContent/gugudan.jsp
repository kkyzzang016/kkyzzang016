<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "java.text.SimpleDateFormat" %>
<%@page import = "java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	th, td{
	border: 1px solid black;
	padding: 1px;
	}
	</style>
<body>
<center>
<table border="5">
<tr><%for(int j=2;j<10;j++){ %>
<td><%=j%>단</td>
<%} %>
</tr>

<% for(int i=1;i<10;i++){ %>
<tr>
<% for(int k=2;k<10;k++){ %>
	<td>
		<%=k%> * <%=i%> = <%=i*k%>
	</td>
	<%} %>
	</tr>
	<%} %>
</table>

		<%
			String[] yoilstr = {"일","월","화","수","목","금","토"};
			Calendar date = Calendar.getInstance();
			SimpleDateFormat today = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
			int yoil = date.get(Calendar.DAY_OF_WEEK);
		%>
		
<%=today.format(date.getTime()) %> 입니다.(오늘은 <%=yoilstr[yoil-1] %>요일 입니다.)
		</center>
</body>
</html>