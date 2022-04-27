package models;

import java.util.Date;

public class BodyProgress {
	private int trackingId = -1;
	private int userId = -1;
	private Date measured;
	private double chest = -1.0;
	private double waist = -1.0;
	private double hips = -1.0;
	private double biceps = -1.0;
	private double thigh = -1.0;
	private double weight = -1.0;
	private double height = -1.0;

	public BodyProgress(int uId) {
		this.userId = uId;
	}

	public BodyProgress(int userId, double chest, double waist, double hips, double biceps, double thigh, double weight,
			double height) {
		this.userId = userId;
		this.chest = chest;
		this.waist = waist;
		this.hips = hips;
		this.biceps = biceps;
		this.thigh = thigh;
		this.weight = weight;
		this.height = height;
	}

	public int getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(int trackingId) {
		this.trackingId = trackingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getChest() {
		return chest;
	}

	public void setChest(double chest) {
		this.chest = chest;
	}

	public Date getMeasured() {
		return measured;
	}

	public void setMeasured(Date measured) {
		this.measured = measured;
	}

	public double getWaist() {
		return waist;
	}

	public void setWaist(double waist) {
		this.waist = waist;
	}

	public double getHips() {
		return hips;
	}

	public void setHips(double hips) {
		this.hips = hips;
	}

	public double getBiceps() {
		return biceps;
	}

	public void setBiceps(double biceps) {
		this.biceps = biceps;
	}

	public double getThigh() {
		return thigh;
	}

	public void setThigh(double thigh) {
		this.thigh = thigh;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	// TODO
	@Override
	public String toString() {
		if (this.measured == null) {
			return "{Tracking_Id: " + this.trackingId + ", FK_User_Id: " + this.userId + ", Date_Meaures: ' ', Chest: "
					+ this.chest + ", Waist: " + this.waist + ", Hips: " + this.hips + ", Biceps: " + this.biceps
					+ ", Thigh: " + this.thigh + ", Weight: " + this.weight + ", Height: " + this.height + "}";
		}
		return "{Tracking_Id: " + this.trackingId + ", FK_User_Id: " + this.userId + ", Date_Meaures: " + this.measured
				+ ", Chest: " + this.chest + ", Waist: " + this.waist + ", Hips: " + this.hips + ", Biceps: "
				+ this.biceps + ", Thigh: " + this.thigh + ", Weight: " + this.weight + ", Height: " + this.height
				+ "}";
	}
}
