package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	//login.jspで入力したloginUserId,loginPasswordの値を定義
	private String loginUserId;
	private String loginPassword;
	//sessionを使うための宣言
	private Map<String,Object> session;
	//LoginDAOインスタンス化
	private LoginDAO loginDAO = new LoginDAO();
	//LoginDTOインスタンス化
	private LoginDTO loginDTO = new LoginDTO();
	//BuyItemDAOインスタンス化
	private BuyItemDAO buyItemDAO =new BuyItemDAO();

	public String execute() {
		String result = ERROR;

		//loginDTOは空の状態で下記のイコールから後の内容が入る
		//loginDAOはLoginDAO.javaで実行した内容をloginDTOとして戻り値になる
		//loginUserId,loginPasswordをloginDTOに代入
		loginDTO = loginDAO.getLoginUserInfo(loginUserId,loginPassword);

		//login.jspで入力したloginUserをキーの型、loginDTOを値の型としてputメソッド呼び出す
		//入力値から
		session.put("loginUser", loginDTO);

		//ユーザーの情報を検索しログイン認証が成功した場合
		//if文がtrueだとif文の中の内容が実行される
		//理解度テスト回答
		//getLoginFlg()メソッドを実行するためにはオブジェクト型では型が違うので実行できないため
		//LoginDTO型を使って使用できる状態にする
		if(((LoginDTO) session.get("loginUser")).getLoginFlg()) {
			//other ecsiteSTEP5
			//
			if((((LoginDTO) session.get("loginUser")).getAdminFlg() != null)
				&& (((LoginDTO) session.get("loginUser")).getAdminFlg().equals("1"))) {

			//回答以外の書き方はコメントアウトの部分　"1".equals()とは必ず""の中に値が入っていないといけない
			//それ以外だとnullの処理を書かないといけない
//			if(("1".equals(((LoginDTO) session.get("loginUser")).getAdminFlg()))) {
					result = "admin";
			}else {
				result = SUCCESS;
				//BuyItemDTOにはユーザーが購入した商品情報を格納したもの

				//getBuyItemInfoには取り出したすべての情報
				BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();

				//buyItem.jspで入力した情報
				//次の画面で下記の必要な「商品情報」を取得する
				//sessionには取得した内容が入る
				System.out.println(buyItemDTO.getItemName());
				session.put("login_user_id", loginDTO.getLoginId());

				session.put("id", buyItemDTO.getId());
				session.put("buyItem_name", buyItemDTO.getItemName());
				session.put("buyItem_price", buyItemDTO.getItemPrice());
				//STEP9
				session.put("item_stock", buyItemDTO.getItemStock());
			}
		}
		return result;

	}
	//loginUserId、loginPassword(setter)を定義することでlogin.jspでユーザーが入力した
	//loginUserIdとloginPasswordの値がそれぞれのフィールド変数に格納される
	public String getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId) {
		this.loginUserId =loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword =loginPassword;
	}
	public Map<String,Object> getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session =session;
	}

}
