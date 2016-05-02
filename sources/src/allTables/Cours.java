package allTables;

public class Cours {
	
	private int id;
	private String nom;
	private String prof_responsable;
	
	public Cours(int id, String nom, String prof_responsable) {
		this.id = id;
		this.nom = nom;
		this.prof_responsable = prof_responsable;
	}
	
	
	@Override
	public String toString(){
		return this.nom;	
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}

	public String getProf_responsable() {
		return prof_responsable;
	}
	
	

}
