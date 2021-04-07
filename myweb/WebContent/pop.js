/**
 * 
 */
function pop() {
	var res = confirm("로그아웃 하시겠습니까?");
	
	if(res) {
		document.getElementsByName("logout_ans").value = "true";
	} else {
		history.back();
	};
}