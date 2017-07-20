package com.EQCSYS.app.bean;

public class QuestionSampleBean {
	private int qID;
	private String qQuestion, qAnswer;
	
	public int getQID(){
		return qID;
	}
	
	public void setQID(int qID){
		this.qID = qID;
	}
	
	public String getQQuestion(){
		return qQuestion;
	}
	
	public void setQQuestion(String qQuestion){
		this.qQuestion = qQuestion;
	}
	
	public String getQAnswer(){
		return qAnswer;
	}
	
	public void setQAnswer(String qAnswer){
		this.qAnswer = qAnswer;
	}
}
