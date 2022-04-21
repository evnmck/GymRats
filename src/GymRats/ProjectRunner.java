package GymRats;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class ProjectRunner {
	
	static String connectionUrl = "jdbc:mysql://127.0.0.1:3306/gymrats"; //could be different
	static String dbUsername = "root"; //replace with your username (most likely "root")
	static String dbPassword = "382682498Mck!"; //replace with your password 

	public static void main(String[] args) throws ClassNotFoundException {
	
		UserController user = new UserController(connectionUrl, dbUsername, dbPassword);
		user.getUsers();
	
	}

	public static void getWorkoutForUser() throws ClassNotFoundException {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your User Id: ");
		int user_id = scan.nextInt();
		scan.close();
		boolean found = false;
		String sqlSelectAllPersons = "SELECT * FROM user_workout";
		try (Connection conn = DriverManager.getConnection(connectionUrl, dbUsername, dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt("User_Id");
				if(id == user_id) {
				String eName = rs.getString("Exercise_Name");
				String name = rs.getString("Username");
				String start = rs.getString("Start_Weight");
				String end = rs.getString("End_Weight");
				String reps = rs.getString("Repetitions");
				String sets = rs.getString("Sets");
				String time = rs.getString("Time_in_Minutes");
				System.out.println("\nInfo for user " + id + ": " + name + "\nExercise: " + eName
						+ "\nStarting Weight (lbs): " + start + "\nEnding Weight (lbs): " + end + "\nReps: " + reps
						+ "\nSets: " + sets + "\nTotal Time: " + time);
				found = true;
				}
			}
			
			if(!found) {
					System.out.println("No data for user id: " + user_id);
			}
						
		} catch (SQLException e) {
			System.out.println(e);
		}
	}



}
