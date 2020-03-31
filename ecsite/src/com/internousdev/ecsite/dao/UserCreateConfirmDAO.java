package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.util.DBConnector;

public class UserCreateConfirmDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	//isExistUserという変数を作る＝存在するユーザーという意味のメソッド
	public boolean isExistUser(String loginUserId) {
		//解説1： count(*)とは件数を出す関数　引数に * を指定すると NULL かどうかに関係なく行数を取得することができきる
		String sql ="select count(*) as count from login_user_transaction where login_id =?";
		boolean result = false;
		//解説2：
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ResultSet rs =ps.executeQuery();
			//解説3：countとはsql文で作った
			if(rs.next()) {
				if(rs.getInt("count") > 0) {
					result = true;
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
