<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	<center>
		<h2>파일 업로드</h2>
		<form action="FileUploacProc.jsp"  method="post"  enctype="multipart/form-data">
			<table width="350" border="1" bordercolor="black">
			
				<tr height="40">
						<td width="150">이름</td>
						<td width="200"><input type="text" name="name"></td>
				</tr>
				
				<tr height="40">
						<td width="150">파일 선택</td>
						<td width="200"><input type="file" name="filedata"></td>
				</tr>
				
				<tr height="40">
						<td colspan="2" align="center"><input type="submit" value="파일 업로드"></td>
				</tr>
				
			</table>
		</form>
	</center>
</body>
</html>