<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="partbuy.do">
<table width="1200" >	
		<tr height="40">
			<td width="600" align="center" rowspan="5" valign="middle">
				 <img alt="" src="img/${bean.img1 }" width="450"> </td>
			<td width="300" align="center"> ��ǰ��ȣ </td>
			<td width="300" align="left"> ${bean.pno } </td>
		</tr>	
		<tr height="40">
			<td width="300" align="center"> ��ǰ�� </td>
			<td width="300" align="left"> ${bean.pname } </td>
		</tr>	
		<tr height="40">
			<td width="300" align="center"> ��ǰ���� </td>
			<td width="300" align="left"> ${bean.price } </td>
		</tr>
		<tr height="40">
			<td width="300" align="center"> ���� </td>
			<td width="300" align="left" > <input type="number" name="qty" id="qty"> </td>
		</tr>
		<tr height="40">
			<td width="200" align="center" colspan="2">  
				<input type="hidden" name="pno" value="${bean.pno }"> 
				<input type="submit" value="�����ϱ�">  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" onclick="getbuy()" value="��ٱ���">
				</td>
		</tr>
	</table>
	</form>	
	<hr color="gray" size="1" width="1200">
	<h3> �󼼺��� </h3><br><br>
	<font size="3" color="gray"> ${bean.info } </font> <br><br>
	<img alt="" src="img/${bean.img2 }" width="1000"><br><br>
	<img alt="" src="img/${bean.img3 }" width="1000"><br><br>	
	<hr color="gray" size="1" width="1000">
</body>
</html>