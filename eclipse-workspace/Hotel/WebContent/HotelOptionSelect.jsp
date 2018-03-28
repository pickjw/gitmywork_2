<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>

		<%
			int no = Integer.parseInt(request.getParameter("no"));
			
			//이미지
			String img = request.getParameter("img");
		%>
	
	<center>
		<form action="HotelMain.jsp?center=HotelReserveResult.jsp" method="post">
			<table width="1000">
				
				<tr height="100" >
			 		<td colspan="3" align="center">
		 				<font size="6" color="white">예약 옵션</font>
		 			</td>
		 		</tr>
		 		
		 		
		 		
		 		<tr>
					<td rowspan="6" width="600"><img alt=""
						src="img/<%= img %>" width="550"></td>
					<td width="250" align="center"><font size="3" color="white">숙박기간</font></td>
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
					<td width="250" align="center"><font size="3" color="white">체크인</font></td>
					<td width="250" align="center"> 
						<input type="date" name="rday" size="15"  >
					</td>
				</tr>
				
				
				<tr>
					<td width="250" align="center"><font size="3" color="white">체크아웃</font></td>
					<td width="250" align="center"> 
						<input type="date" name="rday" size="15"  >
					</td>
				</tr>
				
				<tr>
					<td width="250" align="center"><font size="3" color="white">조식</font></td>
					<td width="250" align="center"> 
						<select name="mfood">
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
					<td width="250" align="center"><font size="3" color="white">석식</font></td>
					<td width="250" align="center"> 
						<select name="dfood">
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
					<td width="250" align="center"><font size="3" color="white">룸서비스</font></td>
					<td width="250" align="center"> 
						<select name="service">
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
				
				
					
			 </table>
			 
			 <br>
			<br> 
			<div style="height: auto; width: 200px; margin: 50px 0px 0px 0px;">
				<ul>
					<li>
						<input type="hidden" name="no" value="<%= no %>">
						<input type="submit" value="예약완료"
						style="font-size: 15pt; height: 50px; width: 150px;">
					</li>
				</ul>
			</div>
			<br>
			<br>
		</form>
	</center>
</body>
</html>