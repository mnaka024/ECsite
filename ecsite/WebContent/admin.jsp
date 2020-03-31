<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>管理者用TOP画面</title>
</head>
<body>


	<div id="header">
	</div>
		<div id="main">
			<div id="top">
				<h1>管理者画面</h1>
			</div>

			<div id="text-center">
				<div id="left">
					<h3>商品</h3>
					<s:form action="ItemCreateAction"><s:submit value="新規登録"/></s:form>
					<s:form action="ItemListAction"><s:submit value="一覧表示"/></s:form>
				</div>
				<div id="right">
					<h3>ユーザー</h3>
					<s:form action="UserCreateAction"><s:submit value="新規登録"/></s:form>
					<s:form action="UserListAction"><s:submit value="一覧表示"/></s:form>
				</div>
			</div>
		</div>
	<div id="footer">
	</div>
</body>
</html>