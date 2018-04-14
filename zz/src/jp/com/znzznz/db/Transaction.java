package jp.com.znzznz.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import jp.com.znzznz.util.PropertyManager;

public class Transaction implements AutoCloseable{

	private final Connection con;
	private HashMap<String, String> prop = PropertyManager.load("connection");
	private final String url = prop.get("url");
	private final String user = prop.get("user");
	private final String pass = prop.get("pass");
	
	private Transaction(boolean isReadOnly) throws SQLException{
		
		this.con = DriverManager.getConnection(url, user, pass);
	}
	
	@Override public void close() throws Exception{
		
		if (this.con != null) {
			
			this.con.close();
		}
	}

}
