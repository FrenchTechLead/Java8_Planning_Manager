package allTables;

import java.sql.Timestamp;
public class Seances {

	int id;
	Timestamp debut;
	Timestamp fin;
	int cours_id;
	int salle_id;
	int prof_id;
	int promos_id;
	String type;
	
	public Seances(int id, Timestamp debut, Timestamp fin, int cours_id, int salle_id, int prof_id, int promos_id,
			String type) {
		this.id = id;
		this.debut = debut;
		this.fin = fin;
		this.cours_id = cours_id;
		this.salle_id = salle_id;
		this.prof_id = prof_id;
		this.promos_id = promos_id;
		this.type = type;
	}
	
	
	@Override
	public String toString(){
		return id+" "+type+" "+debut+" "+fin+" "+cours_id+" "+salle_id+" "+prof_id+" "+promos_id+" "+type;
	}
	

	public int getId() {
		return id;
	}

	public Timestamp getDebut() {
		return debut;
	}

	public Timestamp getFin() {
		return fin;
	}

	public int getCours_id() {
		return cours_id;
	}

	public int getSalle_id() {
		return salle_id;
	}

	public int getProf_id() {
		return prof_id;
	}

	public int getPromos_id() {
		return promos_id;
	}

	public String getType() {
		return type;
	}
	
        public void setId(int id) {
            this.id = id ;
        }
	
	
	
	
	
	
}
