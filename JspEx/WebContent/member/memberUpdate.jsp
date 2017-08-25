<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="/webapp/script/js/member.js"></script>

<body bgcolor="#e0ffff">

   <h2>회원 수정</h2>
   <form action="memberUpdate.do" method="post" name="frm">
      <table>
         <tr>
            <td width="200">사용자 ID</td>
            <td width="400">
            <input type="text" name="id" size="15" value="${mVo.id}" maxlength="12"></td>
         </tr>

         <tr>
            <td width="200">이름</td>
            <td width="400">
            <input type="text" name="name" size="15" value="${mVo.name}" maxlength="12"></td>
         </tr>
         
         <tr>
            <td width="200">비밀번호</td>
            <td width="400">
            <input type="text" name="pass" size="15" value="${mVo.name}" maxlength="12"></td>
         </tr>

         <%-- ${mVo.regist }
         <c:set var="cnt" value=0/>
         <c:forTokens var="jumin" items="${mVo.regist}" delims="-">
            ${jumin}
            <c:set var="cnt" value="${cnt +1}" />
            <c:set var="${'ju' + cnt}" value="${jumin}" />
         </c:forTokens> --%>


         <tr>
            <td width="200">주민등록번호</td>
            <td width="400">
            <input type="text" name="jumin1" size="7" value="${mVo.regist}" maxlength="6"> 
            <input type="text" name="jumin1" size="7" value="${mVo.regist}" maxlength="7">
            </td>
         </tr>

         <tr>
            <td width="200">E-Mail</td>
            <td width="400">
            <input type="text" name="jumin1" size="7" value="${mVo.name}" maxlength="6"></td>
         </tr>

         <tr>
            <td colspan="2" align="center" bgcolor="#b0e0e6">
            <input type="submit" name="confirm" value="수 정"> 
            <input type="reset" name="reset" value="다시입력">
            </td>
         </tr>

      </table>

   </form>
</body>

</html>