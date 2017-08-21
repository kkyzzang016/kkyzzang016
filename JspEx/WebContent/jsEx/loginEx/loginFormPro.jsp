<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import="java.sql.*, javax.naming.*, javax.sql.*, bean.UserInfo"%>
        <%!
public Connection getConnection() {
      Connection conn = null;
      try {
         InitialContext initctx = new InitialContext();
         Context ctx = (Context) initctx.lookup("java:comp/env");
         DataSource ds = (DataSource) ctx.lookup("jdbc/mysql");
         conn = ds.getConnection();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return conn;
   }%>
   
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String tid = null; 
String tpass=null;
String id = request.getParameter("id");
String pass = request.getParameter("pass");

String sql = "select id, pass from userinfo where id='"+id+"'";
Statement stmt = getConnection().createStatement();
ResultSet rs = stmt.executeQuery(sql);


while(rs.next()){
	if(rs.getString("id")==null) {
	%>
	로그인 실패
	<a href="mainPage.jsp">메인 페이지로 이동</a>
	<%
	}else{
	tid = rs.getString("id");
	tpass = rs.getString("pass");
	}
}
if(tid==null){
	%>로그인 실패
	<a href="mainPage.jsp">메인 페이지로 이동</a>
	<%
}

else if(tid.equals(id)&&tpass.equals(pass)){
	session.setAttribute("id", request.getParameter("id"));
	session.setAttribute("pw", request.getParameter("pass"));
	request.getRequestDispatcher("mainPage.jsp").forward(request, response);
}
else {%>로그인 실패
<a href="mainPage.jsp">메인 페이지로 이동</a>
<%} %>

</body>
</html>