<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/home_join.css" type="text/css">
 <script type="text/javascript">
    
        // 필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수
        function checkValue()
        {
            if(!document.userInfo.id.value){
                alert("아이디를 입력하세요.");
                return false;
            }
            
            if(!document.userInfo.pass1.value){
                alert("비밀번호를 입력하세요.");
                return false;
            }
            
            // 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
            if(document.userInfo.pass1.value != document.userInfo.pass2.value ){
                alert("비밀번호를 동일하게 입력하세요.");
                return false;
            }
        }
    </script>
</head>
<body>
	<section class="main_c">
		<div>
			<h1>회원가입</h1>
		</div>
		<div class="join-form">
		    <form action="join" method="post" name="userInfo" onsubmit="return checkValue()">
		    	<label for="user_id">아이디</label>
		        <input type="text" name="id" id="user_id" class="input-block" maxlength="20" placeholder="영문 최대 20자 까지 가능" required>
				
				<label for="user_pass">비밀번호</label>
		        <input type="password" name="pass1" id="user_pass" class="input-block" maxlength="20" placeholder="영문 최대 20자 까지 가능" required>
				
				<label for="user_pass2">비밀번호 확인</label>
				<input type="password" name="pass2" id="user_pass2" class="input-block" maxlength="20" required>
				
				<label for="name">이름</label>
				<input type="text" name="name" id="name" class="input-block" maxlength="20" required>
 				
 				<label for="email">이메일</label>
				<input type="email" name="email" id="email" class="input-block" maxlength="50" required>
				
				<label for="phone">핸드폰 번호</label>
				<input type="text" name="phone" id="phone" class="input-block" maxlength="20" placeholder="(-) 입력해주세요" required>
				
				<br><input type="submit" value="가입" class="btn_join">
			</form>
		</div>
	</section>
</body>
</html>