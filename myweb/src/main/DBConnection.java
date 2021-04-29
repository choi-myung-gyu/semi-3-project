package main;

import java.sql.*;

public class DBConnection {
	private String url = "jdbc:oracle:thin:@";
	private String ip = "localhost";
	private String port = "1521";
	private String username = "web_admin";
	private String password = "web_admin";
	private Connection connection = null;
	
	public DBConnection() {
		this.connect();
	}
	
	public DBConnection(String username, String password) {
		this.username = username;
		this.password = password;
		this.connect();
	}
	
	public DBConnection(String port, String username, String password) {
		this.port = port;
		this.username = username;
		this.password = password;
		this.connect();
	}
	
	public DBConnection(String ip, String port, String username, String password) {
		this.ip = ip;
		this.port = port;
		this.username = username;
		this.password = password;
		this.connect();
	}
	
	private void connect() {
		this.url += this.ip + ":" + this.port + ":xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.connection = DriverManager.getConnection(this.url, this.username, this.password);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Connection getConnect() {
		return this.connection;
	}
	
	public void close() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
