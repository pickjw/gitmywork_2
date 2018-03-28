<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>

		<%
			int no = Integer.parseInt(request.getParameter("no"));
			//수량
			int qty = Integer.parseInt(request.getParameter("qty"));
			//이미지
			String img = request.getParameter("img");
		%>
	
	<center>
		<form action="RentcarMain.jsp?center=CarReserveResult.jsp" method="post">
			<table width="1000">
				
				<tr height="100" >
			 		<td colspan="3" align="center">
		 				<font size="6" color="black">옵션 선택</font>
		 			</td>
		 		</tr>
		 		
		 		<tr>
					<td rowspan="7" width="500"> 
						<img alt="" src="img/<%= img %>" width="450">
					</td>
					<td width="250" align="center"> 대여기간 </td>
					<td width="250" align="center"> 
						<select name="dday">
							<option value="1">1일</option>
							<option value="2">2일</option>
							<option value="3">3일</option>
							<option value="4">4일</option>
							<option value="5">5일</option>
							<option value="6">6일</option>
							<option value="7">7일</option>
							<option value="8">2주</option>
							<option value="9">3주</option>
							<option value="10">1달</option>
						</select>
					</td>
				</tr>
				
				
				<tr>
					<td width="250" align="center"> 대여일시 </td>
					<td width="250" align="center"> 
						<input type="date" name="rday" size="15"  >
					</td>
				</tr>
				
				<tr>
					<td width="250" align="center"> 보험 적용 </td>
					<td width="250" align="center"> 
						<select name="usein">
							<option value="1">적용(1일 1만원)</option>
							<option value="2">적용(2일 2만원)</option>
							<option value="3">적용(3일 3만원)</option>
							<option value="4">적용(4일 4만원)</option>
							<option value="5">적용(5일 5만원)</option>
							<option value="6">적용(6일 6만원)</option>
							<option value="7">적용(7일 7만원)</option>
							<option value="8">적용(2주 14만원)</option>
							<option value="9">적용(3주 21만원)</option>
							<option value="10">적용(1달 30만원)</option>
							<option value="11">비적용</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td width="250" align="center"> 무선 Wifi 적용 </td>
					<td width="250" align="center"> 
						<select name="usewifi">
							<option value="1">적용(1일 1만원)</option>
							<option value="2">적용(2일 2만원)</option>
							<option value="3">적용(3일 3만원)</option>
							<option value="4">적용(4일 4만원)</option>
							<option value="5">적용(5일 5만원)</option>
							<option value="6">적용(6일 6만원)</option>
							<option value="7">적용(7일 7만원)</option>
							<option value="8">적용(2주 14만원)</option>
							<option value="9">적용(3주 21만원)</option>
							<option value="10">적용(1달 30만원)</option>
							<option value="11">비적용</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td width="250" align="center"> 네비게이션 적용 </td>
					<td width="250" align="center"> 
						<select name="usenavi">
							<option value="1">적용(무료)</option>
							<option value="2">비적용</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td width="250" align="center"> 베이비시트 적용 </td>
					<td width="250" align="center"> 
						<select name="useseat">
							<option value="1">적용(1일 1만원)</option>
							<option value="2">적용(2일 2만원)</option>
							<option value="3">적용(3일 3만원)</option>
							<option value="4">적용(4일 4만원)</option>
							<option value="5">적용(5일 5만원)</option>
							<option value="6">적용(6일 6만원)</option>
							<option value="7">적용(7일 7만원)</option>
							<option value="8">적용(2주 14만원)</option>
							<option value="9">적용(3주 21만원)</option>
							<option value="10">적용(1달 30만원)</option>
							<option value="11">비적용</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="hidden" name="no" value="<%= no %>">
						<input type="hidden" name="qty" value="<%= qty %>">
						<input type="submit" value="차량예약하기">
					</td>
				</tr>
					
			 </table>
		</form>
	</center>
</body>
</html>