package interface_Graphique.affToutesSalles_mvc;

import allTables.Database;

public class ToutesSallesModel {
	
	 private Database db;
	    
	    public ToutesSallesModel(Database db){
	        this.db = db;
	    }


	    
	    
	    public Database getDb(){
	    	return this.db;
	    }
}
