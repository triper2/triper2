<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

<%
	String center=request.getParameter("center");
	 out.print(center); 
	//처음 실행시에는 center 값이 넘어오지 않기에 
	if(center ==null){ //null
		center ="Center.jsp";    //디폴트 center값을 부여
		
	}
%>

<center>
<table width ="1000" >
	<!-- Top 부분 -->
	<tr height="140" align="center">
		<td align="center" width="1000"><jsp:include page="Top.jsp" /></td>
	</tr>
	
	<!-- Center 부분 -->
	<tr  align="center"  height="400">
		<td align="center" width="1000"><jsp:include page="<%=center %>" /></td>
	</tr>
	<!-- Bottom 부분 -->
	<tr height="100" align="center">
		<td  align="center" width="1000"><jsp:include page="Bottom.jsp" /></td>
	</tr>
	<!-- 메인 페이지 -->
</table>
</center>

</body>
</html>













