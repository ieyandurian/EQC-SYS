package com.EQCSYS.app.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class OwnershipBean {
	private int lecturerID, questionID;
	private String shareAccess;
	private boolean valid;
	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean newValid) {
		valid = newValid;
	}

	public String getShareAccess() {
		return shareAccess;
	}

	public void setShareAccess(String shareAccess) {
		this.shareAccess = shareAccess;
	}

	public int getLecturerID() {
		return lecturerID;
	}

	public void setLecturerID(int lecturerID) {
		this.lecturerID = lecturerID;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
}
