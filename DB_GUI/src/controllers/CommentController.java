package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import models.Comment;

public class CommentController {
	String connectionUrl;
	String dbUsername;
	String dbPassword;

	public CommentController(String conn, String usrnm, String psswrd) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.connectionUrl = conn;
		this.dbUsername = usrnm;
		this.dbPassword = psswrd;
	}

	public Comment addCommtent(Comment com) throws ClassNotFoundException {
		String sqlSelectAllPersons = null;
		if (com.getComment() != null) {
			sqlSelectAllPersons = "INSERT INTO comment (FK_Commenter_Id, FK_Workout_Id) VALUES (" + com.getCommenterId()
					+ ", " + com.getWorkoutId() + ")";
		} else {
			sqlSelectAllPersons = "INSERT INTO comment (FK_Commenter_Id, FK_Workout_Id, Comment) VALUES ("
					+ com.getCommenterId() + ", " + com.getWorkoutId() + ", '" + com.getComment() + "')";
		}
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);) {
			try {
				ps.execute();
			} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println("Error: Username already taken.");
			}
			return getComment(com.getCommenterId(), com.getWorkoutId());
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public Comment changeComment(int cId, int wId, String comment) throws ClassNotFoundException {
		String sqlSelectAllPersons = "UPDATE comment SET Comment = '" + comment + "'WHERE FK_Commenter_Id = " + cId
				+ " && FK_Workout_Id = " + wId;
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);) {
			ps.execute();
			return getComment(cId, wId);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public Comment deleteComment(int cId, int wId) throws ClassNotFoundException {
		Comment ret = getComment(cId, wId);
		String sqlSelectAllPersons = "DELETE * FROM comments WHERE FK_Commenter_Id = " + cId + " && FK_Workout_Id = "
				+ wId;
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);) {
			ps.executeQuery();
			return ret;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public Comment getComment(int cId, int wId) throws ClassNotFoundException {
		String sqlSelectAllPersons = "SELECT * FROM comments WHERE FK_Commenter_Id = " + cId + " && FK_Workout_Id = "
				+ wId;
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			if (rs.next()) {
				Comment sub = new Comment(rs.getInt("FK_Commenter_Id"), rs.getInt("FK_Workout_Id"),
						rs.getString("Comment"));
				return sub;
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public ArrayList<Comment> getComments() throws ClassNotFoundException {
		String sqlSelectAllPersons = "SELECT * FROM comments";
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			ArrayList<Comment> ret = new ArrayList<Comment>();
			while (rs.next()) {
				Comment sub = new Comment(rs.getInt("FK_Commenter_Id"), rs.getInt("FK_Workout_Id"),
						rs.getString("Comment"));
				ret.add(sub);
			}
			return ret;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;

	}

}
