/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoryDatabaseExchange;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */

//Va créer un objet Database à partir de ce qui est contenu dans notre base de données
public class DatabaseBuilderLoad extends DatabaseBuilder {

    @Override
    public void loadBatiments() {
        try {
            getDatabase().setBatiments(BatimentsLoader.getBatimentsList()) ;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBuilderLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void loadCours() {
        try {
            getDatabase().setCours(CoursLoader.getCoursList()) ;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBuilderLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void loadPromos() {
        try {
            getDatabase().setPromos(PromosLoader.getPromosList()) ;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBuilderLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void loadSalles() {
        try {
            getDatabase().setSalles(SallesLoader.getSallesList()) ;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBuilderLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void loadSeances() {
        try {
            getDatabase().setSeances(SeancesLoader.getSeancesList()) ;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBuilderLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void loadUsers() {
        try {
            getDatabase().setUsers(UsersLoader.getUsersList()) ;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBuilderLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
