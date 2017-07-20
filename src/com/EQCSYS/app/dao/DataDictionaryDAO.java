package com.EQCSYS.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.EQCSYS.app.bean.DataDictionaryBean;
import com.EQCSYS.app.util.ConnectionManager;

public class DataDictionaryDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static ResultSet rs1 = null;

	public static DataDictionaryBean categorizeQuestion(
			DataDictionaryBean keyword, String topic, String difficulty)
			throws SQLException {
		try {
			currentCon = ConnectionManager.getConnection();
			try {
				Statement stmt = currentCon.createStatement();

				if (difficulty.equalsIgnoreCase("C1")) {
					System.out.println("2nd!!!");
					rs = stmt
							.executeQuery("select * from datadictionary where leveloftaxonomy=1");
					while (rs.next()) {
						String key = rs.getString("keywords");
						System.out.println("3rd!!!");
						QuestionSampleDAO.retrieveSample(topic, key, difficulty, currentCon);
						System.out.println(key);
					}
				} else if (difficulty.equalsIgnoreCase("C2")) {
					System.out.println("2nd!!!");
					rs = stmt
							.executeQuery("select * from datadictionary where leveloftaxonomy=2");
					while (rs.next()) {
						String key = rs.getString("keywords");
						System.out.println("3rd!!!");
						QuestionSampleDAO.retrieveSample(topic, key, difficulty, currentCon);
						System.out.println(key);
					}
				} else if (difficulty.equalsIgnoreCase("C3")) {
					System.out.println("2nd!!!");
					rs = stmt
							.executeQuery("select * from datadictionary where leveloftaxonomy=3");
					while (rs.next()) {
						String key = rs.getString("keywords");
						System.out.println("3rd!!!");
						QuestionSampleDAO.retrieveSample(topic, key, difficulty, currentCon);
						System.out.println(key);
					}
				} else if (difficulty.equalsIgnoreCase("C4")) {
					System.out.println("2nd!!!");
					rs = stmt
							.executeQuery("select * from datadictionary where leveloftaxonomy=4");
					while (rs.next()) {
						String key = rs.getString("keywords");
						System.out.println("3rd!!!");
						QuestionSampleDAO.retrieveSample(topic, key, difficulty, currentCon);
						System.out.println(key);
					}
				}
				keyword.setValid(true);
				currentCon.close();
			} catch (Exception e) {
				System.err.println("Got an exception! ");
				System.err.println(e.getMessage());
			}
		} finally {
			currentCon.close();
		}
		return keyword;
	}
}
