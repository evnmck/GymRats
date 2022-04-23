package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import models.Workout;

public class WorkoutController {
	String connectionUrl;
	String dbUsername;
	String dbPassword;

	public WorkoutController(String conn, String usrnm, String psswrd) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.connectionUrl = conn;
		this.dbUsername = usrnm;
		this.dbPassword = psswrd;
	}

	public boolean addWorkout(Workout workout) throws ClassNotFoundException {
		String sqlSelectAllPersons = null;
		if (workout.getDate() != null) {
			sqlSelectAllPersons = "INSERT INTO comment (FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, Repetitions, Sets, Time_in_Minutes, Date) VALUES ("
					+ workout.getEId() + ", " + workout.getUid() + ", " + workout.getSWeight() + ", "
					+ workout.getEWeight() + ", " + workout.getReps() + ", " + workout.getSets() + ", "
					+ workout.getTime() + ", " + workout.getDate() + ")";
		} else {
			sqlSelectAllPersons = "INSERT INTO comment (FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, Repetitions, Sets, Time_in_Minutes) VALUES ("
					+ workout.getEId() + ", " + workout.getUid() + ", " + workout.getSWeight() + ", "
					+ workout.getEWeight() + ", " + workout.getReps() + ", " + workout.getSets() + ", "
					+ workout.getTime() + ")";
		}
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);) {
			try {
				ps.execute();
			} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println("Error: Username already taken.");
				return false;
			}
			return true;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}

	/* TODO */
	public Workout deleteWorkout(int wId, int eId, int uId) throws ClassNotFoundException {
		return null;
	}

	/* TODO */
	public Workout getWorkout(int wId, int eId, int uId) throws ClassNotFoundException {
		return null;
	}

	public ArrayList<Workout> getWorkouts() throws ClassNotFoundException {
		String sqlSelectAllPersons = "SELECT * FROM workout";
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			ArrayList<Workout> ret = new ArrayList<Workout>();
			while (rs.next()) {
				Workout sub = new Workout(rs.getInt("FK_Exercise_Id"), rs.getInt("FK_User_Id"));
				sub.setWId(rs.getInt("Workout_Id"));
				if (rs.getInt("Start_Weight") >= 0) {
					sub.setSWeight(rs.getInt("Start_Weight"));
				}
				if (rs.getInt("End_Weight") >= 0) {
					sub.setEWeight(rs.getInt("End_Weight"));
				}
				if (rs.getInt("Repetitions") >= 0) {
					sub.setReps(rs.getInt("Repetitions"));
				}
				if (rs.getInt("Sets") >= 0) {
					sub.setSets(rs.getInt("Sets"));
				}
				if (rs.getInt("Time_in_Minutes") >= 0) {
					sub.setTime(rs.getInt("Time_in_Minutes"));
				}
				if (rs.getDate("Date") != null) {
					sub.setDate(rs.getDate("Date"));
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
