package models;

public class UserWorkout {
	private int uId;
	private String eName;
	private String uName;
	private int startWeight;
	private int endWeight;
	private int reps;
	private int sets;
	private int time;

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

	//TODO 
	@Override
	public String toString() {
		return null;
	}
}
