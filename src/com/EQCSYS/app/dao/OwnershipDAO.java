package com.EQCSYS.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.EQCSYS.app.bean.LecturerBean;
import com.EQCSYS.app.bean.OwnershipBean;
import com.EQCSYS.app.bean.QuestionBankBean;
import com.EQCSYS.app.util.ConnectionManager;

public class OwnershipDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	
	public static OwnershipBean assignOwnership(OwnershipBean own, QuestionBankBean ques, LecturerBean lect) {
		try {
			Connection con = ConnectionManager.getConnection();

			PreparedStatement ps = con
					.prepareStatement("insert into ownership values(?,?,?)");
			System.out.println("ques!!!");
			ps.setInt(1, lect.getLecturerID());
			System.out.println("ques!!!");
			ps.setInt(2, ques.getQuestionID());
			System.out.println("ques!!!");
			ps.setString(3, own.getShareAccess());
			ps.executeUpdate();
			own.setValid(true);
		} catch (Exception e2) {
			System.out.println(e2);
		}
		return own;
	}

	public static OwnershipBean updateOwnership(OwnershipBean own, QuestionBankBean ques, LecturerBean lect) throws SQLException {
		try {
			currentCon = ConnectionManager.getConnection();
			try {
				PreparedStatement ps = currentCon
						.prepareStatement("update ownership set shareAccess=? where lecturerID=? and questionID=?");
				try {
					ps.setString(1, own.getShareAccess());
					ps.setInt(2, lect.getLecturerID());
					ps.setInt(3, ques.getQuestionID());
					ps.executeUpdate();
					own.setValid(true);
				} finally {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			currentCon.close();
		}
		return own;
	}
	
	public static OwnershipBean deleteOwnership(OwnershipBean own, QuestionBankBean ques, LecturerBean lect) throws SQLException {
		try {
			currentCon = ConnectionManager.getConnection();
			try {
				PreparedStatement ps = currentCon
						.prepareStatement("delete from ownership where lecturerID=? and questionID=?");
				try {
					ps.setInt(1, lect.getLecturerID());
					ps.setInt(2, ques.getQuestionID());
					ps.executeUpdate();
					own.setValid(true);
				} finally {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			currentCon.close();
		}
		return own;
	}
}
