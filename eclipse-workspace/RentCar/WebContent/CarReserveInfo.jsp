<%@page import="db.CarListBean"%>
<%@page import="db.RentcarDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>

<%
		int no = Integer.parseInt(request.getParameter("no"));

		//데이터베이스에 접근
		RentcarDAO rdao = new RentcarDAO();
		//렌트카 하나에 대한 정보를 얻어옴
		CarListBean bean = rdao.getOneCar(no);	
		
		//카테고리 분류값을 받아옴
		int category = bean.getCategory();
		String temp="";
		if(category==1)temp="소형";
		else if (category==2)temp="중형";
		else if (category==3)temp="대형";		
%>
	<center>
		<form action="RentcarMain.jsp?center=CarOptionSelect.jsp" method="post">
			<table width="1000">
			
				<tr height="100" >
			 		<td colspan="3" align="center">
		 				<font size="6" color="black"><%=bean.getName() %> 차량 선택</font>
		 			</td>
		 		</tr>
		 		
				<tr>
					<td rowspan="6" width="500"> 
						<img alt="" src="img/<%=bean.getImg()%>" width="450">
					</td>
					<td width="250" align="center"> 차량이름</td>
					<td width="250" align="center"> <%= bean.getName() %></td>
				</tr>
				
				<tr>
					<td width="250" align="center"> 차량수량</td>
					<td width="250" align="center">
						<select name="qty">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td width="250" align="center"> 차량분류</td>
					<td width="250" align="center"> <%= temp %></td>
				</tr>
				
				<tr>
					<td width="250" align="center"> 대여가격</td>
					<td width="250" align="center"> <%= bean.getPrice() %> 원</td>
				</tr>
				
				<tr>
					<td width="250" align="center">제조회사</td>
					<td width="250" align="center"> <%= bean.getCompany() %></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="hidden" name="no" value="<%= bean.getNo() %>">
						<input type="hidden" name="img" value="<%= bean.getImg() %>">
						<input type="submit" value="옵션 선택후 구매하기">
					</td>
				</tr>
				
			</table>
			<br><br><br>
			<font size="5" color="black">차량 정보 보기</font>
			<p><%=bean.getInfo()%></p>
		</form>
	</center>
</body>
</html>