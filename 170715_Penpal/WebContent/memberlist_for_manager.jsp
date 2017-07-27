<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자용 회원목록보기</title>
<link rel="stylesheet" href="stylesheet/manager_memberlist.css" />
</head>
<body>
 <div class='manager'>
	 <h2>회원 목록 보기</h2>
   전체회원목록보기 입니다.
   <select class="abc">
   <option value="10">10명 정렬</option>
   <option value="20">20명 정렬</option>
   <option value="30">30명 정렬</option>
   
   </select>
   <hr>
   <form name = 'searchResultForm' id = 'searchResultForm' method='post' action='ShowServlet'>
   <table class="table_css">
   <tr align="center">
   <th colspan="2" width="30px"></th>
   <td width="200px">
   이름(아이디)
   </td> <td width="120px">가입일</td><td width="120px">최종방문일</td><td width="90px">방문수</td><td width="110px">게시글수</td><td width="90px">댓글수</td><td width="50px">등급</td><td width="110px">계정상태</td>
   </tr>
   
   <c:forEach var = "member" items="${list}">
   <tr align="center">
   <th><input type="checkbox"/></th>
   <th>
   <img src="images/human.JPG" />
   </th>
 <td class="trtr" width="200px">
   ${member[0]}
   </td> <td class="trtr" width="120px">${member[1] }</td><td class="trtr" width="120px">${member[2] }</td><td class="trtr" >${member[3] }</td><td class="trtr" >${member[4] }</td><td class="trtr" >${member[5]}</td><td class="trtr" >${member[6] }</td><td class="trtr" >${member[7] }</td>
 
   	    
    </tr>
  </c:forEach>
   
    </table>
    <p align="center"><b style="font-size: 20pt">선택 멤버를&nbsp;&nbsp;&nbsp;</b> <img width="80px" height="30px" src="images/stop.JPG"/>&nbsp;&nbsp;
    <img width="80px" height="30px" src="images/out.JPG"/>&nbsp;
    <img width="80px" height="30px" src="images/Rating.JPG"/>&nbsp;&nbsp;<img width="80px" height="30px" src="images/letter.JPG"/><p>
    </form>
    
     <div class="manager2">
        <c:if test="${startPage != 1}">
            <a href="MemberListForManagerServ?page=${startPage-1}&lNum=${lNum}">[이전]</a>
        </c:if>
        
        <c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
            <c:if test="${pageNum == spage}">
                ${pageNum}&nbsp;
            </c:if>
            <c:if test="${pageNum != spage}">
                <a href='MemberListForManagerServ?page=${pageNum}&lNum=${lNum}'>${pageNum}&nbsp;</a>
            </c:if>
        </c:forEach>
        
        <c:if test="${endPage != maxPage }">
            <a href='MemberListForManagerServ?page=${endPage+1}&lNum=${lNum}'>[다음]</a>
        </c:if>
    </div>
 </div>
 

</body>
</html>