<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/product.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<h1>상품 등록 - 관리자 페이지</h1>
		<form method="post" action="movieWrite.do" enctype="multipart/form-data" name="frm">
			<table>
				<tr>
					<th>제 목</th>
					<td><input type="text" name="title" size="80"></td>
				</tr>
				<tr>
					<th>가 격</th>
					<td><input type="text" name="price"> 원</td>
				</tr>
				<tr>
					<th>감 독</th>
					<td><input type="text" name="director"> 원</td>
				</tr>
				<tr>
					<th>배 우</th>
					<td><input type="text" name="actor"> 원</td>
				</tr>
				<tr>
					<th>사 진</th>
					<td><input type="file" name="poster"><br>
						(주의사항 : 이미지를 변경하고자 할때만 선택하시오)</td>
				</tr>
				<tr>
					<th>설 명</th>
					<td><textarea cols="80" rows="10" name="synopsis"></textarea></td>
				</tr>
			</table>
			<br> <input type="submit" value="등록"
				onclick="return movieCheck()"> <input type="reset"
				value="다시작성"> <input type="button" value="목록"
				onclick="location.href='movieList.do'">
		</form>
	</div>
</body>
</html>