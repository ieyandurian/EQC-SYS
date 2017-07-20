package com.EQCSYS.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EQCSYS.app.bean.DataDictionaryBean;
import com.EQCSYS.app.bean.DataSourceBean;
import com.EQCSYS.app.bean.QuestionBankBean;
import com.EQCSYS.app.bean.TokenBean;
import com.EQCSYS.app.dao.DataDictionaryDAO;
import com.EQCSYS.app.dao.DataSourceDAO;
import com.EQCSYS.app.dao.QuestionBankDAO;
import com.EQCSYS.app.dao.TokenDAO;

public class CreateQuestionAutoServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		DataDictionaryBean keyword = new DataDictionaryBean();
		QuestionBankBean question = new QuestionBankBean();
		System.out.println("1st!!!");
		DataSourceBean source = new DataSourceBean();
		TokenBean token = new TokenBean();
		String topic = request.getParameter("questionTopicCode");
		String difficulty = request.getParameter("questionDifficulty");
		System.out.println(topic + " " + difficulty);
		
		try {
			keyword = DataDictionaryDAO.categorizeQuestion(keyword,topic,difficulty);
			source = DataSourceDAO.extractText(source, topic);
			question = QuestionBankDAO.cosineSimilarity(question, token, source, topic);
			if (keyword.isValid()) {
				System.out.println("Success!!!");
				response.sendRedirect("userLecturer/createquestionautodisplay.jsp");
			} else {
				System.out.println("Error!!!");
				response.sendRedirect("userLecturer/login.jsp");
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}

		out.close();
	}
}

