<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="mine" uri="randomThings" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="myTags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

Advisor Page<br/>
<c:set var="user" scope="page" >
${userName}
</c:set>
<mine:advice user="${user}" >
This is the body.
</mine:advice>

<hr/>
<myTags:Header fontColor="#660099" subTitle="서브타이틀!?">
	We take the sting out of SOAP. OK, so... &lt;skip&gt;
</myTags:Header>

</body>
</html>