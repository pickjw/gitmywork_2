<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<!-- Top -->
	<table width="800">
	
		<tr	height="100">
			<!-- logo image -->
			<td colspan="2" align="center" width="260">
				<img alt="로고이미지입니다" src="img/logo.png" width="200" height="70">
			</td>
			
			<td colspan="5" align="center">
				<font size="10">낭만 캠핑</font>
			</td>
		</tr>
		
		<!--메뉴 만들기 -->
		<tr	height="50">
			<td width="110" align="center"> 텐트 </td>
			<td width="110" align="center"> 의자 </td>
			<td width="110" align="center"> 식기 </td>
			<td width="110" align="center"> 침낭 </td>
			<td width="110" align="center"> 테이블 </td>
			<td width="110" align="center"> 화롯대 </td>
			<td width="140" align="center"> <%= request.getParameter("id") %> </td>
		</tr>

	</table>


</body>
</html>