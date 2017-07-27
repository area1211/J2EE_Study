<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="stylesheet/bookmark_list.css" />
<script src="js/bookmark_list.js"></script>
<script src="jscript/jquery-3.2.1.min.js"></script>
<script>

$(document).ready(function (e){
	var videos = $('.videos');
	console.log($('.videos'));
	console.log(document.querySelectorAll(".videos"));
	console.log($('.videos')[0]);
	console.log(videos[0]);
	
	console.log(videos[1]);
	
	
	/* for(i=0; i<videos.length; i++){
		//alert(videos[i]);
		//console.log(i);
		//alert(videos.length);
		$('.videos')[i].hover(function(e){
			$('.videos')[i].get(0).play();
		},function(e){$(".videos")[i].get(0).pause();});
	} */
	$('.videos').hover(function(e){
		this.play();
	},function(e){this.pause();});
});
	
	
</script>
</head>
<body>
 <h2>즐겨찾기 목록</h2>
   <div>당신이 기다리는 친구들의 목록입니다.</div>
   <hr>
   <form name = 'searchResultForm' id = 'searchResultForm' method='post' action='ShowServlet'>
   <table class="table_css">
   <tr>
   <td class="title" colspan="3">
   즐겨찾기 친구목록
   </td>
   </tr>
   <c:forEach var = "bookmark" items="${list}">
   <tr>
   		<c:choose>
   			<c:when test="${bookmark[6]=='0' }">
      <td class="imageVideo">
      	<img src="${bookmark[5] }"/>
      </td>
      	</c:when>
      	</c:choose>
      	
      	<c:choose>
   			<c:when test="${bookmark[6]=='1' }">
      <td class="imageVideo">
      	<video class="videos" src="${bookmark[5]}" type="video/mp4" width="200px" height="110px"/>
      </td>
      	</c:when>
      	</c:choose>
      <td class="textTd">
       
      이름:${bookmark[0]}  
      <br>나이:${bookmark[1]}  <br>성별:${bookmark[2]}  <br>국적:${bookmark[3]}  <br>소개글:${bookmark[4]}<br> 
      </td>
      <td>
      <img src="images/trash.png"/>
      </td>
    </tr>
  </c:forEach>
   
    </table>
    </form>
</body>
</html>