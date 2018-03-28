<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<%-- <script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.js"></script> --%>
	<script type="text/javascript" src="./include/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
	$(function(){
		var show = getCookie("showCookies");
		console.log(document.cookie);//확인용
		if (show != "N") {
			window.open("Popup.jsp", "", "width=300, height=400");
		}
		var cookie_userid = getCookie("userid");
		if (cookie_userid != "") {
			$("#userid").val(cookie_userid);
			$("#chkSave").attr("checked",true);	
		}
		$("#btnLogin").click(function(){
			if($("#chkSave").is(":checked")) { //check
				saveCookie($("#userid").val());
			} else { //uncheck
				saveCookie("");
			}
		});
		$("#chkSave").click(function(){
			if($("#chkSave").is(":checked")) { 
				if(!confirm("로그인 정보를 저장 하시겠습니까?")) {
					$("#chkSave").prop("checked",false);
				}
			}
		});
	});
	function saveCookie(id) {
		if (id != "") {
			setCookie("userid", id, 7); //7일
		} else {
			setCookie("userid", id, -1); //삭제
		}
	}
	function setCookie(name, value, days) {
		var today = new Date(); //날짜 객체
		today.setDate(today.getDate() + days);
		document.cookie = name + "=" + value
			+ ";path=/Model2_DriveTest;expires="
			+ today.toGMTString() + ";";	
	}
	//저장된 쿠키를 검사하는 함수
	function getCookie(cname) {
		var cookie = document.cokkie + ";";
		console.log(cookie);
		var idx = cookie.indexOf(cname,0);
		var val = "";
		if (idx != -1) {
			consol.log(idx + "," + cookie.length);
			cookie = cookie.substring(idx, cookie.length);
			begin = cookie.indexOf("=", 0) + 1;
			end = cookie.indexOf(";", begin);
			consol.log(begin + "," +end);
		}
		
		return val;
	}
	
	
	</script>
</head>
<body>
	<form action="" method="post">
		<table border="1"> 		
			<tr>
				<td>아이디</td>                                                     <!--  checked -->
				<td><input name="userid" id="userid" value=""><input type="checkbox" id="chkSave" >아이디저장</td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="로그인" id="btnLogin">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>