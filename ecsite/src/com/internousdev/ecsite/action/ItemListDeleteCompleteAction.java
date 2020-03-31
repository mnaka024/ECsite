package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class ItemListDeleteCompleteAction extends ActionSupport {

	//itemListDeleteCompleteDAOインスタンス化
	private ItemListDeleteCompleteDAO itemListDeleteCompleteDAO = new ItemListDeleteCompleteDAO();
	//itemListインスタンス化
	private ArrayList<ItemInfoDTO> itemList =new ArrayList<ItemInfoDTO>();
	//message定義
	private String message;

//	public String execute() throws SQLException {
//		//containsKey　！否定だからfalseになるから戻り値がERRORになる
////		if(!session.containsKey("login_user_id")) {
////			return ERROR;
////		}
//		//履歴の削除がされてるかチェックする
//		//deleteFlg == null とは削除ボタンが押されていない場合処理のこと
//		//getMyPageUserInfoで記述した条件式がある場合は書く
//
//		return result;
//	}
	//履歴の削除を行うメソッド
	public String execute() throws SQLException{

		String result = SUCCESS;
		//DBから削除した履歴情報の件数を「res」に格納している
		//itemListDAOはItemListDAOクラスの中のitemListHistoryDeleteの中を実行している
		int res = itemListDeleteCompleteDAO.itemListHistoryDelete();

		//1件以上削除されたか否かを正常に削除処理がされたか判別する
		//deleteした件数が0より多いと成功
		if(res > 0) {
			itemList = null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res ==0) {
			//deleteした件数が0だと失敗
			setMessage("商品情報の削除に失敗しました。");
		}

		return result;
	}

	public ArrayList<ItemInfoDTO> getItemList(){
		return this.itemList;
	}

	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
