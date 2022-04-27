package models;

public class User {
	private int userId = -1;
	private String fName;
	private String lName;
	private String uName;
	private String pWord;
	private String bio = null;
	private int trainerId = -1;
	private Role role;

	public User(String fName, String lName, String uName, String pWord, String role) {
		this.fName = fName;
		this.lName = lName;
		this.uName = uName;
		this.pWord = pWord;
		if (role.toLowerCase().equals("trainer")) {
			this.role = Role.TRAINER;
		} else if (role.toLowerCase().equals("admin")) {
			this.role = Role.ADMIN;
		} else {
			this.role = Role.USER;
		}
	}

	public int getUId() {
		return this.userId;
	}

	public void setUId(int uId) {
		this.userId = uId;
	}

	public String getFName() {
		return this.fName;
	}

	public String getLName() {
		return this.lName;
	}

	public String getUName() {
		return this.uName;
	}

	public String getPWord() {
		return this.pWord;
	}

	public String getBio() {
		return this.bio;
	}

	public int getTrainerId() {
		return this.trainerId;
	}

	public Role getRole() {
		return this.role;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public void setTrainerId(int id) {
		this.trainerId = id;
	}

	public void setRole(String role) {
		if (role.toLowerCase().equals("user")) {
			this.role = Role.USER;
		} else if (role.toLowerCase().equals("trainer")) {
			this.role = Role.TRAINER;
		} else if (role.toLowerCase().equals("admin")) {
			this.role = Role.ADMIN;
		}
	}

	public boolean isAdmin() {
		if (this.role == Role.ADMIN) {
			return true;
		}
		return false;
	}

	public boolean isTrainer() {
		if (this.role == Role.TRAINER) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		if (this.bio == null) {
			return "{User_Id: " + this.userId + ", Fname: " + this.fName + ", Lname: " + this.lName + ", Username: "
					+ this.uName + ", Password: " + this.pWord + ", Bio: '', FK_Trainer_Id: " + this.trainerId
					+ ", Role: " + this.role.toString() + "}";
		}
		return "{User_Id: " + this.userId + ", Fname: " + this.fName + ", Lname: " + this.lName + ", Username: "
				+ this.uName + ", Password: " + this.pWord + ", Bio: " + this.bio + ", FK_Trainer_Id: " + this.trainerId
				+ ", Role: " + this.role.toString() + "}";
	}
}
