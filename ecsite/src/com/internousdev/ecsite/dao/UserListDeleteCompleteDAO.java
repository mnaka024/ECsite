package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserListDeleteCompleteDAO {

//Other STEP4 削除するためのメソッド
//	public int userListHistoryDelete()throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		//DELETE FROM [テーブル名]; 全件削除
		//DELETE FROM [テーブル名]　WHERE [条件];

		//STEP4
//		public int userListHistoryDelete() throws SQLException{
		//other STEP6　管理者以外のユーザーを削除に変更する条件を追加
		public int deleteUserList() throws SQLException {
			//SQL文の意味：is nullは空の時　<>='1'(sql) = !="1"(java)同じ意味　1でないときを表している
		String sql="delete from login_user_transaction where admin_flag is null or admin_flag <> '1'";
		PreparedStatement ps;
		int result =0;
		try {
			ps= con.prepareStatement(sql);

			//更新し、delete件数を返してる
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
		}

		//Actionクラスに削除した件数を返す
		return result;
	}
}
