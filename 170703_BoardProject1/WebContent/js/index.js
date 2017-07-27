
$.errMsg = {
	contain_blank : "아이디에 공백문자가 포함되어있습니다!"
	
}


var checkId = function(){
	if($('input#id').val().indexOf(" ") >= 0){
		alert(contain_blank);
		$('input#id').prop('value', "");
		$('input#id').focus();
		return false;
	} else if ($('input#id').val().length < 4){
		alert("아이디는 4자 이상이어야 합니다!");
		$('input#pwd').prop('value', "");
		$('input#id').focus();
		return false;
	} else if (isNumber($('input#id').val().charAt(0))){
		alert("아이디는 숫자로 시작할 수 없습니다!");
		$('input#pwd').prop('value', "");
		$('input#id').focus();
		return false;
	}
	
	return true;
};

var checkPwd = function(){
	reg = '^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,19}$';
	if($('input#pwd').val().indexOf(" ") >= 0){
		alert("비밀번호에 공백문자가 포함되어있습니다!");
		$('input#pwd').prop('value', "");
		$('input#pwd').focus();
		return false;
	} else if ($('input#pwd').val().length < 4){
		alert("비밀번호는 4자 이상이어야 합니다!");
		$('input#pwd').prop('value', "");
		$('input#pwd').focus();
		return false;
	} 
//	else if (!($('input#pwd').val().match(reg))){
//	//else if(!RegExp(reg, 'i').test(!$('input#pwd').val())){
//		alert("비밀번호는 영문, 숫자, 특수문자의 조합이어야 합니다!");
//		$('input#pwd').prop('value', "");
//		$('input#pwd').focus();
//		return false;
//	}
	
	return true;
}

function isNumber(s) {
	s += ''; // 문자열로 변환
	s = s.replace(/^\s*|\s*$/g, ''); // 좌우 공백 제거
	if (s == '' || isNaN(s)) return false;
	  return true;
}

function urlencode(str) {
    str = (str + '').toString();
    return encodeURIComponent(str)
        .replace(/!/g, '%21')
        .replace(/'/g, '%27')
        .replace(/\(/g, '%28')
        .replace(/\)/g, '%29')
        .replace(/\*/g, '%2A')
        .replace(/%20/g, '+');
}

function urldecode(str) {
    return decodeURIComponent((str + '')
        .replace(/%(?![\da-f]{2})/gi, function() {
            return '%25';
        })
        .replace(/\+/g, '%20'));
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
	
	
	//$('button#join').click(function(e){
	
	
	
//	document.getElementById('write').onclick = function(e){
//		//location.href="WriteFoward.do";
//		location.href="Front.do?cmd=WriteForward.do";
//	};
	
	
	
	document.getElementById('select').onchange = function(e){
//		console.log(e);
//		console.log(this);
//		alert(e.target.value);
//		location.href="Front.do?cmd=BoardList&board=축구게시판&lNum="+e.target.value;
		location.href="Front.do?"+urlencode("cmd=BoardList&board=축구게시판&lNum="+e.target.value);
	}
	
	document.getElementById('board1').onclick = function(e){
//		location.href="Front.do?cmd=BoardList&board=축구게시판";
		location.href="Front.do?"+urlencode("cmd=BoardList&board=축구게시판");
	};
	
	document.getElementById('board2').onclick = function(e){
//		location.href="Front.do?cmd=BoardList&board=농구게시판";
		location.href=urlencode("Front.do?cmd=BoardList&board=농구게시판");
	};
	
	document.getElementById('board3').onclick = function(e){
//		location.href="Front.do?cmd=BoardList&board=야구게시판";
		location.href=urlencode("Front.do?cmd=BoardList&board=야구게시판");
	};
	
	$('input#login').click(function(e){
		if(checkId()&&checkPwd()){
			return true;
		}
		return false;
	});
	
//	document.getElementById('logout').onclick = function(e){
//		location.href="Front.do?cmd=Logout.do";
//		
//	};
	
//	document.getElementById('login').onclick = function(e){
//		alert("로그인첵!");
//		if(checkId()&&checkPwd()){
//			
//			return true;
//		}
//		
//		return false;
//		
//	};
	
	
});
