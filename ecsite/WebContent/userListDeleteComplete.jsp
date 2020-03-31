<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>UserListDeleteComplete</title>
</head>
<body>
	<div id="header">
	</div>
		<div id="main">
			<div id="top">
				<p>UserListDeleteComplete</p>
			</div>
			<div>
<!-- 			other STEP6　管理者以外のユーザーを削除に変更したのでメッセージも変更 -->
				<p>管理者以外のユーザーの削除が完了致しました。</p>
				<div id="text-right">
					<p>管理者画面へ戻る場合は<a href='<s:url action="AdminAction"/>'>こちら</a></p>
				</div>
			</div>
		</div>
	<div id="footer">
	</div>
</body>
</html>