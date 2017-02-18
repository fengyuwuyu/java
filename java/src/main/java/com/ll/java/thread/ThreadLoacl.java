package com.ll.java.thread;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ll.java.main.App;

public class ThreadLoacl {

	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>(){

		@Override
		protected Connection initialValue() {
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(App.DB_URL, App.USERNAME, App.PASSWD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}
		
	};
	
	public static Connection getConnection(){
		return threadLocal.get();
	}
}
