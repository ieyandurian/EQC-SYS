package com.EQCSYS.app.exampapercreation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import com.EQCSYS.app.bean.QuestionBankBean;
import com.EQCSYS.app.util.ConnectionManager;

public class DocumentCreation {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static void drawTable(PDPage page,
			PDPageContentStream contentStream, float y, float margin,
			String[][] content) throws IOException {
		final int rows = content.length;
		final int cols = content[0].length;
		final float rowHeight = 25f;
		final float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
		final float tableHeight = rowHeight * rows;
		final float colWidth = tableWidth / (float) cols;
		final float cellMargin = 10f;

		// draw the rows
		float nexty = y;
		for (int i = 0; i <= rows; i++) {
			if (i == 0 || i == rows) {
				contentStream.drawLine(margin, nexty, margin + tableWidth,
						nexty);
			}
			nexty -= rowHeight;
		}

		// draw the columns
		float nextx = margin;
		for (int i = 0; i <= cols; i++) {
			if (i == 0 || i == cols) {
				contentStream.drawLine(nextx, y, nextx, y - tableHeight);
			}
			nextx += colWidth;
		}

		// now add the text
		contentStream.setFont(PDType1Font.HELVETICA_BOLD, 13);
		float textx = margin + cellMargin;
		float texty = y - 30;
		for (int i = 0; i < content.length; i++) {
			for (int j = 0; j < content[i].length; j++) {
				String text = content[i][j];
				contentStream.beginText();
				contentStream.moveTextPositionByAmount(textx, texty);
				contentStream.drawString(text);
				contentStream.endText();
				textx += colWidth;
			}
			texty -= rowHeight;
			textx = margin + cellMargin;
		}
	}

	@SuppressWarnings("deprecation")
	public static void generateExamPaper(String examMonth, String examYear,
			String examDuration, String filename) throws IOException,
			SQLException {
		String heading = null;
		String month = null;
		System.out.println("1");

		if (examMonth.equalsIgnoreCase("JANUARY")
				|| examMonth.equalsIgnoreCase("DECEMBER")) {
			month = examMonth.substring(0, 3);
		} else {
			month = examMonth;
		}

		// Create a document and add a page to it
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage(page);

		// Create a new font object selecting one of the PDF base fonts
		PDFont font = PDType1Font.HELVETICA_BOLD;
		PDFont font1 = PDType1Font.HELVETICA;
		PDFont font2 = PDType1Font.HELVETICA_OBLIQUE;

		PDFont pdfFont = PDType1Font.HELVETICA;
		float fontSize = 12;
		float leading = 1.5f * fontSize;

		PDRectangle mediabox = page.getMediaBox();
		float margin = 70;
		float width = mediabox.getWidth() - 2 * margin;
		float startX = mediabox.getLowerLeftX() + margin;
		float startY = mediabox.getUpperRightY() - margin;
		float heightCounter = startY;

		// Creating PDImageXObject object
		PDImageXObject pdImage = PDImageXObject
				.createFromFile(
						"C:\\Users\\jijol\\workspace\\EQC-SYS\\WebContent\\assets\\img\\uitm.PNG",
						document);

		// Start a new content stream which will "hold" the to be created
		// content
		PDPageContentStream contentStream = new PDPageContentStream(document,
				page);

		// Drawing the image in the PDF document
		contentStream.drawXObject(pdImage, 187, 630, 238, 101);

		System.out.println("Image inserted");

		String course = "COURSE                      :     FUNDAMENTALS OF INFORMATION SYSTEMS";
		String code = "COURSE CODE           :     ITS410";
		String examination = "EXAMINATION             :     " + examMonth + " "
				+ examYear;
		String hour = "TIME                             :     " + examDuration;
		// Draw table
		String[][] content = { { course }, { code }, { examination }, { hour },
				{} };

		drawTable(page, contentStream, 615, 70, content);

		contentStream.drawLine(265, 453, 69, 453);
		contentStream.drawLine(70, 90, 530, 90);
		contentStream.drawLine(70, 110, 530, 110);

		// Define a text content stream using the selected font, moving the
		// cursor and drawing the text "Hello World"
		contentStream.beginText();
		contentStream.setFont(font, 12);
		contentStream.moveTextPositionByAmount(70, 725);
		contentStream.drawString("CONFIDENTIAL");
		contentStream.moveTextPositionByAmount(345, 0);
		contentStream.drawString("CS/" + month + " " + examYear + "/ITS410");
		contentStream.newLineAtOffset(-415, -270);
		contentStream.moveTextPositionByAmount(70, 0);
		contentStream.drawString("INSTRUCTIONS TO CANDIDATES");

		int i = 0;
		QuestionBankBean ques = new QuestionBankBean();
		int countTOTALQ_ALL = 0;
		String[] qID = null;
		String[] qDifficulty = null;
		String[] qTopicCode = null;
		String[] qQuestion = null;
		String[] qAnswer = null;
		String[] qMarks = null;
		try {
			currentCon = ConnectionManager.getConnection();
			try {
				Statement stmt = currentCon.createStatement();
				System.out.println("Step 1");
				// All Questions Count
				rs = stmt.executeQuery("SELECT COUNT(*) FROM EXAMPAPER");
				rs.next();
				countTOTALQ_ALL = rs.getInt(1);
				qID = new String[countTOTALQ_ALL];
				qDifficulty = new String[countTOTALQ_ALL];
				qTopicCode = new String[countTOTALQ_ALL];
				qQuestion = new String[countTOTALQ_ALL];
				qAnswer = new String[countTOTALQ_ALL];
				qMarks = new String[countTOTALQ_ALL];
				rs = stmt
						.executeQuery("SELECT * FROM exampaper ORDER BY questionTopicCode, questionID");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					System.out.println(rs.getString("questionQuestion"));
					System.out.println(rs.getString("questionAnswer"));
					System.out.println(rs.getInt("questionMarks"));
					qID[i] = String.valueOf(ques.getQuestionID());
					qDifficulty[i] = ques.getQuestionDifficulty();
					qTopicCode[i] = ques.getQuestionTopicCode();
					qQuestion[i] = ques.getQuestionQuestion();
					qAnswer[i] = ques.getQuestionAnswer();
					qMarks[i] = String.valueOf(ques.getQuestionMarks());
					i++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			currentCon.close();
		}
		for (int j = 0; j < countTOTALQ_ALL; j++) {
			System.out.println(qQuestion[j]);
			System.out.println(qAnswer[j]);
			System.out.println(qMarks[j]);
			System.out.println("======");
		}

		String text1 = "1.        This question paper contains of "
				+ countTOTALQ_ALL + " questions.";
		String text2 = "2.        Answer ALL questions in the Answer Booklet. Start each answer on a new page.";
		String text3 = "3.        Do not bring any material into the examination room unless permission is given by";
		String text3cont = "           the invigilator.";
		String text4 = "4.        Please check to make sure that this examination pack consists of:";
		String text4sub1 = "           i)     the Question Paper";
		String text4sub2 = "           ii)    an Answer Booklet -  provided by the Faculty";
		String text5 = "5.        Answer ALL questions in English.";

		contentStream.setFont(font1, 12);
		contentStream.newLineAtOffset(-70, -30);
		contentStream.moveTextPositionByAmount(70, 0);

		// Setting the leading
		contentStream.setLeading(14.5f);
		contentStream.showText(text1);
		contentStream.newLine();
		contentStream.newLine();
		contentStream.showText(text2);
		contentStream.newLine();
		contentStream.newLine();
		contentStream.showText(text3);
		contentStream.newLine();
		contentStream.showText(text3cont);
		contentStream.newLine();
		contentStream.newLine();
		contentStream.showText(text4);
		contentStream.newLine();
		contentStream.newLine();
		contentStream.showText(text4sub1);
		contentStream.newLine();
		contentStream.showText(text4sub2);
		contentStream.newLine();
		contentStream.newLine();
		contentStream.showText(text5);
		contentStream.newLine();
		contentStream.newLine();

		contentStream.setFont(font, 12);
		contentStream.moveTextPositionByAmount(53, -127);
		contentStream
				.drawString("DO NOT TURN THIS PAGE UNTIL YOU ARE TOLD TO DO SO");
		contentStream.setFont(font2, 12);
		contentStream.moveTextPositionByAmount(20, -17);
		contentStream
				.drawString("This examination paper consists of several printed papers.");

		contentStream.setFont(font, 10);
		contentStream.moveTextPositionByAmount(-75, -20);
		contentStream.drawString("© Hak Cipta Universiti Teknologi MARA");
		contentStream.setFont(font, 12);
		contentStream.moveTextPositionByAmount(380, 0);
		contentStream.drawString("CONFIDENTIAL");

		contentStream.endText();

		// Make sure that the content stream is closed:
		contentStream.close();

		// add another page
		PDPage page1 = new PDPage();
		document.addPage(page1);
		// Start a new content stream which will "hold" the to be created
		// content
		PDPageContentStream contentStream1 = new PDPageContentStream(document,
				page1);
		// Define a text content stream using the selected font, moving the
		// cursor and drawing the text "Hello World"
		contentStream1.beginText();
		contentStream1.setFont(font, 12);
		contentStream1.moveTextPositionByAmount(70, 725);
		contentStream1.drawString("CONFIDENTIAL");
		contentStream1.moveTextPositionByAmount(345, 0);
		contentStream1.drawString("CS/" + month + " " + examYear + "/ITS410");
		contentStream1.moveTextPositionByAmount(-345, -50);
		for (int a = 0; a < countTOTALQ_ALL; a++) {
			if (a%3==0 && a!=0) {
				contentStream1.endText();
				contentStream1.close();
				page1 = new PDPage();
				document.addPage(page1);
				contentStream1 = new PDPageContentStream(document, page1);
				contentStream1.beginText();
				contentStream1.setFont(font, 12);
				contentStream1.moveTextPositionByAmount(70, 725);
				contentStream1.drawString("CONFIDENTIAL");
				contentStream1.moveTextPositionByAmount(345, 0);
				contentStream1.drawString("CS/" + month + " " + examYear
						+ "/ITS410");
				contentStream1.moveTextPositionByAmount(-345, -50);
			}
			System.out.println("Question " + (a + 1));
			System.out.println(qQuestion[a]);
			System.out.println(qAnswer[a]);
			System.out.println(qMarks[a]);
			System.out.println("");
			contentStream1.setFont(font1, 12);

			// Setting the leading
			contentStream1.setLeading(14.5f);
			heading = "QUESTION " + (a + 1);

			contentStream1.setFont(font, 12);
			contentStream1.showText(heading);
			contentStream1.newLine();
			contentStream1.newLine();

			List<String> lines = new ArrayList<String>();
			int lastSpace = -1;
			while (qQuestion[a].length() > 0) {
				int spaceIndex = qQuestion[a].indexOf(' ', lastSpace + 1);
				if (spaceIndex < 0)
					spaceIndex = qQuestion[a].length();
				String subString = qQuestion[a].substring(0, spaceIndex);
				float size = fontSize * pdfFont.getStringWidth(subString)
						/ 1000;
				System.out.printf("'%s' - %f of %f\n", subString, size, width);
				if (size > width) {
					if (lastSpace < 0)
						lastSpace = spaceIndex;
					subString = qQuestion[a].substring(0, lastSpace);
					lines.add(subString);
					qQuestion[a] = qQuestion[a].substring(lastSpace).trim();
					System.out.printf("'%s' is line\n", subString);
					lastSpace = -1;
				} else if (spaceIndex == qQuestion[a].length()) {
					lines.add(qQuestion[a]);
					System.out.printf("'%s' is line\n", qQuestion[a]);
					qQuestion[a] = "";
				} else {
					lastSpace = spaceIndex;
				}
			}

			contentStream1.setFont(pdfFont, fontSize);
			contentStream1.newLineAtOffset(0, 0);
			for (String line : lines) {
				float charSpacing = 0;
				if (line.length() > 1) {
					float size = fontSize * pdfFont.getStringWidth(line) / 1000;
					float free = width - size;
					if (free > 0) {
						charSpacing = free / (line.length() - 1);
					}
				}
				contentStream1.appendRawCommands(charSpacing);
				contentStream1.showText(line);
				contentStream1.newLineAtOffset(0, -20);
			}

			contentStream1.setFont(font1, 12);
			contentStream1.showText("(" + qMarks[a] + " Marks)");
			contentStream1.newLine();
			contentStream1.newLine();
			contentStream1.newLine();
		}
		contentStream1.endText();
		// Make sure that the content stream is closed:
		contentStream1.close();

		// Save the results and ensure that the document is properly closed:
		document.save("D:\\EQC-SYS\\OUTPUT\\" + filename + ".pdf");
		document.close();
	}

	@SuppressWarnings("deprecation")
	public static void generateAnswerSchemes(String examMonth, String examYear,
			String examDuration, String filename2) throws IOException,
			SQLException {
		String heading = null;
		String month = null;
		System.out.println("1");

		if (examMonth.equalsIgnoreCase("JANUARY")
				|| examMonth.equalsIgnoreCase("DECEMBER")) {
			month = examMonth.substring(0, 3);
		} else {
			month = examMonth;
		}

		// Create a document and add a page to it
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage(page);

		// Create a new font object selecting one of the PDF base fonts
		PDFont font = PDType1Font.HELVETICA_BOLD;
		PDFont font1 = PDType1Font.HELVETICA;
		PDFont font2 = PDType1Font.HELVETICA_OBLIQUE;

		PDFont pdfFont = PDType1Font.HELVETICA;
		float fontSize = 12;
		float leading = 1.5f * fontSize;

		PDRectangle mediabox = page.getMediaBox();
		float margin = 70;
		float width = mediabox.getWidth() - 2 * margin;
		float startX = mediabox.getLowerLeftX() + margin;
		float startY = mediabox.getUpperRightY() - margin;
		float heightCounter = startY;

		// Creating PDImageXObject object
		PDImageXObject pdImage = PDImageXObject
				.createFromFile(
						"C:\\Users\\jijol\\workspace\\EQC-SYS\\WebContent\\assets\\img\\uitm.PNG",
						document);

		// Start a new content stream which will "hold" the to be created
		// content
		PDPageContentStream contentStream = new PDPageContentStream(document,
				page);

		// Drawing the image in the PDF document
		contentStream.drawXObject(pdImage, 187, 630, 238, 101);

		System.out.println("Image inserted");

		String course = "COURSE                      :     FUNDAMENTALS OF INFORMATION SYSTEMS";
		String code = "COURSE CODE           :     ITS410";
		String examination = "EXAMINATION             :     " + examMonth + " "
				+ examYear;
		String hour = "TIME                             :     " + examDuration;
		// Draw table
		String[][] content = { { course }, { code }, { examination }, { hour },
				{} };

		drawTable(page, contentStream, 615, 70, content);

		contentStream.drawLine(265, 453, 69, 453);
		contentStream.drawLine(70, 90, 530, 90);
		contentStream.drawLine(70, 110, 530, 110);

		// Define a text content stream using the selected font, moving the
		// cursor and drawing the text "Hello World"
		contentStream.beginText();
		contentStream.setFont(font, 12);
		contentStream.moveTextPositionByAmount(70, 725);
		contentStream.drawString("CONFIDENTIAL");
		contentStream.moveTextPositionByAmount(345, 0);
		contentStream.drawString("CS/" + month + " " + examYear + "/ITS410");
		contentStream.newLineAtOffset(-415, -270);
		contentStream.moveTextPositionByAmount(70, 0);
		contentStream.drawString("INSTRUCTIONS TO CANDIDATES");

		int i = 0;
		QuestionBankBean ques = new QuestionBankBean();
		int countTOTALQ_ALL = 0;
		String[] qID = null;
		String[] qDifficulty = null;
		String[] qTopicCode = null;
		String[] qQuestion = null;
		String[] qAnswer = null;
		String[] qMarks = null;
		try {
			currentCon = ConnectionManager.getConnection();
			try {
				Statement stmt = currentCon.createStatement();
				System.out.println("Step 1");
				// All Questions Count
				rs = stmt.executeQuery("SELECT COUNT(*) FROM EXAMPAPER");
				rs.next();
				countTOTALQ_ALL = rs.getInt(1);
				qID = new String[countTOTALQ_ALL];
				qDifficulty = new String[countTOTALQ_ALL];
				qTopicCode = new String[countTOTALQ_ALL];
				qQuestion = new String[countTOTALQ_ALL];
				qAnswer = new String[countTOTALQ_ALL];
				qMarks = new String[countTOTALQ_ALL];
				rs = stmt
						.executeQuery("SELECT * FROM exampaper ORDER BY questionTopicCode asc, questionID asc");
				while (rs.next()) {
					ques.setQuestionID(rs.getInt("questionID"));
					ques.setQuestionDifficulty(rs
							.getString("questionDifficulty"));
					ques.setQuestionMarks(rs.getInt("questionMarks"));
					ques.setQuestionTopicCode(rs.getString("questionTopicCode"));
					ques.setQuestionQuestion(rs.getString("questionQuestion"));
					ques.setQuestionAnswer(rs.getString("questionAnswer"));
					System.out.println(rs.getString("questionQuestion"));
					System.out.println(rs.getString("questionAnswer"));
					System.out.println(rs.getInt("questionMarks"));
					qID[i] = String.valueOf(ques.getQuestionID());
					qDifficulty[i] = ques.getQuestionDifficulty();
					qTopicCode[i] = ques.getQuestionTopicCode();
					qQuestion[i] = ques.getQuestionQuestion();
					qAnswer[i] = ques.getQuestionAnswer();
					qMarks[i] = String.valueOf(ques.getQuestionMarks());
					i++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			currentCon.close();
		}
		for (int j = 0; j < countTOTALQ_ALL; j++) {
			System.out.println(qQuestion[j]);
			System.out.println(qAnswer[j]);
			System.out.println(qMarks[j]);
			System.out.println("======");
		}

		String text1 = "1.        This question paper contains of "
				+ countTOTALQ_ALL + " questions.";
		String text2 = "2.        Answer ALL questions in the Answer Booklet. Start each answer on a new page.";
		String text3 = "3.        Do not bring any material into the examination room unless permission is given by";
		String text3cont = "           the invigilator.";
		String text4 = "4.        Please check to make sure that this examination pack consists of:";
		String text4sub1 = "           i)     the Question Paper";
		String text4sub2 = "           ii)    an Answer Booklet -  provided by the Faculty";
		String text5 = "5.        Answer ALL questions in English.";

		contentStream.setFont(font1, 12);
		contentStream.newLineAtOffset(-70, -30);
		contentStream.moveTextPositionByAmount(70, 0);

		// Setting the leading
		contentStream.setLeading(14.5f);
		contentStream.showText(text1);
		contentStream.newLine();
		contentStream.newLine();
		contentStream.showText(text2);
		contentStream.newLine();
		contentStream.newLine();
		contentStream.showText(text3);
		contentStream.newLine();
		contentStream.showText(text3cont);
		contentStream.newLine();
		contentStream.newLine();
		contentStream.showText(text4);
		contentStream.newLine();
		contentStream.newLine();
		contentStream.showText(text4sub1);
		contentStream.newLine();
		contentStream.showText(text4sub2);
		contentStream.newLine();
		contentStream.newLine();
		contentStream.showText(text5);
		contentStream.newLine();
		contentStream.newLine();

		contentStream.setFont(font, 12);
		contentStream.moveTextPositionByAmount(53, -127);
		contentStream
				.drawString("DO NOT TURN THIS PAGE UNTIL YOU ARE TOLD TO DO SO");
		contentStream.setFont(font2, 12);
		contentStream.moveTextPositionByAmount(20, -17);
		contentStream
				.drawString("This examination paper consists of several printed papers.");

		contentStream.setFont(font, 10);
		contentStream.moveTextPositionByAmount(-75, -20);
		contentStream.drawString("© Hak Cipta Universiti Teknologi MARA");
		contentStream.setFont(font, 12);
		contentStream.moveTextPositionByAmount(380, 0);
		contentStream.drawString("CONFIDENTIAL");

		contentStream.endText();

		// Make sure that the content stream is closed:
		contentStream.close();

		// add another page
		PDPage page1 = new PDPage();
		document.addPage(page1);
		// Start a new content stream which will "hold" the to be created
		// content
		PDPageContentStream contentStream1 = new PDPageContentStream(document,
				page1);
		// Define a text content stream using the selected font, moving the
		// cursor and drawing the text "Hello World"
		contentStream1.beginText();
		contentStream1.setFont(font, 12);
		contentStream1.moveTextPositionByAmount(70, 725);
		contentStream1.drawString("CONFIDENTIAL");
		contentStream1.moveTextPositionByAmount(345, 0);
		contentStream1.drawString("CS/" + month + " " + examYear + "/ITS410");
		contentStream1.moveTextPositionByAmount(-345, -50);
		for (int a = 0; a < countTOTALQ_ALL; a++) {
			if (a%3==0 && a!=0) {
				contentStream1.endText();
				contentStream1.close();
				page1 = new PDPage();
				document.addPage(page1);
				contentStream1 = new PDPageContentStream(document, page1);
				contentStream1.beginText();
				contentStream1.setFont(font, 12);
				contentStream1.moveTextPositionByAmount(70, 725);
				contentStream1.drawString("CONFIDENTIAL");
				contentStream1.moveTextPositionByAmount(345, 0);
				contentStream1.drawString("CS/" + month + " " + examYear
						+ "/ITS410");
				contentStream1.moveTextPositionByAmount(-345, -50);
			}
			System.out.println("Question " + (a + 1));
			System.out.println(qQuestion[a]);
			System.out.println(qAnswer[a]);
			System.out.println(qMarks[a]);
			System.out.println("");
			contentStream1.setFont(font1, 12);

			// Setting the leading
			contentStream1.setLeading(14.5f);
			heading = "QUESTION " + (a + 1);

			contentStream1.setFont(font, 12);
			contentStream1.showText(heading);
			contentStream1.newLine();
			contentStream1.newLine();

			List<String> lines = new ArrayList<String>();
			int lastSpace = -1;
			while (qQuestion[a].length() > 0) {
				int spaceIndex = qQuestion[a].indexOf(' ', lastSpace + 1);
				if (spaceIndex < 0)
					spaceIndex = qQuestion[a].length();
				String subString = qQuestion[a].substring(0, spaceIndex);
				float size = fontSize * pdfFont.getStringWidth(subString)
						/ 1000;
				System.out.printf("'%s' - %f of %f\n", subString, size, width);
				if (size > width) {
					if (lastSpace < 0)
						lastSpace = spaceIndex;
					subString = qQuestion[a].substring(0, lastSpace);
					lines.add(subString);
					qQuestion[a] = qQuestion[a].substring(lastSpace).trim();
					System.out.printf("'%s' is line\n", subString);
					lastSpace = -1;
				} else if (spaceIndex == qQuestion[a].length()) {
					lines.add(qQuestion[a]);
					System.out.printf("'%s' is line\n", qQuestion[a]);
					qQuestion[a] = "";
				} else {
					lastSpace = spaceIndex;
				}
			}

			contentStream1.setFont(pdfFont, fontSize);
			contentStream1.newLineAtOffset(0, 0);
			for (String line : lines) {
				float charSpacing = 0;
				if (line.length() > 1) {
					float size = fontSize * pdfFont.getStringWidth(line) / 1000;
					float free = width - size;
					if (free > 0) {
						charSpacing = free / (line.length() - 1);
					}
				}
				contentStream1.appendRawCommands(charSpacing);
				contentStream1.showText(line);
				contentStream1.newLineAtOffset(0, -20);
			}

			lines = new ArrayList<String>();
			lastSpace = -1;
			while (qAnswer[a].length() > 0) {
				int spaceIndex = qAnswer[a].indexOf(' ', lastSpace + 1);
				if (spaceIndex < 0)
					spaceIndex = qAnswer[a].length();
				String subString = qAnswer[a].substring(0, spaceIndex);
				float size = fontSize * pdfFont.getStringWidth(subString)
						/ 1000;
				System.out.printf("'%s' - %f of %f\n", subString, size, width);
				if (size > width) {
					if (lastSpace < 0)
						lastSpace = spaceIndex;
					subString = qAnswer[a].substring(0, lastSpace);
					lines.add(subString);
					qAnswer[a] = qAnswer[a].substring(lastSpace).trim();
					System.out.printf("'%s' is line\n", subString);
					lastSpace = -1;
				} else if (spaceIndex == qAnswer[a].length()) {
					lines.add(qAnswer[a]);
					System.out.printf("'%s' is line\n", qAnswer[a]);
					qAnswer[a] = "";
				} else {
					lastSpace = spaceIndex;
				}
			}

			contentStream1.setFont(pdfFont, fontSize);
			contentStream1.newLineAtOffset(0, 0);
			contentStream1
					.showText("===============================Answer Begin============================");
			contentStream1.newLine();
			for (String line : lines) {
				float charSpacing = 0;
				if (line.length() > 1) {
					float size = fontSize * pdfFont.getStringWidth(line) / 1000;
					float free = width - size;
					if (free > 0) {
						charSpacing = free / (line.length() - 1);
					}
				}
				contentStream1.appendRawCommands(charSpacing);
				contentStream1.showText(line);
				contentStream1.newLineAtOffset(0, -20);
			}
			contentStream1
					.showText("===============================Answer End=============================");
			contentStream1.newLine();
			contentStream1.setFont(font1, 12);
			contentStream1.showText("(" + qMarks[a] + " Marks)");
			contentStream1.newLine();
			contentStream1.newLine();
			contentStream1.newLine();
		}
		contentStream1.endText();
		// Make sure that the content stream is closed:
		contentStream1.close();

		// Save the results and ensure that the document is properly closed:
		document.save("D:\\EQC-SYS\\OUTPUT\\" + filename2 + ".pdf");
		document.close();
	}
}