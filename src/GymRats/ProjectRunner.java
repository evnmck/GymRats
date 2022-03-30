package GymRats;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProjectRunner {

	public static void main(String[] args) throws ClassNotFoundException {
		//addUser();
		//getUsers();
		getAllWorkouts();
	}

	public static void getAllWorkouts() throws ClassNotFoundException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your User Id: ");
		int user_id = scan.nextInt();
		boolean found = false;
		String sqlSelectAllPersons = "SELECT * FROM user_workout";
		String connectionUrl = "jdbc:mysql://127.0.0.1:3306/gymrats";
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "382682498Mck!");
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

	public static void getUsers() throws ClassNotFoundException {
		String sqlSelectAllPersons = "SELECT * FROM user";
		String connectionUrl = "jdbc:mysql://127.0.0.1:3306/gymrats";
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "382682498Mck!");
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt("User_Id");
				String name = rs.getString("FName");
				String lastName = rs.getString("LName");
				System.out.println(id + ": " + name + " " + lastName);

				// do something with the extracted data...
			}
		} catch (SQLException e) {
			System.out.println(e);
			// handle the exception
		}
	}

	public static void addUser() throws ClassNotFoundException {
		String sqlSelectAllPersons = "INSERT INTO user (FName, LName, Username, Password) VALUES ('Evan', 'McKnight', 'user1', '123password')";
		String connectionUrl = "jdbc:mysql://127.0.0.1:3306/gymrats";
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "382682498Mck!");
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);) {
			ps.execute();
		} catch (SQLException e) {
			System.out.println(e);
			// handle the exception
		}
	}

}
