package interface_Graphique.admin_controls;
import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import allTables.Database;
import allTables.Users;
public class AddUser {
	JFrame frame;
	
	private JTextField textField;
	private JComboBox<String> comboBox ;
	private Database db;
	public AddUser(Database db){
		this.db = db;
		frame = new JFrame("Add User :");
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(33, 57, 174, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setBounds(33, 29, 46, 14);
		frame.getContentPane().add(lblNom);
		
		comboBox= new JComboBox<String>();
		comboBox.setBounds(33, 143, 174, 29);
		comboBox.addItem("Etudiant");
		comboBox.addItem("Prof");
		comboBox.addItem("Admin");
		frame.getContentPane().add(comboBox);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(33, 118, 46, 14);
		frame.getContentPane().add(lblType);
		
		JButton btnNewButton = new JButton("Ajouter !");
		btnNewButton.addActionListener(a -> addUser());
		btnNewButton.setBounds(33, 220, 174, 29);
		frame.getContentPane().add(btnNewButton);
	}
	public void addUser(){
		Users user = new Users(0, textField.getText(),(String)comboBox.getSelectedItem());
		
		System.out.println("AddingUser "+user);
		boolean success = false;
		try {
			success = db.addUser(user);
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
