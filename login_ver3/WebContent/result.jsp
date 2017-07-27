<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="css/jspstyle.css"></script>
</head>
<body>

<div id="thebody">

<%
// 	List<String> styles = (List<String>)request.getAttribute("styles");
	
// 	for(String tmp: styles){
// 		out.print("<br/>try: "+tmp);
// 	}

	String[] result=(String[])request.getAttribute("result");
	if(result.length==2){
		out.print("<br/> 로그인 실패 : "+result[1]);
	}
	else if(result.length==3){
		out.print("<br/> 로그인 성공!");
		out.print("<br/> "+result[2]+"님 안녕하세요!");
	}
	
	out.print("<h1><a href=\""+request.getHeader("referer")+"\">이전페이지 돌아가기</a></h1>");


%>

</div>
</body>
</html>