<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<strong>Member Comments</strong><br/>
<hr/>
<c:forEach var="comment" items="${commentList}" >
	${comment} <br/><br/>
</c:forEach>

<hr/>
<c:if test="${userType == 'member'}">
	<jsp:include page="inputComments.jsp"/>
</c:if>


<c:choose >
	<c:when test="${userPref == 'performance'}" >
		Now you can stop even if you <em>do</em> drive insanely fast.
	</c:when>
	<c:when test="${userPref == 'safety' }">
		Our brakes will never lock up, no matter how bad a driver you are.
	</c:when>
	<c:when test="${userPref == 'maintenance' }">
		Lost your tech job? No problem--you won't have to service these brakes for at least three years.
	</c:when>
	<c:otherwise>
		Our brakes are the best.
	</c:otherwise>
</c:choose>
<c:set target="${PetMap}" property="dogName" >
"바둑이"
</c:set>
<hr/>


<hr/>
<c:remove var="userPref" scope="page" />
<c:out value="${userPref }" default="null"/>

<hr/>

<c:import url="Header.jsp">
	<c:param name="subTitle" value="We take the sting out of SOAP." />
</c:import>


<hr/>
<c:set var="last" value="Hidden Cursor" />
<c:set var="first" value="Crouching Pixels" />
<c:url value="/inputComments.jsp" var="inputURL" >
	<c:param name="firstName" value="${first}" />
	<c:param name="lastName" value="${last}" />
</c:url>
The URL using params is : ${inputURL} <br/>

<hr/>
This is a hyperlink with URL rewriting enalbed.
<a href="${inputURL }' />" >Click here</a><br/>


</body>
</html>