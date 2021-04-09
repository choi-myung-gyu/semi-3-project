<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 화면</title>

 <script type="text/javascript">
    
        // 필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수
        function checkValue()
        {
            if(!document.userInfo.userId.value){
                alert("아이디를 입력하세요.");
                return false;
            }
            
            if(!document.userInfo.userPassword1.value){
                alert("비밀번호를 입력하세요.");
                return false;
            }
            
            // 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
            if(document.userInfo.userPassword1.value != document.userInfo.userPassword2.value ){
                alert("비밀번호를 동일하게 입력하세요.");
                return false;
            }
        }
    </script>
</head>
<body>
    <div class="container">
			<h1>회원가입</h1>
	    <form action="join" method="post" name="userInfo" onsubmit="return checkValue()">
		<table>
			<tr>
				<td>아이디</td>
				<td>
				<input type="text" name="userId" maxlength="20" placeholder="영문 최대 20자 까지 가능" >
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
				<input type="password" name="userPassword1" maxlength="20" placeholder="영문 최대 20자 까지 가능" >
				</td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td>
				<input type="password" name="userPassword2" maxlength="20" >
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
				<input type="text" name="userName" id="name" maxlength="20" required>
				</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>
				<input type="email" name="userEmail" maxlength="50" required>
				</td>
			</tr>
			<tr>
				<td>핸드폰번호</td>
				<td>
				<input type="text" name="userPhone" maxlength="20"  placeholder="(-) 입력해주세요" required>
				</td>
			</tr>
			<tr>
			<td>
			<input type="submit" value="가입">
			</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>