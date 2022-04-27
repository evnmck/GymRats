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

	public BodyProgress addBodyProgress(BodyProgress bp) throws ClassNotFoundException {
		String sqlSelectAllPersons = null;
		if (bp.getMeasured() != null) {
			sqlSelectAllPersons = "INSERT INTO body_progress (FK_User_Id, Date_Measured, Chest, Waist, Hips, Biceps, Thigh, Weight, Height) VALUES ("
					+ bp.getUserId() + ", " + bp.getMeasured() + ", " + bp.getChest() + ", " + bp.getWaist() + ", "
					+ bp.getHips() + ", " + bp.getBiceps() + ", " + bp.getThigh() + ", " + bp.getWeight() + ", "
					+ bp.getHeight() + ")";
		} else {
			sqlSelectAllPersons = "INSERT INTO body_progress (FK_User_Id, Chest, Waist, Hips, Biceps, Thigh, Weight, Height) VALUES ("
					+ bp.getUserId() + ", " + bp.getChest() + ", " + bp.getWaist() + ", " + bp.getHips() + ", "
					+ bp.getBiceps() + ", " + bp.getThigh() + ", " + bp.getWeight() + ", " + bp.getHeight() + ")";
		}
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);) {
			try {
				ps.execute();
			} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println("Error: Username already taken.");
				return null;
			}
			return getMostRecentAdd(bp.getUserId());
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public BodyProgress getMostRecentAdd(int user) throws ClassNotFoundException {
		String sqlSelectAllPersons = "SELECT MAX(Tracking_Id) FROM body_progress";
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			if (rs.next()) {
				return getBodyProgress(rs.getInt("MAX(Tracking_Id)"), user);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;

	}

	public BodyProgress deleteBodyProgress(int tId, int uId) throws ClassNotFoundException {
		BodyProgress deleted = getBodyProgress(tId, uId);
		String sqlSelectAllPersons = "DELETE FROM body_progress WHERE Tracking_Id = " + tId + " && FK_User_Id = " + uId;
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);) {
			ps.execute();
			return deleted;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public BodyProgress getBodyProgress(int tId, int uId) throws ClassNotFoundException {
		String sqlSelectAllPersons = "SELECT * FROM body_progress WHERE Tracking_Id = " + tId + " && FK_User_Id = "
				+ uId;
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				BodyProgress sub = new BodyProgress(rs.getInt("FK_User_Id"));
				sub.setTrackingId(rs.getInt("Tracking_Id"));
				if (rs.getDate("Date_Measured") != null) {
					sub.setMeasured(rs.getDate("Date_Measured"));
				}
				if (rs.getDouble("Chest") >= 0.0) {
					sub.setChest(rs.getDouble("Chest"));
				}
				if (rs.getDouble("Waist") >= 0.0) {
					sub.setWaist(rs.getDouble("Waist"));
				}
				if (rs.getDouble("Hips") >= 0.0) {
					sub.setHips(rs.getDouble("Hips"));
				}
				if (rs.getDouble("Biceps") >= 0.0) {
					sub.setBiceps(rs.getDouble("Biceps"));
				}
				if (rs.getDouble("Thigh") >= 0.0) {
					sub.setThigh(rs.getDouble("Thigh"));
				}
				if (rs.getDouble("Weight") >= 0.0) {
					sub.setWeight(rs.getDouble("Weight"));
				}
				if (rs.getDouble("Height") >= 0.0) {
					sub.setHeight(rs.getDouble("Height"));
				}
				return sub;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public ArrayList<BodyProgress> getBodyProgressesForUser(int uId) throws ClassNotFoundException {
		String sqlSelectAllPersons = "SELECT * FROM body_progress WHERE FK_User_Id = " + uId;
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			ArrayList<BodyProgress> ret = new ArrayList<BodyProgress>();
			while (rs.next()) {
				BodyProgress sub = new BodyProgress(rs.getInt("FK_User_Id"));
				sub.setTrackingId(rs.getInt("Tracking_Id"));
				if (rs.getDate("Date_Measured") != null) {
					sub.setMeasured(rs.getDate("Date_Measured"));
				}
				if (rs.getDouble("Chest") >= 0.0) {
					sub.setChest(rs.getDouble("Chest"));
				}
				if (rs.getDouble("Waist") >= 0.0) {
					sub.setWaist(rs.getDouble("Waist"));
				}
				if (rs.getDouble("Hips") >= 0.0) {
					sub.setHips(rs.getDouble("Hips"));
				}
				if (rs.getDouble("Biceps") >= 0.0) {
					sub.setBiceps(rs.getDouble("Biceps"));
				}
				if (rs.getDouble("Thigh") >= 0.0) {
					sub.setThigh(rs.getDouble("Thigh"));
				}
				if (rs.getDouble("Weight") >= 0.0) {
					sub.setWeight(rs.getDouble("Weight"));
				}
				if (rs.getDouble("Height") >= 0.0) {
					sub.setHeight(rs.getDouble("Height"));
				}
				ret.add(sub);
			}
			return ret;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public ArrayList<BodyProgress> getBodyProgresses() throws ClassNotFoundException {
		String sqlSelectAllPersons = "SELECT * FROM body_progress";
		try (Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
				ResultSet rs = ps.executeQuery()) {
			ArrayList<BodyProgress> ret = new ArrayList<BodyProgress>();
			while (rs.next()) {
				BodyProgress sub = new BodyProgress(rs.getInt("FK_User_Id"));
				sub.setTrackingId(rs.getInt("Tracking_Id"));
				if (rs.getDate("Date_Measured") != null) {
					sub.setMeasured(rs.getDate("Date_Measured"));
				}
				if (rs.getDouble("Chest") >= 0.0) {
					sub.setChest(rs.getDouble("Chest"));
				}
				if (rs.getDouble("Waist") >= 0.0) {
					sub.setWaist(rs.getDouble("Waist"));
				}
				if (rs.getDouble("Hips") >= 0.0) {
					sub.setHips(rs.getDouble("Hips"));
				}
				if (rs.getDouble("Biceps") >= 0.0) {
					sub.setBiceps(rs.getDouble("Biceps"));
				}
				if (rs.getDouble("Thigh") >= 0.0) {
					sub.setThigh(rs.getDouble("Thigh"));
				}
				if (rs.getDouble("Weight") >= 0.0) {
					sub.setWeight(rs.getDouble("Weight"));
				}
				if (rs.getDouble("Height") >= 0.0) {
					sub.setHeight(rs.getDouble("Height"));
				}
				ret.add(sub);
			}
			return ret;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
}
