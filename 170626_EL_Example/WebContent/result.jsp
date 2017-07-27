<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="mine" uri="DiceFunctions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 
MapTest : ${map} <br/>
AryTest : ${ary} <br/>
ListTest: ${list} <br/>
BeanTest: ${bean.name}<br/><br/>
MapTest - monday= ${map.mon} <br/>
MapTest - [monday]= ${map["mon"]}<br/>
AryTest : ${ary["1"]}<br/>
ListTest: ${list[0]}<br/>
<hr/>
<jsp:useBean id="bean" type="com.lecto.servlet.BeanSub" scope="request" >
<jsp:setProperty name="bean" property="subName" value="이름세팅했다저녁버전!"/>
Bean created by servlet: 
</jsp:useBean><jsp:getProperty name="bean" property="subName" />

<hr/>
${mine:rollIt()}

</body>
</html>