/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoryDatabaseExchange;

import allTables.Database;

/**
 *
 * @author user
 */

//Builder abstrait pour créer un objet Database
public abstract class DatabaseBuilder {

    private Database db ;
    
    public Database getDatabase(){
        return db ;
    }
    
    public void initDatabase() {
        this.db = new Database() ;
    }
    
    public abstract void loadBatiments() ;
    public abstract void loadCours() ;
    public abstract void loadPromos() ;
    public abstract void loadSalles() ;
    public abstract void loadSeances() ;
    public abstract void loadUsers() ;
}


