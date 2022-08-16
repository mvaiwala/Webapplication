package com.blog.app.helper;
import java.sql.*;


public class ConectionProvider {

	private static Connection con;
	public static Connection getConnection() throws SQLException
	{
		
		try {
			
			//it will check whether con has any connection or not
			//this condition will check one time only
			
			if(con==null)
			{
				//step 1 : load mysql driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//step 2 : get the connection
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/beer?useSSL=false", "root", "rootmadhav@8498");
			
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return con;
	}
	
}
