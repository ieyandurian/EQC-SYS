package com.EQCSYS.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.EQCSYS.app.bean.LecturerBean;
import com.EQCSYS.app.util.ConnectionManager;

public class LecturerDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static LecturerBean loginLecturer(LecturerBean bean) {
		// preparing some objects for connection
		
		Statement stmt = null;
		int lecturerID = bean.getLecturerID();
		String lecturerPassword = bean.getLecturerPassword();
		String searchQuery = "select * from lecturer where lecturerID='"
				+ lecturerID + "' AND lecturerPassword='" + lecturerPassword + "'";
		// "System.out.println" prints in the console; Normally used to trace
		// the process
		System.out.println("Lecturer id is " + lecturerID);
		System.out.println("Lecturer password is " + lecturerPassword);
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
				System.out.println("Welcome Lecturer. You can create and manage Lecturer as an admin of EQC-SYS.");
				bean.setLecturerID(rs.getInt(1));
				bean.setLecturerPassword(rs.getString(2));
				bean.setLecturerFirstName(rs.getString(3));
				bean.setLecturerLastName(rs.getString(4));
				bean.setLecturerPhoneNumber(rs.getString(5));
				bean.setLecturerEmail(rs.getString(6));
				bean.setLecturerFaculty(rs.getString(7));
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
	
	public static LecturerBean addLecturer(LecturerBean lect) {
		try {
			Connection con = ConnectionManager.getConnection();

			PreparedStatement ps = con
					.prepareStatement("insert into lecturer values(lecturerID.nextVal,?,?,?,?,?,?)");
			ps.setString(1, lect.getLecturerPassword());
			ps.setString(2, lect.getLecturerFirstName());
			ps.setString(3, lect.getLecturerLastName());
			ps.setString(4, lect.getLecturerPhoneNumber());
			ps.setString(5, lect.getLecturerEmail());
			ps.setString(6, lect.getLecturerFaculty());
			ps.executeUpdate();
			lect.setValid(true);
		} catch (Exception e2) {
			System.out.println(e2);
		}
		return lect;
	}
	
	public static LecturerBean deleteLecturer(LecturerBean lect)
			throws SQLException {
		// "System.out.println" prints in the console; Normally used to trace
		// the process
		System.out.println("Stage 2 - deleting lecturer...");

		try {
			currentCon = ConnectionManager.getConnection();
			try {
				System.out.println("Stage 3 - deleting lecturer...");
				PreparedStatement ps = currentCon
						.prepareStatement("delete from lecturer where lecturerID = ?");
				try {
					System.out.println("Stage 4 - deleting lecturer...");
					ps.setInt(1, lect.getLecturerID());
					int i = ps.executeUpdate();
					lect.setValid(true);
					System.out.println("Stage 5 - deleting lecturer...");
					ps.close();
					if (i > 0) {
						System.out
								.println("The lecturer has been deleted successfully….");
					} else {
						System.out
								.println("Lecturer cannot be deleted..Try Again…");
					}
				} catch (SQLException ex) {
					System.out
							.println("Integrity constraint: an exception has occurred! "
									+ ex);
				} finally {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			currentCon.close();
		}
		return lect;
	}
	
	public static LecturerBean updateLecturer(LecturerBean lect)
			throws SQLException {
		try {
			currentCon = ConnectionManager.getConnection();
			try {
				PreparedStatement ps = currentCon
						.prepareStatement("update lecturer set lecturerPassword=?, lecturerFirstName=?, lecturerLastName=?, lecturerPhoneNumber=?, lecturerEmail=?, lecturerFaculty=? where lecturerID=?");
				try {
					ps.setString(1, lect.getLecturerPassword());
					ps.setString(2, lect.getLecturerFirstName());
					ps.setString(3, lect.getLecturerLastName());
					ps.setString(4, lect.getLecturerPhoneNumber());
					ps.setString(5, lect.getLecturerEmail());
					ps.setString(6, lect.getLecturerFaculty());
					ps.setInt(7, lect.getLecturerID());
					ps.executeUpdate();
					lect.setValid(true);
				} finally {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			currentCon.close();
		}
		return lect;
	}
}