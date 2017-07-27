<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="formTags" uri="randomThings" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Beer selection</h1>
<form method="POST" action="SelectBeer.do">Select beer characteristics<p>
Color:

<formTags:select id="selectoption" name="color" size="1" optionsList="${applicationScope.colorList}"/>


<br/><br/>
<input type="submit" />
</form>
</body>
</html>