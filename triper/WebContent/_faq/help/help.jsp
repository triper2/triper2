<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
}

dd {
	display: none;
	height: 30px;
	margin: 0;
}
</style>
<script>
        $( function () {
            //dt 를 클릭했을 때
            $( 'dt' ).click( function (e) {
            	/* alert($(this).parent().id); */
                //dd 의 display 속성이 block 이라면
                if ( $( this ).next().css( 'display' ) == 'block' ) {
                    $( this ).next().slideUp( 1000 );    //조건이 참일 때 실행
                }
                    //dd 의 display 속성이 block 이 아니라면
                else{
                	
                    $( this ).next().slideDown( 1000 );//조건이 거짓일 때 실행
                } 
            } );
        } );

    </script>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">

</script>
<title>자주 묻는 질문(FAQ)</title>
</head>
<body>
			<th>자주 묻는 질문(FAQ)</th>
			<hr>

				<dt>고객센터 전화번호가 어떻게 되나요?</dt>
				<dd>010-000-0000</dd>

				<dt>고객센터 위치가 어떻게 되나요?</dt>
				<dd>판교 입니다</dd>

				<dt>고객센터 위치가 어떻게 되나요?</dt>
				<dd>판교 입니다</dd>

				<dt>고객센터 위치가 어떻게 되나요?</dt>
				<dd>판교 입니다</dd>

				<dt>고객센터 위치가 어떻게 되나요?</dt>
				<dd>판교 입니다</dd>

</body>
</html>