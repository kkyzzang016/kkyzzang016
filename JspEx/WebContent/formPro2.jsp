<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
   <h3>* 라디오, 체크박스 결과 *</h3>
   <HR>
   <BR>
   <%-- 폼의 각 파라미터를 읽어나어, 출력한다. --%>
   <% request.setCharacterEncoding("UTF-8"); %>
   <%= "좋아하는 색깔 : " + request.getParameter("color") %>
   <br>

   <%
   String str[];
   str = request.getParameterValues("fruit");
   %>
   <br> 좋아하는 과일 :
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