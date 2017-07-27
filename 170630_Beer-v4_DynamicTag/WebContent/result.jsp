<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Beer Recommendations JSP</h1>
<p>

<%

	List<String> styles = (List<String>)request.getAttribute("styles");
	
	for(String tmp: styles){
		out.print("<br/>try: "+tmp);
	}

%>

</body>
</html>