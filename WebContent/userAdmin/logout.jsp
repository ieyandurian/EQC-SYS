<!-- For not creating new session -->
<%@ page session="false"%>

<body>
	<%
		HttpSession session = request.getSession(false);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		// for checking the session is available or not, if not available it will throw exception, "Session already invalidated."
		if (session != null) {
			session.invalidate();
			response.sendRedirect("../userAdmin/login.jsp");
		}
	%>
</body>