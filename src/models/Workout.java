package models;

import java.sql.Date;

public class Workout {
	private int wId = -1;
	private int eId = -1;
	private int uId = -1;
	private String wName = "";
	private int startWeight = -1;
	private int endWeight = -1;
	private int reps = -1;
	private int sets = -1;
	private int time = -1;
	private String date;

	public Workout(int user) {
		this.uId = user;
	}

	public Workout(int user, int workout, String name) {
		this.uId = user;
		this.wId = workout;
		this.wName = name;
	}

	public Workout(int workout, int exercise, int user) {
		this.wId = workout;
		this.eId = exercise;
		this.uId = user;
	}

	public Workout(int workout, int exercise, int user, String name, int start, int end, int reps, int sets, int time) {
		this.wId = workout;
		this.eId = exercise;
		this.uId = user;
		this.startWeight = start;
		this.endWeight = end;
		this.reps = reps;
		this.sets = sets;
		this.time = time;
		this.wName = name;
	}

	public void setWId(int id) {
		this.wId = id;
	}

	public int getWId() {
		return this.wId;
	}

	public void setEId(int id) {
		this.eId = id;
	}

	public int getEId() {
		return this.eId;
	}

	public void setUId(int id) {
		this.uId = id;
	}

	public int getUid() {
		return this.uId;
	}

	public void setName(String name) {
		this.wName = name;
	}

	public String getName() {
		return this.wName;
	}

	public void setSWeight(int weight) {
		this.startWeight = weight;
	}

	public int getSWeight() {
		return this.startWeight;
	}

	public void setEWeight(int weight) {
		this.endWeight = weight;
	}

	public int getEWeight() {
		return this.endWeight;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public int getReps() {
		return this.reps;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public int getSets() {
		return this.sets;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getTime() {
		return this.time;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return this.date;
	}

	@Override
	public String toString() {
		if (this.date == null) {
			return "{Workout_Id: " + this.wId + ", FK_Exercise_Id: " + this.eId + ", FK_User_Id: " + this.uId
					+ ", Workout_Name: " + this.wName + ", Start_Weight: " + this.startWeight + ", End_Weight: "
					+ this.endWeight + ", Sets: " + this.endWeight + ", Sets: " + this.sets + ", Time_in_Minutes: "
					+ this.time + ", Date: ''}";
		}
		return "{Workout_Id: " + this.wId + ", FK_Exercise_Id: " + this.eId + ", FK_User_Id: " + this.uId
				+ ", Workout_Name: " + this.wName + ", Start_Weight: " + this.startWeight + ", End_Weight: "
				+ this.endWeight + ", Sets: " + this.endWeight + ", Sets: " + this.sets + ", Time_in_Minutes: "
				+ this.time + ", Date: " + date + "}";
	}

}
