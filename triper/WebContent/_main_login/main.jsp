<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title> Triper </title>
<script type="text/javascript">
//window.open("eventPopup.html", "a", "resizable=yes, scrollbars=no, width=480, height=530, left=200, top=50"); //function함수에 안넣으면 자동으로 열림

function getcookie( name ){
    var nameOfcookie = name + "=";
    var x = 0;
    while ( x <= document.cookie.length )
    {
            var y = (x+nameOfcookie.length);
            if ( document.cookie.substring( x, y ) == nameOfcookie ) {
                    if ( (endOfcookie=document.cookie.indexOf( ";", y )) == -1 )
                            endOfcookie = document.cookie.length;
                    return unescape( document.cookie.substring( y, endOfcookie ) );
            }
            x = document.cookie.indexOf( " ", x ) + 1;
            if ( x == 0 )
                    break;
    }
    return "";
}
if ( getcookie( "todayPop" ) != "popBox" )
{
	window.open("eventPopup.html", "a", "resizable=yes, scrollbars=no, width=480, height=530, left=200, top=50");
}
</script>
<style type="text/css">
body {
	margin : 0;
	padding : 0;
	background : url (img.jpg) center center fixed no-repeat;
}
video {
	position : fixed;
	top : -70px; 
	left : 0;
	min-width : 100 %;
	min-height : 100 %;
	width : 100%;
	z-index : -1;
	muted : false;
}
</style>

</head>
<body>
<jsp:include page="../_main_login/header.jsp"></jsp:include>
	<video autoplay loop poster = "img.jpg" muted="false">
		<source src = "../image/Triper.mp4"type = "video/mp4">
	</video>

</body>
</html>