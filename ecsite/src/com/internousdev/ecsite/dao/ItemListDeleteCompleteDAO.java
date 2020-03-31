package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ItemListDeleteCompleteDAO {

	//
	//削除するためのメソッド
	public int itemListHistoryDelete()throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		//DELETE FROM [テーブル名];
		//DELETE FROM [テーブル名]　WHERE [条件];
		String sql="delete from item_info_transaction";
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
