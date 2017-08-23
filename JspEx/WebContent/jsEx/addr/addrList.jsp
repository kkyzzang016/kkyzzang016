<%@page import="db.DBAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
   import="java.util.*, db.DBAction, java.sql.*, bean.AddrBean"%>
<HTML>
<body>
   <center>
      <h3>*주소록 만들기</h3>
   </center>
   <table width="100%">
      <tr>
         <td align="right"><jsp:include page="menu.jsp" /></td>
      </tr>
      <tr>
         <td align="center">
            <table border=1 align="center">
               <tr>
                  <td align=center colspan=6>주소록</td>
               </tr>
               <tr align=center>
                  <td>아이디</td>
                  <td>이름</td>
                  <td>전화번호</td>
                  <td>주소</td>
                  <td colspan=2>관리</td>
               </tr>
               <%
                  DBAction db = DBAction.getInstance();
                  String sql = "select * from addrbook order by id desc";

                  Connection conn = db.getConnection();
                  PreparedStatement pstmt = conn.prepareStatement(sql);
                  ResultSet rs = pstmt.executeQuery();
                  try {
                     while (rs.next()) {
               %>
               <tr>
                  <%
                     String id = rs.getString("id");
                           String name = rs.getString("name");
                           String phone = rs.getString("phone");
                           String addr = rs.getString("addr");
                           AddrBean addrbean = new AddrBean();
                           addrbean.setId(id);
                           addrbean.setName(name);
                           addrbean.setPhone(phone);
                           addrbean.setAddr(addr);
                  %>
                  <td><%=addrbean.getId()%></td>
                  <td><%=addrbean.getName()%></td>
                  <td><%=addrbean.getPhone()%></td>
                  <td><%=addrbean.getAddr()%></td>
                  <td><a href="addrUpdateForm.jsp?id=<%=id%>">수정</a></td>
                  <td><a href="addrDelete.jsp?id=<%=id%>">삭제</a></td>
               </tr>

               <%
                  session.setAttribute(id, addrbean);
                     }
                  } catch (SQLException e) {
                     e.printStackTrace();
                  } finally {
                     if (rs != null)
                        rs.close();
                     if (pstmt != null)
                        pstmt.close();
                     if (conn != null)
                        conn.close();
                  }
               %>
               <tr align=center>
                  <td colspan=6><a href="addrForm.jsp">사용자 추가</a></td>
               </tr>
            </table>
         </td>
      </tr>
   </table>
</body>
</HTML>