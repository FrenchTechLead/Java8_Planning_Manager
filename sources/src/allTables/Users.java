package allTables;

public class Users {
	
	private int id;
	private String nom;
	private String type;
	
	public Users(int id, String nom, String type) {
		this.id = id;
		this.nom = nom;
		this.type = type;
	}
	
	
	@Override
	public String toString(){
		return this.id+" "+this.nom+" "+this.type;	
	}


	
	
	
	public void setId(int id) {
		this.id = id;
	}


	public int getId() {
		return id;
	}


	public String getNom() {
		return nom;
	}


	public String getType() {
		return type;
	}
	
	
	
	
}
