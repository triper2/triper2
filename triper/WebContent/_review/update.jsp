<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="review.bbs.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width" ,intial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>Insert title here</title>
<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="js/bootstrap.js"></script>


<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="se2/js/HuskyEZCreator.js"
	charset="utf-8"></script>

<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>


<script>
	$(function() {
		//전역변수선언
		var editor_object = [];

		nhn.husky.EZCreator.createInIFrame({
			oAppRef : editor_object,
			elPlaceHolder : "review_Content",
			sSkinURI : "se2/SmartEditor2Skin.html",
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true,
			}
		});

		//전송버튼 클릭이벤트
		$("#savebutton").click(
				function() {
					//id가 smarteditor인 textarea에 에디터에서 대입
					editor_object.getById["review_Content"].exec(
							"UPDATE_CONTENTS_FIELD", []);

					// 이부분에 에디터 validation 검증

					//폼 submit
					$("#frm").submit();
				})
	})
</script>

</head>
<body>

	<center>
		<div class="container">
			<div class="row">
				<form method="post" action="updateAction.review">
				<input type="hidden" name="review_ID" value="${bbs.getReview_ID()}">
					<table class="table table-striped"
						style="text-align: center; border: 1px solid #dddddd">
						<thead>
							<tr>
								<th colspan="2"
									style="background-color: #eeeeee; text-align: center;">글
									수정</th>

							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="text" class="form-control"
									placeholder="글 제목" name="review_Title" maxlength="50"
									value="${bbs.getReview_Title()}"></td>
							</tr>

							<tr>
								<td><textarea class="form-control" placeholder="글 내용"
										name="review_Content" id="review_Content" maxlength="2048"
										style="height: 350px;">${bbs.getReview_Content()}</textarea></td>
							</tr>

						</tbody>

					</table>
					<input type="submit" name=savebutton id="savebutton"
						class="btn btn-primary pull-right" value="글수정">
				</form>
			</div>

		</div>
	</center>
</body>
</html>
