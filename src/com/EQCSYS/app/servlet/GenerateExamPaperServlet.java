package com.EQCSYS.app.servlet;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EQCSYS.app.bean.QuestionBankBean;
import com.EQCSYS.app.bean.TSTBean;
import com.EQCSYS.app.dao.QuestionBankDAO;

public class GenerateExamPaperServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		try {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession(true);
			Boolean bool  = false;
			TSTBean tst = ((TSTBean) (session.getAttribute("currentSessionTST")));
			String examMonth = request.getParameter("examMonth");
			String examYear = request.getParameter("examYear");
			String examDuration = request.getParameter("examDuration");
			QuestionBankBean ques = new QuestionBankBean();
			ques = QuestionBankDAO.retrieveQuestion(ques, tst);
			ques = QuestionBankDAO.generateExamPaper(ques, examMonth, examYear, examDuration);

			if (ques.isValid()) {
				session.setAttribute("currentSessionGenerate", bool);
				response.sendRedirect("userLecturer/print.jsp");
			} else
				response.sendRedirect("userLecturer/login.jsp"); // error page
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}