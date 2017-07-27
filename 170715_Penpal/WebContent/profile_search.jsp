<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로필 검색하기</title>
<link rel="stylesheet" href="stylesheet/profile_search.css" />
<script src="js/profile_search.js"></script>
<script src="jscript/jquery-3.2.1.min.js"></script>
</head>
<div class='outerBound'>
   <h2 class = 'titleFont'>프로필 검색</h2>
   <div>당신을 기다리는 친구들을 마음껏 찾아보세요~</div>
   <hr>
   <form name = 'searchForm' id = 'searchForm' method='post' action='ShowServlet'>
   <table>
   <tr>
      <td>
         프로필 영상
      </td>
      <td>
<!-- Rounded switch -->
<label class="switch">
  <input type="checkbox">
  <span class="slider round"></span>
</label>
        <!--  <input type="text" class = "inputLine" id="name" name="name"  /> -->
      </td>
   </tr>
   <tr>
      <td>
         나이
      </td>
      <td>
          <select class = "inputLine_age" name="age1" id = "age">
            <c:forEach var = "age" items="${ageList}">
               <option value = "${age}">${age}</option>
            </c:forEach>
         </select>
      </td>
      <td>ddddddddddd</td>
      <td>
      <select class = "inputLine_age" name="age2" id = "age">
            <c:forEach var = "age" items="${ageList}">
               <option value = "${age}">${age}</option>
            </c:forEach>
         </select>
      </td>
   </tr>
   <tr>
      <td>
      성별
      </td>
      <td>
         <select class = "inputLine" name="motherTongue" id = "motherTongue" >
            <c:forEach var = "sex" items="${sexList}" varStatus="loopCount">
               <option value = "${loopCount.count}">${sex}</option>
            </c:forEach>
         </select>

      </td>
   </tr>
   <tr>
      <td>
         국적
      </td>
      <td>
         <select class = "inputLine" name="hopeLanguage" id = "hopeLanguage">
            <c:forEach var = "country" items="${countryList}" varStatus="loopCount">
               <option value = "${loopCount.count}">${country}</option>
            </c:forEach>
         </select>
      </td>
   </tr>
   <tr>
      <td>
         언어
      </td>
      <td>
         <input type="text" class = "inputLine" id="mail" name="mail"  />
      </td>
   </tr>
   <tr>
      <td>
         정렬기준
      </td>
      <td>
         <input type="text" class = "inputLine" id="gender" name="gender" value=""   />
      </td>
   </tr>
   <tr>
      <td>
      </td>
      <td>
         <input type="button" class = "confirmButton" id="confirmButton" value="검색" onClick = "modifyProfile()"/>
         <input type="button" class = "cancelButton" id="searchButton" value="취소" onClick = "cancelModifyProfile()"/>
      </td>
   </tr>
   </table>
   </form>
   </div>
</body>
</html>