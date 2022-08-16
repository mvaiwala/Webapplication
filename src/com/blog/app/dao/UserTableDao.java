package com.blog.app.dao;

import java.sql.*;

import com.blog.app.entities.UserTable;

public class UserTableDao {
	
	private Connection con;

	//making the obj of connection using constructor of the class UserTableDao (dao class itself).
	public UserTableDao(Connection con) {
		this.con = con;
	}

	//method to insert the data to database
	public boolean saveuser(UserTable usertable)     //intialize obj of getter setter class, it will carry all data(id, username, password) to database
	{
		boolean f=false;
		try
		{
			String query="insert into techblog.usertable (username,emailid,user_password, gender, about) values(?,?,?,?,?)";
			
			PreparedStatement pstmt= con.prepareStatement(query);
			pstmt.setString(1, usertable.getName());
			pstmt.setString(2, usertable.getEmail());
			pstmt.setString(3, usertable.getPassword());
			pstmt.setString(4, usertable.getGender());
			pstmt.setString(5, usertable.getAbout());
			
			pstmt.executeUpdate();
			f=true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return f;
	}
	
	
	//this function will get email and password from servlet and pass it to database(servlet to dao).
	public UserTable getUserTableByEmailAndPassword(String email, String password)
	{
		UserTable ut=null;
		
		try {
			
			String query = "select * from techblog.usertable where emailid=? and user_password=?";
			//it will prepare the query 
			PreparedStatement pstm =con.prepareStatement(query);
			//it will set ? and ? in the above query as email and password we are getting from servlet.
			pstm.setString(1, email);
			pstm.setString(2, password);
			
			//it will fire the query and data are store in resultset's obj.
			ResultSet rs = pstm.executeQuery();
			
			//now send those data from dao to servlet 
			//for one user use if for multiple records use while.
			
			if(rs.next())
			{
				ut = new UserTable();
				//set all the data which came from DB are store in ut obj of UserTable 
				ut.setName(rs.getString("username"));
				ut.setId(rs.getInt("id"));
				ut.setEmail(rs.getString("emailid"));
				ut.setPassword(rs.getString("user_password"));
				ut.setGender(rs.getString("gender"));
				ut.setAbout(rs.getString("about"));
				ut.setDatetime(rs.getTimestamp("registration_date"));
				
				
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ut;
	}
	
}
