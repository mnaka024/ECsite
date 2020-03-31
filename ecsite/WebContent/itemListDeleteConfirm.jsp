<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ItemListDeleteConfirm画面</title>
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
				<p>ItemListDeleteConfirm</p>
			</div>

			<div>
			<h3>すべての商品を削除します。よろしいですか？</h3>
			<table>
				<s:form action="ItemListDeleteCompleteAction">
					<tr>
						<td><input type="button" value="ＯＫ" onclick="submitAction('ItemListDeleteCompleteAction')"/></td>
						<td><input type="button" value="キャンセル" onclick="submitAction('ItemListAction')"/></td>
					</tr>
				</s:form>
			</table>
			</div>

		</div>
	<div id="footer">
	</div>
</body>
</html>