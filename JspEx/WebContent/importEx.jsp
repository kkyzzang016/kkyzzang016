<%@page import = "java.text.SimpleDateFormat" %>
<%@page import = "java.util.Calendar" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<%
			Calendar date = Calendar.getInstance();
			SimpleDateFormat today = new SimpleDateFormat("yyyy�� MM�� dd��");
			SimpleDateFormat now = new SimpleDateFormat("hh�� mm�� ss��");
		%>
		������
		<b><%=today.format(date.getTime()) %>
		</b>�Դϴ�.
		<br> ���� �ð���
		<b> <%=now.format(date.getTime()) %>
		</b>�Դϴ�.
</body>
</html>