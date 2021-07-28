package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Login;

public class MustleDAO {
	private static final String URL = "jdbc:postgresql://ec2-35-174-122-153.compute-1.amazonaws.com:5432/d2fmds2e6idp3v";
	private static final String USER = "tvfdixvlkwscpg";
	private static final String PASS = "1605e6e5123953d83d9e5c5433fdd3431d807c1a033cfb3c933bc6f46e70019a";//各自のパスワードに変更

	public Login find(String userName) {
		//SELECT文の準備
		Login login = new Login();
		String sql = "SELECT userName, con, days FROM login WHERE userName = ? ";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pStmt = conn.prepareStatement(sql);) {
			pStmt.setString(1, userName);
			try (ResultSet rs = pStmt.executeQuery()) {
				int id = rs.getInt("id");
				Date days = rs.getDate("days");
				int con = rs.getInt("con");
				login = new Login(userName, con, days);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return login;
	}

	public boolean create(Login login) {
		//INSERT文の準備
		String sql = "INSERT INTO Login(username, con, days) VALUES(?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pStmt = conn.prepareStatement(sql);) {
			//INSERT文中の？に使用する値を設定しSQLを完成
			pStmt.setString(1, login.getUserName());
			pStmt.setInt(2, login.getCon());
			pStmt.setDate(3, Date.valueOf(login.getDays()));
			//INSERT文を実行
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}