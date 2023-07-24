package com.dao;

import java.sql.Connection;
import com.mysql.cj.jdbc.MysqlDataSource;

public class connectionFactory {
	private static Connection connection;

	@SuppressWarnings("finally")
	public static Connection getcConnection() {
		try {
			MysqlDataSource mysql = new MysqlDataSource();
			mysql.setUser("root");
			mysql.setUrl("jdbc:mysql://localhost:3306/prtofollio");
			mysql.setPassword("");
			connection = mysql.getConnection();
			mysql.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return connection;
		}
	}

}
