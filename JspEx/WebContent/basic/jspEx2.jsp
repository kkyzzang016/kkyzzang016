<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%! int a;
	  int b;
%>
<%
		a=10;
		b=20;
		if(b/a>10){
		%><p>
		양의 값(첫번째)<br>
		<%=" 양의 값 (두번째)" %><br>
		<% out.println("다시 양의 값(세번째)"); %>
		
		<%
		} else{
		%>
		음의 값
		<%
		}
		%>
</body>
</html>