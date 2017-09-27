<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<bady>
		<table class="table" border="0">
		<form action ="../_car/CarcategoryController.do?business_id=${param.business_id }" method="post">
				<tr align="center">
					<td width="20%"><h4>차량종류</h4></td>
					<td width="50%">
					<select class="form-control" name="carcategory">
						<option value="Small">소형</option>
						<option value="Mid">중형</option>
						<option value="Big">대형</option>
						
					</select>
				</td>
					<td  align="center">
						<input class="btn btn-primary" type="submit" value="검색">

					<input class="btn btn-primary" type="button" value="전체검색" onclick="location.href='../_car/CarListController.do?business_id=${param.business_id }'">
					</td>
				</tr>
				</form>
			<img width="100%" alt="" src="../image/giphy.gif" border="0">
		
			</table>
	
</body>
</html>