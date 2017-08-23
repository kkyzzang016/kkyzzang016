<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*, javax.naming.*, javax.sql.*, bean.UserInfo"%>
<%@page import="java.net.URLDecoder"%>
    <%!public Connection getConnection() {
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
<body><center><br><p><br><p>
<h1>회원가입 관리자 페이지	</h1><p><hr><br><p>
<h3><%
	request.setCharacterEncoding("UTF-8");
String result = request.getParameter("result");
if(result!=null) out.println(URLDecoder.decode(result));
%>
</h3>
<hr><br><p>
<table border="1">
<%
String sql = "select * from userinfo";
Statement stmt = getConnection().createStatement();
ResultSet rs = stmt.executeQuery(sql);
ResultSetMetaData rsmd = rs.getMetaData();
int columcnt = rsmd.getColumnCount();
%>
<tr>
<%
for(int i=1; i<columcnt; i++){
%>
<td><%= rsmd.getColumnName(i) %></td>
<%
}
%>
<tr>
<%
while(rs.next()){
	%>
	<tr>
	<%
	for(int i=1;i<=columcnt;i++){
		%>
		<td><%=rs.getString(i) %>		</td>
		<%
	}
	 %>
	 </tr>
	 <%
}
%>
</table><p>
<a href="insert_form.jsp"> 회원가입 </a>&nbsp;&nbsp;
<a href="update_form.jsp"> 회원수정 </a>&nbsp;&nbsp;
<a href="remove.jsp"> 회원탈퇴 </a>
</center>

</body>
</html>