package com.EQCSYS.app.bean;

import java.util.ArrayList;

public class TempStorageBean {
	private static ArrayList<String> myList;
	private boolean valid;

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean newValid) {
		valid = newValid;
	}

	public void setMyList(ArrayList<String> myList, String t) {
		myList.add(t);
	}

	public static ArrayList<String> getMyList() {
		myList.get(0);
		return myList;
	}
}
