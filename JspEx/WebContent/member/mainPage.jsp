<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="fmt" %>

<c:set value="${param.page }" var="reqpage"/>
<c:set value="${sessionScope.loginUser }" var="user"/>
<c:set value="${user.id }" var="id" />

<c:if test="${reqpage == null }">
   <c:set value="mainPage.jsp" var="reqpage" />
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width">
   <title>너비가 고정된 레이아웃</title>
   <style>
   body{
      background:#ccc;
   }
   #wrapper{
      width:960px;
      margin:0 auto;
      background-color:white;
   }
   header{
      width:960px;
      height:120px;
      background-color:#f5f4e0;      
      background:url(back.png) no-repeat left center;      
      border-bottom:1px solid black;               
   }
   header h1{
      padding-top:30px;
      padding-left:120px;
   }   
   .header1{
      font-size:40px;
      font-family: "Comic Sans MS";
   }
   article {
      float:left;
      width:600px;
      padding:20px;
   }
   aside {
      float:right;
      width:300px;
      padding:8px;
      background-color:#d7e4e0;
      border-left:1px dotted black;
   }
   footer{
      clear:both;
      background:#677b75;
      padding:10px;
      text-align:center;
   }
   
   nav li{float:left;padding right:30px; font-family:verdana}
   nav li span{padding:5px; background-color:#fff}
   
   </style>
</head>
<body>
<div id="wrapper">
   <header> 
   <!--    <h1 class="header1">fixed-width Layout</h1>
   </header> -->
   
   
   
   <section>
      <article>
         <p>실제 내용이 표시됩니다</p>
         <p>실제 내용이 표시됩니다
         </p>
         <p>실제 내용이 표시됩니다</p>         
         <p>실제 내용이 표시됩니다</p>
         <p>실제 내용이 표시됩니다</p>
        <p>${msg }</p>
      </article>
     
      <aside>
         <!-- <p> 사이드바의 내용이 표시됩니다</p>
         <p> 사이드바의 내용이 표시됩니다</p>
         <p> 사이드바의 내용이 표시됩니다</p>
         <p> 사이드바의 내용이 표시됩니다</p>
         <p> 사이드바의 내용이 표시됩니다</p>
         <p> 사이드바의 내용이 표시됩니다</p>    -->
                  
         <c:choose>
            <c:when  test="${id!=null }">
            ${message }
               <c:out value="${id }" />님 환영합니다,
               <a href="logout.do" > 로그아웃 </a><br/>
               <input type="button" value="회원정보변경" onclick="location.href='memberUpdate.do?id=${id}'">
               <input type="button" value="회원탈퇴" onclick="location.href='memberDelete.do?id=${id}'">
            </c:when>
            <c:otherwise>
               <jsp:include page="/member/login.jsp" />
            </c:otherwise>
         </c:choose>
         
      </aside>
   </section>
</div>
</body>
</html>