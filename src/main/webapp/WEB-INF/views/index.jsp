<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트</title>
</head>
<body>
	<header>
		<c:choose>
			<c:when test="${userBean.login }">
				<a href = "user/update">회원수정</a>
				<a href = "user/myPage?id=${userBean.user_id }">회원정보</a>
				<a href = "user/delete">회원탈퇴</a>
				<a href = "user/logout">로그아웃</a>
			</c:when>
			<c:otherwise>
				<a href = "user/login">로그인</a>
				<a href = "user/join">회원가입</a>
			</c:otherwise>
		</c:choose>
	</header>
	<section>
		<h2>회원목록</h2>
		<table>
			<tr>
				<th>ID</th>
				<th>이름</th>
				<th>직업</th>
			</tr>
			<c:forEach var="user" items="${list}">
				<tr>
					<td>
						<a href="user/myPage?id=${user.user_id}">
							${user.user_id }
						</a>
					</td>
					<td>${user.user_name }</td>
					<td>${user.user_job }</td>
				</tr>
			</c:forEach>
		</table>
	</section>
	<footer>
		2025 솔데스크.
	</footer>
</body>
</html>