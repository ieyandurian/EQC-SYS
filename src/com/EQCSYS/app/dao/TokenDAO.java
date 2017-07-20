package com.EQCSYS.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.EQCSYS.app.bean.TokenBean;
import com.EQCSYS.app.util.ConnectionManager;

public class TokenDAO {
	public static TokenBean tokenization(TokenBean token, Connection currentCon) {
		PreparedStatement ps;
		try {
			ps = currentCon.prepareStatement("insert into token values (?,?)");
			ps.setString(1, token.getSentence());
			ps.setString(2, token.getTopicCode());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return token;
	}
	
	public static TokenBean deleteToken(TokenBean token) {
		Connection currentCon = ConnectionManager.getConnection();
		PreparedStatement ps;
		try {
			ps = currentCon.prepareStatement("delete from token");
			ps.executeUpdate();
			ps.close();
			token.setValid(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return token;
	}
}