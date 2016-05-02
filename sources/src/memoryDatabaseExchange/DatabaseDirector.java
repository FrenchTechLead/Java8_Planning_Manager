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
public class DatabaseDirector {
    private DatabaseBuilder builder ;
    
    public void setBuilder(DatabaseBuilder builder) { this.builder = builder ;}
    public Database getDatabase() {
        return builder.getDatabase() ;
    }
    
    public void build() {
        builder.initDatabase() ;
        builder.loadBatiments();
        builder.loadCours();
        builder.loadPromos();
        builder.loadSalles();
        builder.loadSeances();
        builder.loadUsers();
    }
}
