package GymRats;

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

		ArrayList<User> users = user.getUsers();
		ArrayList<Exercise> exercises = exercise.getExercises();
		ArrayList<Comment> comments = comment.getComments();
		ArrayList<Workout> workouts = workout.getWorkouts();
		ArrayList<UserWorkout> userWorkouts = userWorkout.getUserWorkouts();
		ArrayList<BodyProgress> bodyProgresses = bodyProgress.getBodyProgresses();

		System.out.println("\n" + userWorkout.getMax(1, "deadlift") + "\n");

		// user.changeRole(1, "admin");
		// user.deleteUserByUserId(21);

		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).toString());
		}
		System.out.println();

		for (int j = 0; j < exercises.size(); j++) {
			System.out.println(exercises.get(j).toString());
		}
		System.out.println();

		for (int k = 0; k < comments.size(); k++) {
			System.out.println(comments.get(k).toString());
		}
		System.out.println();

		for (int h = 0; h < workouts.size(); h++) {
			System.out.println(workouts.get(h).toString());
		}
		System.out.println();

		for (int n = 0; n < userWorkouts.size(); n++) {
			System.out.println(userWorkouts.get(n).toString());
		}
		System.out.println();

		for (int m = 0; m < bodyProgresses.size(); m++) {
			System.out.println(bodyProgresses.get(m).toString());
		}

	}

}
