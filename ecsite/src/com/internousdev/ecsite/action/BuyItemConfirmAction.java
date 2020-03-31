package com.internousdev.ecsite.action;


import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;



public class BuyItemConfirmAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

	public String execute() throws SQLException{
		int count = buyItemCompleteDAO.buyItemInfo(
				session.get("id").toString(),
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("login_user_id").toString(),
				session.get("pay").toString());
		//STEP8 購入処理(user_buy_item_transactionテーブルにinsert)後に在庫を減らす処理を追記
		if (count > 0) {
			buyItemCompleteDAO.updateItemStock(Integer.parseInt(session.get("count").toString()), session.get("id").toString());
		}

		String result = SUCCESS;
		return result;
	}
	public Map<String,Object> getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
