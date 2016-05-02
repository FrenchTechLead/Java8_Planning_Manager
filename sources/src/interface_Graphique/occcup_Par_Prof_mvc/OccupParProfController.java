package interface_Graphique.occcup_Par_Prof_mvc;

import java.util.Date;
import java.util.List;

import allTables.Salles;

import allTables.Users;

public class OccupParProfController {
	private OccupParProfModel model;
	private OccupParProfView view;
	    
	    public OccupParProfController(OccupParProfModel model, OccupParProfView view){
	        this.model = model;
	        this.view = view;
	    }
	    
	    public void control(){       
	              
	        view.getCombo().addActionListener(e ->{
	            showRooms();
	            
	        });
	        view.getDate().addActionListener(e ->{
	            showRooms();
	            
	        });
	    }

	    private void showRooms(){
	    	view.getTextArea().setText("");
	    	Users selectedProf = (Users) view.getCombo().getSelectedItem();
	    	int profId = selectedProf.getId();
	    	
	    	Date selectedDate = (Date)view.getDate().getModel().getValue();
	    	if (selectedDate == null)selectedDate = new Date();
	    	
	    	String toDisplay = "";
	    	
	    	List<Salles> returnedList =model.getDb().getSallesOccupeeParProfParDate(profId,selectedDate );
	    	if(returnedList.size()>0){
	  		  if(returnedList.size()>0){
	  			  for(Salles salle : returnedList){
	  				  toDisplay = toDisplay+
	  						  "	Nom de Salle: "+salle.getNom()+
	  						  "	Type de la Salle: "+salle.getType()+
	  						  "	Etage de la salle dans le batiment: "+salle.getEtage()+"\n";
	  			  }
	  		  }else toDisplay = "Aucune Salle Occupee par ce Prof en Cette Date !";
	  		  
	  		  view.getTextArea().setText(toDisplay);
	    }    
	    

}
}
