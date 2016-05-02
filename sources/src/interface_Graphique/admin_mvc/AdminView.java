package interface_Graphique.admin_mvc;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import interface_Graphique.prof_mvc.ProfView;

public class AdminView extends ProfView{
	private JLabel comboLabel;
	private JComboBox<String> combo;
	public AdminView(){
		super();
		super.frame.setTitle("ADE V9999 Welcome Admin");
		comboLabel = new JLabel("Ajouter :");
		comboLabel.setBounds(225, 350, 120, 30);
		frame.getContentPane().add(comboLabel);
		combo = new JComboBox<String>();
		combo.addItem("user");
		combo.addItem("batiment");
		combo.addItem("cours");
		combo.addItem("promos");
		combo.addItem("salle");
		combo.setBounds(350, 350, 222, 30);
		super.frame.getContentPane().add(combo);
	}
	@Override
	public JComboBox<String> getCombo() {
		return combo;
	}
}
