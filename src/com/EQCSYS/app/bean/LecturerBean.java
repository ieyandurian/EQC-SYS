package com.EQCSYS.app.bean;

public class LecturerBean{;
	private int lecturerID;
	private String lecturerPassword, lecturerFirstName, lecturerLastName, lecturerPhoneNumber;
	private String  lecturerEmail, lecturerFaculty;
	private boolean valid;

	public int getLecturerID() {
		return lecturerID;
	}

	public void setLecturerID(int i) {
		this.lecturerID = i;
	}

	public String getLecturerFirstName() {
		return lecturerFirstName;
	}

	public void setLecturerFirstName(String lecturerFirstName) {
		this.lecturerFirstName = lecturerFirstName;
	}

	public String getLecturerPassword() {
		return lecturerPassword;
	}

	public void setLecturerPassword(String lecturerPassword) {
		this.lecturerPassword = lecturerPassword;
	}

	public String getLecturerLastName() {
		return lecturerLastName;
	}

	public void setLecturerLastName(String lecturerLastName) {
		this.lecturerLastName = lecturerLastName;
	}

	public String getLecturerPhoneNumber() {
		return lecturerPhoneNumber;
	}

	public void setLecturerPhoneNumber(String lecturerPhoneNumber) {
		this.lecturerPhoneNumber = lecturerPhoneNumber;
	}

	public String getLecturerEmail() {
		return lecturerEmail;
	}

	public void setLecturerEmail(String lecturerEmail) {
		this.lecturerEmail = lecturerEmail;
	}

	public String getLecturerFaculty() {
		return lecturerFaculty;
	}

	public void setLecturerFaculty(String lecturerFaculty) {
		this.lecturerFaculty = lecturerFaculty;
	}
	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean newValid) {
		valid = newValid;
	}
}