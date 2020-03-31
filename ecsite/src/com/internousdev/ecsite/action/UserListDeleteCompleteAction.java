package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport{

	//userListDeleteCompleteDAOインスタンス化
//	private UserListDeleteCompleteDAO userListDeleteCompleteDAO = new UserListDeleteCompleteDAO();
	//itemListインスタンス化
//	private ArrayList<UserInfoDTO> userList =new ArrayList<UserInfoDTO>();
	//message定義
	private String message;

	//履歴の削除を行うメソッド
	public String execute() throws SQLException{

		String result = SUCCESS;

		//STEP4
		//DBから削除した履歴情報の件数を「res」に格納している
		//userListDAOはUserListDAOクラスの中のuserListHistoryDeleteの中を実行している
//		int res = userListDeleteCompleteDAO.userListHistoryDelete();
		UserListDeleteCompleteDAO userListDeleteCompleteDAO = new UserListDeleteCompleteDAO();
		int res = userListDeleteCompleteDAO.deleteUserList();

		//STEP4
		//1件以上削除されたか否かを正常に削除処理がされたか判別する
		//deleteした件数が0より多いと成功
//		if(res > 0) {
//			userList = null;
//			setMessage("ユーザー情報を正しく削除しました。");
//		}else if(res ==0) {
//			//deleteした件数が0だと失敗
//			setMessage("ユーザー情報の削除に失敗しました。");
//		}

		//STEP6

		if(res > 0) {
			setMessage("ユーザー情報を正しく削除しました。");
		} else {
			setMessage("ユーザー情報の削除に失敗しました。");
		}
		result = SUCCESS;
		return result;
	}
//STEP4
//	public ArrayList<UserInfoDTO> getUserList(){
//		return this.userList;
//	}

	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
