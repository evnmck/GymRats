package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import models.Exercise;

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

	public Exercise addExercise(Exercise add) throws ClassNotFoundException {
		String sqlSelectAllPersons = "INSERT INTO exercise (Exercise_Name) VALUES ('" + add.getEName().toLowerCase()
				+ "')";
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);) {
			try {
				ps.execute();
			} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println("Error: Username already taken.");
			}
			return getExerciseByExerciseName(add.getEName());
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public Exercise getExercise(int id) {
		String sqlSelectAllPersons = "SELECT * FROM exercise WHERE Exercise_Id = " + id;
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			Exercise sub = new Exercise(rs.getString("Exercise_Name"));
			sub.setEId(rs.getInt("Exercise_Id"));
			return sub;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public ArrayList<Exercise> getExercises() {
		String sqlSelectAllPersons = "SELECT * FROM exercise";
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			ArrayList<Exercise> ret = new ArrayList<Exercise>();
			while (rs.next()) {
				Exercise sub = new Exercise(rs.getString("Exercise_Name"));
				sub.setEId(rs.getInt("Exercise_Id"));
				ret.add(sub);
			}
			return ret;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public Exercise deleteExercise(int id) {
		Exercise deleted = getExercise(id);
		String sqlSelectAllPersons = "DELETE FROM exercise WHERE Exercise_Id = " + id;
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);) {
			ps.execute();
			return deleted;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public Exercise updateExerciseName(int id, String name) {
		String sqlSelectAllPersons = "UPDATE exercise SET Exercise_Name = '" + name + "' WHERE Exercise_Id = " + id;
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);) {
			ps.execute();
			return getExercise(id);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	private Exercise getExerciseByExerciseName(String ExerciseName) throws ClassNotFoundException {
		String sqlSelectAllPersons = "SELECT * FROM exercise WHERE '" + ExerciseName + "' IN (Exercise_Name)";
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			if (rs.next()) {
				Exercise sub = new Exercise(rs.getString("Exercise_Name"));
				sub.setEId(rs.getInt("Exercise_Id"));
				return sub;
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
}
