<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="faq.service.dao.AlbumDao" %>   
<%@ page import ="faq.service.domain.Album" %>   
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jstl/fmt_rt" %>

<c:if test="${album.service_email == null}">
	<c:out value="" />
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글수정</title>
<script type="text/javascript">
<!--
    function checkIt(){
        var user =document.userinput;
        
        if(!user.writer.value){
            alert("사용자 이름을 입력하세요");
            user.name.focus();
            return false;
        }
        if(!user.passwd.value){
            alert("비밀번호를 입력하세요");
            user.passwd.focus();
            return false;
        }
        if(!user.content.value){
            alert("내용을 입력하세요");
            user.content.focus();
            return false;
        }    
    }
//-->
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
			var prevImg = document.getElementById("prevImg"); //이전에 미리보기가 있다면 삭제
			if (prevImg) {
				preview.removeChild(prevImg);
				
			}
			var img = document.createElement("img"); 
			img.id = "prevImg";
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
<form action="updatePro.service" method="post" encType="multipart/form-data" name="userinput"  >  
<input type="hidden" name="service_id" value="${album.service_id}">
<div class="container">
<div class="row">
<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
<tr>
<th colspan="2"style="background-color: #eeeeee; text-align: center;">수 정</td>
</tr>


<tr>
<td colspan=2><input type="text" class="form-control" placeholder="Email" size="40" name="service_email" maxlength="30" value="${album.service_email}"></td>
</tr>

<tr>
    <td colspan=2><input type="text" class="form-control" placeholder="제목" size="40" name="service_title" maxlength="50" value="${album.service_title}"></td>
</tr>
<tr>
    <input type="hidden" name="originImage" value="${album.service_img}">
</tr>
  
<tr>
<td colspan=2><textarea class="form-control" placeholder="글 내용" name="service_content" maxlength="2048" style="height: 350px;">${album.service_content}</textarea></td>
</tr>
<tr>
    <td  width="70" align="center" >이미지</td>
    <td  width="330" >
     <input width="70" align="center" type="file" name="service_img" id="service_img" onchange="previewImage(this,'View_area')" >
  </tr>
  <tr>
  	<td colspan="2" align="center">
	<div align="center" id='View_area' style='position:relative; width: 100px; height: 100px; color: black; border: 0px solid black; dispaly: inline;'>
		<img id="prevImg" src="../_faq/service/upload/${album.service_img}" width="50" height="50" >	 
	</div>
  	</td>
 </tr>

<tr>
<td colspan=2><input type="password" class="form-control" size="8" name="service_pwd" maxlength="12" placeholder="암호와 동일해야 글이 수정됩니다."></td>
</tr>

<tr>
    <td colspan="2"  align="center">
    <input type="hidden" name="service_level" value="${album.service_level}">
    
  <input type="submit" value="수정하기" class="btn btn-success">  
  <input type="reset" value="다시작성" class="btn btn-success">
  <input type="button" value="목록보기" class="btn btn-success" onClick="location.href='list.service'">    
    </td>
</tr>
</table></div></div>  
</form>  
</body>
</html>