/**
 * 
 */

$(document).ready(function(){
	alert(window.location.pathname);
//	var menu_id = 3;
//	var list = $(".menu-title");
//	for(i=0;i<list.length;i++){
//		if(i==menu_id){ // 현재 클릭된 메뉴면
//			if($(list[i].nextElementSibling).is(":visible")){
//				$(list[i].nextElementSibling).slideUp();
//				//$(list[i].nextElementSibling).fadeOut();
//	        } else{
//	        	$(list[i].nextElementSibling).slideDown();
//	        	//$(list[i].nextElementSibling).fadeIn();
//	        }
//		}
//		else{
//			if($(list[i].nextElementSibling).is(":visible")){
//				$(list[i].nextElementSibling).slideUp();
//				//$(list[i].nextElementSibling).fadeOut();
//	        }
//		}
//	}
	
//	$(".outer-menu-item").click(function(){
//		console.log($(this));
//		alert("click");
//// 		console.log($(this.nextElementSibling));		
//		var list = $(".menu-title");
//		for(i=0;i<list.length;i++){
//			if(list[i]==this){ // 현재 클릭된 메뉴면
//				if($(list[i].nextElementSibling).is(":visible")){
//					$(list[i].nextElementSibling).slideUp();
//					//$(list[i].nextElementSibling).fadeOut();
//		        } else{
//		        	$(list[i].nextElementSibling).slideDown();
//		        	//$(list[i].nextElementSibling).fadeIn();
//		        }
//			}
//			else{
//				if($(list[i].nextElementSibling).is(":visible")){
//					$(list[i].nextElementSibling).slideUp();
//					//$(list[i].nextElementSibling).fadeOut();
//		        }
//			}
//		}
//	});
	
//	$(".outer-menu-item").click(function(){
////		console.log($(this));
////		alert("click");
//// 		console.log($(this.nextElementSibling));		
//		var list = $(".menu-title");
//		for(i=0;i<list.length;i++){
//			if(list[i]==this.firstElementChild){ // 현재 클릭된 메뉴면
//				if($(list[i].nextElementSibling).is(":visible")){
//					$(".pull-right").slideUp();
//					$(list[i].nextElementSibling).slideUp();
//					//$(list[i].nextElementSibling).fadeOut();
//		        } else{
//		        	$(".pull-right").slideDown();
//		        	$(list[i].nextElementSibling).slideDown();
//		        	//$(list[i].nextElementSibling).fadeIn();
//		        }
//			}
//			else{
//				if($(list[i].nextElementSibling).is(":visible")){
//					$(".pull-right").slideUp();
//					$(list[i].nextElementSibling).slideUp();
//					//$(list[i].nextElementSibling).fadeOut();
//		        }
//			}
//		}
//	});
	console.log($(".pull-right")[0].style.display);
	$(".outer-menu-item").hover(function(){
		
		var list = $(".menu-title");
		for(i=0;i<list.length;i++){
			if(list[i]==this.firstElementChild){ // 현재 클릭된 메뉴면
				if($(list[i].nextElementSibling).is(":visible")){
					//$(".pull-right").slideUp();
					$(".pull-right")[0].style.display="none";
					$(list[i].nextElementSibling).slideUp();
					//$(list[i].nextElementSibling).fadeOut();
		        } else{
		        	//$(".pull-right").slideDown();
		        	$(".pull-right")[0].style.display="block";
		        	$(list[i].nextElementSibling).slideDown();
		        	//$(list[i].nextElementSibling).fadeIn();
		        }
				
//				if(!$(list[i].nextElementSibling).is(":visible")){
//					$(list[i].nextElementSibling).slideDown();
//					//$(list[i].nextElementSibling).fadeOut();
//		        }
			}
			else{
				if($(list[i].nextElementSibling).is(":visible")){
//					$(".pull-right").slideUp();
					$(list[i].nextElementSibling).slideUp();
					//$(list[i].nextElementSibling).fadeOut();
		        }
			}
		}
	});
});