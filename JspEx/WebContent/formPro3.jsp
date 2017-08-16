<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>* 리스트, 리스트박스 결과*</h3><hr><br>
	<%request.setCharacterEncoding("utf-8"); %>
	<%
	out.println("좋아하는 색깔은 " +request.getParameter("color"));
	out.println("<br>");
	
	String str[];
	str = request.getParameterValues("fruit");
	out.print("좋아하는 과일은");
	for(int i=0;i<str.length;i++)
		out.print(str[i]+" ");
	out.println("<BR>");
	%>
	
</body>
</html>