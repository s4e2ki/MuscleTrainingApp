package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UsersDAO {
	//データベース接続に使用する情報
	private static final String URL = "jdbc:postgresql://ec2-35-174-122-153.compute-1.amazonaws.com:5432/d2fmds2e6idp3v";
	private static final String USER = "tvfdixvlkwscpg";
	private static final String PASS = "1605e6e5123953d83d9e5c5433fdd3431d807c1a033cfb3c933bc6f46e70019a";//各自のパスワードに変更

	public boolean findByUser(User user) {
		//SELECT文の準備
		String sql = "SELECT name, pass FROM users WHERE name = ? AND pass = ?";
		//データベース接続
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pStmt = conn.prepareStatement(sql);) {
			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getPass());
			try (ResultSet rs = pStmt.executeQuery()) {
				if (!rs.next()) {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
