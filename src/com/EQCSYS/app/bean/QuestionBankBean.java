package com.EQCSYS.app.bean;

public class QuestionBankBean {
	private int questionID, questionMarks;
	private String questionDifficulty, questionTopicCode, questionQuestion, questionAnswer;
	private boolean valid;

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean newValid) {
		valid = newValid;
	}

	public int getQuestionMarks() {
		return questionMarks;
	}

	public void setQuestionMarks(int questionMarks) {
		this.questionMarks = questionMarks;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public String getQuestionTopicCode() {
		return questionTopicCode;
	}

	public void setQuestionTopicCode(String questionTopicCode) {
		this.questionTopicCode = questionTopicCode;
	}

	public String getQuestionQuestion() {
		return questionQuestion;
	}

	public void setQuestionQuestion(String questionQuestion) {
		this.questionQuestion = questionQuestion;
	}

	public String getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public String getQuestionDifficulty() {
		return questionDifficulty;
	}

	public void setQuestionDifficulty(String questionDifficulty) {
		this.questionDifficulty = questionDifficulty;
	}
}