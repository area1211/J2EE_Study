<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="./css/menu.css"/>
<style>
.m_menu{
	color:black;
}

</style>
<script src="./js/jquery-3.2.1.min.js"></script>
<script src="./js/navi_bar.js"></script>
<script>
// $(document).ready(function(){

// 	$(".menu-title").click(function(){
// // 		console.log($(this.nextElementSibling));		
// 		var list = $(".menu-title");
// 		for(i=0;i<list.length;i++){
// 			if(list[i]==this){ // 현재 클릭된 메뉴면
// 				if($(list[i].nextElementSibling).is(":visible")){
// 					$(list[i].nextElementSibling).slideUp();
// 		        }else{
// 		        	$(list[i].nextElementSibling).slideDown();
// 		        }
// 			}
// 			else{
// 				if($(list[i].nextElementSibling).is(":visible")){
// 					$(list[i].nextElementSibling).slideUp();
// 		        }
// 			}
// 		}
// 	});
    
});

</script>

<div id="menuBox">
	<div id="page-wrapper">
		<div id="main-header" style="background: rgb(52, 152, 219);">
			<div id="main-title">
				<hgroup>
	                <h1 class="master-title">Vuffalow</h1>
	                <h2 class="master-description">with my penpal</h2>
	            </hgroup>
			</div>
		</div>
		
		
		<div id="main-navigation" style="background: rgb(224, 224, 224);">
			<div class="pull-left">
				<ul class="outer-menu">
					<li class="outer-menu-item">
                  		<span id="profile" class="menu-title"><a class="m_menu" href="HomepageServlet">HOME</a></span>
               		</li>
					<li class="outer-menu-item">
						<span id="profile" class="menu-title"><a class="m_menu" href="viewMyProfile.do">Profile</a></span>
						<ul id="inner-profile" class="inner-menu" style="display: none;">
							<li class="inner-menu-item"><a href="viewMyProfile.do">My profile</a>
							<li class="inner-menu-item"><a href="friendList.do?cmd=3">Favorite </a>
						</ul>
						
						
						
					</li>
					<li class="outer-menu-item">
						<span class="menu-title"><a class="m_menu" href="ViewMailList.do?flag=0">우편함</a></span>
						<ul class="inner-menu" style="display: none;">
							<li class="inner-menu-item"><a href="ViewMailList.do?flag=0">In Mailbox</a>
							<li class="inner-menu-item"><a href="ViewMailList.do?flag=1">Out Mailbox</a>
							<li class="inner-menu-item"><a href="linkSendMail.do">ÆíÁö">Write Mail</a>
						</ul>
					</li>
					<li class="outer-menu-item">
						<span class="menu-title"><a class="m_menu" href="friendList.do?cmd=2">Friends</a></span>
						<ul class="inner-menu" style="display: none;">
							<li class="inner-menu-item"><a href="friendList.do?cmd=2">My Friends</a>
							<li class="inner-menu-item"><a href="friendList.do?cmd=1">Out FriendRequest</a>
							<li class="inner-menu-item"><a href="friendList.do?cmd=4">In FriendRequest</a>
							<li class="inner-menu-item"><a href="friendList.do?cmd=0">CutOff Friends</a>
						</ul>
					</li>
					<li class="outer-menu-item">
						<span class="menu-title"><a class="m_menu" href="viewPostList.do">Board</a></span>
						<ul class="inner-menu" style="display: none;">
							<li class="inner-menu-item"><a href="viewPostList.do">Penpal Board</a>
							<li class="inner-menu-item"><a href="viewPostList.do">Free Board</a>
						</ul>
					</li>
					<li class="outer-menu-item">
						<span class="menu-title">Language</span>
						<ul class="inner-menu" style="display: none;">
							<li class="inner-menu-item"><a href="#">Korean</a>
							<li class="inner-menu-item"><a href="#">English</a>
							<li class="inner-menu-item"><a href="#">Chinese</a>
							<li class="inner-menu-item"><a href="#">Japanese</a>
							<li class="inner-menu-item"><a href="#">Spanish</a>
							<li class="inner-menu-item"><a href="#">French</a>
						</ul>
					<li class="outer-menu-item">
						<span class="menu-title">Recommendation</span>
					</li>
				</ul>
			</div>
			<div class="pull-right" style="display: none;">
			</div>
		</div>
	</div>
</div>