<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환영합니다!</title>
<link rel="stylesheet" href="./home_login.css" type="text/css">
</head>
<body>
	<section class="main_c">
    	<div>
        	<h1>로그인</h1>
        </div>
        <div class="login-form">
			<form action="./semi-login" method="post">
				<label for="user_id">ID</label>
		        <input type="text" name="userId" id="user_id" class="input-block" required>
		        <label for="user_pass">PW</label>
		        <input type="password" name="userPassword" id="user_pass" class="input-block" required>
		        <input type="submit" value="로그인" class="btn_login">
			</form>
	 	</div>
	 	<div><a href="#">회원가입</a></div>
    </section>
</body>
</html>