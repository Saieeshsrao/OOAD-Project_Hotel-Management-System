package hotel;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
	private String url;
	private String user;
	private String pwd;
	private Connection connect;

	public GetConnection() {
		url = "jdbc:mysql://localhost:3307/hotelmodel?serverTimezone=UTC";
		user = "root";
		pwd = "";
	}

	public Connection getConnection() {
		try {
			connect = DriverManager.getConnection(url, user, pwd);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return connect;
	}
}
