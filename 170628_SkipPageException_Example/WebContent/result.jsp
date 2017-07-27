<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="myTags" uri="simpleTagTest" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 1. About to invoke a tag that throws SkipPageException <br/> -->
<%-- <myTags:simple6 name="test"/> --%>
<!-- <br>4. Back in the page after invoking the tag. -->

A1. This is page (A) that includes another page (B).<br/>
A2. Doing the include now:<br/>
<jsp:include page="badTagInclude.jsp" />
<br/>A3. Back in page A after the include...


</body>
</html>