<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="#e0ffff">
	<form method="post" action="inputpro.jsp" name="userinput"
		onsubmit="return checkIt();">
		<table width="600" border="1" cellspacing="0" cellpadding="3"
			align="center">
			<tr>
				<td colspan="2" height="39" align="center" bgcolor="#b0e0e6"><font
					size="1"> <b>회원가입</b></font></td>
			</tr>
			<tr>
				<td width="200" bgcolor="#b0e0e6"><b>아이디 입력</b></td>
				<td width="400" bfcolor="#b0e0e6">&nbsp;</td>
			</tr>

			<tr>
				<td width="200">사용자 ID</td>
				<td width="400"><input type="text" name="id" size="10"
					maxlength="12"> <input type="button" name="confirm_id"
					value="ID중복확인" onclick="openConfirmid(this.form)"></td>
			</tr>

			<tr>
				<td width="200">비밀번호</td>
				<td width="400"><input type="password" name="password"
					size="15" maxlength="12"></td>
			</tr>

			<tr>
				<td width="200">비밀번호 확인</td>
				<td width="400"><input type="password" name="passwd2" size="15"
					maxlength="12"></td>
			</tr>

			<tr>
				<td width="200" bgcolor="#b0e0e6"><b>개인정보 입력</b></td>
				<td width="400"><input type="text" name="name" size="15"
					maxlength="10"></td>
			</tr>

			<tr>
				<td width="200">사용자 이름</td>
				<td width="400"><input type="text" name="name" size="15"
					maxlength="10"></td>
			</tr>

			<tr>
				<td width="200">주민등록번호</td>
				<td width="400"><input type="text" name="jumin1" size="7"
					maxlength="6"> <input type="text" name="jumin2" size="7"
					maxlength="7"></td>
			</tr>

			<tr>
				<td width="200">E-mail</td>
				<td width="400"><input type="text" name="email" size="40"
					maxlength="30"></td>
			</tr>

			<tr>
				<td width="200">내용</td>
				<td width="400"><input type="text" name="content" size="60"
					maxlength="50"></td>
			</tr>

			<tr>
				<td colspan="2" align="center" bgcolor="#b0e0e6"><input
					type="submit" name="confirm" value="등 록"> <input
					type="reset" name="reset" value="다시입력"> <input
					type="button" value="가입안함"
					onclick="javascript:window.location='main.jsp'"></td>
			</tr>

		</table>
</body>
</html>