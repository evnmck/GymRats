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

	public Workout addWorkout(Workout workout) throws ClassNotFoundException {
		String sqlSelectAllPersons = null;
		if (workout.getDate() != null) {
			sqlSelectAllPersons = "INSERT INTO workout (Workout_Id, FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, Repetitions, Sets, Time_in_Minutes, Date) VALUES ("
					+ workout.getWId() + ", " + workout.getEId() + ", " + workout.getUid() + ", " + workout.getSWeight()
					+ ", " + workout.getEWeight() + ", " + workout.getReps() + ", " + workout.getSets() + ", "
					+ workout.getTime() + ", '" + workout.getDate() + "')";
		} else {
			sqlSelectAllPersons = "INSERT INTO workout (Workout_Id, FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, Repetitions, Sets, Time_in_Minutes) VALUES ("
					+ workout.getWId() + ", " + workout.getEId() + ", " + workout.getUid() + ", " + workout.getSWeight()
					+ ", " + workout.getEWeight() + ", " + workout.getReps() + ", " + workout.getSets() + ", "
					+ workout.getTime() + ")";
		}
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);) {
			try {
				ps.execute();
			} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println("Error: Username already taken.");
				return null;
			}
			System.out.println("Success");
			return getWorkout(workout.getWId(), workout.getEId(), workout.getUid());

		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public ArrayList<Workout> addAllWorkoutsforWID(ArrayList<Workout> add) throws ClassNotFoundException {
		ArrayList<Workout> ret = new ArrayList<Workout>();
		for (int i = 0; i < add.size(); i++) {
			ret.add(addWorkout(add.get(i)));
		}
		return ret;
	}

	public Workout deleteWorkout(int wId, int eId, int uId) throws ClassNotFoundException {
		Workout deleted = getWorkout(wId, eId, uId);
		String sqlSelectAllPersons = "DELETE FROM workout WHERE Workout_Id = " + wId + " && FK_Exercise_Id = " + eId
				+ " && FK_User_Id = " + uId;
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);) {
			ps.execute();
			return deleted;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public Workout getWorkout(int wId, int eId, int uId) throws ClassNotFoundException {
		String sqlSelectAllPersons = "SELECT * FROM workout WHERE Workout_Id = " + wId + " && FK_Exercise_Id = " + eId
				+ " && FK_User_Id = " + uId;
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Workout sub = new Workout(rs.getInt("Workout_Id"), rs.getInt("FK_Exercise_Id"),
						rs.getInt("FK_User_Id"));
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
				return sub;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public ArrayList<Workout> getWorkouts() throws ClassNotFoundException {
		String sqlSelectAllPersons = "SELECT * FROM workout";
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			ArrayList<Workout> ret = new ArrayList<Workout>();
			while (rs.next()) {
				Workout sub = new Workout(rs.getInt("Workout_Id"), rs.getInt("FK_Exercise_Id"),
						rs.getInt("FK_User_Id"));
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
