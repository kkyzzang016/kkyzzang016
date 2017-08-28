<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center" >
		<tr>
			<td colspan="2" align="center"> 마이페이지</td>
		</tr>
		<tr>
			<td align="center" width="300">아이디</td>
			<td width="300" align="center"><input type="text" name="id" ></td>
		</tr>
		<tr>
			<td align="center" >비밀번호</td>
			<td align="center"><input type="password" name="pass"></td>
		</tr>
		<tr>
			<td align="center">이름</td>
			<td width="300" align="center"><input type="text" name="name" ></td>
		</tr>
		<tr>
			<td align="center">권한</td>
			<td align="center"><select name="lev" disabled="disabled">
				<option value = "A">운영자</option>
				<option value = "B" selected>일반회원</option>
			</select></td>
		</tr>
		<tr>
			<td align="center">성별</td>
			<td align="center"><select name="gender">
				<option value = "male" selected>남자</option>
				<option value = "female" >여자</option>
			</select></td>
		</tr>
		<tr>
			<td align="center">전화번호</td>
			<td width="300" align="center"><input type="text" name="phone" ></td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<input type="submit" value="수정">
				<input type="reset" value="취소">
			</td>
		</tr>			
		</table>
</body>
</html>