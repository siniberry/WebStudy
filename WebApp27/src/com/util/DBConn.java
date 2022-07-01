/* ============================================
 	DBConn.java
 	- 데이터베이스 연결 전용 객체(Singleton)
 	- 예외 처리 : throws
============================================*/
package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn
{
	private static Connection dbconn;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		if (dbconn == null)
		{
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String pwd = "tiger";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			dbconn = DriverManager.getConnection(url, user, pwd);
		}
		return dbconn;
	}
	
	
	public static Connection getConnection(String url, String user ,String pwd) throws ClassNotFoundException, SQLException
	{
		if (dbconn == null)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			dbconn = DriverManager.getConnection(url, user, pwd);
		}
		return dbconn;
	}
	
	
	public static void close() throws SQLException
	{
		if (dbconn != null)
		{
			if (!dbconn.isClosed())
			{
				dbconn.close();
			}
		}
		dbconn = null;
	}
	
}
