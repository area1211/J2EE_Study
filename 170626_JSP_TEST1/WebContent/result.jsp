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

간식명단: ${foods}<br/>
간식이름1: ${foods[1]}<br/>
간식이름2: ${foods["2"]}<br/>
<hr/>
<table>

<c:forEach var="food" items="${foods}" varStatus="foodCount">
<tr><td>NO.${foodCount.count}:</td><td>${food}</td></tr>
</c:forEach>

</table>
<hr/>
음반명단: ${music} <br>
1. ${music["C1"]} <br>
2. ${music.C2} <br>
3. ${music["C3"]} & ${music.C3} & ${Genre[C3]} <br>
4. ${music[C4]} & ${music["C4"]} <br>

<jsp:useBean id="person" class="jsp.tags.bean.Person" scope="request">
<jsp:setProperty name="person" property="name" value="홍길동"/>
</jsp:useBean>
1. 강아지 주인이름(표준액션태그) : <jsp:getProperty name="person" property="name"/><br/>
2. 강아지 정보(표준액션태그) : <jsp:getProperty name="person" property="dog"/><br/>
3. 강아지 정보(EL) : ${person.dog} <br/>
4. 강아지 장난감뱅열(EL) : ${person.dog.toys}<br/>
5. 강아지 장난감배열(EL) : ${person.dog.toys[0]}, ${person.dog.toys[1]}, ${person.dog.toys[2]}<br/>
6. 강아지 장난감배열(JSTL) : <c:forEach var="toy" items="${person.dog.toys}">${toy.name}&nbsp;</c:forEach>



</body>
</html>