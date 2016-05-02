package allTables;


public class Batiments {
	int id;
	String nom;
	int nombre_etages;
	
	public Batiments(int id, String nom, int nombre_etages) {
		this.id = id;
		this.nom = nom;
		this.nombre_etages = nombre_etages;
	}
	
	
	@Override
	public String toString(){
		return this.nom;	
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public int getNombre_etages() {
		return nombre_etages;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	
	

}
