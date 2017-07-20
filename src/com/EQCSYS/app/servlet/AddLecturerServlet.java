package com.EQCSYS.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EQCSYS.app.bean.AdminBean;
import com.EQCSYS.app.bean.LecturerBean;
import com.EQCSYS.app.dao.LecturerDAO;

public class AddLecturerServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		LecturerBean lect = new LecturerBean();
		HttpSession session = request.getSession(true);
		AdminBean admin = ((AdminBean) (session
				.getAttribute("currentSessionAdmin")));

		System.out.println("1st!!!");

		String lecturerPassword = request.getParameter("lecturerPassword");
		String lecturerFirstName = request.getParameter("lecturerFirstName");
		String lecturerLastName = request.getParameter("lecturerLastName");
		String lecturerPhoneNumber = request
				.getParameter("lecturerPhoneNumber");
		String lecturerEmail = request.getParameter("lecturerEmail");
		String lecturerFaculty = request.getParameter("lecturerFaculty");

		lect.setLecturerPassword(lecturerPassword);
		lect.setLecturerFirstName(lecturerFirstName);
		lect.setLecturerLastName(lecturerLastName);
		lect.setLecturerPhoneNumber(lecturerPhoneNumber);
		lect.setLecturerEmail(lecturerEmail);
		lect.setLecturerFaculty(lecturerFaculty);

		try {
			lect = LecturerDAO.addLecturer(lect);
			if (lect.isValid()) {
				System.out.println("Success!!!");
				response.sendRedirect("userAdmin/home.jsp");
			} else {
				System.out.println("Error!!!");
				response.sendRedirect("userAdmin/login.jsp");
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}

		out.close();
	}
}
