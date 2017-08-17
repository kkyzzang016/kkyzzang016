<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="java.sql.*, javax.naming.*, javax.sql.*, bean.UserInfo"%>
<%@page import="" %>
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
<%
   request.setCharacterEncoding("UTF-8");
   String id = request.getParameter("id");
   String pass = request.getParameter("pass");
   String name = request.getParameter("name");
   String regist = request.getParameter("regist");
   
   // 이후 자동화
   
   UserInfo bean = new UserInfo();
   bean.setId(id);
   bean.setPass(pass);
   bean.setName(name.trim());
   bean.setRegist(regist);
   
   //DB insert
   String sql = "insert into userinfo(id,pass,name,regist)" + " values(?,?,?,?)";
   Connection conn = getConnection();
   PreparedStatement pstmt = conn.prepareStatement(sql);
   pstmt.setString(1, bean.getId());
   pstmt.setString(2, bean.getPass());
   pstmt.setString(3, bean.getName().trim());
   pstmt.setString(4, bean.getRegist());
   
   int result = pstmt.executeUpdate();
   String msg = result > 0 ? "success" : "fail";
   //response.sendRedirect("suerinfolist.jsp?result=" + str);
%>
<%= msg %>
<body>

</body>
</html>