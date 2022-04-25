package models;

public class Exercise {
	private int eId = -1;
	private String eName;

	public Exercise(String name) {
		this.eName = name;
	}

	public int getEId() {
		return this.eId;
	}

	public void setEId(int id) {
		this.eId = id;
	}

	public String getEName() {
		return this.eName;
	}

	@Override
	public String toString() {
		return "{Exercise_Id: " + Integer.toString(this.eId) + ", Exercise_Name: " + this.eName + "}";
	}

}
