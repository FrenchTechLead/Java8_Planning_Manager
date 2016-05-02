package interface_Graphique.occcup_Par_Prof_mvc;

import allTables.Database;

public class OccupParProfModel {
	 private Database db;
	    
	    public OccupParProfModel(Database db){
	        this.db = db;
	    }


	    
	    
	    public Database getDb(){
	    	return this.db;
	    }
}
