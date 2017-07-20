package com.EQCSYS.app.servlet;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EQCSYS.app.bean.QuestionBankBean;
import com.EQCSYS.app.bean.TSTBean;
import com.EQCSYS.app.dao.TSTDAO;

public class TSTValidateServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		try {
			TSTBean tst = new TSTBean();

			tst.setQC1_TOPIC1(request.getParameter("QC1_TOPIC1"));
			tst.setC1_TOPIC1(request.getParameter("C1_TOPIC1"));
			tst.setQC2_TOPIC1(request.getParameter("QC2_TOPIC1"));
			tst.setC2_TOPIC1(request.getParameter("C2_TOPIC1"));
			tst.setQC3_TOPIC1(request.getParameter("QC3_TOPIC1"));
			tst.setC3_TOPIC1(request.getParameter("C3_TOPIC1"));
			tst.setQC4_TOPIC1(request.getParameter("QC4_TOPIC1"));
			tst.setC4_TOPIC1(request.getParameter("C4_TOPIC1"));
			tst.setQC5_TOPIC1(request.getParameter("QC5_TOPIC1"));
			tst.setC5_TOPIC1(request.getParameter("C5_TOPIC1"));
			tst.setQC6_TOPIC1(request.getParameter("QC6_TOPIC1"));
			tst.setC6_TOPIC1(request.getParameter("C6_TOPIC1"));
			tst.setTOTALQ_TOPIC1(request.getParameter("TOTALQ_TOPIC1"));
			tst.setTOTALM_TOPIC1(request.getParameter("TOTALM_TOPIC1"));

			tst.setQC1_TOPIC2(request.getParameter("QC1_TOPIC2"));
			tst.setC1_TOPIC2(request.getParameter("C1_TOPIC2"));
			tst.setQC2_TOPIC2(request.getParameter("QC2_TOPIC2"));
			tst.setC2_TOPIC2(request.getParameter("C2_TOPIC2"));
			tst.setQC3_TOPIC2(request.getParameter("QC3_TOPIC2"));
			tst.setC3_TOPIC2(request.getParameter("C3_TOPIC2"));
			tst.setQC4_TOPIC2(request.getParameter("QC4_TOPIC2"));
			tst.setC4_TOPIC2(request.getParameter("C4_TOPIC2"));
			tst.setQC5_TOPIC2(request.getParameter("QC5_TOPIC2"));
			tst.setC5_TOPIC2(request.getParameter("C5_TOPIC2"));
			tst.setQC6_TOPIC2(request.getParameter("QC6_TOPIC2"));
			tst.setC6_TOPIC2(request.getParameter("C6_TOPIC2"));
			tst.setTOTALQ_TOPIC2(request.getParameter("TOTALQ_TOPIC2"));
			tst.setTOTALM_TOPIC2(request.getParameter("TOTALM_TOPIC2"));

			tst.setQC1_TOPIC3(request.getParameter("QC1_TOPIC3"));
			tst.setC1_TOPIC3(request.getParameter("C1_TOPIC3"));
			tst.setQC2_TOPIC3(request.getParameter("QC2_TOPIC3"));
			tst.setC2_TOPIC3(request.getParameter("C2_TOPIC3"));
			tst.setQC3_TOPIC3(request.getParameter("QC3_TOPIC3"));
			tst.setC3_TOPIC3(request.getParameter("C3_TOPIC3"));
			tst.setQC4_TOPIC3(request.getParameter("QC4_TOPIC3"));
			tst.setC4_TOPIC3(request.getParameter("C4_TOPIC3"));
			tst.setQC5_TOPIC3(request.getParameter("QC5_TOPIC3"));
			tst.setC5_TOPIC3(request.getParameter("C5_TOPIC3"));
			tst.setQC6_TOPIC3(request.getParameter("QC6_TOPIC3"));
			tst.setC6_TOPIC3(request.getParameter("C6_TOPIC3"));
			tst.setTOTALQ_TOPIC3(request.getParameter("TOTALQ_TOPIC3"));
			tst.setTOTALM_TOPIC3(request.getParameter("TOTALM_TOPIC3"));

			tst.setQC1_TOPIC4(request.getParameter("QC1_TOPIC4"));
			tst.setC1_TOPIC4(request.getParameter("C1_TOPIC4"));
			tst.setQC2_TOPIC4(request.getParameter("QC2_TOPIC4"));
			tst.setC2_TOPIC4(request.getParameter("C2_TOPIC4"));
			tst.setQC3_TOPIC4(request.getParameter("QC3_TOPIC4"));
			tst.setC3_TOPIC4(request.getParameter("C3_TOPIC4"));
			tst.setQC4_TOPIC4(request.getParameter("QC4_TOPIC4"));
			tst.setC4_TOPIC4(request.getParameter("C4_TOPIC4"));
			tst.setQC5_TOPIC4(request.getParameter("QC5_TOPIC4"));
			tst.setC5_TOPIC4(request.getParameter("C5_TOPIC4"));
			tst.setQC6_TOPIC4(request.getParameter("QC6_TOPIC4"));
			tst.setC6_TOPIC4(request.getParameter("C6_TOPIC4"));
			tst.setTOTALQ_TOPIC4(request.getParameter("TOTALQ_TOPIC4"));
			tst.setTOTALM_TOPIC4(request.getParameter("TOTALM_TOPIC4"));

			tst.setQC1_TOPIC5(request.getParameter("QC1_TOPIC5"));
			tst.setC1_TOPIC5(request.getParameter("C1_TOPIC5"));
			tst.setQC2_TOPIC5(request.getParameter("QC2_TOPIC5"));
			tst.setC2_TOPIC5(request.getParameter("C2_TOPIC5"));
			tst.setQC3_TOPIC5(request.getParameter("QC3_TOPIC5"));
			tst.setC3_TOPIC5(request.getParameter("C3_TOPIC5"));
			tst.setQC4_TOPIC5(request.getParameter("QC4_TOPIC5"));
			tst.setC4_TOPIC5(request.getParameter("C4_TOPIC5"));
			tst.setQC5_TOPIC5(request.getParameter("QC5_TOPIC5"));
			tst.setC5_TOPIC5(request.getParameter("C5_TOPIC5"));
			tst.setQC6_TOPIC5(request.getParameter("QC6_TOPIC5"));
			tst.setC6_TOPIC5(request.getParameter("C6_TOPIC5"));
			tst.setTOTALQ_TOPIC5(request.getParameter("TOTALQ_TOPIC5"));
			tst.setTOTALM_TOPIC5(request.getParameter("TOTALM_TOPIC5"));

			tst.setQC1_TOPIC6(request.getParameter("QC1_TOPIC6"));
			tst.setC1_TOPIC6(request.getParameter("C1_TOPIC6"));
			tst.setQC2_TOPIC6(request.getParameter("QC2_TOPIC6"));
			tst.setC2_TOPIC6(request.getParameter("C2_TOPIC6"));
			tst.setQC3_TOPIC6(request.getParameter("QC3_TOPIC6"));
			tst.setC3_TOPIC6(request.getParameter("C3_TOPIC6"));
			tst.setQC4_TOPIC6(request.getParameter("QC4_TOPIC6"));
			tst.setC4_TOPIC6(request.getParameter("C4_TOPIC6"));
			tst.setQC5_TOPIC6(request.getParameter("QC5_TOPIC6"));
			tst.setC5_TOPIC6(request.getParameter("C5_TOPIC6"));
			tst.setQC6_TOPIC6(request.getParameter("QC6_TOPIC6"));
			tst.setC6_TOPIC6(request.getParameter("C6_TOPIC6"));
			tst.setTOTALQ_TOPIC6(request.getParameter("TOTALQ_TOPIC6"));
			tst.setTOTALM_TOPIC6(request.getParameter("TOTALM_TOPIC6"));

			tst.setQC1_TOPIC7(request.getParameter("QC1_TOPIC7"));
			tst.setC1_TOPIC7(request.getParameter("C1_TOPIC7"));
			tst.setQC2_TOPIC7(request.getParameter("QC2_TOPIC7"));
			tst.setC2_TOPIC7(request.getParameter("C2_TOPIC7"));
			tst.setQC3_TOPIC7(request.getParameter("QC3_TOPIC7"));
			tst.setC3_TOPIC7(request.getParameter("C3_TOPIC7"));
			tst.setQC4_TOPIC7(request.getParameter("QC4_TOPIC7"));
			tst.setC4_TOPIC7(request.getParameter("C4_TOPIC7"));
			tst.setQC5_TOPIC7(request.getParameter("QC5_TOPIC7"));
			tst.setC5_TOPIC7(request.getParameter("C5_TOPIC7"));
			tst.setQC6_TOPIC7(request.getParameter("QC6_TOPIC7"));
			tst.setC6_TOPIC7(request.getParameter("C6_TOPIC7"));
			tst.setTOTALQ_TOPIC7(request.getParameter("TOTALQ_TOPIC7"));
			tst.setTOTALM_TOPIC7(request.getParameter("TOTALM_TOPIC7"));

			tst.setQC1_TOPIC8(request.getParameter("QC1_TOPIC8"));
			tst.setC1_TOPIC8(request.getParameter("C1_TOPIC8"));
			tst.setQC2_TOPIC8(request.getParameter("QC2_TOPIC8"));
			tst.setC2_TOPIC8(request.getParameter("C2_TOPIC8"));
			tst.setQC3_TOPIC8(request.getParameter("QC3_TOPIC8"));
			tst.setC3_TOPIC8(request.getParameter("C3_TOPIC8"));
			tst.setQC4_TOPIC8(request.getParameter("QC4_TOPIC8"));
			tst.setC4_TOPIC8(request.getParameter("C4_TOPIC8"));
			tst.setQC5_TOPIC8(request.getParameter("QC5_TOPIC8"));
			tst.setC5_TOPIC8(request.getParameter("C5_TOPIC8"));
			tst.setQC6_TOPIC8(request.getParameter("QC6_TOPIC8"));
			tst.setC6_TOPIC8(request.getParameter("C6_TOPIC8"));
			tst.setTOTALQ_TOPIC8(request.getParameter("TOTALQ_TOPIC8"));
			tst.setTOTALM_TOPIC8(request.getParameter("TOTALM_TOPIC8"));

			tst.setPLO_TOPIC1(request.getParameter("PLO_TOPIC1"));
			tst.setPLO_TOPIC2(request.getParameter("PLO_TOPIC2"));
			tst.setPLO_TOPIC3(request.getParameter("PLO_TOPIC3"));
			tst.setPLO_TOPIC4(request.getParameter("PLO_TOPIC4"));
			tst.setPLO_TOPIC5(request.getParameter("PLO_TOPIC5"));
			tst.setPLO_TOPIC6(request.getParameter("PLO_TOPIC6"));
			tst.setPLO_TOPIC7(request.getParameter("PLO_TOPIC7"));
			tst.setPLO_TOPIC8(request.getParameter("PLO_TOPIC8"));

			tst.setCLO_TOPIC1(request.getParameter("CLO_TOPIC1"));
			tst.setCLO_TOPIC2(request.getParameter("CLO_TOPIC2"));
			tst.setCLO_TOPIC3(request.getParameter("CLO_TOPIC3"));
			tst.setCLO_TOPIC4(request.getParameter("CLO_TOPIC4"));
			tst.setCLO_TOPIC5(request.getParameter("CLO_TOPIC5"));
			tst.setCLO_TOPIC6(request.getParameter("CLO_TOPIC6"));
			tst.setCLO_TOPIC7(request.getParameter("CLO_TOPIC7"));
			tst.setCLO_TOPIC8(request.getParameter("CLO_TOPIC8"));

			tst.setHOUR_TOPIC1(request.getParameter("HOUR_TOPIC1"));
			tst.setHOUR_TOPIC2(request.getParameter("HOUR_TOPIC2"));
			tst.setHOUR_TOPIC3(request.getParameter("HOUR_TOPIC3"));
			tst.setHOUR_TOPIC4(request.getParameter("HOUR_TOPIC4"));
			tst.setHOUR_TOPIC5(request.getParameter("HOUR_TOPIC5"));
			tst.setHOUR_TOPIC6(request.getParameter("HOUR_TOPIC6"));
			tst.setHOUR_TOPIC7(request.getParameter("HOUR_TOPIC7"));
			tst.setHOUR_TOPIC8(request.getParameter("HOUR_TOPIC8"));

			tst.setTIME_TOPIC1(request.getParameter("TIME_TOPIC1"));
			tst.setTIME_TOPIC2(request.getParameter("TIME_TOPIC2"));
			tst.setTIME_TOPIC3(request.getParameter("TIME_TOPIC3"));
			tst.setTIME_TOPIC4(request.getParameter("TIME_TOPIC4"));
			tst.setTIME_TOPIC5(request.getParameter("TIME_TOPIC5"));
			tst.setTIME_TOPIC6(request.getParameter("TIME_TOPIC6"));
			tst.setTIME_TOPIC7(request.getParameter("TIME_TOPIC7"));
			tst.setTIME_TOPIC8(request.getParameter("TIME_TOPIC8"));

			tst.setEXAM_TOPIC1(request.getParameter("EXAM_TOPIC1"));
			tst.setEXAM_TOPIC2(request.getParameter("EXAM_TOPIC2"));
			tst.setEXAM_TOPIC3(request.getParameter("EXAM_TOPIC3"));
			tst.setEXAM_TOPIC4(request.getParameter("EXAM_TOPIC4"));
			tst.setEXAM_TOPIC5(request.getParameter("EXAM_TOPIC5"));
			tst.setEXAM_TOPIC6(request.getParameter("EXAM_TOPIC6"));
			tst.setEXAM_TOPIC7(request.getParameter("EXAM_TOPIC7"));
			tst.setEXAM_TOPIC8(request.getParameter("EXAM_TOPIC8"));

			tst.setTOTALTIME_HR(request.getParameter("TOTALTIME_HR"));
			tst.setTOTALTIME_PERCENTAGE(request
					.getParameter("TOTALTIME_PERCENTAGE"));
			tst.setTOTALEXAM_PERCENTAGE(request
					.getParameter("TOTALEXAM_PERCENTAGE"));
			tst.setTOTALM_C1(request.getParameter("TOTALM_C1"));
			tst.setTOTALM_C2(request.getParameter("TOTALM_C2"));
			tst.setTOTALM_C3(request.getParameter("TOTALM_C3"));
			tst.setTOTALM_C4(request.getParameter("TOTALM_C4"));
			tst.setTOTALM_C5(request.getParameter("TOTALM_C5"));
			tst.setTOTALM_C6(request.getParameter("TOTALM_C6"));
			tst.setTOTALM_ALL(request.getParameter("TOTALM_ALL"));
			tst.setTOTALQ_ALL(request.getParameter("TOTALQ_ALL"));
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			HttpSession session = request.getSession(true);

			tst = TSTDAO.tstValidate(tst);
			if (tst.isValid()) {
				System.out
						.println("Validated. There is enough questions in the question bank.");
			} else {
				System.out
						.println("There is not enough questions in the question bank.");
			}
			if (Integer.parseInt(tst.getTOTALM_ALL()) == 0
					|| Integer.parseInt(tst.getTOTALQ_ALL()) == 0) {
				System.out.println("Either the questions or marks are 0!!");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Either the questions or marks are 0!!');");
				out.println("location='userLecturer/tst.jsp';");
				out.println("</script>");
			} else {
				if (tst.isValid()) {
					session.setAttribute("currentSessionTST", tst);
					response.sendRedirect("userLecturer/generate.jsp");
				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('There is not enough questions in the question bank.');");
					out.println("location='userLecturer/tst.jsp';");
					out.println("</script>");
				}
			}

		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}