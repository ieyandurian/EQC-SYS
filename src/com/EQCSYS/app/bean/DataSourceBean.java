package com.EQCSYS.app.bean;

import java.sql.Blob;

public class DataSourceBean {
	private int dataSourceID;
	private String dataSourceTopicCode;
	public Blob dataSourceFile;
	private boolean valid;

	public int getDataSourceID() {
		return dataSourceID;
	}

	public void setDataSourceID(int dataSourceID) {
		this.dataSourceID = dataSourceID;
	}

	public String getDataSourceTopicCode() {
		return dataSourceTopicCode;
	}

	public void setDataSourceTopicCode(String dataSourceTopicCode) {
		this.dataSourceTopicCode = dataSourceTopicCode;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean newValid) {
		valid = newValid;
	}
}