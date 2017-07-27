<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="bean2" type="com.lecto.servlet.Bean" class="com.lecto.servlet.BeanSub">
	<jsp:setProperty name="bean2" property="*"/>
</jsp:useBean>
<jsp:useBean id="bean" type="com.lecto.servlet.Bean" class="com.lecto.servlet.BeanSub">
	<jsp:setProperty name="bean" property="*"/>
</jsp:useBean>
super:${bean.name}
sub:<jsp:getProperty name="bean" property="subName"/><br/>
${pageContext.request.method }
</body>
</html>