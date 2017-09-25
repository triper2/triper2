<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/custom.css">
<link rel="stylesheet" href="../css/review.css">

<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="../js/bootstrap.js"></script>

<html>
<body>

	<!-- ī�װ� �з� �˻��� ���Ͽ� form������ ó�� -->
	<form action="../_car/CarcategoryController.do" method="post">
	<div>
 <c:set var="j" value="0" />
      <c:forEach var="v" items="${v}">
      <c:if test="${j%3==0}">
      <div class="wrap">
      </c:if>
         <a href="../_car/CarInfoController.do?product_carno=${v.product_carno}">
            <div class="tile">
            <img src="/triper/_car/img/${v.product_carimg}">
            <div class="text">
            ������ : ${v.product_carname }<br>
            
           �뿩�ݾ� : ${v.product_carprice} ��
         </div></div>
         </a>
         <c:if test="${j%3==2 }">
         </div>
         </c:if>
         <c:set var="j" value="${j+1 }"/>         
      </c:forEach>
      
      </div>
	
	<table class="table table-striped" style="text-align: left; border: 1px solid #dddddd">
		<tr height="70">
			<td width="30%">
	
			</td>
			<td align="center">
			<select class=" form-control" name="carcategory">
				   <option value="Small"> ���� </option>	
				   <option value="Mid"> ���� </option>	
				   <option value="Big"> ���� </option>			
			</select>
			</td>
			<td >
			<input class="btn btn-primary" type="submit" value="�����˻�">&nbsp;&nbsp;&nbsp;
			<input class="btn btn-primary" type="button" value="��ü�˻�" onclick="location.href='../_car/CarListController.do'">
			</td>
		</tr>
	</table>
		
	</form>

</body>
</html>

