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

	/* TODO */
	public ArrayList<UserWorkout> getUserWorkoutForUser(int id) throws ClassNotFoundException {
		return null;
	}

	/* TODO */
	public ArrayList<UserWorkout> getUserWorkouts() throws ClassNotFoundException {
		return null;
	}
}
