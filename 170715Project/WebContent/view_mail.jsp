<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
    $("#spreadBtn").click(function(){
        if($("#hiddenList").is(":visible")){
            $("#hiddenList").slideUp();
        }else{
            $("#hiddenList").slideDown();
        }
    });
});
</script>
<style>
h2{
	color: #3498db;
}

table{
	border-collapse: collapse;
	border-spacing: 10px;
	width:1000px;
	color: #3498db;
	background-color: #e6e6e6;
	
}

td{
	padding: 10px;
}

#tb {
	
}

#btns {
	text-align: right;
}
.box{
	border: 1px solid #3498db;
	height: 200px;
	vertical-align: top;
}
</style>

</head>
<body>

<div id="l_body" style="height:700px; width:1000px;" >
	<div>
	<h2>&nbsp;편지내용</h2>
	</div>
	<hr/>

	<div id="btns">
	<input type="button" value="답장"/>
	<input type="button" value="삭제"/>
	<input type="button" value="목록으로"/>
	</div>
	<br/>
	<div id="tb">
		<table>
			<tr>
				<td>From.</td>
				<td><input type="text" value="보낸사람" readonly/></td>		
			</tr>
			<tr>
				<td>Title.</td>
				<td><input type="text" value="제목ㅎ" readonly/></td>
			</tr>
			<tr>
				<td>Date.</td>
				<td><input type="text" value="2017/07/15 11:04" readonly/></td>
			</tr>
			<tr>
				<td><button id="spreadBtn" class="btn01">펼치기</button></td>
			</tr>
			<tr>                                   
				<td id="hiddenList" class="box" colspan="2" style="display: none;">
				<video poster="movie.jpg" width="400" height="300" controls="controls">
				 <source src="movie.ogg" type='video/ogg' />
				 <source src="contents/movie.mp4" type='video/mp4' /> 
				
				</video>
				</td>
			</tr>
			<tr>
				<td class="box" colspan="2">먹고 힘내렴...</td>
			</tr>
		
		
		</table>	
	</div>



</div>

</body>
</html>