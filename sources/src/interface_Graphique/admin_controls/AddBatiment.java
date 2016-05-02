package interface_Graphique.admin_controls;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import allTables.Batiments;
import allTables.Database;

public class AddBatiment {
	JFrame frame;
	
	private JTextField textField;
	private Database db;
	private JTextField textField_1;
	public AddBatiment(Database db){
		this.db = db;
		frame = new JFrame("Add Batiment :");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(33, 57, 174, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setBounds(33, 29, 46, 14);
		frame.getContentPane().add(lblNom);
		
		JLabel lblType = new JLabel("etages:");
		lblType.setBounds(33, 118, 46, 14);
		frame.getContentPane().add(lblType);
		
		JButton btnNewButton = new JButton("Ajouter !");
		btnNewButton.addActionListener(a -> addUser());
		btnNewButton.setBounds(33, 220, 174, 29);
		frame.getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(33, 143, 174, 29);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
	public void addUser(){
		Batiments batiment = new Batiments(0, textField.getText(),Integer.parseInt(textField_1.getText()) );
		
		System.out.println("AddingBatiment "+batiment);
		boolean success = false;
		try {
			success = db.addBatiment(batiment);
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
