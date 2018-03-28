<%@page import="db.HotelRoomListDTO"%>
<%@page import="db.HotelDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	<%
		//카테고리 분류값을 받아옴
		int category = Integer.parseInt(request.getParameter("category"));
		String temp = "";
		if (category == 1)
			temp = "스탠다드룸 (Standard Room)";
		else if (category == 2)
			temp = "슈페리어룸 (Superior Room)";
		else if (category == 3)
			temp = " 딜럭스룸 (Deluxe Room)";
		else if (category == 4)
			temp = " 이그제큐티브룸 (Executive Room)";
		else if (category == 5)
			temp = " 스위트룸 (Suite Room)";
	%>
	<center>
		<table width="1000">

			<tr height="100">
				<td colspan="3" align="center"><font size="6" color="black"><%=temp%></font></td>
			</tr>
			<%
				HotelDAO hdao = new HotelDAO();

				//Arraylist 데이터를 저장
				ArrayList<HotelRoomListDTO> arrayList = hdao.getCategoryHotel(category);
				//tr을 3개씩 보여 주고 다시 tr를 실행 할수 있도록 적용 하는 변수 선언
				int j = 0;
				for (int i = 0; i < arrayList.size(); i++) {

					//ArrayList에 저장되어 있는 dto클래스를 축출
					HotelRoomListDTO dto = arrayList.get(i);
					if (j % 3 == 0) {
			%>
			<tr height="220">

				<%
					}
				%>
				<td width="333" align="center"><a
					href="HotelMain.jsp?center=HotelReserveInfo.jsp?no=<%=dto.getNo()%>">
						<img alt="" src="img/<%=dto.getImg()%>" width="300" height="200">
				</a>
					<p>
						<font size="3" color="black"> <b>Room :<%=dto.getName()%></b></font>
					</p></td>

				<%
					j = j + 1;//j값을증가 하여 하나의 행에 총 3개의 정보를 보여 주기위해서 증가 
					}
				%>
			</tr>
		</table>
	</center>
</body>
</html>