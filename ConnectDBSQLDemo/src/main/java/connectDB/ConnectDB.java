package connectDB;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public class ConnectDB {
public static Connection conn=null;
private static ConnectDB instance=new ConnectDB();
public static ConnectDB getInstance() {
	return instance;
}
public void connect() throws SQLException, ClassNotFoundException{
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String url= "jdbc:sqlserver://localhost:1433;databasename=student_1";
	String user="sa";
	String password="sapassword";
	conn= DriverManager.getConnection(url,user,password);
}
public void disconnect() {
	if (conn!=null) 
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
public static Connection getConnection() {
	return conn;
}
}
