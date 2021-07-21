package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Todo;

public class TodoDAO {
	// データベース接続に使用する情報
	private static final String URL = "jdbc:postgresql://ec2-35-174-122-153.compute-1.amazonaws.com:5432/d2fmds2e6idp3v";
	private static final String USER = "tvfdixvlkwscpg";
	private static final String PASS = "1605e6e5123953d83d9e5c5433fdd3431d807c1a033cfb3c933bc6f46e70019a";//各自のパスワードに変更

	public List<Todo> find(String userName) {
		List<Todo> todoList = new ArrayList<Todo>();
		//SELECT文の準備
		String sql = "SELECT id,importance,content, deadline,userName FROM todo WHERE userName = ? ORDER BY importance DESC,id ASC";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pStmt = conn.prepareStatement(sql);) {
			pStmt.setString(1, userName);
			try (ResultSet rs = pStmt.executeQuery()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String importance = rs.getString("importance");
					String content = rs.getString("content");
					String deadline = rs.getString("deadline");
					Todo todo = new Todo(id, importance, content, deadline, userName);
					todoList.add(todo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return todoList;
	}

	public boolean create(Todo todo) {
		//INSERT文の準備
		String sql = "INSERT INTO todo(id, importance, content, deadline, userName) VALUES(NEXTVAL('TODO_ID_SEQ'), ?, ?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pStmt = conn.prepareStatement(sql);) {
			//INSERT文中の？に使用する値を設定しSQLを完成
			pStmt.setInt(1, Integer.parseInt(todo.getImportance()));
			pStmt.setString(2, todo.getContent());
			pStmt.setDate(3, Date.valueOf(todo.getDeadline()));
			pStmt.setString(4, todo.getUserName());
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

	public boolean update(Todo todo) {
		//UPDATE文の準備
		String sql = "UPDATE todo SET importance = ?, content = ?, deadline = ? WHERE id = ?";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pStmt = conn.prepareStatement(sql);) {
			//UPDATE文中の？に使用する値を設定しSQLを完成
			pStmt.setInt(1, Integer.parseInt(todo.getImportance()));
			pStmt.setString(2, todo.getContent());
			pStmt.setDate(3, Date.valueOf(todo.getDeadline()));
			pStmt.setInt(4, todo.getId());
			//UPDATE文を実行
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

	public boolean delete(int id) {
		//DELETE文の準備
		String sql = "DELETE FROM todo WHERE id = ?";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pStmt = conn.prepareStatement(sql);) {
			//UPDATE文中の？に使用する値を設定しSQLを完成
			pStmt.setInt(1, id);
			//UPDATE文を実行
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