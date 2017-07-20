package com.EQCSYS.app.servlet;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EQCSYS.app.bean.AdminBean;
import com.EQCSYS.app.dao.AdminDAO;

/**
 * Servlet implementation class LoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			AdminBean user = new AdminBean();
			user.setAdminID(request.getParameter("un"));
			user.setAdminPassword(request.getParameter("pw"));
			user = AdminDAO.loginAdmin(user);

			if (user.isValid()) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionAdmin", user);
				response.sendRedirect("userAdmin/home.jsp"); // logged-in
																// page
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('ID or password incorrect');");
				out.println("location='userAdmin/login.jsp';");
				out.println("</script>");
			}
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}