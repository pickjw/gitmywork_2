<%@page import="db.HotelViewDTO"%>
<%@page import="db.HotelDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>

	<%
		String id = (String) session.getAttribute("id");
	
		if(id==null) {
	%>		
		<script>
			alert("로그인을 먼저 해주세요!");
			location.href="RentcarMain.jsp?center=MemberLogin.jsp";
		</script>	
	<%	
		}
		//로그인 되어있는 아이디를 읽어 옴
		HotelDAO hdao = new HotelDAO();
		ArrayList<HotelViewDTO> arrayList = hdao.getAllReserve(id);	
	%>
	<center>
		<table width="1000" border="1">
				<tr height="100" >
			 		<td colspan="11" align="center">
		 				<font size="6" color="white">예약 내역 화면</font>
		 			</td>
		 		</tr>
		 		
		 		<tr height="40" >
			 		<td width="150" align="center">룸&nbsp;이미지</td>
			 		<td width="150" align="center">호수명</td>
			 		<td width="150" align="center">날짜</td>
			 		<td width="60" align="center">숙박기간</td>
			 		<td width="100" align="center">금액</td>
			 		<td width="60" align="center">조식</td>
			 		<td width="60" align="center">보험</td>
			 		<td width="60" align="center">석식</td>
			 		<td width="60" align="center">룸서비스</td>
			 		<td width="60" align="center">삭제</td>
			 		<td width="90" align="center">전송</td>
		 		</tr>
		 		
	<%
		for(int i=0; i< arrayList.size(); i++) {
			HotelViewDTO dto = arrayList.get(i);
	%>	
				<tr height="70" bordercolor="bule">
			 		<td width="150" align="center">
			 			<img alt="" src="img/<%=dto.getImg() %>" width="150" height="70">
			 		</td>
			 		<td width="150" align="center"><%=dto.getName() %></td>
			 		<td width="150" align="center"><%=dto.getRday()%></td>
			 		<td width="60" align="center"><%=dto.getDday()%></td>
			 		<td width="100" align="center"><%=dto.getPrice()%></td>
			 		<td width="60" align="center"><%=dto.getMfood()%></td>
			 		<td width="60" align="center"><%=dto.getDfood()%></td>
			 		<td width="60" align="center"><%=dto.getService()%></td>
			 		<td width="90" align="center">
			 			<button onclick="location.href='CarReserveDel.jsp?id=<%=id%>&rday=<%=dto.getRday()%>'">삭제</button>
			 		</td>
			 		<td width="90" align="center">
			 			<button onclick="location.href='CarReserveDel.jsp?id=<%=id%>&rday=<%=dto.getRday()%>'">전송</button>
			 		</td>
			 	</tr>
	<%	
		}
	%>	 		
		 		
		 		
		 		
		 		
		 		
			
		</table>
	</center>
</body>
</html>