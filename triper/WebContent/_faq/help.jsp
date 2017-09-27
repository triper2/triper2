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
	text-align: left;
	border: 1px;
}

dd {
	display: none;
	height: 100px;
	margin: 0;
	font-size: 17px;
	text-align: left;
	border: 1px;
}

th {
	text-align: left;
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
                    obj.src="./help/images/sort_down1.png";
                    
                    
                }
                    //dd 의 display 속성이 block 이 아니라면
                else{
                	
                    $( this ).next().slideDown( 100 );//조건이 거짓일 때 실행
                    obj.src="./help/images/sort_up1.png"; 
                } 
            } );
        } );

 		
/*         function toggle_object(e)
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
 */
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
			<th><font size="6" style="float:left;"><b>자주 묻는 질문(FAQ)</b></font></th><br><br><br>
			<!-- <hr style="border: solid 3px red;"> -->
				<br><dt id="dt_0" ><a id="a_0"  style="text-decoration: none; color: black; margin-left: 12px;" ><img id="img1_0" src="./help/images/faq_q1.png" align="left" style="width: 25px;"><b id="b_0">회원 아이디와 비밀번호는 변경이 가능한가요?</b><img id="img2_0" src="./help/images/sort_down1.png" align="right" width="40px"/></a></dt>
				<dd id="c_0"><br><img src="./help/images/faq_a1.png" align="left" width="25px">
				<div style="margin-left: 30px;">아이디의 변경은 불가능합니다. <br>
				아이디 변경을 하시려면 탈퇴 후 재가입(동일 아이디 사용 불가)을 하셔야 하며,<br>
				비밀번호 변경은 사이트에서 로그인 후 [마이페이지 - 회원정보수정］에서 변경하실 수 있습니다.<br></div>
				</dd><br>
			<!-- <hr style="border: solid 1px;"> -->
				<br><dt id="dt_1" ><a id="a_1"   style="text-decoration: none; color: black; margin-left: 12px;" ><img src="./help/images/faq_q1.png" align="left" style="width: 25px;"><b id="b_1">회원탈퇴는 어떻게 하나요?</b><img id="img2_1" src="./help/images/sort_down1.png" align="right" width="40px"/></a></dt>
				<dd id="c_1"><br><img src="./help/images/faq_a1.png" align="left" width="25px">
				<div style="margin-left: 30px;">탈퇴신청은 로그인 후 홈페이지 상단의 ［마이페이지 - 회원탈퇴]에서 신청해 주시면 됩니다.<br>
				탈퇴와 관련한 자세한 사항은 회원 이용약관을 참고하여 주시길 바랍니다.<br>
				</div>
				</dd><br>
			<!-- <hr style="border: solid 1px;"> -->
				<br><dt id="dt_2" ><a id="a_2"   style="text-decoration: none; color: black; margin-left: 12px;" ><img src="./help/images/faq_q1.png" align="left" style="width: 25px;"><b id="b_2">정기 세일 기간이 있나요?</b><img id="img2_2" src="./help/images/sort_down1.png" align="right" width="40px"/></a></dt>
				<dd id="2"><br><img src="./help/images/faq_a1.png" align="left" width="25px">
				<div style="margin-left: 30px;">정기 세일이나 할인은 하지 않습니다.<br>
				그러나 세일이 행사나 이벤트를 지속적으로 시행하고 있으며,<br>
				행사 시작 전 메인 팝업창을 통해 고객님들께 홍보하고 있습니다.<br>
				</div>
				</dd><br>
			<!-- <hr style="border: solid 1px;"> -->
				<br><dt id="dt_3" ><a id="a_3"   style="text-decoration: none; color: black; margin-left: 12px;" ><img src="./help/images/faq_q1.png" align="left" style="width: 25px;"><b id="b_3">렌탈 가능한 제품의 종류는 어떻게 되나요?</b><img  id="img2_3" src="./help/images/sort_down1.png" align="right" width="40px"/></a></dt>
				<dd id="3"><br><img src="./help/images/faq_a1.png" align="left" width="25px">
				<div style="margin-left: 30px;">차, 보드 등이 있습니다.<br>
				차후 렌탈 가능한 제품을 늘려서 고객분들에게 도움이 되도록 노력하겠습니다.<br>
				</div>
				</dd><br>
			<!-- <hr style="border: solid 1px;"> -->
				<br><dt id="dt_4" ><a id="a_4"   style="text-decoration: none; color: black; margin-left: 12px;" ><img src="./help/images/faq_q1.png" align="left" style="width: 25px;"><b id="b_4">위치가 어떻게 되나요?</b> <img  id="img2_4" src="./help/images/sort_down1.png" align="right" width="40px"/></a></dt>
				<dd id="4"><br><img src="./help/images/faq_a1.png" align="left" width="25px">
				<div style="margin-left: 30px;">판교에 위치하고 있습니다.<br>
				자세한 문의는 <b>[대표번호 : 031)114 FAX : 01-112-119]</b> 으로 주시면 감사하겠습니다<br>
				</div>
				</dd><br>
			<!-- <hr style="border: solid 1px;">	 -->
			<br><dt id="dt_4" ><a id="a_4"   style="text-decoration: none; color: black; margin-left: 12px;" ><img src="./help/images/faq_q1.png" align="left" style="width: 25px;"><b id="b_4">사업자 등록 어떻게 하나요?</b> <img  id="img2_4" src="./help/images/sort_down1.png" align="right" width="40px"/></a></dt>
				<dd id="4"><br><img src="./help/images/faq_a1.png" align="left" width="25px">
				<div style="margin-left: 30px;">로그인 후 [마이페이지 - 사업자등록]을 통해 등록 가능 합니다.<br>
				등록 신청 완료 후 저희가 사업자 이름과 사업자 번호를 비교 확인 후 승인해드립니다.<br>
				자세한 문의는 <b>[대표번호 : 031)114 &nbsp;&nbsp; FAX : 01-112-119]</b> 으로 주시면 감사하겠습니다<br>
				</div>
				</dd><br>

</body>
</html>