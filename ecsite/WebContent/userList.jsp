<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserList</title>
</head>
<body>
	<div id="header">
	</div>
		<div id="main">
			<div id="top">
				<p>UserList画面</p>
			</div>

			<div>
			<s:if test="userInfoDTOList == null">
				<h3>ユーザー一覧情報はありません。</h3>
			</s:if>
			<s:elseif test="message == null">
				<h3>ユーザー一覧情報は以下になります。</h3>
				<table border="1">
					<tr>
						<th>id</th>
						<th>ログインID</th>
						<th>パスワード</th>
						<th>ユーザー名</th>
						<th>登録日</th>
						<th>更新日</th>
						<th>詳細</th>
					</tr>
					<s:iterator value="userInfoDTOList">
						<tr>
							<td><s:property value="id" /></td>
							<td><s:property value="login_id"/></td>
							<td><s:property value="login_pass"/></td>
							<td><s:property value="user_name"/></td>
							<td><s:property value="insert_date"/></td>
							<td><s:property value="update_date" /></td>
							<td>
							<a href='<s:url action="UserDetailsAction">
								<s:param name="login_id" value="%{login_id}"/>
								</s:url>'>詳細</a>
							</td>
						</tr>
					</s:iterator>
				</table>

				<s:form action="UserListDeleteConfirmAction">
					<s:submit value="削除"/>
				</s:form>
			</s:elseif>
					<!-- 削除実行結果のメッセージを表示する  -->
				<s:if test="message != null">
					<h3><s:property value="message"/></h3>
				</s:if>
				<div id="text-right">
					<p>管理者画面へ戻る場合は<a href='admin.jsp'>こちら</a></p>
				</div>
			</div>

		</div>
	<div id="footer">
	</div>
</body>
</html>