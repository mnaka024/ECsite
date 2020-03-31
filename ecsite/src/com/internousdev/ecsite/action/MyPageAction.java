package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;


public class MyPageAction extends ActionSupport implements SessionAware{

	//Map型の宣言
	private Map<String,Object> session;
	//myPageDAOインスタンス化
	private MyPageDAO myPageDAO = new MyPageDAO();
	//myPageListインスタンス化
	private ArrayList<MyPageDTO> myPageList =new ArrayList<MyPageDTO>();
	//deleteFlg定義
	private String deleteFlg;
	//message定義
	private String message;

	public String execute() throws SQLException {
		//containsKey　！否定だからfalseになるから戻り値がERRORになる
		if(!session.containsKey("login_user_id")) {
			return ERROR;
		}
		//履歴の削除がされてるかチェックする
		//deleteFlg == null とは削除ボタンが押されていない場合処理のこと
		//getMyPageUserInfoで記述した条件式がある場合は書く
		if(deleteFlg == null) {
			String item_transaction_id = session.get("id").toString();
			String user_master_id =session.get("login_user_id").toString();
			//DBから取得した履歴情報を「myPageList」に格納している
			myPageList = myPageDAO.getMyPageUserInfo(item_transaction_id,user_master_id);
			//else ifではそれ以外の処理を行い、deleteFlg.equals("1")はmyPage.jspで削除ボタンに
			//記述した値のことつまり、削除ボタンを押した場合の処理を書いている
			//equals("1")とはname="deleteFlg"のvalue="1"を説明している
		}else if(deleteFlg.equals("1")) {

			//「delete」メソッドを呼び出して履歴の削除処理を行う
			//delete();は前に何も記述していないので同ページの下記delete()メソッドの中を
			//実行すると書いてある
			delete();
		}
		/*
		 * 上記のif文は、struts.xmlから呼び出された時点では、何も処理されない
		 * (そもそも、この時点では、String型変数のdeleteFlgには何も値が代入されていないから)
		 * そして、ちゃんと見るとこのexecuteメソッドが実行された時点で、resultがsuccessになっており、
		 * struts.xmlから呼び出された時点では、ただ単に、returnでsuccessを返すだけとなる
		 */
		String result = SUCCESS;
		return result;
	}

	//履歴の削除を行うメソッド
	public void delete() throws SQLException{

//削除するときに指定した条件を記述
		String item_transaction_id = session.get("id").toString();
		String user_master_id = session.get("login_user_id").toString();

		//DBから削除した履歴情報の件数を「res」に格納している
		//myPageDAOはMyPageDAOクラスの中のbuyItemHistoryDeleteの中を実行している
		int res = myPageDAO.buyItemHistoryDelete(item_transaction_id,user_master_id);

		//1件以上削除されたか否かを正常に削除処理がされたか判別する
		//deleteした件数が0より多いと成功
		if(res > 0) {
			myPageList = null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res ==0) {
			//deleteした件数が0だと失敗
			setMessage("商品情報の削除に失敗しました。");
		}
	}
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
	public ArrayList<MyPageDTO> getMyPageList(){
		return this.myPageList;
	}

	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String,Object> getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
}
