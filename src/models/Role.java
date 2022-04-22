package models;

public enum Role {
	USER, TRAINER, ADMIN;
	
	@Override
	public String toString() {
		if (this == USER) {
			return "user";
		} else if (this == TRAINER) {
			return "trainer";
		} else {
			return "admin";
		}
	}
}
