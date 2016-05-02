package memoryDatabaseExchange;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import allTables.Users;

public class UsersLoader{
		
	public static ArrayList<Users> getUsersList() throws SQLException {
		ArrayList<Users> usersList = new ArrayList<Users>();
		ResultSet result = DbConnection.getStatement().executeQuery("SELECT * FROM users");
		while(result.next()){
			usersList.add(new Users(result.getInt(1), result.getString(2), result.getString(3)));
		}
		System.out.println("\n\n\n************ Users List *************\n" + "(id, nom, type)");
		usersList.stream().forEach((item)-> System.out.println(item.getId()+" "+item.getNom()+" "+item.getType()));
		
		return usersList ;
	}
}
