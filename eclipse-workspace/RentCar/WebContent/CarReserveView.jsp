<%@page import="db.CarViewBean"%>
<%@page import="db.CarReserveBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.RentcarDAO"%>
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
		RentcarDAO rdao = new RentcarDAO();
		ArrayList<CarViewBean> arrayList = rdao.getAllReserve(id);	
	%>
	<center>
		<table width="1000" border="1">
				<tr height="100" >
			 		<td colspan="11" align="center">
		 				<font size="6" color="black">차량 예약 화면</font>
		 			</td>
		 		</tr>
		 		
		 		<tr height="40" >
			 		<td width="150" align="center">차량이미지</td>
			 		<td width="150" align="center">차량명</td>
			 		<td width="150" align="center">대여일시</td>
			 		<td width="60" align="center">대여기간</td>
			 		<td width="100" align="center">차량 금액</td>
			 		<td width="60" align="center">수량</td>
			 		<td width="60" align="center">보험</td>
			 		<td width="60" align="center">WIFI</td>
			 		<td width="60" align="center">네비게이션</td>
			 		<td width="60" align="center">베이비시트</td>
			 		<td width="90" align="center">삭제</td>
		 		</tr>
		 		
	<%
		for(int i=0; i< arrayList.size(); i++) {
			CarViewBean bean = arrayList.get(i);
	%>	
				<tr height="70" bordercolor="bule">
			 		<td width="150" align="center">
			 			<img alt="" src="img/<%=bean.getImg() %>" width="150" height="70">
			 		</td>
			 		<td width="150" align="center"><%=bean.getName() %></td>
			 		<td width="150" align="center"><%=bean.getRday()%></td>
			 		<td width="60" align="center"><%=bean.getDday()%></td>
			 		<td width="100" align="center"><%=bean.getPrice()%></td>
			 		<td width="60" align="center"><%=bean.getQty()%></td>
			 		<td width="60" align="center"><%=bean.getUsein()%></td>
			 		<td width="60" align="center"><%=bean.getUsewifi()%></td>
			 		<td width="60" align="center"><%=bean.getUsenavi() %></td>
			 		<td width="60" align="center"><%=bean.getUseseat()%></td>
			 		<td width="90" align="center">
			 			<button onclick="location.href='CarReserveDel.jsp?id=<%=id%>&rday=<%=bean.getRday()%>'">삭제</button>
			 		</td>
			 	</tr>
	<%	
		}
	%>	 		
		 		
		 		
		 		
		 		
		 		
			
		</table>
	</center>
</body>
</html>