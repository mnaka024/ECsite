package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//STEP6追記
import java.util.List;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {
	//DBから購入履歴を取得するためのメソッド
	DBConnector db = new DBConnector();
	Connection con = db.getConnection();
//STEP4
//	public ArrayList<UserInfoDTO> getUserListInfo() throws SQLException{
//
//		ArrayList<UserInfoDTO> userInfoDTO = new ArrayList<UserInfoDTO>();

	//STEP6
		public List<UserInfoDTO> getUserList() throws SQLException{

			List<UserInfoDTO> userInfoDTOList = new ArrayList<UserInfoDTO>();
//STEP6
			String sql="select * from login_user_transaction order by id";

			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				//取得した結果を1件ずつDTOに格納し、更にDTOをArrayListに格納している
				while(rs.next()) {
					UserInfoDTO dto = new UserInfoDTO();
					dto.setId(rs.getString("id"));
					dto.setLogin_id(rs.getString("login_id"));
					dto.setLogin_pass(rs.getString("login_pass"));
					dto.setUser_name(rs.getString("user_name"));
					dto.setInsert_date(rs.getString("insert_date"));
					dto.setUpdate_date(rs.getString("updated_date"));
					userInfoDTOList.add(dto);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				con.close();
			}
			return userInfoDTOList;
		}
}
