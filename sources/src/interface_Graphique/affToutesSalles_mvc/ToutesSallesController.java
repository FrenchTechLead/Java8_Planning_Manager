package interface_Graphique.affToutesSalles_mvc;


import java.util.List;
import allTables.*;

public class ToutesSallesController {
	private ToutesSallesModel model;
	private ToutesSallesView view;

	
	 public ToutesSallesController(ToutesSallesModel model, ToutesSallesView view){
	        this.model = model;
	        this.view = view;

	    }
	  public void control(){       
          
	        view.getCombo().addActionListener(e ->{
	            showSalles();
	            
	        });

	    }
	  
	  private void showSalles(){
		  Batiments selectedBatiment = (Batiments) view.getCombo().getSelectedItem();
		  List<Salles> salles = model.getDb().getSallesDansBat(selectedBatiment);
		  String toDisplay="";
		  if(salles.size()>0){
			  for(Salles salle : salles){
				  toDisplay = toDisplay+
						  "	Nom de Salle: "+salle.getNom()+
						  "	Type de la Salle: "+salle.getType()+
						  "	Etage de la salle: "+salle.getEtage()+"\n";
			  }
		  }else toDisplay = "Pas de salles dans ce batiment pour l'instant !";
		  
		  view.getTextArea().setText(toDisplay);
		  
	  }

}
