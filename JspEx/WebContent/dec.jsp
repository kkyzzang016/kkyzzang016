<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%! String str = "�ȳ��ϼ���!";
		int a=5, b=-5;
		
		public int abs (int n){
			if(n<0){
				n=-n;
			}
			return n;
		}%>
		
		<%
			out.print(str+"<br>");
			out.print(a+"�� ���밪 : "+abs(a)+"<br>");
			out.print(b+"�� ���밪 : "+abs(b)+"<br>");
		%>
</body>
</html>