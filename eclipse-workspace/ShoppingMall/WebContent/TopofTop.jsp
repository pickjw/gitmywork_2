<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<body>
	
	<c:set var="id" value="${sessionScope.id }" />
	<c:if test="${id==null }">
		<c:set var="id" value="Guest" />
	</c:if>

 <table width="1200">
  <tr height="60">
   <td width="30%" align="center" ><a href="shoppingmain.do" style="text-decoration: none">
    <img src="img/logo.JPG" width="200" height="60" style="text-decoration: none"></a></td>
   <td width="30%" align="right" ><a href="shoppingmain.do" style="text-decoration: none">
     <font color="orange" size="6" face="굴림체"> 컴퓨터 쇼핑몰 </font> </a></td>  
   <td width="40%" align="center" >
   		<c:if test="${id=='Guest' }">
   			 ${id }님 방갑습니다. &nbsp;&nbsp;&nbsp;<a href="loginform.do" style="text-decoration: none">로그인</a>
   			&nbsp;&nbsp;<a href="memberjoin.do" style="text-decoration: none">회원가입</a>
   		</c:if>
   		<c:if test="${id!='Guest' }">
   			 ${id }님 방갑습니다. &nbsp;&nbsp;&nbsp;<a href="logout.do" style="text-decoration: none">로그아웃</a>   			 
   			  &nbsp;&nbsp;<a href="mypage.do" style="text-decoration: none">마이페이지</a>
   			 &nbsp;&nbsp;<a href="shoppingcart.do" style="text-decoration: none">장바구니</a>
   		</c:if>&nbsp;&nbsp;&nbsp;   		
   </td>
  </tr>
 </table>

</body>
</html>
