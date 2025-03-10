<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<header>
		<h2>회원가입</h2>
	</header>
	<section>
		<form:form action="joinPro" modelAttribute="userBean" method="post">
			<form:label path="user_id">ID</form:label>
			<form:input path="user_id" />
			<form:errors path="user_id" cssStyle="color:red;" />
			<form:label path="user_pass">비밀번호</form:label>
			<form:password path="user_pass" />
			<form:errors path="user_pass" cssStyle="color:red;" />
			<form:label path="user_name">이름</form:label>
			<form:input path="user_name" />
			<form:errors path="user_name" cssStyle="color:red;" />
			<form:label path="user_age">나이</form:label>
			<form:input path="user_age" />
			<form:errors path="user_age" cssStyle="color:red;" />
			<form:label path="user_gender">성별</form:label>
			<form:select path="user_gender">
				<form:option value="남성">남성</form:option>
				<form:option value="여성">여성</form:option>
			</form:select>
			<form:label path="user_job">직업</form:label>
			<form:input path="user_job" />
			<form:errors path="user_job" cssStyle="color:red;" />
			<form:label path="user_address">주소</form:label>
			<form:input path="user_address" />
			<form:errors path="user_address" cssStyle="color:red;" />
			<button type="submit">회원가입</button>
		</form:form>

	</section>
	<footer> © 솔데스크 </footer>
</body>
</html>