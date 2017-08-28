<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<form action="loginemp.do" method="post" name="login">
		<table border="1" align="center" >
		<tr>
			<td colspan="2" align="center"> 로그인</td>
		</tr>
		<tr>
			<td align="center">아이디</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td align="center">비밀번호</td>
			<td><input type="password" name="pass"></td>
		</tr>
		<tr>
			<td align="center">레벨</td>
			<td><select name="lev">
				<option value = "A">운영자</option>
				<option value = "B">일반회원</option>
			</select></td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<input type="submit" value="로그인" onclick="return loginCheck()">
				<input type="reset" value="취소">
			</td>
		</tr>			
		</table>
	</form>
</center>
</body>
</html>