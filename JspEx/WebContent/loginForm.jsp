<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name=f method="post" action=".jsp">
		<center>
			<table border=2 cellspacing=0 width=300>
				<tr>
					<td align=center height=40><b> ID </b></td>
					<td align=center><input type="text" size=20 maxlength=16
						name="id"></td>
				</tr>
				<tr>
					<td align=center height=40><b> PASSWORD </b></td>
					<td align=center><input type="password" size=20 maxlength=10
						name="pass"></td>
				</tr>
				<tr align=center>
					<td colspan=2 height=40><input type="button" value=" ok " onclick=check(this.form) /> &nbsp;&nbsp; 
						<input type="reset" value=" cancel " /> &nbsp;&nbsp;
					    <a href="insertForm.jsp">회원가입</a>
					</td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>