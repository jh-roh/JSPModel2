<%@page import="model.MemberBean"%>
<%@page import="java.util.Vector"%>
<%@page import="model.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 1.데이터베이스에서 모든 회원의 정보를 가져옴. 2. table 태그를 이용하여 화면에 회원들의 정보를 표출  -->

<%
	MemberDao mdao = new MemberDao();

	//회원들의 정보가 얼마나 저장되어 있는지 모르기에 가변길이인 Vecotr를 이용하여 데이터를
	//저장해준다.
	Vector<MemberBean> vec = mdao.getAllMember();
	
	request.setAttribute("vec", vec);

%>
<center>
	<%-- <table width="800" border="1">
		<tr height="50">
			<td align="center" width="150">아이디</td>
			<td align="center" width="250">이메일</td>
			<td align="center" width="200">전화번호</td>
			<td align="center" width="200">취미</td>
		</tr>
		<%
			for(int i = 0; i < vec.size(); i++) {
			//벡터에 담긴 빈 클래스를 하나씩 추출
			MemberBean bean = vec.get(i);
		%>
			<tr height="50">
				<td align="center" width="150">
					<a href="MemberInfo.jsp?id=<%=bean.getId()%>">
					<%=bean.getId() %></a>
				</td>
				<td align="center" width="250"><%=bean.getEmail() %></td>
				<td align="center" width="200"><%=bean.getTel() %></td>
				<td align="center" width="200"><%=bean.getHobby() %></td>
			</tr>
		<%}%>
	</table> --%>
	<table width="800" border="1">
		<tr height="50">
			<td align="center" width="150">아이디</td>
			<td align="center" width="250">이메일</td>
			<td align="center" width="200">전화번호</td>
			<td align="center" width="200">취미</td>
		</tr>
			<c:forEach var="bean" items="${vec}">
		<tr height="50">
				<td align="center" width="150">
					<a href="MemberInfo.jsp?id=${bean.id}%>">${bean.id}</a>
				</td>
				<td align="center" width="250">${bean.email}</td>
				<td align="center" width="200">${bean.tel}</td>
				<td align="center" width="200">${bean.hobby}</td>
			</tr>
	</c:forEach>
	</table>

</center>
</body>
</html>