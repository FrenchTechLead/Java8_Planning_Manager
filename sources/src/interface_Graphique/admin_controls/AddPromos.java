package interface_Graphique.admin_controls;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import allTables.Database;
import allTables.Promos;

public class AddPromos {
	JFrame frame;
	
	private JTextField textField;
	private Database db;
	public AddPromos(Database db){
		this.db = db;
		frame = new JFrame("Add promo :");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(33, 57, 174, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setBounds(33, 29, 46, 14);
		frame.getContentPane().add(lblNom);

		
		JButton btnNewButton = new JButton("Ajouter !");
		btnNewButton.addActionListener(a -> addUser());
		btnNewButton.setBounds(33, 220, 174, 29);
		frame.getContentPane().add(btnNewButton);
	}
	public void addUser(){
		Promos promos = new Promos(0, textField.getText());
		
		System.out.println("AddingCours "+promos);
		boolean success = false;
		try {
			success = db.addPromos(promos);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(success)JOptionPane.showMessageDialog(null, "Success !");
		else JOptionPane.showMessageDialog(frame, "Ajout impossible !", "Error", JOptionPane.ERROR_MESSAGE);
	}
	public void control() {
		// TODO Auto-generated method stub
		
	}
}
