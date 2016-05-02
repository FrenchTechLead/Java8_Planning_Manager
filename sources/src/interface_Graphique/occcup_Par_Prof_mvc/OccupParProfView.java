package interface_Graphique.occcup_Par_Prof_mvc;

import javax.swing.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import allTables.Users;
import interface_Graphique.DateLabelFormatter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Properties;

public class OccupParProfView {

	private JFrame frame;
	private JLabel profLabel;
	private JLabel dateLabel;
	private JComboBox<Users> combo;
	private JDatePickerImpl datePicker;
	private JTextArea textArea;

	public OccupParProfView(ArrayList<Users> users){ 
		 
	 frame = new JFrame("ADE V9999 Select occupation periodique par prof");                                    
     frame.getContentPane().setLayout(new BorderLayout());                                          
     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);           
     frame.setSize(800,600);        
     frame.setVisible(true);
     frame.setLayout(null);
     frame.setResizable(false);
     
     profLabel = new JLabel("Promos :");
     profLabel.setBounds(10, 10, 250, 32);
     frame.getContentPane().add(profLabel);
     
     combo  = new JComboBox<Users>();
     combo.setBounds(10, 40, 150, 32);
     users.stream().filter(user -> user.getType().equals(new String ("Prof"))).forEach(prof -> combo.addItem(prof));
     frame.getContentPane().add(combo);
     
     dateLabel = new JLabel("Date :");
     dateLabel.setBounds(530, 10, 250, 32);
     frame.getContentPane().add(dateLabel);
     
     textArea = new JTextArea();
     textArea.setBounds(10, 250, 773, 300);
     textArea.setBackground(Color.pink);
     frame.getContentPane().add(textArea);
     
     
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
	 
	 }
     
	public JTextArea getTextArea(){
    	return this.textArea;
    }
    public JDatePickerImpl getDate(){
    	return this.datePicker;
    }
    public JComboBox<Users> getCombo(){
    	return this.combo;
    }

    
    public JFrame getFrame(){
    	return this.frame;
    }

}
