<%@page import="user.UserDAO"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- 반응형 웹구현 -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/bootstrap.css">
	<title>JSP AJAX</title>
	<!-- 애니메이션 jquery & bootstrap -->
	<script type="text/javascript" src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	
	<!--자바스크립트 searchFunction 함수실행- ajaxTable -->   
	<script type="text/javascript" >
	
		var searchRequest = new XMLHttpRequest();
		var registerRequest = new XMLHttpRequest();	
		
		function searchFunction() {						//자바스크립트 ajax 통신시  encodeURIComponet utf-8인코팅 실제 파라미터  			
			//searchRequest.open("POST", "/UserSearchServlet?userName="+document.getElementById("userName").value);
			//searchRequest.open("POST", "/UserSearchServlet");
			//searchRequest.onreadystatechange = searchProcess;
			//searchRequest.send(null);
			//alert(" userName : " + document.getElementById("userName").value);
			$.ajax({
				type: "post",
				url: "/bbs/UserSearchServlet",
				cache : false,
				data: {userName : document.getElementById("userName").value},
				//dataType : 'json',
				//contentType : 'application/json',
				success: function(result) {
					console.log(result);
					//console.log(result.)
					var html = "";
					
					$("#ajaxTable").append(html);
					
				}	
			});
			
		}
		function searchProcess() {
			var table = document.getElementById("ajaxTable");
			table.innerHTML= "";
			if(searchRequest.readyState == 4 && searchRequest.status == 200) {
				var object = eval("("+ searchRequest.responseText+ ")");
				var result = object.result;
				for(var i = 0; i < result.length; i++) {
					var row = table.insertRow(0); //행만들기
					for(var j = 0; j < result[i].length; j++) {
						var cell = row.insertCell(j);
						cell.innerHTML = result[i][j].value;
					}
				}
			}
		}
		function registerFunction() {
			registerRequest.open("POST", "./UserRegisterServlet?userName=" +encodeURIComponet(document.getElementById("registerName").value) +
										"&userAge=" + encodeURIComponet(document.getElementById("registerAge").value) +
										"&userGender=" + encodeURIComponet($('input[name=registerGender] : checked').val()) + 
										"&userEmail=" + encodeURIComponet(document.getElementById("registerEmail").value) , true);
			registerFunction.onreadystatechange = registerFunctionProcess;
			registerFunction.send(null);
			
		}
		function registerFunctionProcess() {
			if(registerRequest.readyState == 4 && searchRequest.status == 200) {
				var result = registerRequest.responseText;
				if(result !=1) {
					alert("등록에 실패헀습니다.");
				}else {
					var userName = document.getElementById("userName");
					var registerName = document.getElementById("registerName");
					var registerAge = document.getElementById("registerAge");
					var registerEmail = document.getElementById("registerEmail");
					userName.value = "";
					registerName.value = "";
					registerAge.value = "";
					registerEmail.value = "";
					searchFunction();
				}
				
			}
			
		}
		window.onload = function() {
			searchFunction();
		}
	</script>
	
</head>
<body>
	<!-- DB연결테스트확인용  -->
	<% 
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	Boolean connect = false;
	try {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jwdb");

		con = ds.getConnection();
		connect = true;

	} catch (Exception e) {
		connect = false;
		e.printStackTrace();
	}

	if (connect) {
		System.out.println("연결ooo");
	} else {
		System.out.println("연결x");
	}

	%>
	
	<br>
	
	<div class="container">
		<!-- 1. 상단 검색 -->   
		<div class="form-group row pull-right">
		     <!--  검색 창 -->       
      		<div class="col-xs-8">							<!--자바스크립트  함수실행 설정 -->      
      			<input class="form-contorl" id="userName" onkeyup="searchFunction()" type="text" size="20">      
      		</div>
      		  <!--  검색 버튼 -->       
      		<div class="col-xs-2">						<!--자바스크립트  함수실행 설정 --> 
      			<input class="btn btn-primary" onclick="searchFunction();" type="button" value="검색">
      		</div>	
      	</div>
      	
      	<!-- 2. 회원정보   -->   
      	<table	class="table" style="text-align: center; border:1px solid #dddddd">
      		<!-- 제목  -->  
      		<thead>
      			<tr>
      				<th style="background-color: #fafafa; text-align: center;">이름</th>
      				<th style="background-color: #fafafa; text-align: center;">나이</th>
      				<th style="background-color: #fafafa; text-align: center;">성별</th>
      				<th style="background-color: #fafafa; text-align: center;">이메일</th>
      			</tr>
      		</thead>
      		
      		<!-- 데이터 베이스의 회원 정보  -->
      		<!--자바스크립트  함수실행 ajaxTable 설정 -->   
      		<tbody id="ajaxTable">
      		</tbody>
      	</table>
	</div>
	<div class="container" >
		<!-- 3. 회원정보등록   -->   
      	<table	class="table" style="text-align: center; border:1px solid #dddddd">
			<thead>
      			<tr>
      				<th colspan="2"  style="background-color: #fafafa; text-align:center;" >회원등록양식</th>
      			</tr>
      		</thead>
      		<tbody>
      			<tr>
      				<td style="background-color: #fafafa; text-align:center;"><h5>이름</h5></td>
      				<td><input class="form-control" type="text" id="registerName" size="20"></td>
      			</tr>
      			<tr>
      				<td style="background-color: #fafafa; text-align:center;"><h5>나이</h5></td>
      				<td><input class="form-control" type="text" id="registerAge" size="20"></td>
      			</tr>
      			<tr>
      				<td style="background-color: #fafafa; text-align:center;"><h5>성별</h5></td>
      				<td>
      					<div class="form-group" style="text-align:center; margin: 0 auto;">
      						<div class="btn-group" data-toggle="buttons" >
      							<label class="btn btn-primary active">
	      							<input type="radio" name="registerGender" autocomplete="off" value="남자" checked>남자
      							</label>
      							 <label class="btn btn-primary">
      								 <input type="radio" name="registerGender" autocomplete="off" value="여자" >여자
      							 </label>
      						</div>
      					</div>
      				</td>
      			</tr>
      			<tr>
      				<td style="background-color: #fafafa; text-align:center;"><h5>이메일</h5></td>
      				<td><input class="form-control" type="email" id="registerEmail" size="20"></td>
      			</tr>
      			<tr>
      				<td colspan="2"><input class="btn btn-primary pull-right" onclick="registerFunction();" type="button" value="등록"></td>
      				
      			</tr>
      		</tbody>
		</table>
	</div>
</body>
</html>












