<%@page import="java.net.URLEncoder"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String id = "abc";
	String pwd = "123";
	String name="이혁재";
	request.setCharacterEncoding("UTF-8");
	if(id.equals(request.getParameter("id")) && pwd.equals(request.getParameter("pwd"))){
		response.sendRedirect("main.jsp?name="+URLEncoder.encode(name,"UTF-8"));
	}else{
		response.sendRedirect("loginTest.jsp");
	}
	%>