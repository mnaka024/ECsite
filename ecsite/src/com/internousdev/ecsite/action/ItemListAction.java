package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware{
	//Map型の宣言
	private Map<String,Object> session;
	//itemListDAO化インスタンス
//	private ItemListDAO itemListDAO = new ItemListDAO();
	//itemInfoDTOListインスタンス化
	private List<ItemInfoDTO> itemInfoDTOList = new ArrayList<ItemInfoDTO>();
	//message定義
//	private String message;

	public String execute() throws SQLException {

		//itemInfoDTOListは空の状態で下記のイコールから後の内容が入る
		//getItemListには取り出したすべての情報が入る
//STEP		itemList = itemListDAO.getItemListInfo();
		ItemListDAO itemListDAO = new ItemListDAO();
		itemInfoDTOList = itemListDAO.getItemList();
		if(!(itemInfoDTOList.size() > 0)) {
			itemInfoDTOList = null;
		}
		String result = SUCCESS;
	return result;
	}

	public List<ItemInfoDTO> getItemInfoDTOList() {
		return itemInfoDTOList;
	}
	public void setItemInfoDTOList(List<ItemInfoDTO> itemInfoDTOList) {
		this.itemInfoDTOList = itemInfoDTOList;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return session;
	}


}
