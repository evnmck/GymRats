package GymRats;

import java.awt.EventQueue;
import java.util.ArrayList;

import controllers.*;
import models.*;

public class ProjectRunner {

	static String connectionUrl = "jdbc:mysql://127.0.0.1:3306/gymrats"; // could be different
	static String dbUsername = "root"; // replace with your username (most likely "root")
	static String dbPassword = "382682498Mck!"; // replace with your password

	public static void main(String[] args) throws ClassNotFoundException {
		UserController user = new UserController(connectionUrl, dbUsername, dbPassword);
		ExerciseController exercise = new ExerciseController(connectionUrl, dbUsername, dbPassword);
		CommentController comment = new CommentController(connectionUrl, dbUsername, dbPassword);
		WorkoutController workout = new WorkoutController(connectionUrl, dbUsername, dbPassword);
		UserWorkoutController userWorkout = new UserWorkoutController(connectionUrl, dbUsername, dbPassword);
		BodyProgressController bodyProgress = new BodyProgressController(connectionUrl, dbUsername, dbPassword);

		 System.out.println("\nMax: " + userWorkout.getMax(1, "deadlift") + "\n");
		 ArrayList<UserWorkout> unordered = userWorkout.getAllForExcerciseName(1,
		 "deadlift");
		 System.out.println("\nUnordered Deadlift: " + unordered + "\n");
		 System.out.println("\nInorder Deadlift: " +
		 userWorkout.sortUserWorkouts(unordered) + "\n");
		// The code below will get all of the record lifts for deadlift from all users,
		// sort them, and list the top 5
		
		  ArrayList<UserWorkout> sortedDeadLift = userWorkout
		  .sortUserWorkouts(userWorkout.getAllWithSameName("deadlift"));
		  System.out.println();
		  
		  int a = 0; while (true) { if (a == 5) { break; } if (sortedDeadLift.get(a) ==
		  null) { break; } int rank = a + 1; System.out.println("Rank #" + rank +
		  "\t Username: " + sortedDeadLift.get(a).getuName() + "\tMax Lift: " +
		  sortedDeadLift.get(a).getMaxWeight()); a++; } System.out.println();
		 

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login(connectionUrl, dbUsername, dbPassword);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}