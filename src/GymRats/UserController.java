package GymRats;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class UserController {
	String connectionUrl;
	String dbUsername;
	String dbPassword;

	public UserController(String conn, String usrnm, String psswrd) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.connectionUrl = conn; // could be different
		this.dbUsername = usrnm; // replace with your username (most likely "root")
		this.dbPassword = psswrd; // replace with your password

	}

	public void getUsers() throws ClassNotFoundException {
		String sqlSelectAllPersons = "SELECT * FROM user";
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt("User_Id");
				String name = rs.getString("FName");
				String lastName = rs.getString("LName");
				System.out.println("User #" + id + ": " + name + " " + lastName);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void addUser(String Fname, String Lname, String username, String password, String Bio, String trainer)
			throws ClassNotFoundException {
		String sqlSelectAllPersons = "INSERT INTO user (FName, LName, Username, Password, Bio, FK_Trainer_Id) VALUES ('"
				+ Fname + "', '" + Lname + "', '" + username + "', '" + password + "', '" + Bio + "', '" + trainer
				+ "')";
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

	public boolean getUserByUsername(String username) throws ClassNotFoundException {
		String sqlSelectAllPersons = "SELECT User_Id FROM user WHERE '" + username + "' IN (Username)";
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			if (rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	public void deleteUser() throws ClassNotFoundException {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter User Id to remove: ");
		int deleted = scan.nextInt();
		scan.close();
		String sqlSelectAllPersons = "DELETE FROM user WHERE User_Id = " + deleted;
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);) {
			ps.execute();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
