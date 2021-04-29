<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환영합니다!</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/home_login.css" type="text/css">
</head>
<body>
	<section class="main_c">
    	<div>
        	<h1>로그인</h1>
        	<h5>게시판을 이용하려면 로그인 하세요</h5>
        </div>
        <div class="login-form">
			<form action="./semi-login" method="post">
				<label for="user_id">아이디</label>
		        <input type="text" name="userId" id="user_id" class="input-block" required>
		       
		        <label for="user_pass">비밀번호</label>
		        <input type="password" name="userPassword" id="user_pass" class="input-block" required>
		        
		        
		        <br><input type="submit" value="로그인" class="btn_login">
			</form>
			<div>
				<form action="./join" method="get">
					<input type="submit" value="회원가입" class="btn_join">
				</form>
			</div>

	 	</div>
	 	
    </section>
</body>
</html>