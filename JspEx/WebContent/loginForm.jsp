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
		<form method="post" action="Login">
			<br>
			<br>
			<br>
			<h2>환영합니다!</h2>
			<br>
			<table border=3 cellspacing=0 width=300>
				<tr>
					<td align=center height=50><b>Name</b></td>
					<td align=center><input type=text size=20 maxlength=10 name="name">
					</td>
				</tr>
				<tr>
					<td align=center height=50><b>Job</b></td>
					<td align=center><input type=text size=20 maxlength=10 name="job">
					</td>
				</tr>
				<tr align=center>
					<td colspan="2" height=50>
					<input type="submit" value="전송">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>