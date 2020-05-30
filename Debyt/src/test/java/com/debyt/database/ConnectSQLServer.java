package com.debyt.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.debyt.testCases.TC_Signup_1_DDT;
import com.google.common.annotations.VisibleForTesting;

public class ConnectSQLServer {

	
	public String testDB(String wemail) throws ClassNotFoundException, SQLException
	{
		
		
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
	
	String url = "jdbc:sqlserver://debytqasql.database.windows.net;databaseName=qamssqldebyt";
	String UserName="debytQA";
	String Password="Thf7yt39b9";
	String email = wemail;
	String result = null;
	
	Connection con = DriverManager.getConnection(url, UserName, Password);
	
	System.out.println("Connected to DB");
	
	String query = "Select VerifyEmailToken from dbo.accounts where email = '"+email+"';";
	
	Statement stmt = con.createStatement();
	
	ResultSet rst = stmt.executeQuery(query);
	
	while (rst.next())
	{
		result = rst.getNString(1);
		
		System.out.println ("Token: "+result);
		
		break;
	}
	
	con.close();
	
	return result;
	
	
	
	

}
	}