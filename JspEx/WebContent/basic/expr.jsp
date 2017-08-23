<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%! String str = "안녕하세요!";
    		int a=5, b=-5;
    		
    		public int abs(int n){
    		if(n<0) n=-n;
    		return n;
    		}
    		%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%=str%><br>
	<%=a%>의 절대값 : 
	<%=abs(a)%><br>
	<%=b%>의 절대값 : 
	<%=abs(b)%>
</body>
</html>