package models;

import java.util.Date;

public class BodyProgress {
	private int trackingId;
	private int userId;
	private Date measured;
	private double chest;
	private double waist;
	private double hips;
	private double biceps;
	private double thigh;
	private double weight;
	private double height;

	public BodyProgress(int uId) {
		this.setUserId(uId);
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

	@Override
	public String toString() {
		return null;
	}
}
