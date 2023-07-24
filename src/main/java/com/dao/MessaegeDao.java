package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.apache.tomcat.dbcp.dbcp2.ConnectionFactory;

public class MessaegeDao implements insertDao {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private int row;
	private String result;

	@SuppressWarnings("finally")
	@Override
	public String insert(ArrayList<Object> al) {
		try {
			connection = connectionFactory.getcConnection();
//			String name = (String) al.get(0);
//			String email = (String) al.get(1);
//			String message = (String) al.get(2);
			String sql = "insert into message(name,email,message,datetime) values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, (String) al.get(0));
			preparedStatement.setString(2, (String) al.get(1));
			preparedStatement.setString(3, (String) al.get(2));
			preparedStatement.setString(4, LocalDateTime.now().toString());

			row = preparedStatement.executeUpdate();
			if (row == 1)
				result = "Saved";

			System.out.println(connection);
		} catch (Exception e) {
			result = "failed";
			e.printStackTrace();
		} finally {
			return result;
		}
	}

}
