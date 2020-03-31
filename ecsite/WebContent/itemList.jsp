<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ItemList画面</title>
</head>
<body>
	<div id="header">
	</div>
		<div id="main">
			<div id="top">
				<p>ItemList</p>
			</div>

			<div>
			<s:if test="itemInfoDTOList == null">
				<h3>商品情報はありません。</h3>
			</s:if>
			<s:elseif test="message == null">
				<h3>商品情報は以下になります。</h3>
				<table border="1">
					<tr>
						<th>id</th>
						<th>商品名</th>
						<th>値段</th>
						<th>在庫</th>
						<th>登録日</th>
						<th>更新日</th>
						<th>詳細</th>
					</tr>
					<!-- STEP10 詳細リンク追加 -->
					<s:iterator value="itemInfoDTOList">
						<tr>
							<td><s:property value="id" /></td>
							<td><s:property value="itemName"/></td>
							<td><s:property value="itemPrice"/><span>円</span></td>
							<td><s:property value="itemStock"/><span>個</span></td>
							<td><s:property value="insert_date"/></td>
							<td><s:property value="update_date" /></td>
							<td>
							<a href='<s:url action="ItemDetailsAction">
								<s:param name="id" value="%{id}"/>
								</s:url>'>詳細</a>
							</td>
						</tr>
					</s:iterator>
				</table>
				<!--  -->
				<s:form action="ItemListDeleteConfirmAction">
					<s:submit value="削除"/>
				</s:form>
			</s:elseif>

			<s:form action="SearchItemAction">
				<s:textfield name="itemName"/>
				<s:submit value="検索"/>
			</s:form>
					<!-- 削除実行結果のメッセージを表示する  -->
				<s:if test="message != null">
					<h3><s:property value="message"/></h3>
				</s:if>
				<div id="text-right">
					<p>管理者画面へ戻る場合は<a href='<s:url action="AdminAction"/>'>こちら</a></p>
				</div>
			</div>

		</div>
	<div id="footer">
	</div>
</body>
</html>