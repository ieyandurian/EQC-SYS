package com.EQCSYS.app.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.EQCSYS.app.bean.DataSourceBean;
import com.EQCSYS.app.bean.QuestionBankBean;
import com.EQCSYS.app.bean.TSTBean;
import com.EQCSYS.app.bean.TokenBean;
import com.EQCSYS.app.cosinesimilarity.CosineDocumentSimilarity;
import com.EQCSYS.app.exampapercreation.DocumentCreation;
import com.EQCSYS.app.util.ConnectionManager;

public class QuestionBankDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static ResultSet rs1 = null;
	static ResultSet rs2 = null;
	static ResultSet rs3 = null;
	static ResultSet rs4 = null;
	static ResultSet rs5 = null;
	static ResultSet rs6 = null;
	static ResultSet rs7 = null;
	static ResultSet rs8 = null;
	static ResultSet rs9 = null;
	static ResultSet rs10 = null;
	static ResultSet rs11 = null;
	static ResultSet rs12 = null;
	static ResultSet rs13 = null;
	static ResultSet rs14 = null;
	static ResultSet rs15 = null;
	static ResultSet rs16 = null;
	static ResultSet rs17 = null;
	static ResultSet rs18 = null;
	static ResultSet rs19 = null;
	static ResultSet rs20 = null;
	static ResultSet rs21 = null;
	static ResultSet rs22 = null;
	static ResultSet rs23 = null;
	static ResultSet rs24 = null;
	static ResultSet rs25 = null;
	static ResultSet rs26 = null;
	static ResultSet rs27 = null;
	static ResultSet rs28 = null;
	static ResultSet rs29 = null;
	static ResultSet rs30 = null;
	static ResultSet rs31 = null;
	static ResultSet rs32 = null;
	static ResultSet rs33 = null;
	static ResultSet rs34 = null;
	static ResultSet rs35 = null;
	static ResultSet rs36 = null;
	static ResultSet rs37 = null;
	static ResultSet rs38 = null;
	static ResultSet rs39 = null;
	static ResultSet rs40 = null;
	static ResultSet rs41 = null;
	static ResultSet rs42 = null;
	static ResultSet rs43 = null;
	static ResultSet rs44 = null;
	static ResultSet rs45 = null;
	static ResultSet rs46 = null;
	static ResultSet rs47 = null;
	static ResultSet rs48 = null;

	public static QuestionBankBean updateQuestion(QuestionBankBean ques)
			throws SQLException {
		try {
			currentCon = ConnectionManager.getConnection();
			try {
				PreparedStatement ps = currentCon
						.prepareStatement("update questionbank set questionDifficulty=?, questionMarks=?, questionTopicCode=?, questionQuestion=?, questionAnswer=? where questionID=?");
				try {
					ps.setString(1, ques.getQuestionDifficulty());
					ps.setInt(2, ques.getQuestionMarks());
					ps.setString(3, ques.getQuestionTopicCode());
					ps.setString(4, ques.getQuestionQuestion());
					ps.setString(5, ques.getQuestionAnswer());
					ps.setInt(6, ques.getQuestionID());
					ps.executeUpdate();
					ques.setValid(true);
				} finally {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			currentCon.close();
		}
		return ques;
	}

	public static QuestionBankBean deleteQuestion(QuestionBankBean ques)
			throws SQLException {
		// "System.out.println" prints in the console; Normally used to trace
		// the process
		System.out.println("Stage 2 - deleting question...");

		try {
			currentCon = ConnectionManager.getConnection();
			try {
				System.out.println("Stage 3 - deleting question...");
				PreparedStatement ps = currentCon
						.prepareStatement("delete from questionbank where questionID = ?");
				try {
					System.out.println("Stage 4 - deleting question...");
					ps.setInt(1, ques.getQuestionID());
					int i = ps.executeUpdate();
					ques.setValid(true);
					System.out.println("Stage 5 - deleting question...");
					ps.close();
					if (i > 0) {
						System.out
								.println("The question has been deleted successfully….");
					} else {
						System.out
								.println("Question cannot be deleted..Try Again…");
					}
				} catch (SQLException ex) {
					System.out
							.println("Integrity constraint: an exception has occurred! "
									+ ex);
				} finally {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			currentCon.close();
		}
		return ques;
	}

	public static QuestionBankBean createQuestionManual(QuestionBankBean ques)
			throws SQLException {
		try {
			currentCon = ConnectionManager.getConnection();
			try {
				Statement stmt = currentCon.createStatement();
				ResultSet rs = stmt
						.executeQuery("select questionID.nextval from dual");
				boolean more = rs.next();
				// if user does not exist set the isValid variable to false
				if (!more) {
					System.out.println("Sorry, you have no order.");
					ques.setValid(false);
				}
				// if user exists set the isValid variable to true
				else if (more) {
					int questionID = rs.getInt("nextval");
					ques.setQuestionID(questionID);
					ques.setValid(true);
				}

				PreparedStatement ps = currentCon
						.prepareStatement("insert into questionbank values(questionID.currVal,?,?,?,?,?)");
				ps.setString(1, ques.getQuestionDifficulty());
				ps.setInt(2, ques.getQuestionMarks());
				ps.setString(3, ques.getQuestionTopicCode());
				ps.setString(4, ques.getQuestionQuestion());
				ps.setString(5, ques.getQuestionAnswer());
				ps.executeUpdate();
				ques.setValid(true);

				stmt = currentCon.createStatement();
				rs = stmt.executeQuery("select questionID.currval from dual");
				more = rs.next();
				// if user does not exist set the isValid variable to false
				if (!more) {
					System.out.println("Sorry, you have no order.");
					ques.setValid(false);
				}
				// if user exists set the isValid variable to true
				else if (more) {
					int questionID = rs.getInt("currval");
					ques.setQuestionID(questionID);
					ques.setValid(true);
				}
			} catch (Exception e2) {
				System.out.println(e2);
			}
		} finally {
			currentCon.close();
		}
		return ques;
	}

	public static QuestionBankBean createQuestionAuto(QuestionBankBean ques)
			throws SQLException {
		int id = ques.getQuestionID();
		try {
			currentCon = ConnectionManager.getConnection();
			try {
				Statement stmt = currentCon.createStatement();
				rs = stmt
						.executeQuery("select * from questionbankstore where questionID = "
								+ ques.getQuestionID());
				boolean more = rs.next();
				// if user does not exist set the isValid variable to false
				if (!more) {
					System.out.println("Sorry, error!");
					ques.setValid(false);
				}
				// if user exists set the isValid variable to true
				else if (more) {
					ques.setQuestionID(rs.getInt(1));
					ques.setQuestionDifficulty(rs.getString(2));
					ques.setQuestionMarks(rs.getInt(3));
					ques.setQuestionTopicCode(rs.getString(4));
					ques.setQuestionQuestion(rs.getString(5));
					ques.setQuestionAnswer(rs.getString(6));
					ques.setValid(true);
				}

				stmt = currentCon.createStatement();
				ResultSet rs = stmt
						.executeQuery("select questionID.nextval from dual");
				boolean more1 = rs.next();
				// if user does not exist set the isValid variable to false
				if (!more1) {
					System.out.println("Sorry, you have no order.");
					ques.setValid(false);
				}
				// if user exists set the isValid variable to true
				else if (more1) {
					int questionID = rs.getInt("nextval");
					ques.setQuestionID(questionID);
					ques.setValid(true);
				}

				PreparedStatement ps = currentCon
						.prepareStatement("insert into questionbank values(questionID.currVal,?,?,?,?,?)");
				ps.setString(1, ques.getQuestionDifficulty());
				ps.setInt(2, ques.getQuestionMarks());
				ps.setString(3, ques.getQuestionTopicCode());
				ps.setString(4, ques.getQuestionQuestion());
				ps.setString(5, ques.getQuestionAnswer());
				ps.executeUpdate();
				ques.setValid(true);

				stmt = currentCon.createStatement();
				rs = stmt.executeQuery("select questionID.currval from dual");
				more = rs.next();
				// if user does not exist set the isValid variable to false
				if (!more) {
					System.out.println("Sorry, you have no order.");
					ques.setValid(false);
				}
				// if user exists set the isValid variable to true
				else if (more) {
					int questionID = rs.getInt("currval");
					ques.setQuestionID(questionID);
					ques.setValid(true);
				}
				PreparedStatement ps1 = currentCon
						.prepareStatement("delete from questionbankstore where questionID = ?");
				try {
					System.out.println("Stage 4 - deleting question...");
					ps1.setInt(1, id);
					int i = ps1.executeUpdate();
					System.out.println("Stage 5 - deleting question...");
					ps.close();
					if (i > 0) {
						ques.setValid(true);
						System.out
								.println("The question has been deleted successfully….");
					} else {
						System.out
								.println("Question cannot be deleted..Try Again…");
					}
				} catch (SQLException ex) {
					System.out
							.println("Integrity constraint: an exception has occurred! "
									+ ex);
				} finally {
					ps.close();
				}
			} catch (Exception e2) {
				System.out.println(e2);
			}
		} finally {
			currentCon.close();
		}
		return ques;
	}

	public static QuestionBankBean createQuestionAuto(QuestionBankBean ques,
			Connection currentCon) throws SQLException {
		int id = ques.getQuestionID();
		try {
			Statement stmt = currentCon.createStatement();
			rs = stmt
					.executeQuery("select * from questionbanktemp where questionID = "
							+ ques.getQuestionID());
			boolean more = rs.next();
			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out.println("Sorry, error!");
				ques.setValid(false);
			}
			// if user exists set the isValid variable to true
			else if (more) {
				ques.setQuestionID(rs.getInt(1));
				ques.setQuestionDifficulty(rs.getString(2));
				ques.setQuestionMarks(rs.getInt(3));
				ques.setQuestionTopicCode(rs.getString(4));
				ques.setQuestionQuestion(rs.getString(5));
				ques.setQuestionAnswer(rs.getString(6));
				ques.setValid(true);
			}

			stmt = currentCon.createStatement();
			ResultSet rs = stmt
					.executeQuery("select questionIDSTORE.nextval from dual");
			boolean more1 = rs.next();
			// if user does not exist set the isValid variable to false
			if (!more1) {
				System.out.println("Sorry, you have no order.");
				ques.setValid(false);
			}
			// if user exists set the isValid variable to true
			else if (more1) {
				int questionID = rs.getInt("nextval");
				ques.setQuestionID(questionID);
				ques.setValid(true);
			}

			PreparedStatement ps = currentCon
					.prepareStatement("insert into questionbankstore values(questionIDSTORE.currVal,?,?,?,?,?)");
			ps.setString(1, ques.getQuestionDifficulty());
			ps.setInt(2, ques.getQuestionMarks());
			ps.setString(3, ques.getQuestionTopicCode());
			ps.setString(4, ques.getQuestionQuestion());
			ps.setString(5, ques.getQuestionAnswer());
			ps.executeUpdate();
			ques.setValid(true);

			stmt = currentCon.createStatement();
			rs = stmt.executeQuery("select questionIDSTORE.currval from dual");
			more = rs.next();
			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out.println("Sorry, you have no order.");
				ques.setValid(false);
			}
			// if user exists set the isValid variable to true
			else if (more) {
				int questionID = rs.getInt("currval");
				ques.setQuestionID(questionID);
				ques.setValid(true);
			}
			PreparedStatement ps1 = currentCon
					.prepareStatement("delete from questionbanktemp where questionID = ?");
			try {
				System.out.println("Stage 4 - deleting question...");
				ps1.setInt(1, id);
				int i = ps1.executeUpdate();
				System.out.println("Stage 5 - deleting question...");
				ps.close();
				if (i > 0) {
					ques.setValid(true);
					System.out
							.println("The question has been deleted successfully….");
				} else {
					System.out
							.println("Question cannot be deleted..Try Again…");
				}
			} catch (SQLException ex) {
				System.out
						.println("Integrity constraint: an exception has occurred! "
								+ ex);
			} finally {
				ps.close();
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}
		return ques;
	}

	public static QuestionBankBean deleteAutoQuestion(QuestionBankBean ques)
			throws SQLException {
		// "System.out.println" prints in the console; Normally used to trace
		// the process
		System.out.println("Stage 2 - deleting question...");

		try {
			currentCon = ConnectionManager.getConnection();
			try {
				System.out.println("Stage 3 - deleting question...");
				PreparedStatement ps = currentCon
						.prepareStatement("delete from questionbanktemp where questionID = ?");
				PreparedStatement ps1 = currentCon
						.prepareStatement("delete from questionbankstore where questionID = ?");
				try {
					System.out.println("Stage 4 - deleting question...");
					ps.setInt(1, ques.getQuestionID());
					ps1.setInt(1, ques.getQuestionID());
					int i = ps.executeUpdate();
					System.out.println("Stage 5 - deleting question...");
					ps.close();
					if (i > 0) {
						ques.setValid(true);
						System.out
								.println("The question has been deleted successfully….");
					} else {
						System.out
								.println("Question cannot be deleted..Try Again…");
					}
				} catch (SQLException ex) {
					System.out
							.println("Integrity constraint: an exception has occurred! "
									+ ex);
				} finally {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			currentCon.close();
		}
		return ques;
	}

	public static QuestionBankBean deleteAllQuestion(QuestionBankBean ques)
			throws SQLException {
		// "System.out.println" prints in the console; Normally used to trace
		// the process
		System.out.println("Stage 2 - deleting all question...");

		try {
			currentCon = ConnectionManager.getConnection();
			try {
				System.out.println("Stage 3 - deleting all question...");
				PreparedStatement ps = currentCon
						.prepareStatement("delete from questionbanktemp");
				PreparedStatement ps1 = currentCon
						.prepareStatement("delete from questionbankstore");
				try {
					System.out.println("Stage 4 - deleting all question...");
					int i = ps.executeUpdate();
					ps1.executeUpdate();
					System.out.println("Stage 5 - deleting all question...");
					ps.close();
					if (i > 0) {
						ques.setValid(true);
						System.out
								.println("The questions has been deleted successfully….");
					} else {
						System.out
								.println("Questions cannot be deleted..Try Again…");
					}
				} catch (SQLException ex) {
					System.out
							.println("Integrity constraint: an exception has occurred! "
									+ ex);
				} finally {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			currentCon.close();
		}
		return ques;
	}

	public static QuestionBankBean cosineSimilarity(QuestionBankBean ques,
			TokenBean token, DataSourceBean source, String topic)
			throws Exception {
		String no = null;
		if (topic.equalsIgnoreCase("Topic 1")) {
			no = "1";
		} else if (topic.equalsIgnoreCase("Topic 2")) {
			no = "2";
		} else if (topic.equalsIgnoreCase("Topic 3")) {
			no = "3";
		} else if (topic.equalsIgnoreCase("Topic 4")) {
			no = "4";
		} else if (topic.equalsIgnoreCase("Topic 5")) {
			no = "5";
		} else if (topic.equalsIgnoreCase("Topic 6")) {
			no = "6";
		} else if (topic.equalsIgnoreCase("Topic 7")) {
			no = "7";
		} else if (topic.equalsIgnoreCase("Topic 8")) {
			no = "8";
		}
		try {
			currentCon = ConnectionManager.getConnection();
			try {
				QuestionBankBean quesReal = new QuestionBankBean();
				Statement stmt1 = currentCon.createStatement();
				Statement stmt = currentCon.createStatement();
				System.out.println("token compare");
				rs1 = stmt1
						.executeQuery("select * from token where topicCode='"
								+ topic + "'");
				int a = 0;
				while (rs1.next()) {
					System.out
							.println("=======================================Token sentence=========================================");
					String sentence = rs1.getString("sentence");
					System.out.println(sentence);
					System.out.println("question compare");
					rs = stmt.executeQuery("select * from questionbanktemp");
					double ret[] = new double[1000];
					int i = 0;
					while (rs.next()) {
						String question = rs.getString("questionAnswer");
						ques.setQuestionID(rs.getInt("questionID"));
						System.out.println(question);
						ret[i] = CosineDocumentSimilarity.getCosineSimilarity(
								question, sentence);
						File file1 = new File("D:\\EQC-SYS\\COSINE\\TOPIC "
								+ no + "\\" + topic + "_" + no + "_" + a + "_"
								+ i + ".txt");
						FileWriter fw1 = new FileWriter(file1);
						PrintWriter pw1 = new PrintWriter(fw1);
						pw1.println("Question: "
								+ question
								+ "\nToken: "
								+ sentence
								+ "\nCosine Similarity: "
								+ ret[i]);
						pw1.close();
						if (ret[i] > 0.5) {
							System.out
							.println("========Cosine Similarity Test=========");
							System.out.println("test this " + ret[i]);
							quesReal.setQuestionID(rs.getInt("questionID"));
							quesReal.setQuestionDifficulty(rs
									.getString("questionDifficulty"));
							quesReal.setQuestionMarks(rs
									.getInt("questionMarks"));
							quesReal.setQuestionTopicCode(rs
									.getString("questionTopicCode"));
							quesReal.setQuestionQuestion(rs
									.getString("questionQuestion"));
							quesReal.setQuestionAnswer(rs
									.getString("questionAnswer"));
							quesReal = QuestionBankDAO.createQuestionAuto(
									quesReal, currentCon);
						}
						i++;
					}
					a++;
				}
				System.out.println();
				ques.setValid(true);
				currentCon.close();
			} catch (Exception e) {
				System.err.println("Got an exception! ");
				System.err.println(e.getMessage());
			}
		} finally {
			currentCon.close();
		}

		return ques;
	}

	public static QuestionBankBean retrieveQuestion(QuestionBankBean ques,
			TSTBean tst) {
		int QC1_TOPIC1 = Integer.parseInt(tst.getQC1_TOPIC1());
		int QC2_TOPIC1 = Integer.parseInt(tst.getQC2_TOPIC1());
		int QC3_TOPIC1 = Integer.parseInt(tst.getQC3_TOPIC1());
		int QC4_TOPIC1 = Integer.parseInt(tst.getQC4_TOPIC1());
		int QC5_TOPIC1 = Integer.parseInt(tst.getQC5_TOPIC1());
		int QC6_TOPIC1 = Integer.parseInt(tst.getQC6_TOPIC1());
		int QC1_TOPIC2 = Integer.parseInt(tst.getQC1_TOPIC2());
		int QC2_TOPIC2 = Integer.parseInt(tst.getQC2_TOPIC2());
		int QC3_TOPIC2 = Integer.parseInt(tst.getQC3_TOPIC2());
		int QC4_TOPIC2 = Integer.parseInt(tst.getQC4_TOPIC2());
		int QC5_TOPIC2 = Integer.parseInt(tst.getQC5_TOPIC2());
		int QC6_TOPIC2 = Integer.parseInt(tst.getQC6_TOPIC2());
		int QC1_TOPIC3 = Integer.parseInt(tst.getQC1_TOPIC3());
		int QC2_TOPIC3 = Integer.parseInt(tst.getQC2_TOPIC3());
		int QC3_TOPIC3 = Integer.parseInt(tst.getQC3_TOPIC3());
		int QC4_TOPIC3 = Integer.parseInt(tst.getQC4_TOPIC3());
		int QC5_TOPIC3 = Integer.parseInt(tst.getQC5_TOPIC3());
		int QC6_TOPIC3 = Integer.parseInt(tst.getQC6_TOPIC3());
		int QC1_TOPIC4 = Integer.parseInt(tst.getQC1_TOPIC4());
		int QC2_TOPIC4 = Integer.parseInt(tst.getQC2_TOPIC4());
		int QC3_TOPIC4 = Integer.parseInt(tst.getQC3_TOPIC4());
		int QC4_TOPIC4 = Integer.parseInt(tst.getQC4_TOPIC4());
		int QC5_TOPIC4 = Integer.parseInt(tst.getQC5_TOPIC4());
		int QC6_TOPIC4 = Integer.parseInt(tst.getQC6_TOPIC4());
		int QC1_TOPIC5 = Integer.parseInt(tst.getQC1_TOPIC5());
		int QC2_TOPIC5 = Integer.parseInt(tst.getQC2_TOPIC5());
		int QC3_TOPIC5 = Integer.parseInt(tst.getQC3_TOPIC5());
		int QC4_TOPIC5 = Integer.parseInt(tst.getQC4_TOPIC5());
		int QC5_TOPIC5 = Integer.parseInt(tst.getQC5_TOPIC5());
		int QC6_TOPIC5 = Integer.parseInt(tst.getQC6_TOPIC5());
		int QC1_TOPIC6 = Integer.parseInt(tst.getQC1_TOPIC6());
		int QC2_TOPIC6 = Integer.parseInt(tst.getQC2_TOPIC6());
		int QC3_TOPIC6 = Integer.parseInt(tst.getQC3_TOPIC6());
		int QC4_TOPIC6 = Integer.parseInt(tst.getQC4_TOPIC6());
		int QC5_TOPIC6 = Integer.parseInt(tst.getQC5_TOPIC6());
		int QC6_TOPIC6 = Integer.parseInt(tst.getQC6_TOPIC6());
		int QC1_TOPIC7 = Integer.parseInt(tst.getQC1_TOPIC7());
		int QC2_TOPIC7 = Integer.parseInt(tst.getQC2_TOPIC7());
		int QC3_TOPIC7 = Integer.parseInt(tst.getQC3_TOPIC7());
		int QC4_TOPIC7 = Integer.parseInt(tst.getQC4_TOPIC7());
		int QC5_TOPIC7 = Integer.parseInt(tst.getQC5_TOPIC7());
		int QC6_TOPIC7 = Integer.parseInt(tst.getQC6_TOPIC7());
		int QC1_TOPIC8 = Integer.parseInt(tst.getQC1_TOPIC8());
		int QC2_TOPIC8 = Integer.parseInt(tst.getQC2_TOPIC8());
		int QC3_TOPIC8 = Integer.parseInt(tst.getQC3_TOPIC8());
		int QC4_TOPIC8 = Integer.parseInt(tst.getQC4_TOPIC8());
		int QC5_TOPIC8 = Integer.parseInt(tst.getQC5_TOPIC8());
		int QC6_TOPIC8 = Integer.parseInt(tst.getQC6_TOPIC8());

		try {
			currentCon = ConnectionManager.getConnection();
			try {
				Statement stmt = currentCon.createStatement();
				System.out.println("Step 1");
				// Topic 1
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 1' and questionDifficulty='C1' and rownum <= '"
								+ QC1_TOPIC1 + "'");
				System.out.println("Step 2");
				while (rs.next()) {
					System.out.println("Step 3 - in the db");
					System.out.println(rs.getString("questionQuestion"));
					System.out.println(rs.getString("questionAnswer"));
					System.out.println(rs.getString("questionMarks"));
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				System.out.println("Step 4");
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 1' and questionDifficulty='C2' and rownum <= '"
								+ QC2_TOPIC1 + "'");
				System.out.println("Step 5");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				System.out.println("Step 7");
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 1' and questionDifficulty='C3' and rownum <= '"
								+ QC3_TOPIC1 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 1' and questionDifficulty='C4' and rownum <= '"
								+ QC4_TOPIC1 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 1' and questionDifficulty='C5' and rownum <= '"
								+ QC5_TOPIC1 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 1' and questionDifficulty='C6' and rownum <= '"
								+ QC6_TOPIC1 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}

				// Topic 2
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 2' and questionDifficulty='C1' and rownum <= '"
								+ QC1_TOPIC2 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 2' and questionDifficulty='C2' and rownum <= '"
								+ QC2_TOPIC2 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 2' and questionDifficulty='C3' and rownum <= '"
								+ QC3_TOPIC2 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 2' and questionDifficulty='C4' and rownum <= '"
								+ QC4_TOPIC2 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 2' and questionDifficulty='C5' and rownum <= '"
								+ QC5_TOPIC2 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 2' and questionDifficulty='C6' and rownum <= '"
								+ QC6_TOPIC2 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}

				// Topic 3
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 3' and questionDifficulty='C1' and rownum <= '"
								+ QC1_TOPIC3 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 3' and questionDifficulty='C2' and rownum <= '"
								+ QC2_TOPIC3 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 3' and questionDifficulty='C3' and rownum <= '"
								+ QC3_TOPIC3 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 3' and questionDifficulty='C4' and rownum <= '"
								+ QC4_TOPIC3 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 3' and questionDifficulty='C5' and rownum <= '"
								+ QC5_TOPIC3 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 3' and questionDifficulty='C6' and rownum <= '"
								+ QC6_TOPIC3 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}

				// Topic 4
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 4' and questionDifficulty='C1' and rownum <= '"
								+ QC1_TOPIC4 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 4' and questionDifficulty='C2' and rownum <= '"
								+ QC2_TOPIC4 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 4' and questionDifficulty='C3' and rownum <= '"
								+ QC3_TOPIC4 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 4' and questionDifficulty='C4' and rownum <= '"
								+ QC4_TOPIC4 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 4' and questionDifficulty='C5' and rownum <= '"
								+ QC5_TOPIC4 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 4' and questionDifficulty='C6' and rownum <= '"
								+ QC6_TOPIC4 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}

				// Topic 5
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 5' and questionDifficulty='C1' and rownum <= '"
								+ QC1_TOPIC5 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 5' and questionDifficulty='C2' and rownum <= '"
								+ QC2_TOPIC5 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 5' and questionDifficulty='C3' and rownum <= '"
								+ QC3_TOPIC5 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 5' and questionDifficulty='C4' and rownum <= '"
								+ QC4_TOPIC5 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 5' and questionDifficulty='C5' and rownum <= '"
								+ QC5_TOPIC5 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 5' and questionDifficulty='C6' and rownum <= '"
								+ QC6_TOPIC5 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}

				// Topic 6
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 6' and questionDifficulty='C1' and rownum <= '"
								+ QC1_TOPIC6 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 6' and questionDifficulty='C2' and rownum <= '"
								+ QC2_TOPIC6 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 6' and questionDifficulty='C3' and rownum <= '"
								+ QC3_TOPIC6 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 6' and questionDifficulty='C4' and rownum <= '"
								+ QC4_TOPIC6 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 6' and questionDifficulty='C5' and rownum <= '"
								+ QC5_TOPIC6 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 6' and questionDifficulty='C6' and rownum <= '"
								+ QC6_TOPIC6 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}

				// Topic 7
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 7' and questionDifficulty='C1' and rownum <= '"
								+ QC1_TOPIC7 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 7' and questionDifficulty='C2' and rownum <= '"
								+ QC2_TOPIC7 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 7' and questionDifficulty='C3' and rownum <= '"
								+ QC3_TOPIC7 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 7' and questionDifficulty='C4' and rownum <= '"
								+ QC4_TOPIC7 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 7' and questionDifficulty='C5' and rownum <= '"
								+ QC5_TOPIC7 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 7' and questionDifficulty='C6' and rownum <= '"
								+ QC6_TOPIC7 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}

				// Topic 8
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 8' and questionDifficulty='C1' and rownum <= '"
								+ QC1_TOPIC8 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 8' and questionDifficulty='C2' and rownum <= '"
								+ QC2_TOPIC8 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 8' and questionDifficulty='C3' and rownum <= '"
								+ QC3_TOPIC8 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 8' and questionDifficulty='C4' and rownum <= '"
								+ QC4_TOPIC8 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 8' and questionDifficulty='C5' and rownum <= '"
								+ QC5_TOPIC8 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
				rs = stmt
						.executeQuery("SELECT * FROM (SELECT * FROM  questionbank ORDER BY DBMS_RANDOM.RANDOM) WHERE  questionTopicCode='Topic 8' and questionDifficulty='C6' and rownum <= '"
								+ QC6_TOPIC8 + "'");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					try {
						PreparedStatement ps = currentCon
								.prepareStatement("insert into exampaper values(?,?,?,?,?,?)");
						System.out.println("ques!!!");
						ps.setInt(1, ques.getQuestionID());
						System.out.println("ques!!!");
						ps.setString(2, ques.getQuestionDifficulty());
						System.out.println("ques!!!");
						ps.setInt(3, ques.getQuestionMarks());
						System.out.println("ques!!!");
						ps.setString(4, ques.getQuestionTopicCode());
						System.out.println("ques!!!");
						ps.setString(5, ques.getQuestionQuestion());
						System.out.println("ques!!!");
						ps.setString(6, ques.getQuestionAnswer());
						ps.executeUpdate();
						ques.setValid(true);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}

			} catch (Exception e2) {
				System.out.println(e2);
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}
		return ques;
	}

	public static QuestionBankBean generateExamPaper(QuestionBankBean ques, String examMonth,
			String examYear, String examDuration) {
		try {
			String filename = "EXAM PAPER";
			String filename2 = "ANSWER SCHEMES";

			DocumentCreation.generateExamPaper(examMonth, examYear,
					examDuration, filename);
			DocumentCreation.generateAnswerSchemes(examMonth, examYear, examDuration, filename2);
			try {
				currentCon = ConnectionManager.getConnection();
				try {
					System.out.println("Stage 3 - deleting all question...");
					PreparedStatement ps = currentCon
							.prepareStatement("delete from exampaper");
					try {
						System.out.println("Stage 4 - deleting all question...");
						int i = ps.executeUpdate();
						System.out.println("Stage 5 - deleting all question...");
						ps.close();
						if (i > 0) {
							ques.setValid(true);
							System.out
									.println("The questions has been deleted successfully….");
						} else {
							System.out
									.println("Questions cannot be deleted..Try Again…");
						}
					} catch (SQLException ex) {
						System.out
								.println("Integrity constraint: an exception has occurred! "
										+ ex);
					} finally {
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} finally {
				currentCon.close();
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}
		return ques;
	}
}