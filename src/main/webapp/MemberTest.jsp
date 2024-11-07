<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<center>
		<h2>회원 가입 양식</h2>
	<center>
		<table width="400">
			<tr height="40">
				<td width="150">아이디</td>
				<td width="250">${bean.id}</td>
			</tr>
			<tr height="40">
				<td width="150">패스워드</td>
				<td width="250">${bean.pass1}</td>
			</tr>
			<tr height="40">
				<td width="150">이메일</td>
				<td width="250">${bean.email}</td>
			</tr>
			<tr height="40">
				<td width="150">전화번호</td>
				<td width="250">${bean.tel}</td>
			</tr>
			<tr height="40">
				<td width="150">주소</td>
				<td width="250">${bean.info}</td>
			</tr>
		</table>

	</center>
</body>
</html>