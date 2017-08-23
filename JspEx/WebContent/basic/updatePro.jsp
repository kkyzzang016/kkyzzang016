<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*, javax.naming.*, javax.sql.*, bean.UserInfo"%>
<%!
public UserInfo bean = new UserInfo();
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

<%
   request.setCharacterEncoding("UTF-8");

//hidden value
String id = request.getParameter("id");
//코드 작성1 use request method

//코드 작성2 UserInfo 사용

//정상적처리 이후
Connection conn = getConnection();
String sql = "update userinfo set pass=?, name=?, regist=? where";
PreparedStatement pstmt = conn.prepareStatement(sql);

pstmt.setString(1,bean.getPass());
pstmt.setString(2,bean.getName());
pstmt.setString(3,bean.getRegist());
pstmt.setString(4,bean.getId());
int result = pstmt.executeUpdate();
String msg = result > 0 ? "success" : "fail";

response.setCharacterEncoding("UTF-8");
response.sendRedirect("userinfolist.jsp?result=" +URLEncoder.encode(msg));

%>

<body>

</body>
</html>