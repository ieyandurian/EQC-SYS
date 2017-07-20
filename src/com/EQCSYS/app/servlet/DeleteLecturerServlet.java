package com.EQCSYS.app.servlet;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EQCSYS.app.bean.LecturerBean;
import com.EQCSYS.app.dao.LecturerDAO;

public class DeleteLecturerServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			System.out.println("Stage 1 - deleting lecturer...");
			LecturerBean lect = new LecturerBean();
			lect.setLecturerID(Integer.parseInt(request
					.getParameter("lecturerID")));
			lect = LecturerDAO.deleteLecturer(lect);
			if (lect.isValid()) {
				request.setAttribute("deletelect", lect);
				response.sendRedirect("userAdmin/managelecturer.jsp"); // logged-in
																		// page
			} else {
				out.println("<script type='text/javascript'>alert('Delete Lecturer Failed');</script>");
				response.sendRedirect("userAdmin/login.jsp"); // error page
			}
		} catch (Throwable theException) {
			System.out.println(theException);
		}
		out.close();
	}
}