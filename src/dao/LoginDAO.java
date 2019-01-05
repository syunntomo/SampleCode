package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBConnector;

public class LoginDAO {

	public String username;
	public String password;

	public boolean select(String username, String password) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		boolean ret = false;

		String sql = "select * from users where USER_NAME = ? and PASSWORD = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				this.username = rs.getString("user_name");
				this.password = rs.getString("password");
				ret = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
}