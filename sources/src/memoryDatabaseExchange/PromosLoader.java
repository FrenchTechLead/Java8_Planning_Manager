package memoryDatabaseExchange;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import allTables.Promos;


public class PromosLoader {

	public static ArrayList<Promos> getPromosList() throws SQLException {
		ArrayList<Promos> promosList = new ArrayList<Promos>();
		ResultSet result = DbConnection.getStatement().executeQuery("SELECT * FROM promos");
		while(result.next()){
			promosList.add(new Promos(result.getInt(1), result.getString(2)));
		}
		System.out.println("\n\n\n************ Promos List *************\n"
				+ "(id, nom)");
		promosList.stream().forEach((item)-> System.out.println(item.getId()+" "+item.getNom()));
		
		return promosList ;
	}
}
