<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
   <TITLE>addr_form</TITLE>
</HEAD>
<BODY>
<center>
   <h3>* 주소록 추가 *</h3><hr/>        
   <FORM method="post" action="addrPro.jsp">
      <table width="100%">                
         <tr><td align="right"></td></tr>
         <tr><td align="center"><table border=1>
               <tr><td colspan=2 align=center>사용자 추가</td></tr>
               <tr><td>아이디</td><td><input type="text" name="id"></td></tr>
               <tr><td>이름</td><td><input type="text" name="name"></td></tr>
               <tr><td>전화번호</td><td><input type="text" name="phone"></td></tr>
               <tr><td>주소</td><td><input type="text" name="addr"></td></tr>
               <tr><td colspan=2 align=center><INPUT TYPE="SUBMIT" VALUE="사용자 추가">
                  <input type="reset" value="Reset"></td></tr>
         </table></td></tr>
      </table>
      <a href="addrList.jsp">주소록 보기</a>
   </FORM>
</center>
</BODY>
</HTML>