package interface_Graphique.admin_controls;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import allTables.Cours;
import allTables.Database;

public class AddCours {
	JFrame frame;
	
	private JTextField textField;
	private JComboBox<String> comboBox ;
	private Database db;
	public AddCours(Database db){
		this.db = db;
		frame = new JFrame("Add Cours :");
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
		
		comboBox= new JComboBox<String>();
		comboBox.setBounds(33, 143, 174, 29);
		db.getUsers()
					.stream().filter(u-> u.getType().equals(new String ("Prof")))
					.forEach(usr -> comboBox.addItem(usr.getNom()));
		frame.getContentPane().add(comboBox);
		
		JLabel lblType = new JLabel("Prof Responsable :");
		lblType.setBounds(33, 118, 200, 14);
		frame.getContentPane().add(lblType);
		
		JButton btnNewButton = new JButton("Ajouter !");
		btnNewButton.addActionListener(a -> addUser());
		btnNewButton.setBounds(33, 220, 174, 29);
		frame.getContentPane().add(btnNewButton);
	}
	public void addUser(){
		Cours cours = new Cours(0, textField.getText(),(String)comboBox.getSelectedItem());
		
		System.out.println("AddingCours "+cours);
		boolean success = false;
		try {
			success = db.addCours(cours);
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
