package com.EQCSYS.app.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.EQCSYS.app.bean.AdminBean;
import com.EQCSYS.app.util.ConnectionManager;

public class AdminDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static AdminBean loginAdmin(AdminBean bean) {
		// preparing some objects for connection
		
		Statement stmt = null;
		String adminID = bean.getAdminID();
		String adminPassword = bean.getAdminPassword();
		String searchQuery = "select * from admin where adminID='"
				+ adminID + "' AND adminPassword='" + adminPassword + "'";
		// "System.out.println" prints in the console; Normally used to trace
		// the process
		System.out.println("Admin id is " + adminID);
		System.out.println("Admin password is " + adminPassword);
		System.out.println("Query: " + searchQuery);

		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();
			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out
						.println("Sorry, you are not authorized to use the system");
				bean.setValid(false);
			}
			// if user exists set the isValid variable to true
			else if (more) {
				System.out.println("Welcome Admin. You can create and manage Lecturer as an admin of EQC-SYS.");
				bean.setValid(true);
			}
		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}
		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return bean;
				
	}
}