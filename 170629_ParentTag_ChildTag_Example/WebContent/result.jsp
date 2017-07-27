<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="mine" uri="randomThings" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<mine:NestedLevel>
	<mine:NestedLevel>
		<mine:NestedLevel/>
	</mine:NestedLevel>
</mine:NestedLevel>
<hr/>
심플 태그와 클래식 태그 간 상호 작용...<br/>
<mine:ClassicParent name="ClassicParentTag">
	<mine:SimpleInner />
</mine:ClassicParent>

</body>
</html>