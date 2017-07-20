package com.EQCSYS.app.servlet;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EQCSYS.app.bean.QuestionBankBean;
import com.EQCSYS.app.dao.QuestionBankDAO;

public class DeleteQuestionServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			System.out.println("Stage 1 - deleting question...");
			QuestionBankBean ques = new QuestionBankBean();
			ques.setQuestionID(Integer.parseInt(request.getParameter("questionID")));
			ques = QuestionBankDAO.deleteQuestion(ques);
			if (ques.isValid()) {
				request.setAttribute("deleteques", ques);
				response.sendRedirect("userLecturer/managequestion.jsp"); // logged-in
																			// page
			} else {
				response.sendRedirect("userLecturer/login.jsp"); // error page
			}
		} catch (Throwable theException) {
			System.out.println(theException);
		}
		out.close();
	}
}