package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String userName;
	private Map<String,Object> session;
	private String errorMessage;

	public String execute() {

		String result = SUCCESS;
//解説:理論演算子！否定を表している反対になる　空出ないとき
		if(!(loginUserId.equals(""))
				&& !(loginPassword.equals(""))
				&& !(userName.equals(""))) {
			//STEP7 ユーザー登録する際にログインID存在チェックを追加
			//isExistUserという変数を作る
			UserCreateConfirmDAO userCreateConfirmDAO = new UserCreateConfirmDAO();
			if(!userCreateConfirmDAO.isExistUser(loginUserId)){
				session.put("loginUserId", loginUserId);
				session.put("loginPassword", loginPassword);
				session.put("userName", userName);

			}else {
				setErrorMessage("すでに登録されているログインIDです。");
				result = ERROR;
			}
		}else {
			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}
		return result;

	}
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

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName =userName;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage =errorMessage;
	}

	public Map<String,Object> getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
