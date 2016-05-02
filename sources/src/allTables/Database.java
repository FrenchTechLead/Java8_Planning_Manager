/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allTables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.*;

import org.apache.commons.lang3.time.DateUtils;

import memoryDatabaseExchange.DbConnection;

/**
 *
 * @author user
 */
public class Database {

    private ArrayList<Batiments> batiments;
    private ArrayList<Cours> cours;
    private ArrayList<Promos> promos;
    private ArrayList<Salles> salles;
    private ArrayList<Seances> seances;
    private ArrayList<Users> users;

    public <T> void addItem(T item) {
        if (item instanceof Batiments) {
            this.batiments.add((Batiments) item);
        } else if (item instanceof Cours) {
            this.cours.add((Cours) item);
        } else if (item instanceof Promos) {
            this.promos.add((Promos) item);
        } else if (item instanceof Salles) {
            this.salles.add((Salles) item);
        } else if (item instanceof Seances) {
            this.seances.add((Seances) item);
        } else if (item instanceof Users) {
            this.users.add((Users) item);
        }
    }
    
    
    public boolean addSalle(Salles salle) throws SQLException{
    	String query = "INSERT INTO salles(type, etage, nom, batiment_id, id_voisin_precedent, id_voisin_suivant) "
        		+ "VALUES ( "
        		+ "'" + salle.getType() + "','" 
        		+ salle.getEtage() + "','" 
        		+ salle.getNom() + "','" 
        		+ salle.getBatiment_id() + "','" 
        		+ salle.getId_voisin_precedent() + "','"
        		+ salle.getId_voisin_suivant() 
        		
        		+"')";
    	try {
			DbConnection.getStatement().executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}
        ResultSet result = DbConnection.getStatement().executeQuery("SELECT salle_id from salles ORDER BY salle_id DESC LIMIT 1");
        int id =0;
        if (result.first()) {
            id = result.getInt(1);
        }
        salle.setId(id);
    	addItem(salle);
    	
    	if(id==0)return false;
    	return true;
    }
    
    
    
    public boolean addPromos(Promos promos) throws SQLException{
    	String query = "INSERT INTO promos(nom) "
        		+ "VALUES ( '" + promos.getNom() + "')";
    	try {
			DbConnection.getStatement().executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}
        ResultSet result = DbConnection.getStatement().executeQuery("SELECT promo_id from promos ORDER BY promo_id DESC LIMIT 1");
        int id =0;
        if (result.first()) {
            id = result.getInt(1);
        }
        promos.setId(id);
    	addItem(promos);
    	
    	if(id==0)return false;
    	return true;
    }
    
    public boolean addCours(Cours cours) throws SQLException{
    	String query = "INSERT INTO cours(nom_cours, prof_responsable) "
        		+ "VALUES ( '" + cours.getNom() + "','" + cours.getProf_responsable() +"')";
    	try {
			DbConnection.getStatement().executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}
        ResultSet result = DbConnection.getStatement().executeQuery("SELECT liste_cours_id from cours ORDER BY liste_cours_id DESC LIMIT 1");
        int id =0;
        if (result.first()) {
            id = result.getInt(1);
        }
        cours.setId(id);
    	addItem(cours);
    	
    	if(id==0)return false;
    	return true;
    }
    
    public boolean addBatiment(Batiments batiment) throws SQLException{
    	String query = "INSERT INTO batiments(nom_batiment, nombre_etages) "
        		+ "VALUES ( '" + batiment.getNom() + "','" + batiment.getNombre_etages() +"')";
    	try {
			DbConnection.getStatement().executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}
        ResultSet result = DbConnection.getStatement().executeQuery("SELECT batiment_id from batiments ORDER BY batiment_id DESC LIMIT 1");
        int id =0;
        if (result.first()) {
            id = result.getInt(1);
        }
        batiment.setId(id);
    	addItem(batiment);
    	
    	if(id==0)return false;
    	return true;
    }
    
    public boolean addUser(Users user) throws SQLException{
		
    	String query = "INSERT INTO users(nom_user, type_user) "
        		+ "VALUES ( '" + user.getNom() + "','" + user.getType() +"')";
    	try {
			DbConnection.getStatement().executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}
        ResultSet result = DbConnection.getStatement().executeQuery("SELECT user_id from users ORDER BY user_id DESC LIMIT 1");
        int id =0;
        if (result.first()) {
            id = result.getInt(1);
        }
    	user.setId(id);
    	addItem(user);
    	
    	if(id==0)return false;
    	return true;
    }

    public  ArrayList<Salles> freeFromTo(Timestamp debut, Timestamp fin) {
    	ArrayList<Salles> all = new ArrayList<>();
    	for(Salles item : salles)all.add(item); // to copy by value and not by reference !
    	System.out.println("toutes "+all);
    	all.removeAll(occupeeFromTo(debut, fin));
    	System.out.println("libres "+all);
    	return all;
    	
    }
    
    public ArrayList<Salles> occupeeFromTo(Timestamp debut, Timestamp fin){
    	List<Integer> IdSallesOccupeesDansCeCreneau = new ArrayList<>();
    	// salles occupées dans le créneau selectionné
    	IdSallesOccupeesDansCeCreneau = getSeances().stream()
    			.filter(s -> ( s.getDebut().before(debut) && s.getFin().after(debut) ) ||
    					     ( s.getDebut().before(fin) && s.getFin().after(fin)     )||
    					     ( debut.before(s.getDebut()) && fin.after(s.getFin())	) ||
    					     debut.equals(s.getDebut()) || fin.equals(s.getFin())
    					     ).map( s -> s.getSalle_id()).distinct()
    					     .collect(Collectors.toList());
    	ArrayList<Salles> sallesOccupes = new ArrayList<>();
    	for (Integer id : IdSallesOccupeesDansCeCreneau){
    		sallesOccupes.add(getSallesById(id));
    	}
    	System.out.println("Occupees"+sallesOccupes);
    	return sallesOccupes;
    }

 
    
    public List<Salles> getSallesDansBat (Batiments b) {
        return getSalles().stream()
                .filter(s-> s.getBatiment_id()==b.getId())
               .collect(Collectors.toList());
    }

    
    
    public String timestampFormat(Timestamp t) {
    	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = formatter.format(t.getTime());
        return s;
    }

    
    //returns True if booked correctly !
    public boolean bookRoom(Salles salle, Cours cours, Timestamp debut, Timestamp fin, Promos promo, String type, Users prof) throws SQLException {
        if(debut.after(fin))return false;
    	int id_prof = prof.getId();
        String query = "INSERT INTO seances(heure_debut, heure_fin, cours_id, salle_id, prof_id, promo_id, type) "
        		+ "VALUES ( '" + timestampFormat(debut) + "','" + timestampFormat(fin) + "','" + cours.getId() + "','"
                + salle.getId() + "','" + id_prof + "','" + promo.getId() + "','" + type + "')";
        DbConnection.getStatement().executeUpdate(query);

        int id = 0; //la vraie id sera recuperee apres recuperation de la bd distante
        Seances s = new Seances(id, debut, fin, cours.getId(), salle.getId(), id_prof, promo.getId(), type);
        ResultSet result = DbConnection.getStatement().executeQuery("SELECT seance_id from seances ORDER BY seance_id DESC LIMIT 1");

        if (result.first()) {
            id = result.getInt(1);
        }
        s.setId(id);
        addItem(s);
        if(id==0)return false;
        else return true;
    }

    public List<Seances> getPlanningByDayByPromos(Date date, int promosId) {
        Comparator<Seances> byTimeStamp = (e1, e2) -> e1.getDebut().compareTo(e2.getFin()); //pour trier par heure de debut

        return this.seances.stream().filter(seance -> seance.getPromos_id() == promosId
                && DateUtils.isSameDay(seance.debut, date))
                .sorted(byTimeStamp).collect(Collectors.toList());

    }
    
    public List<Salles> getSallesOccupeeParProfParDate(int idProf,Date date){
    	List<Salles> sallesoccup = new ArrayList<>();
    	this.getSeances().stream().filter(seance -> seance.getProf_id() == idProf 
    			&& DateUtils.isSameDay(seance.debut, date)).map(seance -> seance.getSalle_id())
    	.collect(Collectors.toList()).forEach(idSalles ->sallesoccup.add(getSallesById(idSalles)));
    	System.out.println("salles occupee : "+sallesoccup);
    	return sallesoccup;
    }
    
    public String getCoursNameById(int id) {

        try {
            return this.cours.stream().
                    filter(cours -> cours.getId() == id).
                    map(cours -> cours.getNom()).
                    collect(Collectors.toList()).
                    get(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("aucun cours!");
            return "";
        }

    }

    public Cours getCoursById(int id) {
        return this.cours.stream().
                filter(c -> c.getId() == id).
                collect(Collectors.toList()).
                get(0);
    }

    public Batiments getBatimentsById(int id) {
        return this.batiments.stream().
                filter(b -> b.getId() == id).
                collect(Collectors.toList()).
                get(0);
    }

    public Promos getPromosById(int id) {
        return this.promos.stream().
                filter(p -> p.getId() == id).
                collect(Collectors.toList()).
                get(0);
    }

    public Salles getSallesById(int id) {
    	try{
    		return this.salles.stream().
                    filter(s -> s.getId() == id).
                    collect(Collectors.toList()).
                    get(0);
    	}catch(Exception x){
    		
    	}
        return null;
    }

    public Seances getSeancesById(int id) {
        return this.seances.stream().
                filter(s -> s.getId() == id).
                collect(Collectors.toList()).
                get(0);
    }

    public Users getUsersById(int id) {
        return this.users.stream().
                filter(u -> u.getId() == id).
                collect(Collectors.toList()).
                get(0);
    }
    
    


    //getters and setters
    public void setBatiments(ArrayList<Batiments> b) {
        this.batiments = b;
    }

    public void setCours(ArrayList<Cours> c) {
        this.cours = c;
    }

    public void setPromos(ArrayList<Promos> p) {
        this.promos = p;
    }

    public void setSalles(ArrayList<Salles> s) {
        this.salles = s;
    }

    public void setSeances(ArrayList<Seances> s) {
        this.seances = s;
    }

    public void setUsers(ArrayList<Users> u) {
        this.users = u;
    }

    public ArrayList<Batiments> getBatiments() {
        return batiments;
    }

    public ArrayList<Cours> getCours() {
        return cours;
    }

    public ArrayList<Promos> getPromos() {
        return promos;
    }

    public ArrayList<Salles> getSalles() {
        return salles;
    }

    public ArrayList<Seances> getSeances() {
        return seances;
    }

    public ArrayList<Users> getUsers() {
        return users;
    }

}
