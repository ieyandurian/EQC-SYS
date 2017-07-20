package com.EQCSYS.app.servlet;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EQCSYS.app.bean.LecturerBean;
import com.EQCSYS.app.bean.OwnershipBean;
import com.EQCSYS.app.bean.QuestionBankBean;
import com.EQCSYS.app.dao.OwnershipDAO;
import com.EQCSYS.app.dao.QuestionBankDAO;

public class DeleteAutoQuestionServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(true);
		LecturerBean lect = ((LecturerBean) (session
				.getAttribute("currentSessionUser")));
		QuestionBankBean ques = new QuestionBankBean();
		OwnershipBean own = new OwnershipBean();
		try {
			System.out.println("Stage 1 - deleting question...");
			ques.setQuestionID(Integer.parseInt(request
					.getParameter("questionID")));
			ques = QuestionBankDAO.deleteAutoQuestion(ques);
			if (ques.isValid()) {
				System.out.println("ques!!!");
				own = OwnershipDAO.deleteOwnership(own, ques, lect);
				if (own.isValid()) {
					System.out.println("own!!!");
					System.out.println("Success!!!");
					request.setAttribute("deleteques", ques);
					response.sendRedirect("userLecturer/createquestionautodisplay.jsp");
				} else {
					System.out.println("Error!!!");
					response.sendRedirect("userLecturer/login.jsp");
				}
			} else {
				response.sendRedirect("userLecturer/login.jsp"); // error page
			}
		} catch (Throwable theException) {
			System.out.println(theException);
		}
		out.close();
	}
}