<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form id="loginForm" action="MemberLoginPro.me" method="post">
		<label>이메일  <input type="text" name="email"></label><br>
		<label>비밀번호 <input type="password" name="pass"></label>
<input type="submit" value="로그인" >
<input type="button" value="회원가입" onclick="location.href='MemberJoinForm.me'">
<input type="button" value="취소" onclick="history.back()">
<input type="checkbox" value="이메일 저장" >
</form>
</body>
</html>