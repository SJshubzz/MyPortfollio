package com.dao;

import com.mysql.cj.xdevapi.SessionFactory;

public class UserDao {
	private SessionFactory factory;
	public void USerDao(SessionFactory factory) {
		this.factory=factory;
	}
	

}
