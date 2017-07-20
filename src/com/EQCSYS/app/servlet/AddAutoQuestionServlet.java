package com.EQCSYS.app.servlet;

import java.io.IOException;
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

public class AddAutoQuestionServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		System.out.println("1st!!!");
		HttpSession session = request.getSession(true);
		LecturerBean lect = ((LecturerBean) (session
				.getAttribute("currentSessionUser")));
		QuestionBankBean ques = new QuestionBankBean();
		OwnershipBean own = new OwnershipBean();

		ques.setQuestionID(Integer.parseInt(request.getParameter("questionID")));
		own.setShareAccess(request.getParameter("questionShare"));

		try {
			ques = QuestionBankDAO.createQuestionAuto(ques);
			if (ques.isValid()) {
				System.out.println("ques!!!");
				own = OwnershipDAO.assignOwnership(own, ques, lect);
				if (own.isValid()) {
					System.out.println("own!!!");
					request.setAttribute("createques", ques);
					System.out.println("Success!!!");
					response.sendRedirect("userLecturer/createquestionautodisplay.jsp");
				} else {
					System.out.println("Error!!!");
					response.sendRedirect("userLecturer/login.jsp");
				}
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
