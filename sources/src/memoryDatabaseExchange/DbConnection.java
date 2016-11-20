package memoryDatabaseExchange;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	
	private static Connection singleConnection ;
	private static Statement  singleStatement;
	
	
	public static synchronized Statement getStatement() throws SQLException{
		
		if (singleConnection == null){
			singleConnection = DriverManager.getConnection("jdbc:mysql://sql4.freesqldatabase.com:3306/sql4100703","sql4100703","pass");
			if (singleStatement == null){
				singleStatement = singleConnection.createStatement();
				System.out.println("Connection Success !");
			}
		}
		return singleStatement;
	}

}
