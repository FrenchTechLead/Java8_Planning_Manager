package allTables;

public class Salles {
	private int id;
	private String type;
	private int etage;
	private String nom;
	private int batiment_id;
	private int id_voisin_precedent;
	private int id_voisin_suivant;
	
	public Salles(int id, String type, int etage, String nom, int batiment_id, int id_voisin_precedent,
			int id_voisin_suivant) {
		super();
		this.id = id;
		this.type = type;
		this.etage = etage;
		this.nom = nom;
		this.batiment_id = batiment_id;
		this.id_voisin_precedent = id_voisin_precedent;
		this.id_voisin_suivant = id_voisin_suivant;
	}
	
	@Override
	public String toString(){
		return "nom: "+nom+" type: "+type;
	}
        
        public String toStringShort(){
            return id+ "   " + etage + " " + nom + " (" + type + ")" ; 
        }
	
	
	
	public int getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	public int getEtage() {
		return etage;
	}
	public String getNom() {
		return nom;
	}
	public int getBatiment_id() {
		return batiment_id;
	}
	public int getId_voisin_precedent() {
		return id_voisin_precedent;
	}
	public int getId_voisin_suivant() {
		return id_voisin_suivant;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	
	
	

}
