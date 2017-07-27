<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	
	String[] list = (String[])request.getAttribute("cart");
	out.println(" * 장바구니 목록 * <br/>");
	for(String tmp: list){
		out.println("<br/>"+tmp);
	}
	
%>

</body>
</html>