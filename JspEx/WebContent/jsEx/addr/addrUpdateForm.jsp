<%@page import="bean.AddrBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*, bean.AddrBean" errorPage="errors/error.jsp"%>
<%
   request.setCharacterEncoding("UTF-8");
   String id = request.getParameter("id");
   AddrBean addr = (AddrBean)session.getAttribute(id);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update page</title>
</head>
<body>
   <center>
      <h3>*주소록 수정*</h3>
   </center>
   <hr />
   <tabel width="100%">
   <tr>
      <td align="right"><jsp:include = page="menu.jsp" flush="false" />
      </td>
      
   </tr>
   <tr>
      <td align="center">
         <FORM method="post" action="addrUpdate.jsp">
            <table border=1>
               <tr>
                  <td colspan=2 align=center>사용자 추가</td>
               </tr>
               <tr>
                  <td>아이디</td>
                  <td><input type = "text" name = "id" vlaue = "<%=addr.getId() %>">
                  </td>
               </tr>
               <tr>
                  <td>전화번호</td>
                  <td><input type="text" name="phone"
                     value="<%=addr.getPhone() %>"></td>
               </tr>
               <tr>
                  <td>주소</td>
                  <td><input type="text" name="Addr"
                     value="<%=addr.getAddr() %>"></td>
               </tr>
               <tr>
                  <td colspan=2 align=center><input type="submit"
                     value="사용자 추가"> <input type="reset" value="reset">
                  </td>
               </tr>
            </table>
         </FORM>
      </td>
   </tr>
   </tabel>
</BODY>
</body>
</html>