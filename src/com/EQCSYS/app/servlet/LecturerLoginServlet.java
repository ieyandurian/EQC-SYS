package com.EQCSYS.app.servlet;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EQCSYS.app.bean.LecturerBean;
import com.EQCSYS.app.dao.LecturerDAO;

/**
 * Servlet implementation class LoginServlet
 */
public class LecturerLoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			LecturerBean user = new LecturerBean();
			user.setLecturerID(Integer.parseInt(request.getParameter("un")));
			user.setLecturerPassword(request.getParameter("pw"));
			user = LecturerDAO.loginLecturer(user);

			if (user.isValid()) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);
				response.sendRedirect("userLecturer/home.jsp"); // logged-in
																// page
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('ID or password incorrect');");
				out.println("location='userLecturer/login.jsp';");
				out.println("</script>");
			}
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}