package memoryDatabaseExchange;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import allTables.Seances;

public class SeancesLoader {
	
	public static ArrayList<Seances> getSeancesList() throws SQLException {
		ArrayList<Seances> seancesList = new ArrayList<Seances>();
		ResultSet result = DbConnection.getStatement().executeQuery("SELECT * FROM seances");
		while(result.next()){
			seancesList.add(new Seances(result.getInt(1), result.getTimestamp(2), result.getTimestamp(3),
					result.getInt(4),result.getInt(5),result.getInt(6),result.getInt(7),result.getString(8)));
		}
		System.out.println("\n\n\n************ seances List *************\n"
				+ "(id, debut, fin, cours_id, salle_id, prof_id, promos_id, type)");
		seancesList.stream().forEach((item)-> System.out.println(item.getId()+" "+item.getDebut()+
				" "+item.getFin()+" "+item.getCours_id()+" "+item.getSalle_id()+" "+
				" "+item.getProf_id()+" "+item.getPromos_id()+" "+item.getType()));
		
		return seancesList ;
	}

}
