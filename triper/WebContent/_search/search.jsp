<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html> 
<html>
<form id="defaultForm" method="post" action=".searchServelt">
<body>
<select id="table" name="table">
  <option value="">-- 선택 --</option>
  <option value="service_board">service_board</option>
  <option value="review_board">review_board</option>
  <option value="review_comment">review_comment</option>
  <option value="review_like">review_like</option>
  <option value="event_board">event_board</option>
  <option value="MEMBER_LIST">member_list</option>
</select>
<select id="column" name="column">
  <option value="">-- 선택 --</option>
  <option class="service_board" value="service_id">service_id</option>
  <option class="service_board" value="member_id">member_id</option>
  <option class="service_board" value="service_email">service_email</option>
  <option class="service_board" value="service_content">service_content</option>
  <option class="service_board" value="service_pwd">service_pwd</option>
  <option class="service_board" value="service_reg_date">service_reg_date</option>
  <option class="service_board" value="service_readcount">service_readcount</option>
  <option class="service_board" value="service_ip">service_ip</option>
  <option class="service_board" value="service_img">service_img</option>
  <option class="service_board" value="service_ref">service_ref</option>
  <option class="service_board" value="service_re_step">service_re_step</option>
  <option class="service_board" value="service_level">service_level</option>
  
  
  <option class="review_board" value="review_id">review_id</option>
  <option class="review_board" value="review_title">review_title</option>
  <option class="review_board" value="member_id">member_id</option>
  <option class="review_board" value="review_date">review_date</option>
  <option class="review_board" value="review_content">review_content</option>
  <option class="review_board" value="review_available">review_available</option>
  <option class="review_board" value="review_image_1">review_image_1</option>
  <option class="review_board" value="review_image_2">review_image_2</option>
  <option class="review_board" value="review_Like">review_Like</option>
  <option class="review_board" value="review_Hate">review_Hate</option>
  <option class="review_board" value="review_Viewcount">review_Viewcount</option>
  
  <option class="review_comment" value="review_comment_id">review_comment_id</option>
  <option class="review_comment" value="review_ID">review_ID</option>
  <option class="review_comment" value="member_ID">member_ID</option>
  <option class="review_comment" value="review_comment_date">review_comment_date</option>
  <option class="review_comment" value="review_comment_content">review_comment_content</option>
  <option class="review_comment" value="review_comment_available">review_comment_available</option>
  <option class="review_comment" value="member_image">member_image</option>
  
  <option class="review_like" value="review_ID">review_ID</option>
  <option class="review_like" value="member_ID">member_ID</option>
  
  <option class="event_board " value="ebNum">ebNum</option>
  <option class="event_board " value="ebTitle">ebTitle</option>
  <option class="event_board " value="member_id">member_id</option>
  <option class="event_board " value="ebDate">ebDate</option>
  <option class="event_board " value="ebContent">ebContent</option>
  <option class="event_board " value="ebAvailable">ebAvailable</option>
  <option class="event_board " value="ebImg">ebImg</option>
  
  <option class="MEMBER_LIST " value="member_id">member_id</option>
  <option class="MEMBER_LIST " value="member_name">member_name</option>
  <option class="MEMBER_LIST " value="member_pwd">member_pwd</option>
  <option class="MEMBER_LIST " value="member_phone">member_phone</option>
  <option class="MEMBER_LIST " value="member_email">member_email</option>
  <option class="MEMBER_LIST " value="member_img">member_img</option>
  
</select>
		<input type="submit" value="전송">
 		검색:<input type="text" name="input" id="input">
 		
 </body>
 </form>		
 </html>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src='//rawgit.com/tuupola/jquery_chained/master/jquery.chained.min.js'></script>
<script>
  $("#column").chained("#table");
</script>