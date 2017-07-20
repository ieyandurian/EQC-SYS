package com.EQCSYS.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EQCSYS.app.bean.LecturerBean;
import com.EQCSYS.app.dao.LecturerDAO;

public class UpdateAccountServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		LecturerBean lect = new LecturerBean();

		lect.setLecturerID(Integer.parseInt(request.getParameter("lecturerID")));
		lect.setLecturerPassword(request.getParameter("lecturerPassword"));
		lect.setLecturerFirstName(request.getParameter("lecturerFirstName"));
		lect.setLecturerLastName(request.getParameter("lecturerLastName"));
		lect.setLecturerPhoneNumber(request.getParameter("lecturerPhoneNumber"));
		lect.setLecturerEmail(request.getParameter("lecturerEmail"));
		lect.setLecturerFaculty(request.getParameter("lecturerFaculty"));

		try {
			lect = LecturerDAO.updateLecturer(lect);
			if (lect.isValid()) {
				System.out.println("Update success!!!");
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", lect);
				response.sendRedirect("userLecturer/myaccount.jsp");
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}
		out.close();
	}
}