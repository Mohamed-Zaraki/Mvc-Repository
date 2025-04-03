package MVC;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {
	
	private JButton Ajouter , Modifier , Supprimer;
	private JPanel InfoPan , ContaPan , Manipulationpan;
	private DefaultTableModel model;
	private JTextField Prenom = new JTextField();
	private JTextField Numero = new JTextField();
	private JTextField Nom = new JTextField() ;
	private JTable Table;
	
	static final JComboBox<String> Type =  new JComboBox<>(new String[]{"DEFAULT", "FAMILLE", "TRAVAIL", "COLLEGUES"});
	public View() {
		
		this.setTitle("Contact");
		this.setSize(950, 600);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		 Ajouter = new JButton("Ajouter");
		 Modifier = new JButton("Modifier");
		 Supprimer = new JButton("Supprimer");
		Ajouter.setFocusable(false);
		Ajouter.setBorderPainted(false);
		Modifier.setFocusable(false);
		Modifier.setBorderPainted(false);
		Supprimer.setFocusable(false);
		Supprimer.setBorderPainted(false);
		InfoPan = new JPanel(new GridLayout(1 , 3, 15, 0));
		InfoPan.add(Ajouter);
		InfoPan.add(Modifier);
		InfoPan.add(Supprimer);
		this.add(InfoPan , BorderLayout.SOUTH);
		ContaPan = new JPanel( new GridLayout(1 , 8 , 25 , 0));
		 ContaPan.add(createComponentPanel("Nom:", Nom));
	        ContaPan.add(createComponentPanel("Prenom:", Prenom));
	        ContaPan.add(createComponentPanel("Numero:", Numero));
	        ContaPan.add(createComponentPanel("Type:", Type ));
		this.add(ContaPan , BorderLayout.NORTH);

		Manipulationpan = new JPanel(new BorderLayout()); 
		String[] columns = {"Nom", "Prenom", "Number","Type" };
		model = new DefaultTableModel(columns, 0);
        Table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(Table);
		Manipulationpan.add(scrollPane, BorderLayout.CENTER); 
		this.add(Manipulationpan, BorderLayout.CENTER); 
	
		this.setVisible(true);
	}
	private  <T extends JComponent>  JPanel createComponentPanel(String labelText , T text) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("SansSerif" , Font.BOLD ,14));
        panel.add(label, BorderLayout.WEST);
        panel.add(text, BorderLayout.CENTER);
        return panel;
    }
	public JButton getAjouter() {
		return Ajouter;
	}
	public void setAjouter(JButton ajouter) {
		Ajouter = ajouter;
	}
	public JButton getModifier() {
		return Modifier;
	}
	public void setModifier(JButton modifier) {
		Modifier = modifier;
	}
	public JButton getSupprimer() {
		return Supprimer;
	}
	public void setSupprimer(JButton supprimer) {
		Supprimer = supprimer;
	}
	public JPanel getInfoPan() {
		return InfoPan;
	}
	public void setInfoPan(JPanel infoPan) {
		InfoPan = infoPan;
	}
	public JPanel getContaPan() {
		return ContaPan;
	}
	public void setContaPan(JPanel contaPan) {
		ContaPan = contaPan;
	}
	public JPanel getManipulationpan() {
		return Manipulationpan;
	}
	public void setManipulationpan(JPanel manipulationpan) {
		Manipulationpan = manipulationpan;
	}
	public DefaultTableModel getModel() {
		return model;
	}
	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	public JTextField getPrenom() {
		return Prenom;
	}
	public void setPrenom(JTextField prenom) {
		Prenom = prenom;
	}
	public JTextField getNumero() {
		return Numero;
	}
	public void setNumero(JTextField numero) {
		Numero = numero;
	}
	public JTextField getNom() {
		return Nom;
	}
	public void setNom(JTextField nom) {
		Nom = nom;
	}
	public JTable getTable() {
		return Table;
	}
	public void setTable(JTable table) {
		Table = table;
	}
	
	
	
	
	 

}
