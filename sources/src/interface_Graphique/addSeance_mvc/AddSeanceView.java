package interface_Graphique.addSeance_mvc;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import allTables.Cours;
import allTables.Database;
import allTables.Promos;
import allTables.Salles;
import allTables.Users;
import interface_Graphique.DateLabelFormatter;
import java.util.Properties;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class AddSeanceView {
	
	JFrame frame;
    private JLabel dateLabel;
    private JDatePickerImpl datePicker;
    
    private JLabel heuresDebutLabel;
    private JLabel minutesDebutLabel;
    private JComboBox<Integer> heuresDebut;
    private JComboBox<Integer> minutesDebut;
    
    private JLabel heuresFinLabel;
    private JLabel minutesFinLabel;
    private JComboBox<Integer> heuresFin;
    private JComboBox<Integer> minutesFin;
    
    private JLabel coursLabel;
    private JComboBox<Cours> cours;
    
    private JLabel typeSeanceLabel;
    private JComboBox<String> typeSeance;
    
    private JLabel salleLabel;
    private JComboBox<Salles> salle;
    
    private JLabel profLabel;
    private JComboBox<Users> prof;
    
    private JLabel promoLabel;
    private JComboBox<Promos> promos;
    private JTextArea textArea;

    
    private JButton button;
    
    public AddSeanceView(Database db){
    	frame = new JFrame("Salles Libres Par creneau");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);           
        frame.setSize(800,600);        
        frame.setVisible(true);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);
        
        dateLabel = new JLabel("Date :");
        dateLabel.setBounds(530, 10, 250, 32);
        frame.getContentPane().add(dateLabel);
        UtilDateModel dateModel = new UtilDateModel();
        //model.setDate(20,04,2014);
        // Need this...
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, p);
        // Don't know about the formatter, but there it is...
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePanel.setBounds(530, 40, 250, 200);
        frame.getContentPane().add(datePanel);
        
        heuresDebutLabel = new JLabel("Heure debut:");
        heuresDebutLabel.setBounds(10, 10, 250, 32);
        frame.getContentPane().add(heuresDebutLabel);   
        heuresDebut  = new JComboBox<Integer>();
        heuresDebut.setBounds(10, 40, 150, 32);
        for (int i =0 ; i<24 ;i++)heuresDebut.addItem(new Integer(i));
        frame.getContentPane().add(heuresDebut);
        
        minutesDebutLabel = new JLabel("Minutes debut:");
        minutesDebutLabel.setBounds(200, 10, 250, 32);
        frame.getContentPane().add(minutesDebutLabel);     
        minutesDebut  = new JComboBox<Integer>();
        minutesDebut.setBounds(200, 40, 150, 32);
        for (int i =0 ; i<60 ;i++)minutesDebut.addItem(new Integer(i));
        frame.getContentPane().add(minutesDebut);      
        
        heuresFinLabel = new JLabel("Heure fin:");
        heuresFinLabel.setBounds(10, 80, 250, 32);
        frame.getContentPane().add(heuresFinLabel);    
        heuresFin  = new JComboBox<Integer>();
        heuresFin.setBounds(10, 110, 150, 32);
        for (int i =0 ; i<24 ;i++)heuresFin.addItem(new Integer(i));
        frame.getContentPane().add(heuresFin);
        
        minutesFinLabel = new JLabel("Minutes Fin:");
        minutesFinLabel.setBounds(200, 80, 250, 32);
        frame.getContentPane().add(minutesFinLabel);    
        minutesFin  = new JComboBox<Integer>();
        minutesFin.setBounds(200, 110, 150, 32);
        for (int i =0 ; i<60 ;i++)minutesFin.addItem(new Integer(i));
        frame.getContentPane().add(minutesFin);
        
        typeSeanceLabel = new JLabel("Type de seance :");
        typeSeanceLabel.setBounds(10, 150, 250, 32);
        frame.getContentPane().add(typeSeanceLabel);
        typeSeance = new JComboBox<>();
        typeSeance.setBounds(10, 180, 150, 32);
        typeSeance.addItem("cm");typeSeance.addItem("td");typeSeance.addItem("Tp_Info");typeSeance.addItem("Tp_Chimie");
        frame.getContentPane().add(typeSeance);
        
        coursLabel = new JLabel("Cours :");
        coursLabel.setBounds(200, 150, 250, 32);
        frame.getContentPane().add(coursLabel);
        cours = new JComboBox<>();
        cours.setBounds(200, 180, 150, 32);
        for(Cours item : db.getCours())cours.addItem(item);
        frame.getContentPane().add(cours);
        
        salleLabel = new JLabel("Salle:");
        salleLabel.setBounds(10, 220, 250, 32);
        frame.getContentPane().add(salleLabel);
        salle = new JComboBox<>();
        salle.setBounds(10, 250, 150, 32);
        for(Salles item : db.getSalles())salle.addItem(item);
        frame.getContentPane().add(salle);
        
        profLabel = new JLabel("Prof :");
        profLabel.setBounds(200, 220, 250, 32);
        frame.getContentPane().add(profLabel);
        prof = new JComboBox<>();
        prof.setBounds(200, 250, 150, 32);
        db.getUsers().
        		stream().filter(user -> user.getType().equals(new String("Prof"))).
        		forEach(element -> prof.addItem(element));
        frame.getContentPane().add(prof);
        
        promoLabel = new JLabel("Promo:");
        promoLabel.setBounds(10, 290, 150, 32);
        frame.getContentPane().add(promoLabel);
        promos = new JComboBox<>();
        promos.setBounds(10, 320, 150, 32);
        db.getPromos().stream().forEach(e -> promos.addItem(e));
        frame.getContentPane().add(promos);
        
        
        button = new JButton("Reserver !");
        button.setBounds(10, 500, 150, 32);
        frame.getContentPane().add(button);     
        
        textArea = new JTextArea();
        textArea.setBounds(530, 294, 250, 218);
        frame.getContentPane().add(textArea);
        

    	
    }
    
    
    
    //getteurs
    public JButton getButton(){
    	return button;
    }

	public JFrame getFrame() {
		return frame;
	}

	public JDatePickerImpl getDatePicker() {
		return datePicker;
	}

	public JComboBox<Integer> getHeuresDebut() {
		return heuresDebut;
	}

	public JComboBox<Integer> getMinutesDebut() {
		return minutesDebut;
	}

	public JComboBox<Integer> getHeuresFin() {
		return heuresFin;
	}

	public JComboBox<Integer> getMinutesFin() {
		return minutesFin;
	}

	public JComboBox<Cours> getCours() {
		return cours;
	}

	public JComboBox<String> getTypeSeance() {
		return typeSeance;
	}

	public JComboBox<Salles> getSalle() {
		return salle;
	}

	public JComboBox<Users> getProf() {
		return prof;
	}

	public JComboBox<Promos> getPromos() {
		return promos;
	}



	public JTextArea getTextArea() {
		return textArea;
	}
	
	
}
