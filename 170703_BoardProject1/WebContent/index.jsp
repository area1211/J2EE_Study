<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/index.js"></script>
<script type="text/javascript" >

function goWrite(param){
	  if(param != null && param.length != 0){
	   location.href="Front.do?cmd=WriteForward.do";
	  }else{
	   alert("로그인후 글 작성이 가능합니다.");
	   
	  }
}

function logout(){
	location.href="Front.do?cmd=Logout.do";
}


</script>

<link rel="stylesheet" href="css/indexStyle.css" />
<link rel="stylesheet" href="css/btnStyle.css" />
<link rel="stylesheet" href="css/article.css" />

</head>
<body>
<aside>
	<div id="sideUp">
	<c:if test="${empty sessionScope.nickname}">
		<form action="Front.do?cmd=Login.do" method="post">
			I&nbsp;D&nbsp;<input id="id" class="input" type="text" name="id" /><br/>
			PW<input id="pwd" class="input" type="password" name="pwd" /><br/>
			<input type="submit" id="login" value="Login"/>
			<input type="button" value="Join"/>
		</form>
	</c:if>
	<c:if test="${!empty sessionScope.nickname }">
		${sessionScope.nickname}님 안녕하세요!<br/>
		<input type="button" id="logout" value="Logout" onclick="logout();"/>
	</c:if>
	</div>
	<div id="boardMenu">
		<input id="board1" class="ClassName" type="submit" value="Soccer"/><br/><br/>
		<input id="board2" class="ClassName" type="submit" value="Basketball"/><br/><br/>
		<input id="board3" class="ClassName" type="submit" value="Baseball"/>
	</div>

</aside>
<article>
	<div class="title">
		<h1>
			<c:out value="${mb_name}" default="게시판제목.." />
		</h1>
		<h4>
			<c:out value="${mb_thumb }" default="게시판 요약 설명.." />
		</h4>
	</div>
	<div class="middleMenu">
		<input id="write" class="write" type="button" value="글쓰기" onclick="goWrite('${sessionScope.nickname}'); "/>
		<select id="select" class="select">
			<option value=10 <c:if test="${lNum == 10}">selected</c:if>>10개</option>
			<option value=20 <c:if test="${lNum == 20}">selected</c:if>>20개</option>
			<option value=30 <c:if test="${lNum == 30}">selected</c:if>>30개</option>
		</select>
	</div>
	<div class="postList">
		<table class="table">
			<tr><td>No.</td>
			<td>글제목</td>
			<td>글쓴이</td>
			<td>작성일</td>
			<td>조회수</td>
			<td>추천수</td></tr>
			<c:forEach var="post" items="${p_list }">
			<tr>
				<td>${post.id}</td>
				<td><a href="Front.do?cmd=PostDetail.do&num=${post.id}">${post.title}</a></td>
				<td>${post.nickname }</td>
				<td>${post.date }</td>
				<td>${post.hits }</td>
				<td>0</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<div id="pageForm" class="paging">
        <c:if test="${startPage != 1}">
            <a href="Front.do?cmd=BoardList&page=${startPage-1}&lNum=${lNum}">[이전]</a>
        </c:if>
        
        <c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
            <c:if test="${pageNum == spage}">
                ${pageNum}&nbsp;
            </c:if>
            <c:if test="${pageNum != spage}">
                <a href='Front.do?cmd=BoardList&page=${pageNum}&lNum=${lNum}'>${pageNum}&nbsp;</a>
            </c:if>
        </c:forEach>
        
        <c:if test="${endPage != maxPage }">
            <a href='Front.do?cmd=BoardList&page=${endPage+1}&lNum=${lNum}'>[다음]</a>
        </c:if>
    </div>


	<div id="searchForm" align="center">
        <form>
            <select name="opt">
                <option value="0">제목</option>
                <option value="1">내용</option>
                <option value="2">제목+내용</option>
                <option value="3">글쓴이</option>
            </select>
            <input type="text" size="20" name="condition"/>&nbsp;
            <input type="submit" value="검색"/>
        </form>    
    </div>


</article>
</body>
</html>