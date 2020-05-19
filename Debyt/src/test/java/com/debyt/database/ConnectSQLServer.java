package com.debyt.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.testng.annotations.Test;

public class ConnectSQLServer {

	
	public void testDB(Object ArrayList) throws ClassNotFoundException, SQLException
	{
		
		
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
	
	String url = "jdbc:sqlserver://debytqasql.database.windows.net;databaseName=qamssqldebyt";
	String UserName="debytQA";
	String Password="Thf7yt39b9";
	
	Connection con = DriverManager.getConnection(url, UserName, Password);
	
	System.out.println("Connected to DB");
	
	String query = "Select top 1 email from dbo.accounts;";
	Statement statement = con.createStatement();
	
	ResultSet rst = statement.executeQuery(query);
	
	System.out.println("result: "+rst);

}
	}