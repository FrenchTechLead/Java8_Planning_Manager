package interface_Graphique.addSeance_mvc;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.swing.JOptionPane;

import allTables.Cours;
import allTables.Promos;
import allTables.Salles;
import allTables.Users;

public class AddSeanceController {
	
	AddSeanceModel model;
	AddSeanceView view;

	public AddSeanceController(AddSeanceModel model, AddSeanceView view) {
		this.model = model;
		this.view = view;
	}

	public void control() {
		view.getButton().addActionListener(e ->{
			book();
			checkAvailableRooms();
            
        });
		view.getMinutesFin().addActionListener(e ->checkAvailableRooms());
		view.getHeuresFin().addActionListener(e ->checkAvailableRooms());
		view.getMinutesDebut().addActionListener(e ->checkAvailableRooms());
		view.getHeuresDebut().addActionListener(e ->checkAvailableRooms());
		view.getDatePicker().addActionListener(e ->checkAvailableRooms());
		view.getSalle().addActionListener(rte-> getVoisins());
		
	}
	
	void getVoisins(){
		Salles salleSelectionnee =  (Salles)view.getSalle().getSelectedItem();
		
		view.getTextArea().setText(
				"Salle Selectionee : "+salleSelectionnee+
				"\nSalle voisine precedente: "+model.getDb().getSallesById(salleSelectionnee.getId_voisin_precedent())+
				"\nSalle voisine suivante: "+model.getDb().getSallesById(salleSelectionnee.getId_voisin_suivant()));
		
	}
	
	@SuppressWarnings("deprecation")
	private void checkAvailableRooms(){
		view.getSalle().removeAllItems();
		Date day = (Date)view.getDatePicker().getModel().getValue();	
		if (day == null)day = new Date(0);
		Timestamp debut = new Timestamp(day.getTime());
		Timestamp fin = new Timestamp(day.getTime());
		
		debut.setHours((int)view.getHeuresDebut().getSelectedItem());
		debut.setMinutes((int)view.getMinutesDebut().getSelectedItem());
		debut.setSeconds(0);
		debut.setNanos(0);
		
		fin.setHours((int)view.getHeuresFin().getSelectedItem());
		fin.setMinutes((int)view.getMinutesFin().getSelectedItem());
		fin.setSeconds(0);
		fin.setNanos(0);
		
		model.getDb().freeFromTo(debut, fin).forEach(s -> view.getSalle().addItem(s));
		
	}
	@SuppressWarnings("deprecation")
	private void book(){
		Date day = (Date)view.getDatePicker().getModel().getValue();	
		if (day == null)day = new Date(0);
		Timestamp debut = new Timestamp(day.getTime());
		Timestamp fin = new Timestamp(day.getTime());
		
		debut.setHours((int)view.getHeuresDebut().getSelectedItem());
		debut.setMinutes((int)view.getMinutesDebut().getSelectedItem());
		debut.setSeconds(0);
		debut.setNanos(0);
		
		fin.setHours((int)view.getHeuresFin().getSelectedItem());
		fin.setMinutes((int)view.getMinutesFin().getSelectedItem());
		fin.setSeconds(0);
		fin.setNanos(0);
		
		Cours cours =(Cours) view.getCours().getSelectedItem();
		String typeSeance = (String)view.getTypeSeance().getSelectedItem();
		Salles salle = (Salles)view.getSalle().getSelectedItem();
		Users prof = (Users)view.getProf().getSelectedItem();
		Promos promo = (Promos)view.getPromos().getSelectedItem();
		
		boolean success =false;
		if(typeSeance.equals(salle.getType())){
			try {
				 success = model.getDb().bookRoom(salle, cours, debut, fin, promo, typeSeance, prof);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(!typeSeance.equals(salle.getType())){
			int reply = JOptionPane.showConfirmDialog(null, "Type de seance et type de salle ne sont pas les memes"
					+"\nContinuer quand meme ?", "roomTypeError", JOptionPane.YES_NO_OPTION);
	        if (reply == JOptionPane.YES_OPTION) {
	        	try {
					 success = model.getDb().bookRoom(salle, cours, debut, fin, promo, typeSeance,prof);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        else {
	           JOptionPane.showMessageDialog(null, "Selectionez le bon type de salle alors !");

	        }
		}
		
if(!success)
			JOptionPane.showMessageDialog(view.getFrame(), "Reservation impossible !", "Error", JOptionPane.ERROR_MESSAGE);
if(success)
	JOptionPane.showMessageDialog(view.getFrame(), "Success !", "Success !", JOptionPane.WARNING_MESSAGE);
	
	}

}
