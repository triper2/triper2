<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>web test</title>
<style type="text/css">
* {box-sizing: border-box}
body {font-family: "Lato", sans-serif;}

/* Style the tab */
div.tab {
    float: left;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
    width: 10%;
    height: 500px;
}

/* Style the buttons inside the tab */
div.tab button {
    display: block;
    background-color: inherit;
    color: black;
    padding: 22px 16px;
    width: 100%;
    border: none;
    outline: none;
    text-align: left;
    cursor: pointer;
    transition: 0.3s;
    font-size: 17px;
}

/* Change background color of buttons on hover */
div.tab button:hover {
    background-color: #ddd;
}

/* Create an active/current "tab button" class */
div.tab button.active {
    background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
    float: left;
    padding: 0px 12px;
    border: 1px solid #ccc;
    width: 90%;
    border-left: none;
    height: 500px;
}
</style>
</head>
<body>
<p>고객 센터</p>

<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'Help')" id="defaultOpen">고객센터</button>
  <button class="tablinks" onclick="openCity(event, 'Notice')">공지사항</button>
 <!-- <button class="tablinks" onclick="openCity(event, 'Board')">Board</button> -->
<button class="tablinks" onclick="openCity(event, 'Board')">게시판</button>
  <button class="tablinks" onclick="openCity(event, 'Chat')">1:1채팅</button>
</div>

<div id="Help" class="tabcontent">
  <h3>고객센터</h3>
  <jsp:include page="help/help.jsp"></jsp:include>
</div>

<div id="Notice" class="tabcontent">
  <h3>공지사항</h3>
</div>
<!-- <a href="board.jsp" style="text-decoration: none"></a>  -->

<div id="Board" class="tabcontent">
   <jsp:include page="list.jsp"></jsp:include>
</div>

<div id="Chat" class="tabcontent">
  <h3>1:1채팅</h3>
  <embed height="80%" width="90%" src="http://www.gagalive.kr/gagalive.swf?chatroom=%7E%7E%7Ejsp%21"></embed>
</div>

<script>
function openCity(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();
</script>	
</body>
</html>