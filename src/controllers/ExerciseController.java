package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class ExerciseController {
	String connectionUrl;
	String dbUsername;
	String dbPassword;

	public ExerciseController(String conn, String usrnm, String psswrd) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.connectionUrl = conn;
		this.dbUsername = usrnm;
		this.dbPassword = psswrd;

	}
	
	public void addExercise() {
		
	}

	public Dictionary<String, String> getExercise() {
		String sqlSelectAllPersons = "SELECT * FROM exercise";
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
				Dictionary<String, String> sub = new Hashtable<String, String>();
				sub.put("Exercise_Id", Integer.toString(rs.getInt("Exercise_Id")));
				sub.put("Exercise_Name", rs.getString("Exercise_Name"));
			return sub;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	public ArrayList<Dictionary<String, String>> getExercises() {
		String sqlSelectAllPersons = "SELECT * FROM exercise";
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			ArrayList<Dictionary<String, String>> ret = new ArrayList<Dictionary<String, String>>();
			while (rs.next()) {
				Dictionary<String, String> sub = new Hashtable<String, String>();
				sub.put("Exercise_Id", Integer.toString(rs.getInt("Exercise_Id")));
				sub.put("Exercise_Name", rs.getString("Exercise_Name"));
				ret.add(sub);
			}
			return ret;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	public void DeleteExercise() {
		
	}
}
