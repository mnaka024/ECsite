package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class SearchItemDAO {
	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	public List<ItemInfoDTO> getItemList () throws SQLException {
	List<ItemInfoDTO> itemInfoDTOList = new ArrayList<ItemInfoDTO>();
//		String sql=" select * from item_info_transaction where item_name = ?";
	//部分一致
	String sql="select * from item_info_transaction where item_name like '%ペン%'";
//複数検索ワード
//	String sql="select * from item_info_transaction where item_name like '%ゴム%'";
	try {
		PreparedStatement ps = con.prepareStatement(sql);
//		ps.setString(1, itemName);
//executeQuery()する前にSystem.out.println(ps);を書いて実行し、sqlを確認する
//		System.out.println(ps);
//
		ResultSet rs = ps.executeQuery();

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