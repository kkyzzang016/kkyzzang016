<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
   <h3>* ����, üũ�ڽ� ��� *</h3>
   <HR>
   <BR>
   <%-- ���� �� �Ķ���͸� �о��, ����Ѵ�. --%>
   <% request.setCharacterEncoding("UTF-8"); %>
   <%= "�����ϴ� ���� : " + request.getParameter("color") %>
   <br>

   <%
   String str[];
   str = request.getParameterValues("fruit");
   %>
   <br> �����ϴ� ���� :
   <%
      for(int i = 0; i < str.length; i++){
         if(i == str.length - 1){
   %>
      <%=str[i]%>
   <%
         }else {
   %>
      <%=str[i] + "<br>" %>
   <%
         }
      }
   %>
</body>
</html>