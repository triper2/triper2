<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>

<c:remove scope="session" var="sessionInfo" />
<c:remove scope="session" var="id" />
<!DOCTYPE html>
<html>
<head><title></title></head>
<body>이게 안먹혀
	<script type="text/javascript">
		alret("로그아웃 합니다.")
	</script>
	<!--<c:redirect url="index.jsp" />-->
</body>
</html>
