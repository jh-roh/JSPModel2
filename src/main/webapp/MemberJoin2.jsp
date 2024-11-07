<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<center>
		<h2>회원 가입 양식</h2>
		<form action="Mproc2" method="post">
			<table width="400" border="1" bordercolor="gray">
				<tr height="40">
					<td width="150">아이디</td>
					<td width="250"><input type="text" name="id"></td>
				</tr>
				<tr height="40">
					<td width="150">패스워드</td>
					<td width="250"><input type="password" name="pass1"></td>
				</tr>
				<tr height="40">
					<td width="150">이메일</td>
					<td width="250"><input type="email" name="email"></td>
				</tr>
				<tr height="40">
					<td width="150">전화번호</td>
					<td width="250"><input type="tel" name="tel"></td>
				</tr>
				<tr height="40">
					<td width="150">주소</td>
					<td width="250"><input type="text" name="info"></td>
				</tr>
				<tr height="40">
					<td align="center" colspan="2"><input type="submit" value="회원가입"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>