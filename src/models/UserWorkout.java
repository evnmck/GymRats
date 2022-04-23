package models;

public class UserWorkout {
	private int uId;
	private String eName = null;
	private String uName = null;
	private int startWeight = -1;
	private int endWeight = -1;
	private int reps = -1;
	private int sets = -1;
	private int time = -1;

	public UserWorkout(int uId) {
		this.setuId(uId);
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public int getStartWeight() {
		return startWeight;
	}

	public void setStartWeight(int startWeight) {
		this.startWeight = startWeight;
	}

	public int getEndWeight() {
		return endWeight;
	}

	public void setEndWeight(int endWeight) {
		this.endWeight = endWeight;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	// TODO
	@Override
	public String toString() {
		return "{User_Id: " + this.uId + ", Exercise_Name: " + this.eName + ", Username: " + this.uName
				+ ", Start_Weight: " + this.startWeight + ", End_Weight: " + this.endWeight + ", Repetitions: "
				+ this.reps + ", Sets: " + this.sets + ", Time_in_Minutes: " + this.time + "}";
	}
}
