<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="./include/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
	$(function(){		
		$("#btnLogin").click(function(){
			var param = "userid="+$("#userid").val()
					+"&userpass="+$("#userpass").val();
			$.ajax({
				type: "post",
				url: "/Model2_DriveTest/control_servlet2/login_oracle_secret.do", 
				data: param,
				cache : false,
				success:function(result){   
					console.log(result);
					 $("#result").html(result);     //  $("#div1").load("가져올페이지");   $("#result").html(result); 
				}
			});
		});
	});
	/* window.onload = function() {
		searchFunction();
	} */
	</script>
</head>
<body>
	<h2>로그인 (오라클 암호화)</h2>
	아이디 : <input id="userid"><br>
	비번 : <input type="password" id="userpass"><br>
	<button id="btnLogin">로그인</button>
	<div id="result">값나와라</div>
</body>
</html>