<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<title>.slideUp(), .slideDown()</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<style>
dl {
	width: 90%;
	height: 90%:
	margin: 50px auto;
}

dt {
	cursor: pointer;
	font-size: 20px;
}

dd {
	display: none;
	height: 70px;
	margin: 0;
	font-size: 17px;
}


</style>
<script>
        $( function () {
            //dt 를 클릭했을 때
            $( 'dt' ).click( function (e) {
            	var obj = document.getElementById('img2_'+e.target.id.split("_")[1]);  
            	if(!obj) return; 
            	/* alert($(this).parent().id); */
                //dd 의 display 속성이 block 이라면
                if ( $( this ).next().css( 'display' ) == 'block' ) {
                    $( this ).next().slideUp( 100 );    //조건이 참일 때 실행
                    obj.src="./images/sort_down.png";
                    
                    
                }
                    //dd 의 display 속성이 block 이 아니라면
                else{
                	
                    $( this ).next().slideDown( 100 );//조건이 거짓일 때 실행
                    obj.src="./images/sort_up.png"; 
                } 
            } );
        } );

 		
        function toggle_object(e)
        {   
        	e.target.name = 1 + e.target.name;
        	alert(e.target.name);
            var obj = document.getElementById('test');   
            if(!obj) return;   
          
            if(i%2!=0)
            {   
                obj.src="./images/sort_up.png"; 
                
            } 
            else 
            {   
                obj.src="./images/sort_down.png";
            }
        }

    </script>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">

</script>
<title>자주 묻는 질문(FAQ)</title>
</head>
<body>
		<jsp:include page="../_main_login/header.jsp"></jsp:include>
			<th><font size="6"><b>자주 묻는 질문(FAQ)</b></font></th>
			<tr>
			<hr style="border: solid 3px red;">
				<br><dt id="dt_0" ><a id="a_0" href="#" style="text-decoration: none; color: black;" ><img id="img1_0" src="./images/faq_q.png" align="left"><b id="b_0">고객센터 전화번호가 어떻게 되나요?</b><img id="img2_0" src="./images/sort_down.png" align="right" /></a></dt>
				<dd id="0"><br><img src="./images/faq_a.png" align="left">
				<div style="margin-left: 30px;">010-000-0000 으로 연락 주시면 됩니다.<br>
				010-000-0000 으로 연락 주시면 됩니다.<br>
				010-000-0000 으로 연락 주시면 됩니다.<br></div>
				</dd><br>
			</tr>	
			<hr style="border: solid 1px;">
				<br><dt id="dt_1" ><a id="a_1"  href="#" style="text-decoration: none; color: black;" ><img src="./images/faq_q.png" align="left"><b id="b_1">고객센터 위치가 어떻게 되나요?</b><img id="img2_1" src="./images/sort_down.png" align="right" /></a></dt>
				<dd><br><img src="./images/faq_a.png" align="left">
				<div style="margin-left: 30px;">판교 입니다<br>
				판교 입니다<br>
				판교 입니다<br>
				</div>
				</dd><br>
			<hr style="border: solid 1px;">
				<br><dt id="dt_2" ><a id="a_2"  href="#" style="text-decoration: none; color: black;" ><img src="./images/faq_q.png" align="left"><b id="b_2">고객센터 위치가 어떻게 되나요?</b><img id="img2_2" src="./images/sort_down.png" align="right" /></a></dt>
				<dd><br><img src="./images/faq_a.png" align="left">
				<div style="margin-left: 30px;">판교 입니다<br>
				판교 입니다<br>
				판교 입니다<br>
				</div>
				</dd><br>
			<hr style="border: solid 1px;">
				<br><dt id="dt_3" ><a id="a_3"  href="#" style="text-decoration: none; color: black;" ><img src="./images/faq_q.png" align="left"><b id="b_3">고객센터 위치가 어떻게 되나요?</b><img  id="img2_3" src="./images/sort_down.png" align="right" /></a></dt>
				<dd><br><img src="./images/faq_a.png" align="left">
				<div style="margin-left: 30px;">판교 입니다<br>
				판교 입니다<br>
				판교 입니다<br>
				</div>
				</dd><br>
			<hr style="border: solid 1px;">
				<br><dt id="dt_4" ><a id="a_4"  href="#" style="text-decoration: none; color: black;" ><img src="./images/faq_q.png" align="left"><b id="b_4">고객센터 위치가 어떻게 되나요?</b> <img  id="img2_4" src="./images/sort_down.png" align="right" /></a></dt>
				<dd><br><img src="./images/faq_a.png" align="left">
				<div style="margin-left: 30px;">판교 입니다<br>
				판교 입니다<br>
				판교 입니다<br>
				</div>
				</dd><br>
			<hr style="border: solid 1px;">	

</body>
</html>