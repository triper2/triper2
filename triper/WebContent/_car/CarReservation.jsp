<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<center>
		<table width="400" border="0">
			<h1>  <img height="50" src="img/ccs.jpg" border="0"></h1>
		<form action ="../CarcategoryController.do" method="post">
				<tr align="center">
					<td width="100">차량종류</td>
					<td width="100" height="50">
					<select name="carcategory">
						<option value="Small">소형</option>
						<option value="Mid">중형</option>
						<option value="Big">대형</option>
						
					</select>
				</td>
					<td align="center">
						<input type="submit" value="검색">
					</td>
				
					<td align="center">
					<input type="button" value="전체검색" onclick="location.href='../CarListController.do'">
					</td>
				</tr>
				
			</table>
		<table width="1000" border="0">
		<tr>
			<td aling="center" width="333">
				<!-- <a href = "carMain.jsp?center=CarEvent.jsp"> -->
					<img alt="" src="img/lfsonata.jpg" width="280">
				</a>
			</td>
			<td aling="center" width="333">
				<!-- <a href = "carMain.jsp?center=CarEvent.jsp"> -->
					<img alt="" src="img/k5.jpg" width="280">
				</a>
			</td>
			<td aling="center" width="333">
				<!-- <a href = "carMain.jsp?center=CarEvent.jsp"> -->
					<img alt="" src="img/avante.jpg" width="280">
				</a>
			</td>
		</tr>
		</table>
	
		<!-- 	<table width="400" border="0">
			<h1><img height="50" src="img/ccs.jpg" border="0"></h1>
		<form action ="CarcategoryController.do" method="post">
				<tr align="center">
					<td width="100">차량종류</td>
					<td width="100" height="50">
					<select name="carcategory">
						<option value="Small">소형</option>
						<option value="Mid">중형</option>
						<option value="Big">대형</option>
						
					</select>
				</td>
					<td align="center">
						<input type="submit" value="검색">
					</td>
				
					<td align="center">
					<input type="button" value="전체검색" onclick="location.href='CarListController.do'">
					</td>
				</tr>
				
			</table> -->
		</form>
	
	</center>
</body>
</html>