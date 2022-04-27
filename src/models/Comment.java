package models;

public class Comment {
	private int commenterId = -1;
	private int workoutId = -1;
	private String comment = null;

	public Comment(int cId, int wId, String comment) {
		this.commenterId = cId;
		this.workoutId = wId;
		this.comment = comment;
	}

	public int getCommenterId() {
		return this.commenterId;
	}

	public int getWorkoutId() {
		return this.workoutId;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		if (this.comment == null) {
			return "{FK_Commenter_Id: " + this.commenterId + ", FK_Workout_Id: " + this.workoutId + ", Comment: ''}";
		}
		return "{FK_Commenter_Id: " + this.commenterId + ", FK_Workout_Id: " + this.workoutId + ", Comment: "
				+ this.comment + "}";
	}

}
