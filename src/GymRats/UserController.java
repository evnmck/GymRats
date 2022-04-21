package GymRats;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class UserController {
	String connectionUrl;
	String dbUsername;
	String dbPassword;

	public UserController(String conn, String usrnm, String psswrd) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.connectionUrl = conn;
		this.dbUsername = usrnm;
		this.dbPassword = psswrd;

	}

	public ArrayList<Dictionary<String, String>> getUsers() throws ClassNotFoundException {
		String sqlSelectAllPersons = "SELECT * FROM user";
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			ArrayList<Dictionary<String, String>> ret = new ArrayList<Dictionary<String, String>>();
			while (rs.next()) {
				Dictionary<String, String> sub = new Hashtable<String, String>();
				sub.put("User_id", Integer.toString(rs.getInt("User_Id")));
				sub.put("FName", rs.getString("FName"));
				sub.put("LName", rs.getString("LName"));
				sub.put("Username", rs.getString("Username"));
				sub.put("Password", rs.getString("Password"));
				if (rs.getString("Bio") == null) {
					sub.put("Bio", "null");
				} else {
					sub.put("Bio", rs.getString("Bio"));
				}
				if (rs.getString("FK_Trainer_Id") == null) {
					sub.put("FK_Trainer_Id", "null");
				} else {
					sub.put("FK_Trainer_Id", rs.getString("FK_Trainer_Id"));
				}

				ret.add(sub);
			}
			return ret;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public void addUser(Dictionary<String, String> userInfo) throws ClassNotFoundException {
		String sqlSelectAllPersons = null;
		if (userInfo.get("Bio") != null && userInfo.get("FK_Trainer_Id") != null) {
			sqlSelectAllPersons = "INSERT INTO user (FName, LName, Username, Password, Bio, FK_Trainer_Id) VALUES ('"
					+ userInfo.get("FName") + "', '" + userInfo.get("LName") + "', '" + userInfo.get("Username")
					+ "', '" + userInfo.get("Password") + "', '" + userInfo.get("Bio") + "', '"
					+ userInfo.get("Fk_Trainer_Id") + "')";
		} else if (userInfo.get("Bio") != null) {
			sqlSelectAllPersons = "INSERT INTO user (FName, LName, Username, Password, Bio) VALUES ('"
					+ userInfo.get("FName") + "', '" + userInfo.get("LName") + "', '" + userInfo.get("Username")
					+ "', '" + userInfo.get("Password") + "', '" + userInfo.get("Bio") + "')";
		} else if (userInfo.get("FK_Trainer_Id") != null) {
			sqlSelectAllPersons = "INSERT INTO user (FName, LName, Username, Password,FK_Trainer_Id) VALUES ('"
					+ userInfo.get("FName") + "', '" + userInfo.get("LName") + "', '" + userInfo.get("Username")
					+ "', '" + userInfo.get("Password") + "', '" + userInfo.get("Fk_Trainer_Id") + "')";
		} else {
			sqlSelectAllPersons = "INSERT INTO user (FName, LName, Username, Password) VALUES ('"
					+ userInfo.get("FName") + "', '" + userInfo.get("LName") + "', '" + userInfo.get("Username")
					+ "', '" + userInfo.get("Password") + "')";
		}

		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);) {
			try {
				ps.execute();
			} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println("Error: Username already taken.");
				return;
			}
			System.out.println("Success!");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public Dictionary<String, String> getUser(int userId) throws ClassNotFoundException {
		String sqlSelectAllPersons = "SELECT * FROM user WHERE User_Id = " + userId;
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			if (rs.next()) {
				Dictionary<String, String> ret = new Hashtable<String, String>();
				ret.put("User_id", Integer.toString(rs.getInt("User_Id")));
				ret.put("FName", rs.getString("FName"));
				ret.put("LName", rs.getString("LName"));
				ret.put("Username", rs.getString("Username"));
				ret.put("Password", rs.getString("Password"));
				ret.put("Bio", rs.getString("Bio"));
				ret.put("FK_Trainer_Id", rs.getString("FK_Trainer_Id"));
				return ret;
			}
			return null;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	public void deleteUserByUserId(int userId) throws ClassNotFoundException {
		String sqlSelectAllPersons = "DELETE FROM user WHERE User_Id = " + userId;
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);) {
			ps.execute();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void deleteUserByUsername(String username) throws ClassNotFoundException {
		int userId = getUserByUsername(username);
		deleteUserByUserId(userId);
	}

	private int getUserByUsername(String username) throws ClassNotFoundException {
		String sqlSelectAllPersons = "SELECT * FROM user WHERE '" + username + "' IN (Username)";
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			if (rs.next()) {
				return rs.getInt("User_Id");
			}
			return -1;
		} catch (SQLException e) {
			System.out.println(e);
			return -1;
		}
	}
}
