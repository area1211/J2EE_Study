<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="mine" uri="KathyClassicTags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

Classic Tag One:<br/>
<mine:classicOne />
<hr/>
Classic Tag Two:<br/>
<mine:classicTwo >bodybody</mine:classicTwo>
<hr/>
Simple Body Tag:<br/>
<mine:simpleBody>This is body.</mine:simpleBody>
<hr/>
Simple Iterator Tag:<br/>
<table border="1">
<mine:simpleItr>
	<tr><td><c:out value="${movie}"  /></td></tr>
</mine:simpleItr>
</table>
</body>
</html>