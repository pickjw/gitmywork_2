<%@page import="db.CarListBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.RentcarDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	<center>
	 <!--  데이터 베이스에 연결하여 최신순 자동차 3대만 뿌려 주는 데이터를 가져옴 -->
	 
	 <%
	 
			RentcarDAO rdao = new RentcarDAO();
	 
	 		//Arraylist 데이터를 저장
	 		ArrayList<CarListBean> arrayList = rdao.getSelectCar();
	 		
	 %>
	 	<table	width="1000">
	 	
	 		<tr height="100" >
		 		<td colspan="3" align="center">
	 				<font size="6" color="black">최신형 자동차</font>
	 			</td>
	 		</tr>
	 		
	 		
	 		<tr height="240">
	 <%
	 	for(int i=0; i < arrayList.size(); i++) {
	 		CarListBean bean = arrayList.get(i);
	 
	 %>
	 			<td width="333" align="center">
	 				<a href="RentcarMain.jsp?center=CarReserveInfo.jsp?no=<%=bean.getNo()%>">
	 					<img alt="" src="img/<%=bean.getImg()%>" width="300" height="220">
	 				</a>
	 				<p>차량명 : <%= bean.getName() %>
	 			</td>
	 <%
	 	}
	 %>		
	 		</tr>
	 	</table>
    <!--<hr color="red" size="3"> -->
	 	<p>
	 		<font size="4" color="black"><b>차량 검색 하기</b></font><br><br><br>
	 	</p>
	 	<form action="RentcarMain.jsp?center=CarCartegoryList.jsp" method="post">
	 	   <font size="3" color="black"><b>차량 검색 하기</b></font>&nbsp;&nbsp;
	 			<select name="category">
	 				<option value="1">소형</option>
	 				<option value="2">중형</option>
	 				<option value="3">대형</option>
	 			</select>&nbsp;&nbsp;
	 			<input type="submit" value="검색">&nbsp;&nbsp;	 	
	 	</form>
	 	<br><br>
	 	 <!-- 따로 돌아 갈야 하기에 form태그 밖에 -->
	 	<input type="button" value="전체 검색" onclick="location.href='RentcarMain.jsp?center=CarAllList.jsp'">
	</center>
</body>
</html>









