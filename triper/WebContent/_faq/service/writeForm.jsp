<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jstl/fmt_rt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>게시판</title>


<script type="text/javaScript">
function writeSave(){
    
    if(document.writeform.member_id.value==""){
      alert("작성자를 입력하십시요.");
      document.writeform.member_id.focus();
      return false;
    }
    if(document.writeform.service_title.value==""){
      alert("제목을 입력하십시요.");
      document.writeform.service_title.focus();
      return false;
    }
    
    if(document.writeform.service_content.value==""){
      alert("내용을 입력하십시요.");
      document.writeform.service_content.focus();
      return false;
    }
        
/*     if(document.writeform.service_pwd.value==""){
      alert(" 비밀번호를 입력하십시요.");
      document.writeform.service_pwd.focus();
      return false;
    } */
    return true;
 }    
 
function previewImage(targetObj, View_area) {
	var preview = document.getElementById(View_area); //div id
	var ua = window.navigator.userAgent;

  //ie일때(IE8 이하에서만 작동)
	if (ua.indexOf("MSIE") > -1) {
		targetObj.select();
		try {
			var src = document.selection.createRange().text; // get file full path(IE9, IE10에서 사용 불가)
			var ie_preview_error = document.getElementById("ie_preview_error_" + View_area);

			if (ie_preview_error) {
				preview.removeChild(ie_preview_error); //error가 있으면 delete
			}

			var img = document.getElementById(View_area); //이미지가 뿌려질 곳

			//이미지 로딩, sizingMethod는 div에 맞춰서 사이즈를 자동조절 하는 역할
			img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+src+"', sizingMethod='scale')";
		} catch (e) {
			if (!document.getElementById("ie_preview_error_" + View_area)) {
				var info = document.createElement("<p>");
				info.id = "ie_preview_error_" + View_area;
				info.innerHTML = e.name;
				preview.insertBefore(info, null);
			}
		}
  //ie가 아닐때(크롬, 사파리, FF)
	} else {
		var files = targetObj.files;
		for ( var i = 0; i < files.length; i++) {
			var file = files[i];
			var imageType = /image.*/; //이미지 파일일경우만.. 뿌려준다.
			if (!file.type.match(imageType))
				continue;
			var prevImg = document.getElementById("prev_" + View_area); //이전에 미리보기가 있다면 삭제
			if (prevImg) {
				preview.removeChild(prevImg);
			}
			var img = document.createElement("img"); 
			img.id = "prev_" + View_area;
			img.classList.add("obj");
			img.file = file;
			img.style.width = '100px'; 
			img.style.height = '100px';
			preview.appendChild(img);
			if (window.FileReader) { // FireFox, Chrome, Opera 확인.
				var reader = new FileReader();
				reader.onloadend = (function(aImg) {
					return function(e) {
						aImg.src = e.target.result;
					};
				})(img);
				reader.readAsDataURL(file);
			} else { // safari is not supported FileReader
				//alert('not supported FileReader');
				if (!document.getElementById("sfr_preview_error_"
						+ View_area)) {
					var info = document.createElement("p");
					info.id = "sfr_preview_error_" + View_area;
					info.innerHTML = "not supported FileReader";
					preview.insertBefore(info, null);
				}
			}
		}
	}
}
</script>
</head>
<body>
<jsp:include page="../../_main_login/header.jsp"></jsp:include>
<br>
<form method="post" name="writeform" action="writePro.service" encType="multipart/form-data" onsubmit="return writeSave()">
<input type="hidden" name="service_id" value="${ service_id }" >
<input type="hidden" name="service_ref" value="${ service_ref }">
<input type="hidden" name="service_re_step" value="${ service_re_step }">
<input type="hidden" name="service_level" value="${ service_level }">
<div class="container">
			<div class="row">
<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
       <input type="hidden" size="10" maxlength="10" name="member_id" value="${sessionScope.dto.member_id }">
 <tr>
<th colspan="2"style="background-color: #eeeeee; text-align: center;">글쓰기</th></tr>
  <tr>
<!-- 	답변인것에 대한 처리 -->
<c:if test="${ service_id == 0 }">  <!-- 제목글 -->
	<td colspan=2><input type="text" class="form-control" placeholder="제목" size="40" name="service_title" maxlength="50"></td>
</c:if>
<c:if test="${ service_id != 0 }">  <!-- 답변글 -->
	<td colspan=2><input type="text" class="form-control" placeholder="제목" size="40" name="service_title" maxlength="50" value ="[답변] "></td>
</c:if>
  </tr>
  
<tr>
<td colspan=2><input type="text" class="form-control" placeholder="Email" size="40" name="service_email" maxlength="30"></td>
</tr>

<tr>
<td colspan=2><textarea class="form-control" placeholder="글 내용" name="service_content" maxlength="2048" style="height: 350px;"></textarea></td>
</tr>
  
<tr>
<td colspan=2><input type="password" class="form-control" placeholder="비밀번호(입력하면 비밀글이 됩니다)" size="8" name="service_pwd" maxlength="12"></td>
</tr>
  <tr>
    <td  width="70" align="center" >이미지</td>
    <td  width="330" >
	
    <input width="70" align="center" type="file" name="service_img" id="service_img"  onchange="previewImage(this,'View_area')">

    </td>
  </tr>
  <tr>
  	<td colspan="2" align="center">
	<div align="center" id='View_area' style='position:relative; width: 100px; height: 100px; color: black; border: 0px solid black; dispaly: inline; '></div>
  	</td>
  </tr>

<tr>      
 <td colspan=2 align="center"> 
  <input type="submit" value="글쓰기" class="btn btn-success">  
  <input type="reset" value="다시작성" class="btn btn-success">
  <input type="button" value="목록보기" class="btn btn-success" onClick="location.href='list.service'">
</td></tr></table></div></div>
</form>            
</body>
</html>