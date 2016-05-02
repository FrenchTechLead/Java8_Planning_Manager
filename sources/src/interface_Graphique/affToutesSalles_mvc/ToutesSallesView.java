package interface_Graphique.affToutesSalles_mvc;

import javax.swing.*;

import allTables.Batiments;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

public class ToutesSallesView {
	 private JFrame frame;
	 private JLabel batimentsLabel;
	 private JComboBox<Batiments> combo; 
	 private JTextArea textArea;
	 
	 
	 public ToutesSallesView(ArrayList<Batiments> batiments){
	        frame = new JFrame("ADE V9999 Salles par batiment");                                    
	        frame.getContentPane().setLayout(new BorderLayout());                                          
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);           
	        frame.setSize(800,600);        
	        frame.setVisible(true);
	        frame.setLayout(null);
	        frame.setResizable(false);
	        
	        
	        batimentsLabel = new JLabel("Batiment :");
	        batimentsLabel.setBounds(10, 10, 250, 32);
	        frame.getContentPane().add(batimentsLabel);
	        
	        combo  = new JComboBox<Batiments>();
	        combo.setBounds(10, 40, 150, 32);
	        for (Batiments item : batiments)combo.addItem(item);
	        frame.getContentPane().add(combo);
	        
	        textArea = new JTextArea();
	        textArea.setBounds(10, 250, 773, 300);
	        textArea.setBackground(Color.pink);
	        frame.getContentPane().add(textArea);

}

	 public JTextArea getTextArea(){
	    	return this.textArea;
	    }
	 public JComboBox<Batiments> getCombo(){
	    	return this.combo;
	    }
	 public JFrame getFrame(){
	    	return this.frame;
	    }
	 
}