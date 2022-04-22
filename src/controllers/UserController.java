package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import models.User;

public class UserController {
	String connectionUrl;
	String dbUsername;
	String dbPassword;

	public UserController(String conn, String usrnm, String psswrd) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		this.connectionUrl = conn;
		this.dbUsername = usrnm;
		this.dbPassword = psswrd;

	}

	public ArrayList<User> getUsers() throws ClassNotFoundException {
		String sqlSelectAllPersons = "SELECT * FROM user";
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			ArrayList<User> ret = new ArrayList<User>();
			while (rs.next()) {
				User sub = new User(rs.getString("FName"), rs.getString("LName"), rs.getString("Username"),
						rs.getString("Password"), rs.getString("Role"));
				sub.setUId(rs.getInt("User_Id"));
				if (rs.getString("Bio") != null) {
					sub.setBio(rs.getString("Bio"));
				}
				if (rs.getString("FK_Trainer_Id") != null) {
					sub.setTrainerId(rs.getInt("FK_Trainer_Id"));
				}

				ret.add(sub);
			}
			return ret;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public User addUser(User user) throws ClassNotFoundException {
		String sqlSelectAllPersons = null;
		if (user.getBio() != null && user.getTrainerId() > 0) {
			sqlSelectAllPersons = "INSERT INTO user (FName, LName, Username, Password, Bio, FK_Trainer_Id, Role) VALUES ('"
					+ user.getFName() + "', '" + user.getLName() + "', '" + user.getUName() + "', '" + user.getPWord()
					+ "', '" + user.getBio() + "', '" + user.getTrainerId() + "', " + user.getRole().toString() + "')";
		} else if (user.getBio() != null) {
			sqlSelectAllPersons = "INSERT INTO user (FName, LName, Username, Password, Bio, Role) VALUES ('"
					+ user.getFName() + "', '" + user.getLName() + "', '" + user.getUName() + "', '" + user.getPWord()
					+ "', '" + user.getBio() + "', '" + user.getRole().toString() + "')";
		} else if (user.getTrainerId() > 0) {
			sqlSelectAllPersons = "INSERT INTO user (FName, LName, Username, Password, FK_Trainer_Id, Role) VALUES ('"
					+ user.getFName() + "', '" + user.getLName() + "', '" + user.getUName() + "', '" + user.getPWord()
					+ "', '" + user.getTrainerId() + "', " + user.getRole().toString() + "')";
		} else {
			sqlSelectAllPersons = "INSERT INTO user (FName, LName, Username, Password, Role) VALUES ('"
					+ user.getFName() + "', '" + user.getLName() + "', '" + user.getUName() + "', '" + user.getPWord()
					+ "', '" + user.getRole().toString() + "')";
		}

		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);) {
			try {
				ps.execute();
			} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println("Error: Username already taken.");
				return getUserByUsername(user.getUName());
			}
			System.out.println("Success!");
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public User getUser(int userId) throws ClassNotFoundException {
		String sqlSelectAllPersons = "SELECT * FROM user WHERE User_Id = " + userId;
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			if (rs.next()) {
				User ret = new User(rs.getString("FName"), rs.getString("LName"), rs.getString("Username"),
						rs.getString("Password"), rs.getString("Role"));
				ret.setUId(rs.getInt("User_Id"));
				if (rs.getString("Bio") != null) {
					ret.setBio(rs.getString("Bio"));
				}
				if (rs.getString("FK_Trainer_Id") != null) {
					ret.setTrainerId(rs.getInt("FK_Trainer_Id"));
				}

				return ret;
			}
			return null;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	public User changeRole(int id, String role) throws ClassNotFoundException {
		String sqlSelectAllPersons = "UPDATE user SET Role = '" + role + "' WHERE User_Id = " + id;
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);) {
			ps.execute();
			return getUser(id);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public User changeBio(int id, String bio) throws ClassNotFoundException {
		String sqlSelectAllPersons = "UPDATE user SET Bio = '" + bio + "' WHERE User_Id = " + id;
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);) {
			ps.execute();
			return getUser(id);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public User changeTrainer(int id, int tId) throws ClassNotFoundException {
		String sqlSelectAllPersons = "UPDATE user SET FK_Trainer_Id = '" + tId + "' WHERE User_Id = " + id;
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);) {
			ps.execute();
			return getUser(id);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public User deleteUserByUserId(int userId) throws ClassNotFoundException {
		User deleted = getUser(userId);
		String sqlSelectAllPersons = "DELETE FROM user WHERE User_Id = " + userId;
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);) {
			ps.execute();
			return deleted;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	private User getUserByUsername(String username) throws ClassNotFoundException {
		String sqlSelectAllPersons = "SELECT * FROM user WHERE '" + username + "' IN (Username)";
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			if (rs.next()) {
				User sub = new User(rs.getString("FName"), rs.getString("LName"), rs.getString("Username"),
						rs.getString("Password"), rs.getString("Role"));
				sub.setUId(rs.getInt("User_Id"));
				if (rs.getString("Bio") != null) {
					sub.setBio(rs.getString("Bio"));
				}
				if (rs.getString("FK_Trainer_Id") != null) {
					sub.setTrainerId(rs.getInt("FK_Trainer_Id"));
				}
				return sub;
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
}
