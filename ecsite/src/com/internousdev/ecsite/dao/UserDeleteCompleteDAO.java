package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
//SREP11
public class UserDeleteCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public int deleteUserInfo(String login_id) throws SQLException {
		String sql = "DELETE FROM login_user_transaction WHERE login_id = ?";
		PreparedStatement preparedStatement;
		int result =0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, login_id);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return result;
	}
}