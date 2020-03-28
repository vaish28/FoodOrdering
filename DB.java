package com;
import java.sql.*;
public class DB {

	public static Connection conc()
	{
		Connection con;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			String url=("jdbc:mysql://localhost/dabewala");

			 con=DriverManager.getConnection(url,"root","abcd");
			
			 return con;
		}
		catch(Exception e)
		{
			System.out.println("exception"+e);
			return null;
		} 
		
	}

}
