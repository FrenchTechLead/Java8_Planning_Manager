package memoryDatabaseExchange;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import allTables.Batiments;

public class BatimentsLoader {
	
	public static ArrayList<Batiments> getBatimentsList() throws SQLException {
		ArrayList<Batiments> batimentsList = new ArrayList<Batiments>();
		ResultSet result = DbConnection.getStatement().executeQuery("SELECT * FROM batiments");
		while(result.next()){
			batimentsList.add(new Batiments(result.getInt(1), result.getString(2), result.getInt(3)));
		}
		System.out.println("\n\n\n************ Batiments List *************\n" + "(id, nom, nombre_etages)");
		batimentsList.stream().forEach((item)-> System.out.println(item.getId()+" "+item.getNom()+" "+item.getNombre_etages()));
		
		return batimentsList ;
	}

}
