/**
 * 
 */
$.errMsg = {
	title_blank : "제목을 입력해주세요!",
	body_blank : "본문을 입력해주세요!"
	
}

var checkVaridity = function(){
	if($('input.p_title').val().length==0){
		alert("제목을 입력해주세요!");
		$('input.p_title').focus();
		return false;
	}
	else if($('textarea').val().length==0){
		alert("본문을 입력해주세요!");
		$('input.p_body').focus();
		return false;
	}
	return true;
}

function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
    results = regex.exec(location.search);
    return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}



$(document).ready(function(e){
//	$('input#login').click(function(e){
//	//document.getElementById('login').click(function(e){
//		if(checkId() && checkPwd()){
//			alert("유효성검증통과");
//			//$('form#end').submit();
//			return true;
//		}
//		
//		return false;
//	});
	
	
	document.getElementById('confirm').onclick = function(e){
		if(checkVaridity()){
			alert("전송");
			//location.href="PostSave.do";
			return true;
		}
		
		return false;
	}
	
	document.getElementById('cancel').onclick = function(e){
		alert("취소누르셨습니다.");
		location.href="Front.do?cmd=BoardList";
		
		
	}
	
	document.getElementById('board1').onclick = function(e){
		location.href="Front.do?cmd=BoardList&board=축구게시판";
		
	};
	
	document.getElementById('board2').onclick = function(e){
		location.href="Front.do?cmd=BoardList&board=야구게시판";
		
	};
	
	document.getElementById('board3').onclick = function(e){
		location.href="Front.do?cmd=BoardList&board=농구게시판";
		
	};
	
});