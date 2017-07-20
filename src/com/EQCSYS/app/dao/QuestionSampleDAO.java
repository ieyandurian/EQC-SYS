package com.EQCSYS.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.EQCSYS.app.bean.QuestionSampleBean;

public class QuestionSampleDAO {
	static Connection currentCon = null;
	static ResultSet rs1 = null;

	public static QuestionSampleBean retrieveSample(String topic, String key,
			String difficulty, Connection currentCon) throws SQLException {
		int marks = 0;
		if (difficulty.equalsIgnoreCase("C1")) {
			marks = 2;
		} else if (difficulty.equalsIgnoreCase("C2")) {
			marks = 3;
		} else if (difficulty.equalsIgnoreCase("C3")) {
			marks = 4;
		} else if (difficulty.equalsIgnoreCase("C4")) {
			marks = 5;
		}

		Statement stmt1 = currentCon.createStatement();
		rs1 = stmt1
				.executeQuery("select qquestion, qanswer from questionsample where qTopicCode = '"
						+ topic + "' and lower(qquestion) like '%" + key + "%'");
		System.out.println("4th!!!");
		while (rs1.next()) {
			System.out.println("5th!!!");
			String question = rs1.getString("qQuestion");
			String answer = rs1.getString("qAnswer");
			PreparedStatement ps = currentCon
					.prepareStatement("insert into questionbanktemp values(questionIDTEST.nextVal,?,?,?,?,?)");
			System.out.println("6th!!!");
			ps.setString(1, difficulty.toUpperCase());
			ps.setInt(2, marks);
			ps.setString(3, topic);
			ps.setString(4, question);
			ps.setString(5, answer);
			System.out.println("7th!!!");
			ps.executeUpdate();
			System.out.println("8th!!!");
			System.out.println(question);
		}
		return null;
	}
}
