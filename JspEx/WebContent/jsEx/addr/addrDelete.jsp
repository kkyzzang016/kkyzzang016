<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
   import = "java.util.*, db.DBAction, java.sql.*" errorPage = "errors/error.jsp"    
%>

<%
   request.setCharacterEncoding("UTF-8");
   String id = request.getParameter("id");
   DBAction db = DBAction.getInstance();
   String sql = "delete from addrbook qhere id = ?";
   PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
   pstmt.setString(1, id);
   pstmt.executeUpdate();
   response.sendRedirect("addrList.jsp");
%>