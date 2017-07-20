package com.EQCSYS.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.EQCSYS.app.bean.QuestionBankBean;
import com.EQCSYS.app.bean.TSTBean;
import com.EQCSYS.app.util.ConnectionManager;

public class TSTDAO {
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
	static ResultSet rs49 = null;
	static ResultSet rs50 = null;
	static ResultSet rs51 = null;
	static ResultSet rs52 = null;
	static ResultSet rs53 = null;
	static ResultSet rs54 = null;
	static ResultSet rs55 = null;
	static ResultSet rs56 = null;

	public static TSTBean tstValidate(TSTBean tst) throws SQLException {
		int TOTALQ_ALL = Integer.parseInt(tst.getTOTALQ_ALL());
		int QC1_TOPIC1 = Integer.parseInt(tst.getQC1_TOPIC1());
		int QC2_TOPIC1 = Integer.parseInt(tst.getQC2_TOPIC1());
		int QC3_TOPIC1 = Integer.parseInt(tst.getQC3_TOPIC1());
		int QC4_TOPIC1 = Integer.parseInt(tst.getQC4_TOPIC1());
		int QC5_TOPIC1 = Integer.parseInt(tst.getQC5_TOPIC1());
		int QC6_TOPIC1 = Integer.parseInt(tst.getQC6_TOPIC1());
		int TOTALQ_TOPIC1 = Integer.parseInt(tst.getTOTALQ_TOPIC1());
		int QC1_TOPIC2 = Integer.parseInt(tst.getQC1_TOPIC2());
		int QC2_TOPIC2 = Integer.parseInt(tst.getQC2_TOPIC2());
		int QC3_TOPIC2 = Integer.parseInt(tst.getQC3_TOPIC2());
		int QC4_TOPIC2 = Integer.parseInt(tst.getQC4_TOPIC2());
		int QC5_TOPIC2 = Integer.parseInt(tst.getQC5_TOPIC2());
		int QC6_TOPIC2 = Integer.parseInt(tst.getQC6_TOPIC2());
		int TOTALQ_TOPIC2 = Integer.parseInt(tst.getTOTALQ_TOPIC2());
		int QC1_TOPIC3 = Integer.parseInt(tst.getQC1_TOPIC3());
		int QC2_TOPIC3 = Integer.parseInt(tst.getQC2_TOPIC3());
		int QC3_TOPIC3 = Integer.parseInt(tst.getQC3_TOPIC3());
		int QC4_TOPIC3 = Integer.parseInt(tst.getQC4_TOPIC3());
		int QC5_TOPIC3 = Integer.parseInt(tst.getQC5_TOPIC3());
		int QC6_TOPIC3 = Integer.parseInt(tst.getQC6_TOPIC3());
		int TOTALQ_TOPIC3 = Integer.parseInt(tst.getTOTALQ_TOPIC3());
		int QC1_TOPIC4 = Integer.parseInt(tst.getQC1_TOPIC4());
		int QC2_TOPIC4 = Integer.parseInt(tst.getQC2_TOPIC4());
		int QC3_TOPIC4 = Integer.parseInt(tst.getQC3_TOPIC4());
		int QC4_TOPIC4 = Integer.parseInt(tst.getQC4_TOPIC4());
		int QC5_TOPIC4 = Integer.parseInt(tst.getQC5_TOPIC4());
		int QC6_TOPIC4 = Integer.parseInt(tst.getQC6_TOPIC4());
		int TOTALQ_TOPIC4 = Integer.parseInt(tst.getTOTALQ_TOPIC4());
		int QC1_TOPIC5 = Integer.parseInt(tst.getQC1_TOPIC5());
		int QC2_TOPIC5 = Integer.parseInt(tst.getQC2_TOPIC5());
		int QC3_TOPIC5 = Integer.parseInt(tst.getQC3_TOPIC5());
		int QC4_TOPIC5 = Integer.parseInt(tst.getQC4_TOPIC5());
		int QC5_TOPIC5 = Integer.parseInt(tst.getQC5_TOPIC5());
		int QC6_TOPIC5 = Integer.parseInt(tst.getQC6_TOPIC5());
		int TOTALQ_TOPIC5 = Integer.parseInt(tst.getTOTALQ_TOPIC5());
		int QC1_TOPIC6 = Integer.parseInt(tst.getQC1_TOPIC6());
		int QC2_TOPIC6 = Integer.parseInt(tst.getQC2_TOPIC6());
		int QC3_TOPIC6 = Integer.parseInt(tst.getQC3_TOPIC6());
		int QC4_TOPIC6 = Integer.parseInt(tst.getQC4_TOPIC6());
		int QC5_TOPIC6 = Integer.parseInt(tst.getQC5_TOPIC6());
		int QC6_TOPIC6 = Integer.parseInt(tst.getQC6_TOPIC6());
		int TOTALQ_TOPIC6 = Integer.parseInt(tst.getTOTALQ_TOPIC6());
		int QC1_TOPIC7 = Integer.parseInt(tst.getQC1_TOPIC7());
		int QC2_TOPIC7 = Integer.parseInt(tst.getQC2_TOPIC7());
		int QC3_TOPIC7 = Integer.parseInt(tst.getQC3_TOPIC7());
		int QC4_TOPIC7 = Integer.parseInt(tst.getQC4_TOPIC7());
		int QC5_TOPIC7 = Integer.parseInt(tst.getQC5_TOPIC7());
		int QC6_TOPIC7 = Integer.parseInt(tst.getQC6_TOPIC7());
		int TOTALQ_TOPIC7 = Integer.parseInt(tst.getTOTALQ_TOPIC7());
		int QC1_TOPIC8 = Integer.parseInt(tst.getQC1_TOPIC8());
		int QC2_TOPIC8 = Integer.parseInt(tst.getQC2_TOPIC8());
		int QC3_TOPIC8 = Integer.parseInt(tst.getQC3_TOPIC8());
		int QC4_TOPIC8 = Integer.parseInt(tst.getQC4_TOPIC8());
		int QC5_TOPIC8 = Integer.parseInt(tst.getQC5_TOPIC8());
		int QC6_TOPIC8 = Integer.parseInt(tst.getQC6_TOPIC8());
		int TOTALQ_TOPIC8 = Integer.parseInt(tst.getTOTALQ_TOPIC8());
		try {
			currentCon = ConnectionManager.getConnection();
			try {
				Statement stmt = currentCon.createStatement();
				// All Questions Count
				rs = stmt.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK");
				rs.next();
				int countTOTALQ_ALL = rs.getInt(1);
				System.out.println("All Questions: " + countTOTALQ_ALL);

				// Questions Count Topic
				rs1 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 1'");
				rs1.next();
				int countTOTALQ_TOPIC1 = rs1.getInt(1);
				System.out.println("Topic 1: " + countTOTALQ_TOPIC1);

				rs2 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 2'");
				rs2.next();
				int countTOTALQ_TOPIC2 = rs2.getInt(1);
				System.out.println("Topic 2: " + countTOTALQ_TOPIC2);

				rs3 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 3'");
				rs3.next();
				int countTOTALQ_TOPIC3 = rs3.getInt(1);
				System.out.println("Topic 3: " + countTOTALQ_TOPIC3);

				rs4 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 4'");
				rs4.next();
				int countTOTALQ_TOPIC4 = rs4.getInt(1);
				System.out.println("Topic 4: " + countTOTALQ_TOPIC4);

				rs5 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 5'");
				rs5.next();
				int countTOTALQ_TOPIC5 = rs5.getInt(1);
				System.out.println("Topic 5: " + countTOTALQ_TOPIC5);

				rs6 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 6'");
				rs6.next();
				int countTOTALQ_TOPIC6 = rs6.getInt(1);
				System.out.println("Topic 6: " + countTOTALQ_TOPIC6);

				rs7 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 7'");
				rs7.next();
				int countTOTALQ_TOPIC7 = rs7.getInt(1);
				System.out.println("Topic 7: " + countTOTALQ_TOPIC7);

				rs8 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 8'");
				rs8.next();
				int countTOTALQ_TOPIC8 = rs8.getInt(1);
				System.out.println("Topic 8: " + countTOTALQ_TOPIC8);

				// Topic 1
				rs9 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 1' and questionDifficulty='C1'");
				rs9.next();
				int countQC1_TOPIC1 = rs9.getInt(1);
				System.out.println("Topic 1 C1: " + countQC1_TOPIC1);
				System.out.println("Topic 1 C1: " + QC1_TOPIC1);

				rs10 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 1' and questionDifficulty='C2'");
				rs10.next();
				int countQC2_TOPIC1 = rs10.getInt(1);
				System.out.println("Topic 1 C2: " + countQC2_TOPIC1);

				rs11 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 1' and questionDifficulty='C3'");
				rs11.next();
				int countQC3_TOPIC1 = rs11.getInt(1);
				System.out.println("Topic 1 C3: " + countQC3_TOPIC1);

				rs12 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 1' and questionDifficulty='C4'");
				rs12.next();
				int countQC4_TOPIC1 = rs12.getInt(1);
				System.out.println("Topic 1 C4: " + countQC4_TOPIC1);

				rs13 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 1' and questionDifficulty='C5'");
				rs13.next();
				int countQC5_TOPIC1 = rs13.getInt(1);
				System.out.println("Topic 1 C5: " + countQC5_TOPIC1);

				rs14 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 1' and questionDifficulty='C6'");
				rs14.next();
				int countQC6_TOPIC1 = rs14.getInt(1);
				System.out.println("Topic 1 C6: " + countQC6_TOPIC1);

				// Topic 2
				rs15 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 2' and questionDifficulty='C1'");
				rs15.next();
				int countQC1_TOPIC2 = rs15.getInt(1);
				System.out.println("Topic 2 C1: " + countQC1_TOPIC2);

				rs16 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 2' and questionDifficulty='C2'");
				rs16.next();
				int countQC2_TOPIC2 = rs16.getInt(1);
				System.out.println("Topic 2 C2: " + countQC2_TOPIC2);

				rs17 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 2' and questionDifficulty='C3'");
				rs17.next();
				int countQC3_TOPIC2 = rs17.getInt(1);
				System.out.println("Topic 2 C3: " + countQC3_TOPIC2);

				rs18 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 2' and questionDifficulty='C4'");
				rs18.next();
				int countQC4_TOPIC2 = rs18.getInt(1);
				System.out.println("Topic 2 C4: " + countQC4_TOPIC2);

				rs19 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 2' and questionDifficulty='C5'");
				rs19.next();
				int countQC5_TOPIC2 = rs19.getInt(1);
				System.out.println("Topic 2 C5: " + countQC5_TOPIC2);

				rs20 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 2' and questionDifficulty='C6'");
				rs20.next();
				int countQC6_TOPIC2 = rs20.getInt(1);
				System.out.println("Topic 2 C6: " + countQC6_TOPIC2);

				// Topic 3
				rs21 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 3' and questionDifficulty='C1'");
				rs21.next();
				int countQC1_TOPIC3 = rs21.getInt(1);
				System.out.println("Topic 3 C1: " + countQC1_TOPIC3);

				rs22 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 3' and questionDifficulty='C2'");
				rs22.next();
				int countQC2_TOPIC3 = rs22.getInt(1);
				System.out.println("Topic 3 C2: " + countQC2_TOPIC3);

				rs23 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 3' and questionDifficulty='C3'");
				rs23.next();
				int countQC3_TOPIC3 = rs23.getInt(1);
				System.out.println("Topic 3 C3: " + countQC3_TOPIC3);

				rs24 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 3' and questionDifficulty='C4'");
				rs24.next();
				int countQC4_TOPIC3 = rs24.getInt(1);
				System.out.println("Topic 3 C4: " + countQC4_TOPIC3);

				rs25 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 3' and questionDifficulty='C5'");
				rs25.next();
				int countQC5_TOPIC3 = rs25.getInt(1);
				System.out.println("Topic 3 C5: " + countQC5_TOPIC3);

				rs26 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 3' and questionDifficulty='C6'");
				rs26.next();
				int countQC6_TOPIC3 = rs26.getInt(1);
				System.out.println("Topic 3 C6: " + countQC6_TOPIC3);

				// Topic 4
				rs27 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 4' and questionDifficulty='C1'");
				rs27.next();
				int countQC1_TOPIC4 = rs27.getInt(1);
				System.out.println("Topic 4 C1: " + countQC1_TOPIC4);

				rs28 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 4' and questionDifficulty='C2'");
				rs28.next();
				int countQC2_TOPIC4 = rs28.getInt(1);
				System.out.println("Topic 4 C2: " + countQC2_TOPIC4);

				rs29 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 4' and questionDifficulty='C3'");
				rs29.next();
				int countQC3_TOPIC4 = rs29.getInt(1);
				System.out.println("Topic 4 C3: " + countQC3_TOPIC4);

				rs30 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 4' and questionDifficulty='C4'");
				rs30.next();
				int countQC4_TOPIC4 = rs30.getInt(1);
				System.out.println("Topic 4 C4: " + countQC4_TOPIC4);

				rs31 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 4' and questionDifficulty='C5'");
				rs31.next();
				int countQC5_TOPIC4 = rs31.getInt(1);
				System.out.println("Topic 4 C5: " + countQC5_TOPIC4);

				rs32 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 4' and questionDifficulty='C6'");
				rs32.next();
				int countQC6_TOPIC4 = rs32.getInt(1);
				System.out.println("Topic 4 C6: " + countQC6_TOPIC4);

				// Topic 5
				rs33 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 5' and questionDifficulty='C1'");
				rs33.next();
				int countQC1_TOPIC5 = rs33.getInt(1);
				System.out.println("Topic 5 C1: " + countQC1_TOPIC5);

				rs34 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 5' and questionDifficulty='C2'");
				rs34.next();
				int countQC2_TOPIC5 = rs34.getInt(1);
				System.out.println("Topic 5 C2: " + countQC2_TOPIC5);

				rs35 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 5' and questionDifficulty='C3'");
				rs35.next();
				int countQC3_TOPIC5 = rs35.getInt(1);
				System.out.println("Topic 5 C3: " + countQC3_TOPIC5);

				rs36 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 5' and questionDifficulty='C4'");
				rs36.next();
				int countQC4_TOPIC5 = rs36.getInt(1);
				System.out.println("Topic 5 C4: " + countQC4_TOPIC5);

				rs37 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 5' and questionDifficulty='C5'");
				rs37.next();
				int countQC5_TOPIC5 = rs37.getInt(1);
				System.out.println("Topic 5 C5: " + countQC5_TOPIC5);

				rs38 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 5' and questionDifficulty='C6'");
				rs38.next();
				int countQC6_TOPIC5 = rs38.getInt(1);
				System.out.println("Topic 5 C6: " + countQC6_TOPIC5);

				// Topic 6
				rs39 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 6' and questionDifficulty='C1'");
				rs39.next();
				int countQC1_TOPIC6 = rs39.getInt(1);
				System.out.println("Topic 6 C1: " + countQC1_TOPIC6);

				rs40 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 6' and questionDifficulty='C2'");
				rs40.next();
				int countQC2_TOPIC6 = rs40.getInt(1);
				System.out.println("Topic 6 C2: " + countQC2_TOPIC6);

				rs41 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 6' and questionDifficulty='C3'");
				rs41.next();
				int countQC3_TOPIC6 = rs41.getInt(1);
				System.out.println("Topic 6 C3: " + countQC3_TOPIC6);

				rs42 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 6' and questionDifficulty='C4'");
				rs42.next();
				int countQC4_TOPIC6 = rs42.getInt(1);
				System.out.println("Topic 6 C4: " + countQC4_TOPIC6);

				rs43 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 6' and questionDifficulty='C5'");
				rs43.next();
				int countQC5_TOPIC6 = rs43.getInt(1);
				System.out.println("Topic 6 C5: " + countQC5_TOPIC6);

				rs44 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 6' and questionDifficulty='C6'");
				rs44.next();
				int countQC6_TOPIC6 = rs44.getInt(1);
				System.out.println("Topic 6 C6: " + countQC6_TOPIC6);

				// Topic 7
				rs45 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 7' and questionDifficulty='C1'");
				rs45.next();
				int countQC1_TOPIC7 = rs45.getInt(1);
				System.out.println("Topic 7 C1: " + countQC1_TOPIC7);

				rs46 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 7' and questionDifficulty='C2'");
				rs46.next();
				int countQC2_TOPIC7 = rs46.getInt(1);
				System.out.println("Topic 7 C2: " + countQC2_TOPIC7);

				rs47 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 7' and questionDifficulty='C3'");
				rs47.next();
				int countQC3_TOPIC7 = rs47.getInt(1);
				System.out.println("Topic 7 C3: " + countQC3_TOPIC7);

				rs48 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 7' and questionDifficulty='C4'");
				rs48.next();
				int countQC4_TOPIC7 = rs48.getInt(1);
				System.out.println("Topic 7 C4: " + countQC4_TOPIC7);

				rs49 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 7' and questionDifficulty='C5'");
				rs49.next();
				int countQC5_TOPIC7 = rs49.getInt(1);
				System.out.println("Topic 7 C5: " + countQC5_TOPIC7);

				rs50 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 7' and questionDifficulty='C6'");
				rs50.next();
				int countQC6_TOPIC7 = rs50.getInt(1);
				System.out.println("Topic 7 C6: " + countQC6_TOPIC7);

				// Topic 8
				rs51 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 8' and questionDifficulty='C1'");
				rs51.next();
				int countQC1_TOPIC8 = rs51.getInt(1);
				System.out.println("Topic 8 C1: " + countQC1_TOPIC8);

				rs52 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 8' and questionDifficulty='C2'");
				rs52.next();
				int countQC2_TOPIC8 = rs52.getInt(1);
				System.out.println("Topic 8 C2: " + countQC2_TOPIC8);

				rs53 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 8' and questionDifficulty='C3'");
				rs53.next();
				int countQC3_TOPIC8 = rs53.getInt(1);
				System.out.println("Topic 8 C3: " + countQC3_TOPIC8);

				rs54 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 8' and questionDifficulty='C4'");
				rs54.next();
				int countQC4_TOPIC8 = rs54.getInt(1);
				System.out.println("Topic 8 C4: " + countQC4_TOPIC8);

				rs55 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 8' and questionDifficulty='C5'");
				rs55.next();
				int countQC5_TOPIC8 = rs55.getInt(1);
				System.out.println("Topic 8 C5: " + countQC5_TOPIC8);

				rs56 = stmt
						.executeQuery("SELECT COUNT(*) FROM QUESTIONBANK WHERE questionTopicCode='Topic 8' and questionDifficulty='C6'");
				rs56.next();
				int countQC6_TOPIC8 = rs56.getInt(1);
				System.out.println("Topic 8 C6: " + countQC6_TOPIC8);

				// validation on all questions
				tst.setValid(false);
				if (countTOTALQ_ALL >= TOTALQ_ALL) {
					// validation on topics
					if (countTOTALQ_TOPIC1 >= TOTALQ_TOPIC1) {
						if (countTOTALQ_TOPIC2 >= TOTALQ_TOPIC2) {
							if (countTOTALQ_TOPIC3 >= TOTALQ_TOPIC3) {
								if (countTOTALQ_TOPIC4 >= TOTALQ_TOPIC4) {
									if (countTOTALQ_TOPIC5 >= TOTALQ_TOPIC5) {
										if (countTOTALQ_TOPIC6 >= TOTALQ_TOPIC6) {
											if (countTOTALQ_TOPIC8 >= TOTALQ_TOPIC8) {
												if (countTOTALQ_TOPIC7 >= TOTALQ_TOPIC7) {
													// validation on topic 1
													if (countQC1_TOPIC1 >= QC1_TOPIC1) {
														if (countQC2_TOPIC1 >= QC2_TOPIC1) {
															if (countQC3_TOPIC1 >= QC3_TOPIC1) {
																if (countQC4_TOPIC1 >= QC4_TOPIC1) {
																	if (countQC5_TOPIC1 >= QC5_TOPIC1) {
																		if (countQC6_TOPIC1 >= QC6_TOPIC1) {
																			// validation
																			// on
																			// topic
																			// 2
																			if (countQC1_TOPIC2 >= QC1_TOPIC2) {
																				if (countQC2_TOPIC2 >= QC2_TOPIC2) {
																					if (countQC3_TOPIC2 >= QC3_TOPIC2) {
																						if (countQC4_TOPIC2 >= QC4_TOPIC2) {
																							if (countQC5_TOPIC2 >= QC5_TOPIC2) {
																								if (countQC6_TOPIC2 >= QC6_TOPIC2) {
																									// validation
																									// on
																									// topic
																									// 3
																									if (countQC1_TOPIC3 >= QC1_TOPIC3) {
																										if (countQC2_TOPIC3 >= QC2_TOPIC3) {
																											if (countQC3_TOPIC3 >= QC3_TOPIC3) {
																												if (countQC4_TOPIC3 >= QC4_TOPIC3) {
																													if (countQC5_TOPIC3 >= QC5_TOPIC3) {
																														if (countQC6_TOPIC3 >= QC6_TOPIC3) {
																															// validation
																															// on
																															// topic
																															// 4
																															if (countQC1_TOPIC4 >= QC1_TOPIC4) {
																																if (countQC2_TOPIC4 >= QC2_TOPIC4) {
																																	if (countQC3_TOPIC4 >= QC3_TOPIC4) {
																																		if (countQC4_TOPIC4 >= QC4_TOPIC4) {
																																			if (countQC5_TOPIC4 >= QC5_TOPIC4) {
																																				if (countQC6_TOPIC4 >= QC6_TOPIC4) {
																																					// validation
																																					// on
																																					// topic
																																					// 5
																																					if (countQC1_TOPIC5 >= QC1_TOPIC5) {
																																						if (countQC2_TOPIC5 >= QC2_TOPIC5) {
																																							if (countQC3_TOPIC5 >= QC3_TOPIC5) {
																																								if (countQC4_TOPIC5 >= QC4_TOPIC5) {
																																									if (countQC5_TOPIC5 >= QC5_TOPIC5) {
																																										if (countQC6_TOPIC5 >= QC6_TOPIC5) {
																																											// validation
																																											// on
																																											// topic
																																											// 6
																																											if (countQC1_TOPIC6 >= QC1_TOPIC6) {
																																												if (countQC2_TOPIC6 >= QC2_TOPIC6) {
																																													if (countQC3_TOPIC6 >= QC3_TOPIC6) {
																																														if (countQC4_TOPIC6 >= QC4_TOPIC6) {
																																															if (countQC5_TOPIC6 >= QC5_TOPIC6) {
																																																if (countQC6_TOPIC6 >= QC6_TOPIC6) {
																																																	// validation
																																																	// on
																																																	// topic
																																																	// 7
																																																	if (countQC1_TOPIC7 >= QC1_TOPIC7) {
																																																		if (countQC2_TOPIC7 >= QC2_TOPIC7) {
																																																			if (countQC3_TOPIC7 >= QC3_TOPIC7) {
																																																				if (countQC4_TOPIC7 >= QC4_TOPIC7) {
																																																					if (countQC5_TOPIC7 >= QC5_TOPIC7) {
																																																						if (countQC6_TOPIC7 >= QC6_TOPIC7) {
																																																							// validation
																																																							// on
																																																							// topic
																																																							// 8
																																																							if (countQC1_TOPIC8 >= QC1_TOPIC8) {
																																																								if (countQC2_TOPIC8 >= QC2_TOPIC8) {
																																																									if (countQC3_TOPIC8 >= QC3_TOPIC8) {
																																																										if (countQC4_TOPIC8 >= QC4_TOPIC8) {
																																																											if (countQC5_TOPIC8 >= QC5_TOPIC8) {
																																																												if (countQC6_TOPIC8 >= QC6_TOPIC8) {
																																																													tst.setValid(true);
																																																												} else {
																																																													tst.setValid(false);
																																																												}
																																																											} else {
																																																												tst.setValid(false);
																																																											}
																																																										} else {
																																																											tst.setValid(false);
																																																										}
																																																									} else {
																																																										tst.setValid(false);
																																																									}
																																																								} else {
																																																									tst.setValid(false);
																																																								}
																																																							} else {
																																																								tst.setValid(false);
																																																							}
																																																						} else {
																																																							tst.setValid(false);
																																																						}
																																																					} else {
																																																						tst.setValid(false);
																																																					}
																																																				} else {
																																																					tst.setValid(false);
																																																				}
																																																			} else {
																																																				tst.setValid(false);
																																																			}
																																																		} else {
																																																			tst.setValid(false);
																																																		}
																																																	} else {
																																																		tst.setValid(false);
																																																	}
																																																} else {
																																																	tst.setValid(false);
																																																}
																																															} else {
																																																tst.setValid(false);
																																															}
																																														} else {
																																															tst.setValid(false);
																																														}
																																													} else {
																																														tst.setValid(false);
																																													}
																																												} else {
																																													tst.setValid(false);
																																												}
																																											} else {
																																												tst.setValid(false);
																																											}
																																										} else {
																																											tst.setValid(false);
																																										}
																																									} else {
																																										tst.setValid(false);
																																									}
																																								} else {
																																									tst.setValid(false);
																																								}
																																							} else {
																																								tst.setValid(false);
																																							}
																																						} else {
																																							tst.setValid(false);
																																						}
																																					} else {
																																						tst.setValid(false);
																																					}
																																				} else {
																																					tst.setValid(false);
																																				}
																																			} else {
																																				tst.setValid(false);
																																			}
																																		} else {
																																			tst.setValid(false);
																																		}
																																	} else {
																																		tst.setValid(false);
																																	}
																																} else {
																																	tst.setValid(false);
																																}
																															} else {
																																tst.setValid(false);
																															}
																														} else {
																															tst.setValid(false);
																														}
																													} else {
																														tst.setValid(false);
																													}
																												} else {
																													tst.setValid(false);
																												}
																											} else {
																												tst.setValid(false);
																											}
																										} else {
																											tst.setValid(false);
																										}
																									} else {
																										tst.setValid(false);
																									}
																								} else {
																									tst.setValid(false);
																								}
																							} else {
																								tst.setValid(false);
																							}
																						} else {
																							tst.setValid(false);
																						}
																					} else {
																						tst.setValid(false);
																					}
																				} else {
																					tst.setValid(false);
																				}
																			} else {
																				tst.setValid(false);
																			}
																		} else {
																			tst.setValid(false);
																		}
																	} else {
																		tst.setValid(false);
																	}
																} else {
																	tst.setValid(false);
																}
															} else {
																tst.setValid(false);
															}
														} else {
															tst.setValid(false);
														}
													} else {
														tst.setValid(false);
													}
												} else {
													tst.setValid(false);
												}
											} else {
												tst.setValid(false);
											}
										} else {
											tst.setValid(false);
										}
									} else {
										tst.setValid(false);
									}
								} else {
									tst.setValid(false);
								}
							} else {
								tst.setValid(false);
							}
						} else {
							tst.setValid(false);
						}
					} else {
						tst.setValid(false);
					}

				} else {
					tst.setValid(false);
				}

			} catch (Exception e2) {
				System.out.println(e2);
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}
		return tst;
	}
}
