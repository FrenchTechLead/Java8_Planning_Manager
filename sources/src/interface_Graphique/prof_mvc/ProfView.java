package interface_Graphique.prof_mvc;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;


public  class ProfView {
	protected JFrame frame;
	private JButton button1, button2, button3, button4, button5,button6;
	
	
	
	public ProfView() {
		frame = new JFrame("ADE V9999 - Welcome Prof");
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLayout(null);


		
		button2 = new JButton("Afficher Salles libres / creneau");
		button2.setBounds(225, 100, 350, 30);
		frame.getContentPane().add(button2);
		
		button3 = new JButton("Reserver une salle pour un cours / promos");
		button3.setBounds(225, 150, 350, 30);
		frame.getContentPane().add(button3);	
		
		button4 = new JButton("Salles occupee / Promos");
		button4.setBounds(225, 200, 350, 30);
		frame.getContentPane().add(button4);
		
		button5 = new JButton("Salles occupee / Prof");
		button5.setBounds(225, 250, 350, 30);
		frame.getContentPane().add(button5);
		
		button6 = new JButton("Afficher toutes les salles / Batiment");
		button6.setBounds(225, 300, 350, 30);
		frame.getContentPane().add(button6);
		

		
	}

	
	
	
	
	
	
	//getters and setters
	public JFrame getFrame() {
		return frame;
	}

	public JButton getButton1() {
		return button1;
	}

	public JButton getButton2() {
		return button2;
	}

	public JButton getButton3() {
		return button3;
	}

	public JButton getButton4() {
		return button4;
	}

	public JButton getButton5() {
		return button5;
	}

	public JButton getButton6() {
		return button6;
	}

	public  JComboBox<String> getCombo(){return null;}

}
