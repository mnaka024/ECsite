package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO {
//DBから購入履歴を取得するためのメソッド
	public ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id,String user_master_id) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();

		String sql="select ubit.id, iit.item_name, ubit.total_price, ubit.total_count,ubit.pay, ubit.insert_date "
				+ "from user_buy_item_transaction ubit "
				+ "left join item_info_transaction iit "
				+ "on ubit.item_transaction_id = iit.id "
				+ "where ubit.item_transaction_id =? "
				+ "and ubit.user_master_id=? "
				+ "order by insert_date desc";


		//①ユーザー購入履歴テーブルの商品IDと商品情報テーブルの商品IDが一致するもののみを表示する
		//②where ubit.item_transaction_id =? ubit.user_master_id=?には
		//tryの中に指定する1,2に入っている2のが1を買った表だけを抽出し
		//1行目で指定しているテーブルのカラムをselectする
		//購入日時を降順に並び替える
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);

			ResultSet rs = ps.executeQuery();

			//取得した結果を1件ずつDTOに格納し、更にDTOをArrayListに格納している
			while(rs.next()) {
				MyPageDTO dto = new MyPageDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setPayment(rs.getString("pay"));
				dto.setInsert_date(rs.getString("insert_date"));
				myPageDTO.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return myPageDTO;
	}

	//削除するためのメソッド
	public int buyItemHistoryDelete
	(String item_transaction_id,String user_master_id)throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql="delete from user_buy_item_transaction where item_transaction_id=? and user_master_id=?";
		PreparedStatement ps;
		int result =0;
		try {
			ps= con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);
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
