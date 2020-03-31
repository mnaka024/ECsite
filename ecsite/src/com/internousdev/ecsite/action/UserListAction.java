package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport implements SessionAware{
	//userInfoDTOListインスタンス化
	private List<UserInfoDTO> userInfoDTOList =new ArrayList<UserInfoDTO>();
	//Other STEP6
	private Map<String, Object> session;

	public String execute() throws SQLException {
		UserListDAO userListDAO = new UserListDAO();
		//userInfoDTOListの中身が0でないときnullだといっている
		userInfoDTOList = userListDAO.getUserList();
		if(!(userInfoDTOList.size() > 0)) {
			userInfoDTOList = null;
		}

		String result = SUCCESS;
		return result;
//Other STEP4　回答を見ないで進めたから変数名が異なっている
		//userListは空の状態で下記のイコールから後の内容が入る
		//getUserListInfoには取り出したすべての情報
//		userList = userListDAO.getUserListInfo();
//
//		return SUCCESS;
	}

	public List<UserInfoDTO> getUserInfoDTOList() {
		return userInfoDTOList;
	}
	public void setUserInfoDTOList(List<UserInfoDTO> userInfoDTOList) {
		this.userInfoDTOList = userInfoDTOList;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	//Other STEP4
//	public ArrayList<UserInfoDTO> getUserList(){
//		return this.userList;
//	}
//	public String getMessage() {
//		return this.message;
//	}
//	public void setMessage(String message) {
//		this.message = message;
//	}

}
