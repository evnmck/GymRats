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

		ArrayList<UserWorkout> unordered = userWorkout.getAllForExcerciseName(1, "deadlift");
		System.out.println("\nDeadlift by Wokrout Number:");
		for (int i = 0; i < unordered.size(); i++) {
			System.out.println(unordered.get(i));
		}
		double first = (double) unordered.get(0).getMaxWeight();
		double last = (double) unordered.get(unordered.size() - 2).getMaxWeight();
		double current = (double) unordered.get(unordered.size() - 1).getMaxWeight();
		double lastTwo = Math.round(((double) (current - last) / last) * 100);
		int change = unordered.get(unordered.size() - 1).getEndWeight()
				- unordered.get(unordered.size() - 1).getStartWeight();
		int bigChange = -1;
		double bigPerc = -1.0;
		for (int i = 0; i < unordered.size(); i++) {
			int curChange = unordered.get(i).getEndWeight() - unordered.get(i).getStartWeight();
			if (curChange > bigChange) {
				bigPerc = Math.round(((double) (curChange) / unordered.get(i).getStartWeight()) * 100);
				bigChange = curChange;
			}
		}
		int number = (int) (current - first);
		double percent = Math.round(((double) (number) / first) * 100);
		double total = 0.0;
		for (int i = 0; i < unordered.size() - 1; i++) {
			double cur = (double) unordered.get(i).getMaxWeight();
			double next = (double) unordered.get(i + 1).getMaxWeight();
			double ch = Math.round(((next - cur) / cur) * 100);
			total += ch;
		}
		double average = total / (unordered.size() - 1);

		System.out.println("\nMax deadlift for user:\n" + userWorkout.getMax(1, "deadlift").toString());
		System.out.println("\nPercent change between two last deadlifts: " + lastTwo + " %");
		System.out.println("Change in weight during last workout: " + change + " lbs");
		System.out.println("Largest change is weight during workout: " + bigChange + " lbs (" + bigPerc + " %)");
		System.out.println("Change in weight between first and last workout: " + number + " lbs");
		System.out.println("Change in percent between first and last workout: " + percent + " %");
		System.out.println("Overall average change in percent between workouts: " + average + " %");

		ArrayList<UserWorkout> copy = unordered;
		ArrayList<UserWorkout> ordered = userWorkout.sortUserWorkouts(copy);
		System.out.println("\nInorder by Weight Deadlift:");
		for (int i = 0; i < ordered.size(); i++) {
			System.out.println(ordered.get(i));
		}
		double min = (double) ordered.get(ordered.size() - 1).getMaxWeight();
		double max = (double) ordered.get(0).getMaxWeight();
		System.out.println("\nPercent change between MIN and MAX deadlifts: " + Math.round(((max - min) / min) * 100));

		// The code below will get all of the record lifts for deadlift from all users,
		// sort them, and listthe top 5
		ArrayList<UserWorkout> allDeadlifts = userWorkout.getAllWithSameName("deadlift");
		System.out.println("\nAll workouts with name 'deadlift:");
		for (int i = 0; i < allDeadlifts.size(); i++) {
			System.out.println(allDeadlifts.get(i));
		}

		System.out.println("\nTop 5 Deadlifts with username and max weight:");
		ArrayList<UserWorkout> sortedDeadLift = userWorkout
				.sortUserWorkouts(userWorkout.getAllWithSameName("deadlift"));

		int a = 0;
		while (true) {
			if (a == 5) {
				break;
			}
			if (sortedDeadLift.get(a) == null) {
				break;
			}
			int rank = a + 1;
			System.out.println("Rank #" + rank + "\t Username: " + sortedDeadLift.get(a).getuName() + "\tMax Lift: "
					+ sortedDeadLift.get(a).getMaxWeight());
			a++;
		}
		System.out.println();

	}

}