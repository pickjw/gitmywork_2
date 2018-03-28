<%@page import="db.HotelRoomListDTO"%>
<%@page import="db.HotelDAO"%>
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
		<jsp:useBean id="hdto" class="db.HotelReserveDTO"> 
			<jsp:setProperty name="hdto" property="*"/>
		</jsp:useBean>
		
		<!-- 날짜 : <%= hdto.getRday()%>  추가-->
		
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
			
			d1 = sdf.parse(hdto.getRday());
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
			hdto.setId(id1);
			
			//데이터 베이스에 hdto클래스를 저장
			HotelDAO hdao = new HotelDAO();
			hdao.setReserveHotel(hdto);
			
			//룸정보 얻어오기
			HotelRoomListDTO cbean = hdao.getOneHotel(hdto.getNo());
			
			//총금액 
			int totalhotel = cbean.getPrice()*hdto.getDday();
			
			//옵션금액
			int mfood = 0;
			if(hdto.getMfood() ==1) {
				mfood= 10000;	
			}else if (hdto.getMfood() ==2) {
				mfood= 20000;
			}else if (hdto.getMfood() ==3) {
				mfood= 30000;
			}else if (hdto.getMfood() ==4) {
				mfood= 40000;
			}else if (hdto.getMfood() ==5) {
				mfood= 50000;
			}else if (hdto.getMfood() ==6) {
				mfood= 60000;
			}else if (hdto.getMfood() ==7) {
				mfood= 70000;
			}else if (hdto.getMfood() ==8) {
				mfood= 140000;
			}else if (hdto.getMfood() ==9) {
				mfood= 210000;
			}else if (hdto.getMfood() ==10) {
				mfood= 300000;
			}
				
				
			
			int dfood = 0;
			if(hdto.getDfood() ==1) {
				dfood= 10000;
			}else if (hdto.getDfood() ==2) {
				dfood= 20000;
			}else if (hdto.getDfood() ==3) {
				dfood= 30000;
			}else if (hdto.getDfood() ==4) {
				dfood= 40000;
			}else if (hdto.getDfood() ==5) {
				dfood= 50000;
			}else if (hdto.getDfood() ==6) {
				dfood= 60000;
			}else if (hdto.getDfood() ==7) {
				dfood= 70000;
			}else if (hdto.getDfood() ==8) {
				dfood= 140000;
			}else if (hdto.getDfood() ==9) {
				dfood= 210000;
			}else if (hdto.getDfood() ==10) {
				dfood= 300000;
			}
				
				
			
			int service = 0;
			if(hdto.getService() ==1) {
				service= 10000;
			}else if (hdto.getService() ==2) {
				service= 20000;
			}else if (hdto.getService() ==3) {
				service= 30000;
			}else if (hdto.getService() ==4) {
				service= 40000;
			}else if (hdto.getService() ==5) {
				service= 50000;
			}else if (hdto.getService() ==6) {
				service= 60000;
			}else if (hdto.getService() ==7) {
				service= 70000;
			}else if (hdto.getService() ==8) {
				service= 140000;
			}else if (hdto.getService() ==9) {
				service= 210000;
			}else if (hdto.getService() ==10) {
				service= 300000;
			}
			
			int totaloption = (hdto.getDday()*(mfood + dfood + service));
			
		%>
	<center>
	
		<div style=" height:70px;"></div>
		<div>
		
			<img alt="" src="img/<%=cbean.getImg()%>" width="700">
		
		
		</div>
		
		<table width="1000">
				
				<tr height="100" >
			 		<td colspan="2" align="center">
		 				<font size="5" color="red">예약 완료</font>
		 			</td>
		 		</tr>
		 		
		 		<tr height="50" >
			 		<td colspan="2" align="center">
		 				<font size="5" color="white">호텔룸 금액&nbsp;&#8361;&nbsp;<%= totalhotel %> 원</font>
		 			</td>
		 		</tr>
		 		
		 		<tr height="50" >
			 		<td colspan="2" align="center">
		 				<font size="5" color="white">옵션 금액&nbsp;&#8361;&nbsp;<%= totaloption %> 원</font>
		 			</td>
		 		</tr>
		 		
		 		<tr height="50" >
			 		<td colspan="2" align="center">
		 				<font size="5" color="white">총 금액&nbsp;&#8361;&nbsp;<%= totalhotel + totaloption %> 원</font>
		 			</td>
		 		</tr>
		 		
		 		<tr height="100" >
			 		<td colspan="2" align="center">
		 				<font size="2" color="red"></font>
		 			</td>
		 		</tr>
		 		
		</table>
	</center>
</body>
</html>