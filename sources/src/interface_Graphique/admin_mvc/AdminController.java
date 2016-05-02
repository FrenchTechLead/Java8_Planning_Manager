package interface_Graphique.admin_mvc;

import interface_Graphique.admin_controls.AddBatiment;
import interface_Graphique.admin_controls.AddCours;
import interface_Graphique.admin_controls.AddPromos;
import interface_Graphique.admin_controls.AddSalle;
import interface_Graphique.admin_controls.AddUser;
import interface_Graphique.prof_mvc.ProfController;
import interface_Graphique.prof_mvc.ProfModel;
import interface_Graphique.prof_mvc.ProfView;

public class AdminController extends ProfController {

	public AdminController(ProfModel model, ProfView view) {
		super(model, view);
		// TODO Auto-generated constructor stub
	}
	
	public void control(){
		super.control();
		this.view.getCombo().addActionListener(s-> switchSelection());
	}
	
	private void switchSelection(){
		String selection = (String)this.view.getCombo().getSelectedItem();
		
		switch(selection){
		case "user" :System.out.println("ajout: "+ selection);
			AddUser adding = new AddUser(model.getDb());
			adding.control();
			break;
			
		case "batiment":System.out.println("ajout: "+ selection);
		AddBatiment adding2 = new AddBatiment(model.getDb());
		adding2.control();
			break;
			
		case "cours":System.out.println("ajout: "+ selection);
		AddCours adding3 = new AddCours(model.getDb());
		adding3.control();
			break;
			
		case "promos":System.out.println("ajout: "+ selection);
		AddPromos adding4 = new AddPromos(model.getDb());
		adding4.control();
			break;
			
		case "salle":System.out.println("ajout: "+ selection);
		AddSalle adding5 = new AddSalle(model.getDb());
		adding5.control();
			break;
			
		}
		
	}
}
