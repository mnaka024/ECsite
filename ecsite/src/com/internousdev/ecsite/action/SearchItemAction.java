package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dao.SearchItemDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SearchItemAction extends ActionSupport{

//1.setterを定義する（JSPでユーザーが入力した値がフィールドに格納される）
//2.execute()メソッドを定義
//3.条件分岐でSUCCESSかERRORかを決める
//（ここではユーザーがJSPで入力した値とDTOに格納してある値を比較する）
//4.execute()メソッドの結果をSUCCESSかERRORを返す
//（それにより、あらかじめstruts.xmlに遷移先として定義したそれぞれのJSPに振り分けられる）


	//searchItemDTOListインスタンス化
	private List<ItemInfoDTO> itemInfoDTOList = new ArrayList<ItemInfoDTO>();
	//フィールド変数JSPから受け取る値を定義する
	private String itemName;

	//SQLの例外処理を実行する
	public String execute() throws SQLException{


		//ItemInfoDTOのデータをsearchItemDAOに渡す
		SearchItemDAO searchItemDAO = new SearchItemDAO();
		itemInfoDTOList = searchItemDAO.getItemList();

		if(!(itemInfoDTOList.size() > 0)) {
			itemInfoDTOList = null;
		}
		String result = SUCCESS;
		return result;
	}

	//Listのgetter.setter
	public List<ItemInfoDTO> getItemInfoDTOList() {
		return itemInfoDTOList;
	}
	public void setItemInfoDTOList(List<ItemInfoDTO> itemInfoDTOList) {
		this.itemInfoDTOList = itemInfoDTOList;
	}
	//
	public String getItemName() {
		return itemName;
	}
	//Setterを定義することでJSPで入力した値をフィールド変数に格納できる
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
//すでにある一覧を使い表示する
//	itemInfoDTOListをインスタンス化してしまっているのでnullにはなりえないんです

}
