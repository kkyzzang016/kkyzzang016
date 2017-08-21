<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
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
	</style>
</head>
<body>
<div id="wrapper">
	<!-- <header> 
		<h1 class="header1">fixed-width Layout</h1>
	</header> -->
	
	<jsp:include page="header.jsp"/>
	
	<section>
		<article>
		   <p>실제 내용이 표시됩니다</p>
		   <p>실제 내용이 표시됩니다
		   </p>
		   <p>실제 내용이 표시됩니다</p>		   
		   <p>실제 내용이 표시됩니다</p>
		   <p>실제 내용이 표시됩니다</p>
		</article>
		<aside>
			<!-- <p> 사이드바의 내용이 표시됩니다</p>
			<p> 사이드바의 내용이 표시됩니다</p>
			<p> 사이드바의 내용이 표시됩니다</p>
			<p> 사이드바의 내용이 표시됩니다</p>
			<p> 사이드바의 내용이 표시됩니다</p>
			<p> 사이드바의 내용이 표시됩니다</p>	 -->
			<%if(session.getAttribute("id")==null){ %>
			<jsp:include page="loginForm.jsp"/>
			<%}else{ %>
			<jsp:include page="loginSuccess.jsp"/>
			<%} %>
		</aside>
	</section>
	<footer>
		<!-- <address>제작자 연락처 정보</address>
		<p> 저작권 정보 및 주소  </p> -->
		<jsp:include page="footer.jsp"/>
	</footer>
</div>
</body>
</html>