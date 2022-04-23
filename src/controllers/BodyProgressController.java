package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import models.BodyProgress;

public class BodyProgressController {
	String connectionUrl;
	String dbUsername;
	String dbPassword;

	public BodyProgressController(String conn, String usrnm, String psswrd) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.connectionUrl = conn;
		this.dbUsername = usrnm;
		this.dbPassword = psswrd;
	}

	public boolean addBodyProgress(BodyProgress bp) throws ClassNotFoundException {
		String sqlSelectAllPersons = null;
		if (bp.getMeasured() != null) {
			sqlSelectAllPersons = "INSERT INTO comment (FK_User_Id, Date_Measured, Chest, Waist, Hips, Biceps, Thigh, Weight, Height) VALUES ("
					+ bp.getUserId() + ", " + bp.getMeasured() + ", " + bp.getChest() + ", " + bp.getWaist() + ", "
					+ bp.getHips() + ", " + bp.getBiceps() + ", " + bp.getThigh() + ", " + bp.getWeight() + ", "
					+ bp.getHeight() + ")";
		} else {
			sqlSelectAllPersons = "INSERT INTO comment (FK_User_Id, Chest, Waist, Hips, Biceps, Thigh, Weight, Height) VALUES ("
					+ bp.getUserId() + ", " + bp.getChest() + ", " + bp.getWaist() + ", " + bp.getHips() + ", "
					+ bp.getBiceps() + ", " + bp.getThigh() + ", " + bp.getWeight() + ", " + bp.getHeight() + ")";
		}
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);) {
			try {
				ps.execute();
			} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println("Error: Username already taken.");
				return false;
			}
			return true;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}

	/* TODO */
	public BodyProgress deleteBodyProgress(int tId, int uId) throws ClassNotFoundException {
		return null;
	}

	/* TODO */
	public BodyProgress getBodyProgress(int tId, int uId) throws ClassNotFoundException {
		return null;
	}

	/* TODO */
	public ArrayList<BodyProgress> getBodyProgresses() throws ClassNotFoundException {
		return null;
	}
}
