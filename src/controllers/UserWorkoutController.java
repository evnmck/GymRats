package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.UserWorkout;

public class UserWorkoutController {
	String connectionUrl;
	String dbUsername;
	String dbPassword;

	public UserWorkoutController(String conn, String usrnm, String psswrd) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.connectionUrl = conn;
		this.dbUsername = usrnm;
		this.dbPassword = psswrd;
	}

	public ArrayList<UserWorkout> getUserWorkoutForUser(int id) throws ClassNotFoundException {
		String sqlSelectAllPersons = "SELECT * FROM user_workout WHERE User_Id = " + id;
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			ArrayList<UserWorkout> ret = new ArrayList<UserWorkout>();
			if (rs.next()) {
				UserWorkout sub = new UserWorkout(rs.getInt("User_Id"));
				if (rs.getString("Exercise_Name") != null) {
					sub.seteName(rs.getString("Exercise_Name"));
				}
				if (rs.getString("Username") != null) {
					sub.setuName(rs.getString("Username"));
				}
				if (rs.getInt("Start_Weight") > 0) {
					sub.setStartWeight(rs.getInt("Start_Weight"));
				}
				if (rs.getInt("End_Weight") > 0) {
					sub.setEndWeight(rs.getInt("End_Weight"));
				}
				if (rs.getInt("Sets") > 0) {
					sub.setSets(rs.getInt("Sets"));
				}
				if (rs.getInt("Time_in_Minutes") > 0) {
					sub.setTime(rs.getInt("Time_in_Minutes"));
				}
				ret.add(sub);
			}
			return ret;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;

	}

	public UserWorkout getMax(int id, String name) {
		String sqlSelectAllPersons = "SELECT * FROM user_workout WHERE User_Id = " + id + " && Exercise_Name = '" + name
				+ "'";
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			ArrayList<UserWorkout> ret = new ArrayList<UserWorkout>();
			while (rs.next()) {
				UserWorkout sub = new UserWorkout(rs.getInt("User_Id"));
				if (rs.getString("Exercise_Name") != null) {
					sub.seteName(rs.getString("Exercise_Name"));
				}
				if (rs.getString("Username") != null) {
					sub.setuName(rs.getString("Username"));
				}
				if (rs.getInt("Start_Weight") > 0) {
					sub.setStartWeight(rs.getInt("Start_Weight"));
				}
				if (rs.getInt("End_Weight") > 0) {
					sub.setEndWeight(rs.getInt("End_Weight"));
				}
				if (rs.getInt("Repetitions") > 0) {
					sub.setReps(rs.getInt("Repetitions"));
				}
				if (rs.getInt("Sets") > 0) {
					sub.setSets(rs.getInt("Sets"));
				}
				if (rs.getInt("Time_in_Minutes") > 0) {
					sub.setTime(rs.getInt("Time_in_Minutes"));
				}
				ret.add(sub);
			}
			return getMaxWeight(ret);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	private UserWorkout getMaxWeight(ArrayList<UserWorkout> ret) {
		if (ret == null) {
			return null;
		}
		UserWorkout max = ret.get(0);
		if (ret.size() == 1) {
			return max;
		} else {
			for (int i = 0; i < ret.size(); i++) {
				if (max.getMaxWeight() <= ret.get(i).getMaxWeight()) {
					max = ret.get(i);
					System.out.println(max);
				}
			}
		}

		return max;

	}

	public ArrayList<UserWorkout> getUserWorkouts() throws ClassNotFoundException {
		String sqlSelectAllPersons = "SELECT * FROM user_workout";
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			ArrayList<UserWorkout> ret = new ArrayList<UserWorkout>();
			while (rs.next()) {
				UserWorkout sub = new UserWorkout(rs.getInt("User_Id"));
				if (rs.getString("Exercise_Name") != null) {
					sub.seteName(rs.getString("Exercise_Name"));
				}
				if (rs.getString("Username") != null) {
					sub.setuName(rs.getString("Username"));
				}
				if (rs.getInt("Start_Weight") > 0) {
					sub.setStartWeight(rs.getInt("Start_Weight"));
				}
				if (rs.getInt("End_Weight") > 0) {
					sub.setEndWeight(rs.getInt("End_Weight"));
				}
				if (rs.getInt("Repetitions") > 0) {
					sub.setReps(rs.getInt("Repetitions"));
				}
				if (rs.getInt("Sets") > 0) {
					sub.setSets(rs.getInt("Sets"));
				}
				if (rs.getInt("Time_in_Minutes") > 0) {
					sub.setTime(rs.getInt("Time_in_Minutes"));
				}
				ret.add(sub);
			}
			return ret;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;

	}

}
