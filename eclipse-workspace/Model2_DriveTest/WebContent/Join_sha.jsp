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
		$("#btnJoin").click(function(){
			//userid=kim&passwd=1234&name=김철수  &양사이드에는 공백이 있으면 안됨
			var param = "userid="+$("#userid").val()
				+"&userpass="+$("#userpass").val()
				+"&username="+$("#username").val()
				+"&useremail="+$("#useremail").val()
				+"&phone="+$("#phone").val()
				+"&zinumber="+$("#zinumber").val()
				+"&adress1="+$("#adress1").val()
				+"&adress2="+$("#adress2").val()
				$.ajax({
					type: "post",
					url: "/Model2_DriveTest/control_servlet2/join_sha.do", 
					data: param,
					cache : false,
					success: function() {
						alert("추가되었습니다.")
					}
				});
		});
	});
	
	</script>
</head>
<body>
	<h2>회원가입과 로그인</h2>
	아이디:  <input id="userid"><br>
	비밀번호: <input type="password" id="userpass"><br>
	이름: <input id="username"><br>
	이메일: <input id="useremail"><br>
	핸드폰: <input id="phone"><br>
	우편번호: <input id="zinumber"><br>
	주소=>시군: <input id="adress1"><br>
	상세주소: <input id="adress2"><br>
	<button id="btnJoin">회원가입</button>
	

</body>
</html>