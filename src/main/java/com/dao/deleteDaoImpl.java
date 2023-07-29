package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class deleteDaoImpl implements deleteDao {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private String result;
	private String sql;
	private ResultSet rs;
	private int i;

	@Override
	public String deleteMessage(String sn) {
		try {
			connection=connectionFactory.getcConnection();
			sql="delete from message where sn=?";
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1, Integer.parseInt(sn));
			i=preparedStatement.executeUpdate();
			if (i==1) {
				result="deleted";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result="failed";
		}finally {
			
			return result;
		}
		
		
	}

}
