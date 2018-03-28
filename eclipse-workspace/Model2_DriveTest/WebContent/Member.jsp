<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<%-- <script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.js"></script> --%>
	<script type="text/javascript" src="./include/jquery-3.2.1.min.js"></script>
	<%-- <% String context = request.getContextPath(); %> <!--context context빌드패스 추가하기 위해  --> --%>
	<script type="text/javascript">
		//페이지 로딩이 끝나면 자동으로 실행되는 코드
		$(function (){
			list();	
			$("#btnSave").click(function(){	
				insert();
			}); 
		});
		
		    function insert () {
			var param="userid="+$("#userid").val()+"&userpass="+$("#userpass").val()
						+"&username="+$("#username").val()+"&useremail="+$("#useremail").val()
						+"&phone="+$("#phone").val();
			$.ajax({
				type: "post",
				url: "/Model2_DriveTest/control_servlet/join.do", 
				data: param,
				success: function() {
					list();//회원목록 갱신
					//입력값 초기화
					$("#userid").val(""); 
					$("#userpass").val("");
					$("#username").val(""); 
					$("#useremail").val("");
					$("#phone").val("");
				}	
			});
		} 
		
		function list(){
			//회원목록을 div에 출력
			$.ajax({
				type: "post",
				url: "/Model2_DriveTest/control_servlet/list.do", 
				cache : false,
				success: function(result) {
					console.log(result);
					$("#memberList").html(result);
				}
			});
		}
	</script>
</head>
<body>
	<h2>회원관리</h2>
	아이디 : <input id="userid">
	비번 : <input id="userpass"><br>
	이름 : <input id="username">
	이메일 : <input id="useremail"><br>
	핸드폰 : <input id="phone">
	<button type="button" id="btnSave">추가</button>
	<div id="memberList">    </div>
	
	
	
</body>
</html>