package interface_Graphique.admin_controls;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import allTables.Batiments;
import allTables.Database;
import allTables.Salles;
public class AddSalle {
	JFrame frame;
	
	private JTextField nom;
	private JComboBox<String> type ;
	private Database db;
	private JButton btnNewButton;
	private JComboBox<Batiments> batiment;
	private JComboBox<Integer> etage;
	private JComboBox<Salles> salle_precedente;
	private JComboBox<Salles> salle_suivante;
	
	
	public AddSalle(Database db){
		this.db = db;
		frame = new JFrame("Add Salle :");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(600, 450);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		
		nom = new JTextField();
		nom.setBounds(33, 57, 174, 29);
		frame.getContentPane().add(nom);
		nom.setColumns(10);
		
		JLabel lblNom = new JLabel("Batiment:");
		lblNom.setBounds(33, 115, 174, 14);
		frame.getContentPane().add(lblNom);
		
		type= new JComboBox<String>();
		type.setBounds(292, 57, 174, 29);
		db.getSalles().stream().map(sals -> sals.getType()).distinct().forEach(sall -> type.addItem(sall));
		frame.getContentPane().add(type);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(292, 29, 46, 14);
		frame.getContentPane().add(lblType);
		
		btnNewButton= new JButton("Ajouter !");
		btnNewButton.addActionListener(a -> adding());
		btnNewButton.setBounds(33, 305, 174, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("Nom (int par convention):");
		label.setBounds(33, 29, 174, 14);
		frame.getContentPane().add(label);
		
		batiment= new JComboBox<Batiments>();
		batiment.setBounds(33, 140, 174, 29);
		db.getBatiments().forEach(btm -> batiment.addItem(btm));
		frame.getContentPane().add(batiment);
		
		JLabel label_1 = new JLabel("Etage:");
		label_1.setBounds(292, 115, 174, 14);
		frame.getContentPane().add(label_1);
		
		etage = new JComboBox<Integer>();
		etage.setBounds(292, 140, 174, 29);
		etage.addItem(new Integer(0));
		frame.getContentPane().add(etage);
		
		JLabel label_2 = new JLabel("salle voisine precedente:");
		label_2.setBounds(33, 199, 174, 14);
		frame.getContentPane().add(label_2);
		
		salle_precedente = new JComboBox<Salles>();
		salle_precedente.addItem(new Salles(0,"aucune",0,"aucune",0,0,0));
		salle_precedente.setBounds(33, 224, 174, 29);
		frame.getContentPane().add(salle_precedente);
		
		JLabel label_3 = new JLabel("salle voisine suivante:");
		label_3.setBounds(292, 199, 174, 14);
		frame.getContentPane().add(label_3);
		
		salle_suivante = new JComboBox<Salles>();
		salle_suivante.addItem(new Salles(0,"aucune",0,"aucune",0,0,0));
		salle_suivante.setBounds(292, 224, 174, 29);
		frame.getContentPane().add(salle_suivante);
	}
	
	
	public void adding(){
		String nomDeSalle = nom.getText();
		String typeSalle = (String)type.getSelectedItem();
		Integer etageSalle = (Integer)etage.getSelectedItem();
		Batiments batim = (Batiments)batiment.getSelectedItem();
		Salles voisP = (Salles)salle_precedente.getSelectedItem();
		Salles voisS = (Salles)salle_suivante.getSelectedItem();
		
		Salles toAdd = new Salles(0,
				typeSalle,
				etageSalle.intValue(),
				nomDeSalle,
				batim.getId(),
				voisP.getId(),
				voisS.getId());
		
		System.out.println("AddingSalle "+toAdd);
		boolean success = false;
		try {
			success = db.addSalle(toAdd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(success)JOptionPane.showMessageDialog(null, "Success !");
		else JOptionPane.showMessageDialog(frame, "Ajout impossible !", "Error", JOptionPane.ERROR_MESSAGE);
		
	}
	
	
	
	
	public void control() {
		batiment.addActionListener(s-> {setEtages();
											});
		etage.addActionListener(a -> {setVoisins();});
		
		
	}
	public void setEtages(){
		if(etage.getItemCount() !=0)etage.removeAllItems();
		if(etage.getItemCount() ==0)etage.addItem(new Integer(0));
		Batiments bat = (Batiments)batiment.getSelectedItem();
		int nmbrEtages = bat.getNombre_etages();
		for(int i = 1; i<=nmbrEtages;i++)etage.addItem(new Integer(i));
	}
	public void setVoisins(){
		Batiments bat = (Batiments)batiment.getSelectedItem();
		if(etage.getItemCount() ==0)etage.addItem(new Integer(0));
		int dansEtage = (int)etage.getSelectedItem();
		System.out.println(bat+" "+dansEtage);
		if(salle_precedente.getItemCount() !=0)	salle_precedente.removeAllItems();
		if(salle_suivante.getItemCount() !=0)	salle_suivante.removeAllItems();
		salle_precedente.addItem(new Salles(0,"aucune",0,"aucune",0,0,0));
		salle_suivante.addItem(new Salles(0,"aucune",0,"aucune",0,0,0));
		
		db.getSalles().stream()
		.filter(itm -> itm.getBatiment_id() == bat.getId() && itm.getEtage() == dansEtage)
		.forEach(iteeem -> {
			System.out.println("voisins : "+iteeem);
			salle_precedente.addItem(iteeem);
			salle_suivante.addItem(iteeem);
		});
	}
}
