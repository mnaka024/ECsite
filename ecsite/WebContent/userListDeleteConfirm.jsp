<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>UserListDeleteConfirm</title>
</head>
<body>
	<script type="text/javascript">
		function submitAction(url){
			$('form').attr('action',url);
			$('form').submit();
		}
	</script>
	<div id="header">
	</div>
		<div id="main">
			<div id="top">
				<p>UserListDeleteConfirm</p>
			</div>

			<div>
<!-- 			other STEP6　管理者以外のユーザーを削除に変更したのでメッセージも変更 -->
				<h3>管理者以外のユーザーを削除します。よろしいですか？</h3>
<!-- 			<h3>すべてのユーザーを削除します。よろしいですか？</h3> -->
			<table>
				<s:form action="UserListDeleteCompleteAction">
					<tr>
						<td><input type="button" value="ＯＫ" onclick="submitAction('UserListDeleteCompleteAction')"/></td>
						<td><input type="button" value="キャンセル" onclick="submitAction('UserListAction')"/></td>
					</tr>
				</s:form>
			</table>
			</div>

		</div>
	<div id="footer">
	</div>
</body>
</html>