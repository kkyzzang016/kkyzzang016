<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*, javax.naming.*, javax.sql.*, bean.AddrBean"%>
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
   String name = request.getParameter("name");
   String phone = request.getParameter("phone");
   String addr = request.getParameter("addr");
   
   AddrBean bean = new AddrBean();
   bean.setId(id);
   bean.setName(name);
   bean.setPhone(phone); 
   bean.setAddr(addr);
   
 //DB insert
   String sql = "insert into addrinfo(id,name,phone,addr)" + " values(?,?,?,?)";
   Connection conn = getConnection();
   PreparedStatement pstmt = conn.prepareStatement(sql);
   pstmt.setString(1, bean.getId());
   pstmt.setString(2, bean.getName());
   pstmt.setString(3, bean.getPhone());
   pstmt.setString(4, bean.getAddr());
   
   int result = pstmt.executeUpdate();
   String msg = result > 0 ? "success" : "fail";
   %>
<body>

</body>
</html>