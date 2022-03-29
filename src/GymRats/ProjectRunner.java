package GymRats;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectRunner {

	public static void main(String[] args) throws ClassNotFoundException {
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

}



