package allTables;

public class Promos {
	int id;
	String nom;
	
	public Promos (int id, String nom){
		this.id = id;
		this.nom = nom;
	}
	
	@Override 
	public String toString(){
		return id+" "+nom;
	}

	
	
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setId(int id2) {
		this.id= id2;
		
	}
	
	

}
