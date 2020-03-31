package com.internousdev.ecsite.dto;

public class UserInfoDTO {
	//テーブルカラムに対応したフィールド変数を宣言する
	private String id;
	private String login_id;
	private String login_pass;
	private String user_name;
	private String insert_date;
	//STEP6 追記
	private String update_date;


	//フィールド変数に対応したGetter、Setterを定義する
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getLogin_pass() {
		return login_pass;
	}
	public void setLogin_pass(String login_pass) {
		this.login_pass = login_pass;
	}

	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name= user_name;
	}

//	public String getAdmin_flag() {
//		return admin_flag;
//	}
//	public void setAdmin_flag(String admin_flag) {
//		this.admin_flag= admin_flag;
//	}

	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
}
