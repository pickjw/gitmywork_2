<%@page import="db.CarListBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.RentcarDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	<center>
		<table width="1000">
			<tr height="100" >
			 		<td colspan="3" align="center">
		 				<font size="6" color="black">전체 렌트카 보기</font>
		 			</td>
		 	</tr>
<%
		/* //카테고리 분류값을 받아옴
		int category = Integer.parseInt(request.getParameter("category")); */

		RentcarDAO rdao = new RentcarDAO();
		
		//Arraylist 데이터를 저장
 		ArrayList<CarListBean> arrayList = rdao.getAllCar(); 
		//tr을 3개씩 보여 주고 다시 tr를 실행 할수 있도록 적용 하는 변수 선언
		int j = 0;
		for (int i=0; i <arrayList.size(); i++ ) {
			
			//백터에 저장되어 있는 빈클래스를 축출
			CarListBean bean = arrayList.get(i);
			if(j%3==0) {
%>				
			<tr height="220">
				
<%				
			}
%>
				<td width="333" align="center">
					<a href="RentcarMain.jsp?center=CarReserveInfo.jsp?no=<%=bean.getNo() %>">
						<img alt="" src="img/<%=bean.getImg() %>" width="300" height="200">
					</a>
					<p>
						<font size="3" color="black"> <b>차량명 : <%=bean.getName() %></b></font>
					</p>
				</td>

<%		
			j=j+1;//j값을증가 하여 하나의 행에 총 3개의 차량 정보를 보여 주기위해서 증가 
		}
		
%>
			</tr>
		</table>
	</center>
</body>
</html>