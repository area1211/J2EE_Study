<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자설정메뉴</title>
<link rel="stylesheet" href="./css/admin_menu.css"/>
<style>
	
</style>
<script src="./js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<form>
		<div class="admin_menu">
			<div class="admin_title">
				<h2>관리자설정</h2>
				<h4>페이지를 관리하세요</h4>
				<hr>
			</div>
			<div class="admin_section">
			<table>
				<tr>
					<td class="admin_td_size"><input type="button" class="admin_btn" id="admin_member" value="회원관리"/></td>
					<td class="admin_td_size"><input type="button" class="admin_btn" id="admin_board"  value="게시판관리"/></td>
					<td class="admin_td_size"><input type="button" class="admin_btn" id="admin_report"  value="신고관리"/></td>
					<td class="admin_td_size"><input type="button" class="admin_btn" id="admin_banword"  value="금칙어관리"/></td>
					<td class="admin_td_size"><input type="button" class="admin_btn" id="admin_delete"  value="삭제내역관리"/></td>
					<td class="admin_td_size"><input type="button" class="admin_btn" id="admin_stats"  value="통계관리"/></td>
				</tr>
			</table>
			</div>
		</div>
	</form>
</body>
</html>