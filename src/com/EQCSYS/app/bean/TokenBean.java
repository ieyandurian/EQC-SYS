package com.EQCSYS.app.bean;

public class TokenBean {
	private String sentence, topicCode;
	private boolean valid;

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean newValid) {
		valid = newValid;
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	
	public String getTopicCode() {
		return topicCode;
	}
	
	public void setTopicCode(String topicCode) {
		this.topicCode = topicCode;
	}
}
