<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<center>
		
		<img alt="" width="100%" src="../image/giphy.gif">
		
		<table class="table table-striped" style="text-align: left; border: 1px solid #dddddd">
			<form action ="../_car/CarcategoryController.do" method="post">
				<tr align="center">
				<td width="50%"></td>
					<td width="30%">
						<select class=" form-control" name="carcategory">
							<option value="Small">소형</option>
							<option value="Mid">중형</option>
							<option value="Big">대형</option>
						</select>
					</td>
					<td>
						<input class="btn btn-primary" type="submit" value="검색">
						<input class="btn btn-primary" type="button" value="전체검색" onclick="location.href='../_car/CarListController1.do'">
					</td>
				
				</tr>	
			</form>
		</table>
	</center>
</body>
</html>