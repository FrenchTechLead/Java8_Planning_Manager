package interface_Graphique.connexion_mvc;

import java.util.List;
import java.util.stream.Collectors;

import allTables.Database;
import allTables.Users;

public class ConnectionModel {
    
    private Database db;
    
    public ConnectionModel(Database db){
        this.db = db;
    }


    
    public List<String> getUsersList(){
        return this.db.getUsers().stream().map(Users::getNom).collect(Collectors.toList());
    }
    
    public Database getDb(){
    	return this.db;
    }
}