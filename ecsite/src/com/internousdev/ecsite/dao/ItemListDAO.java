package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {
 	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	//DBから商品履歴を取得するためのメソッド
//		public ArrayList<ItemInfoDTO> getItemListInfo() throws SQLException{

		//Listを使う
//		ArrayList<ItemInfoDTO> itemInfoDTO = new ArrayList<ItemInfoDTO>();
		public List<ItemInfoDTO> getItemList () throws SQLException {
				List<ItemInfoDTO> itemInfoDTOList = new ArrayList<ItemInfoDTO>();
			//全件のため条件式はいらない
			//STEP8:商品のIDを抽出する
			String sql="select * from item_info_transaction order by id";

			//
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				//取得した結果を1件ずつDTOに格納し、更にDTOをArrayListに格納している
				while(rs.next()) {
					ItemInfoDTO dto = new ItemInfoDTO();
					dto.setId(rs.getString("id"));
					dto.setItemName(rs.getString("item_name"));
					dto.setItemPrice(rs.getString("item_price"));
					dto.setItemStock(rs.getString("item_stock"));
					dto.setInsert_date(rs.getString("insert_date"));
					dto.setUpdate_date(rs.getString("update_date"));
					itemInfoDTOList.add(dto);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				con.close();
			}
			return itemInfoDTOList;
		}

}
