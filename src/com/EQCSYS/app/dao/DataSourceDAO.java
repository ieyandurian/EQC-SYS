package com.EQCSYS.app.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.apache.pdfbox.io.IOUtils;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import com.EQCSYS.app.bean.DataSourceBean;
import com.EQCSYS.app.bean.TempStorageBean;
import com.EQCSYS.app.bean.TokenBean;
import com.EQCSYS.app.datasourcetotext.PDFManager;
import com.EQCSYS.app.util.ConnectionManager;

public class DataSourceDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static Statement stmt = null;

	public static DataSourceBean extractText(DataSourceBean source, String topic)
			throws IOException, SAXException, TikaException {
		int counter = 0;
		String delims = ";";
		String t = null;
		String no = null;
		int count = 0;

		if (topic.equalsIgnoreCase("Topic 1")) {
			no = "1";
			t = "1001";
		} else if (topic.equalsIgnoreCase("Topic 2")) {
			no = "2";
			t = "1002";
		} else if (topic.equalsIgnoreCase("Topic 3")) {
			no = "3";
			t = "1003";
		} else if (topic.equalsIgnoreCase("Topic 4")) {
			no = "4";
			t = "1004";
		} else if (topic.equalsIgnoreCase("Topic 5")) {
			no = "5";
			t = "1005";
		} else if (topic.equalsIgnoreCase("Topic 6")) {
			no = "6";
			t = "1006";
		} else if (topic.equalsIgnoreCase("Topic 7")) {
			no = "7";
			t = "1007";
		} else if (topic.equalsIgnoreCase("Topic 8")) {
			no = "8";
			t = "1008";
		}
		System.out.println("Topic" + topic);
		System.out.println("No." + no);
		System.out.println("T. " + no);
		String sql = "SELECT DATASOURCE_FILE FROM DATASOURCE WHERE DATASOURCE_ID='"
				+ t + "'";
		System.out.println(sql);
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			PDFManager pdfManager = new PDFManager();
			while (rs.next()) {
				Blob blobPdf = rs.getBlob("DATASOURCE_FILE");
				File outputFile = new File("D:\\EQC-SYS\\NOTE\\TOPIC " + no + ".pdf");
				FileOutputStream fout = new FileOutputStream(outputFile);
				IOUtils.copy(blobPdf.getBinaryStream(), fout);
				pdfManager.setFilePath("D:\\EQC-SYS\\NOTE\\TOPIC " + no + ".pdf");
				System.out.println(pdfManager.ToText());
			}
			System.out.println("The file has been created...");
			InputStream is = new FileInputStream("D:\\EQC-SYS\\NOTE\\TOPIC " + no
					+ ".pdf");
			ContentHandler contenthandler = new BodyContentHandler();
			Metadata metadata = new Metadata();
			PDFParser pdfparser = new PDFParser();
			pdfparser.parse(is, contenthandler, metadata, new ParseContext());
			System.out.println(contenthandler.toString());
			String splitString = contenthandler.toString();
			splitString = splitString.replaceAll("^\\d{2}(\\.\\d)+ +", "").replaceAll(" +\\?$", "");
			StringTokenizer st = new StringTokenizer(splitString, delims);
			TokenBean temp = new TokenBean();
			TempStorageBean tmp = new TempStorageBean();
			ArrayList<String> listToken = new ArrayList<String>();
			ArrayList<TokenBean> list = new ArrayList<TokenBean>();
			System.out
					.println("==================================================================================");
			while (st.hasMoreElements()) {
				String token = (String) st.nextElement();
				counter++;
				if (counter > 1) {
					listToken.add(token);
					temp.setSentence(token);
					list.add(temp);
					tmp.setMyList(listToken, token);
					System.out
							.println("==================================================================================");
					System.out.println("StringTokenizer Output: " + token);
					System.out
							.println("==================================================================================");
					File file1 = new File("D:\\EQC-SYS\\TOKEN\\TOPIC " + no + "\\"
							+ topic + "_" + no + "_" + count + ".txt");
					FileWriter fw1 = new FileWriter(file1);
					PrintWriter pw1 = new PrintWriter(fw1);
					pw1.println(token);
					pw1.close();
					TokenBean tokenize = new TokenBean();
					tokenize.setSentence(token);
					tokenize.setTopicCode(topic);
					tokenize = TokenDAO.tokenization(tokenize, currentCon);
				}
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return source;
	}
}
