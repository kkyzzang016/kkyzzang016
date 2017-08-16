<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%! String [] str = {"java","jsp","struts","spring","android"}; %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- style 적용 -->
	<style>
	body{ background:#ccc;
	}
	th, td{
	border: 1px solid black;
	padding: 1px;
	}
	</style>
</head>
<body>
<table style="">
<% for(int i=0;i<str.length;i++){ %>
		<tr><th><%=i %></th><td><%=str[i]%></td></tr>
	<%} %>
</table>
	
</body>
</html>