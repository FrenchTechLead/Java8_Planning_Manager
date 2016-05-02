package interface_Graphique.prof_mvc;

import interface_Graphique.student_mvc.*;
import interface_Graphique.addSeance_mvc.AddSeanceController;
import interface_Graphique.addSeance_mvc.AddSeanceModel;
import interface_Graphique.addSeance_mvc.AddSeanceView;
import interface_Graphique.affToutesSalles_mvc.ToutesSallesController;
import interface_Graphique.affToutesSalles_mvc.ToutesSallesModel;
import interface_Graphique.affToutesSalles_mvc.ToutesSallesView;
import interface_Graphique.occcup_Par_Prof_mvc.OccupParProfController;
import interface_Graphique.occcup_Par_Prof_mvc.OccupParProfModel;
import interface_Graphique.occcup_Par_Prof_mvc.OccupParProfView;
import interface_Graphique.salles_libres_mvc.*;

public class ProfController {
	protected ProfModel model;
	protected ProfView view;
	public ProfController(ProfModel model, ProfView view) {
		this.model = model;
		this.view = view;
	}
	
	 public void control(){       
         

	        
	        view.getButton2().addActionListener(e ->{
	        	System.out.println("Consultation Salles libres");
	        	SallesLibresModel sl_model = new SallesLibresModel(model.getDb());
	        	SallesLibresView sl_view = new SallesLibresView();
	        	SallesLibresController sl_controller = new SallesLibresController(sl_model, sl_view);
	        	sl_controller.control();
	        });   
	        
	        view.getButton3().addActionListener(e ->{
	        	System.out.println("reserver une Salles :");
	        	AddSeanceModel sl_model = new AddSeanceModel(model.getDb());
	        	AddSeanceView sl_view = new AddSeanceView(model.getDb());
	        	AddSeanceController sl_controller = new AddSeanceController(sl_model, sl_view);
	        	sl_controller.control();
	        }); 
	        
	        view.getButton4().addActionListener(e ->{
	            System.out.println("Consultation Emploi du temps");
	          	StudentModel s_model = new StudentModel(model.getDb());
	        	StudentView s_view = new StudentView(model.getDb().getPromos());
	        	StudentController s_controller = new StudentController(s_model, s_view);
	        	s_controller.control();
	        });   
	        
	        view.getButton5().addActionListener(e ->{
	            System.out.println("Salles Occupee par prof !");
	          	OccupParProfModel s_model = new OccupParProfModel(model.getDb());
	          	OccupParProfView s_view = new OccupParProfView(model.getDb().getUsers());
	          	OccupParProfController s_controller = new OccupParProfController(s_model, s_view);
	        	s_controller.control();
	        });   
	        
	        view.getButton6().addActionListener(e ->{
	        	System.out.println("Consultation Salles par batiment");
	        	ToutesSallesModel sl_model = new ToutesSallesModel(model.getDb());
	        	ToutesSallesView sl_view = new ToutesSallesView(model.getDb().getBatiments());
	        	ToutesSallesController sl_controller = new ToutesSallesController(sl_model, sl_view);
	        	sl_controller.control();
	        });   
	    }
}
