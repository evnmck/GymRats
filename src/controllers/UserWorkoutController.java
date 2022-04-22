package controllers;

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

	public ArrayList<UserWorkout> getBodyProgressForUser(int id) {
		return null;
	}

	public ArrayList<UserWorkout> getBodyProgresses() {
		return null;
	}
}
