package controllers;

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

	/* TODO */
	public BodyProgress addBodyProgress(BodyProgress bp) throws ClassNotFoundException {
		return null;
	}

	/* TODO */
	public BodyProgress deleteBodyProgress(int tId, int uId) throws ClassNotFoundException {
		return null;
	}

	/* TODO */
	public BodyProgress getBodyProgress(int tId, int uId) throws ClassNotFoundException {
		return null;
	}

	/* TODO */
	public ArrayList<BodyProgress> getBodyProgresses() throws ClassNotFoundException {
		return null;
	}
}
