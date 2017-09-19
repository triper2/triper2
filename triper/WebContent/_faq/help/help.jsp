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
	height: 40px;
	margin: 0;
	font-size: 15px;
}


</style>
<script>
        $( function () {
            //dt 를 클릭했을 때
            $( 'dt' ).click( function (e) {
            	/* alert($(this).parent().id); */
                //dd 의 display 속성이 block 이라면
                if ( $( this ).next().css( 'display' ) == 'block' ) {
                    $( this ).next().slideUp( 100 );    //조건이 참일 때 실행
                    
                }
                    //dd 의 display 속성이 block 이 아니라면
                else{
                	
                    $( this ).next().slideDown( 100 );//조건이 거짓일 때 실행
                } 
            } );
        } );

        
/*         var i = 0;
        function toggle_object(post_id)
        {   
            i = i + post_id;
            var obj = document.getElementById('faq_td');   
            if(!obj) return;   
          
            if(i%2!=0)
            {   
                obj.src="./images/faq_d.png"; 
                
            } 
            else 
            {   
                obj.src="./images/faq_t.png";
            }
        } */
    
/*         $(document).ready(function(){
        	   $('tr').mouseover(function(){ 
        	      $(this).css("backgroundColor","#D2DDEC"); 
        	   }); 
        	   $('tr').mouseout(function(){ 
        	      $(this).css("backgroundColor","#FFFFFF"); 
        	   }); 
        	});  */
    </script>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">

</script>
<title>자주 묻는 질문(FAQ)</title>
</head>
<body>
			<th><font size="6"><b>자주 묻는 질문(FAQ)</b></font></th>
			<tr>
			<hr style="border: solid 3px red;">
				<br><dt><img src="./images/faq_q.png" align="left"><b>고객센터 전화번호가 어떻게 되나요?</b><img src="./images/faq_d.png" align="right" id="faq_td"/></dt>	
				<dd><br><img src="./images/faq_a.png" align="left">010-000-0000 으로 연락 주시면 됩니다.</dd><br>
			</tr>	
			<hr style="border: solid 1px;">
				<br><dt><img src="./images/faq_q.png" align="left"><b>고객센터 위치가 어떻게 되나요?</b><img src="./images/faq_d.png" align="right"/></dt>
				<dd><br><img src="./images/faq_a.png" align="left">판교 입니다</dd><br>
			<hr style="border: solid 1px;">
				<br><dt><img src="./images/faq_q.png" align="left"><b>고객센터 위치가 어떻게 되나요?</b><img src="./images/faq_d.png" align="right"/></dt>
				<dd><br><img src="./images/faq_a.png" align="left">판교 입니다</dd><br>
			<hr style="border: solid 1px;">
				<br><dt><img src="./images/faq_q.png" align="left"><b>고객센터 위치가 어떻게 되나요?</b><img src="./images/faq_d.png" align="right"/></dt>
				<dd><br><img src="./images/faq_qa.png" align="left">판교 입니다</dd><br>
			<hr style="border: solid 1px;">
				<br><dt><img src="./images/faq_q.png" align="left"><b>고객센터 위치가 어떻게 되나요?</b><img src="./images/faq_d.png" align="right"/></dt>
				<dd><br><img src="./images/faq_a.png" align="left">판교 입니다</dd><br>>
			<hr style="border: solid 1px;">	

</body>
</html>