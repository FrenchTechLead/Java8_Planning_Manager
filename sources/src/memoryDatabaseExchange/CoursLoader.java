package memoryDatabaseExchange;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import allTables.Cours;


public class CoursLoader {
	
	public static ArrayList<Cours> getCoursList() throws SQLException {
		ArrayList<Cours> coursList = new ArrayList<Cours>();
		ResultSet result = DbConnection.getStatement().executeQuery("SELECT * FROM cours");
		while(result.next()){
			coursList.add(new Cours(result.getInt(1), result.getString(2), result.getString(3)));
		}
		System.out.println("\n\n\n************ Cours List *************\n" + "(id, nom, prof_responsable)");
		coursList.stream().forEach((item)-> System.out.println(item.getId()+" "+item.getNom()+" "+item.getProf_responsable()));
		
		return coursList ;
	}

}
