<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<body>

	
	<form action="../_car/CarOptionController.do" method="post">
	<table class="table"style="background-color: white; text-align: center; border: 1px solid #dddddd">
	<tr align="center">
		<td rowspan="9" width="70%">
		<img alt="" src="img/${param.carimg }" width="500" >
		</td>
		<td align="center" width="200"> �뿩�� </td>
		<td align="center"><input type="date" name="carbegindate"></td>
		
	</tr>
	<tr>
		<td align="center"> �����ð� </td>
		<td align="center"><input type="time" name="carbegintime"></td>
	</tr>
	<tr>
		<td align="center"> �ݳ��� </td>
		<td align="center"><input type="date" name="carenddate"></td>
	</tr>
	<tr>
		<td align="center"> �ݳ��ð� </td>
		<td align="center"><input  type="time" name="carendtime"></td>
	</tr>	
	<tr>
		<td align="center"> ���� ���� </td>
		<td align="center"><select class=" form-control" name="carins">
							<option value="1">����(1�� 1����)</option>
							<option value="0">������</option>
						   </select></td>
	</tr>	
	<tr>
		<td align="center"> ���� wifi </td>
		<td align="center"><select class=" form-control" name="carwifi">
							<option value="1">����(1�� 1����)</option>
							<option value="0">������</option>
						   </select></td>
	</tr>	
	<tr>
		<td align="center"> �׺���̼� </td>
		<td align="center"><select class=" form-control" name="carnavi">
							<option value="1">����(����)</option>
							<option value="0">������</option>
						   </select></td>
	</tr>	
	<tr>
		<td align="center"> ���̺� ��Ʈ </td>
		<td align="center"><select class=" form-control" name="carbabyseat">
							<option value="1">����(1�� 1����)</option>
							<option value="0">������</option>
						   </select></td>
	</tr>									
	<tr>
		<td align="center">
		<input type="hidden" name="carno" value="${param.carno }">
		<input type="hidden" name="carqty" value="${param.carqty }">
		<input type="hidden" name="carprice" value="${param.carprice }">
		<input type="button" class="btn btn-primary" onclick="location.href='../_car/CarListController.do'"
		 value="������Ϻ���"></td>
		<td align="center">
			<input class="btn btn-primary" type="submit" value="�����ϱ�"></td> 
	</tr>
	</table>
	</form>

</body>
</html>