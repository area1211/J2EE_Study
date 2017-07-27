<%@ page import="java.util.List"%>
<%@ page  language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	out.write("The friends who share your hobby of ");
	out.write(request.getParameter("hobby") + " are");
	
	List<String> friends = (List<String>)request.getAttribute("friends");
	if(friends.size()!=0)
		for(String tmp: friends){
			out.write("<br/>"+tmp);
		}
	else{
		out.write(" not existed!");
	}
	
%>

</body>
</html>