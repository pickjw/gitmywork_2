<%@page import="db.CarListBean"%>
<%@page import="db.RentcarDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
		<%
			request.setCharacterEncoding("UTF-8");		
		%>
		<jsp:useBean id="rbean" class="db.CarReserveBean"> 
			<jsp:setProperty name="rbean" property="*"/>
		</jsp:useBean>
		
		<!-- 날짜 : <%= rbean.getRday()%>  -->
		
		<%
			/* TOP.jsp에 로그인 처리 해놓은것 주석
			String id = (String) session.getAttribute("id");

			//처음 로그인이 되어 있지 않다면 
			if(id== null) {
				id="GUEST";
				
			} */

			String id = (String) session.getAttribute("id");
			if(id==null) {
		%>	
		<script type="text/javascript">
			alert("로그인후 예약이 가능합니다.");
			location.href="RentcarMain.jsp?center=MemberLogin.jsp";
		</script>		
		<%	
			}
			//날짜비교
			Date d1 = new Date();
			Date d2 = new Date();
			//날짜를 2018-2-2 를 포맷 해주는 클래스 선언
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			
			d1 = sdf.parse(rbean.getRday());
			d2 = sdf.parse(sdf.format(d2));
			
			//날짜 비교 메서드를 사용 할수 있음
			int compare = d1.compareTo(d2);
			
			//예약하려는 날짜가 현재 날짜 보다 뒤에 있음 예약안됨=> -1 	(지난 날짜임)
			//예약하려는 날짜가 현재 날짜가 같다면=>  0				(당일 예약임)
			//예약하려는 날짜가 현재 날짜 보다 앞에 있음 예약됨 => 1을 리턴함(당일 이후)
			if(compare == -1 ) {//오늘보다 이전 날짜 선택시 
		%>		
			<script type="text/javascript">
				alert("현재 날짜 보다 이전 날짜는 선택 할수 없습니다.");
				history.go(-1);
			</script>		
		<%		
			}
			
			//결과적으로 문제가 없다면 데이터 저장후 결과 페이지 출력
			//아이디 값이 빈클래스에 없기에  id값 가져오기
			String id1 = (String) session.getAttribute("id");
			rbean.setId(id1);
			
			//데이터 베이스에 빈클래스를 저장
			RentcarDAO rdao = new RentcarDAO();
			rdao.setReserveCar(rbean);
			
			//차량정보 얻어오기
			CarListBean cbean = rdao.getOneCar(rbean.getNo());
			
			//차량 총금액 
			int totalcar = cbean.getPrice()*rbean.getQty()* rbean.getDday();
			
			//옵션금액
			int usein = 0;
			if(rbean.getUsein() ==1) {
				usein= 10000;	
			}else if (rbean.getUsein() ==2) {
				usein= 20000;
			}else if (rbean.getUsein() ==3) {
				usein= 30000;
			}else if (rbean.getUsein() ==4) {
				usein= 40000;
			}else if (rbean.getUsein() ==5) {
				usein= 50000;
			}else if (rbean.getUsein() ==6) {
				usein= 60000;
			}else if (rbean.getUsein() ==7) {
				usein= 70000;
			}else if (rbean.getUsein() ==8) {
				usein= 140000;
			}else if (rbean.getUsein() ==9) {
				usein= 210000;
			}else if (rbean.getUsein() ==10) {
				usein= 300000;
			}
				
				
			
			int usewifi = 0;
			if(rbean.getUsewifi() ==1) {
				usewifi= 10000;
			}else if (rbean.getUsewifi() ==2) {
				usewifi= 20000;
			}else if (rbean.getUsewifi() ==3) {
				usewifi= 30000;
			}else if (rbean.getUsewifi() ==4) {
				usewifi= 40000;
			}else if (rbean.getUsewifi() ==5) {
				usewifi= 50000;
			}else if (rbean.getUsewifi() ==6) {
				usewifi= 60000;
			}else if (rbean.getUsewifi() ==7) {
				usewifi= 70000;
			}else if (rbean.getUsewifi() ==8) {
				usewifi= 140000;
			}else if (rbean.getUsewifi() ==9) {
				usewifi= 210000;
			}else if (rbean.getUsewifi() ==10) {
				usewifi= 300000;
			}
				
				
			
			int useseat = 0;
			if(rbean.getUseseat() ==1) {
				useseat= 10000;
			}else if (rbean.getUseseat() ==2) {
				useseat= 20000;
			}else if (rbean.getUseseat() ==3) {
				useseat= 30000;
			}else if (rbean.getUseseat() ==4) {
				useseat= 40000;
			}else if (rbean.getUseseat() ==5) {
				useseat= 50000;
			}else if (rbean.getUseseat() ==6) {
				useseat= 60000;
			}else if (rbean.getUseseat() ==7) {
				useseat= 70000;
			}else if (rbean.getUseseat() ==8) {
				useseat= 140000;
			}else if (rbean.getUseseat() ==9) {
				useseat= 210000;
			}else if (rbean.getUseseat() ==10) {
				useseat= 300000;
			}
			
			int totaloption = (rbean.getQty()* rbean.getDday()*(usein + usewifi + useseat));
			
		%>
	<center>
		<table width="1000">
				
				<tr height="100" >
			 		<td colspan="2" align="center">
		 				<font size="6" color="black">차량 예약 완료</font>
		 			</td>
		 		</tr>
		 		
		 		<tr>
			 		<td  align="center">
		 				<img alt="" src="img/<%=cbean.getImg()%>" width="470">
		 			</td>
		 		</tr>
		 		
		 		<tr height="50" >
			 		<td colspan="2" align="center">
		 				<font size="5" color="red">차량 총 예약 금액<%= totalcar %> 원</font>
		 			</td>
		 		</tr>
		 		
		 		<tr height="50" >
			 		<td colspan="2" align="center">
		 				<font size="5" color="red">차량 총 옵션 금액<%= totaloption %> 원</font>
		 			</td>
		 		</tr>
		 		
		 		<tr height="50" >
			 		<td colspan="2" align="center">
		 				<font size="5" color="red">차량 총 금액<%= totalcar + totaloption %> 원</font>
		 			</td>
		 		</tr>
		 		
		</table>
	</center>
</body>
</html>