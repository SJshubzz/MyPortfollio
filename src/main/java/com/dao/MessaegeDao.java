package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.pojo.MessagePojo;

public class MessaegeDao implements insertDao,readDao {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private int row;
	private String result;
	private String sql;
	private ResultSet rs;

	@SuppressWarnings("finally")
	@Override
	public String insert(ArrayList<Object> al) {
		try {
			connection = connectionFactory.getcConnection();
//			String name = (String) al.get(0);
//			String email = (String) al.get(1);
//			String message = (String) al.get(2);
			sql = "insert into message(name,email,message,datetime) values(?,?,?,?)";
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

	@Override
	public ArrayList<Object> read() {
		
		ArrayList<Object> arrayList=new ArrayList<>();
		try {
			connection=connectionFactory.getcConnection();
			sql="select * from message";
			preparedStatement=connection.prepareStatement(sql);
			rs=preparedStatement.executeQuery();
			while(rs.next()) {
				MessagePojo m=new MessagePojo(rs.getInt("sn"), rs.getString("name"), rs.getString("email"), rs.getString("message"),rs.getString("datetime"));
				arrayList.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return arrayList;
	}

	@Override
	public String login(String email, String password) {
		try {
			sql="select * from admin where email=? and password=?";
			connection=connectionFactory.getcConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			rs=preparedStatement.executeQuery();
			if (rs.next()==true) {
				result="exist";
			}else {
				result="not exist";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return result; 
	}

}
