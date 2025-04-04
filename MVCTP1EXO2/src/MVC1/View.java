package MVC1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class View extends JFrame {
	
	
	private JPanel HeaderPanel , FooterPanel ,MainPanel , selectedPanel = null;
	private JButton Ajouter ,Supprimer , Valider;
	private JLabel Area_Text , SelectedLabel = null ;
	private JTextArea text ;
	;
	
	public View()
	{
		this.setTitle("Gestion Des Taches");
		this.setSize(600, 800);
//		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		  MainPanel = new JPanel();
	       MainPanel.setLayout(new BoxLayout(MainPanel,BoxLayout.Y_AXIS));
		JScrollPane scrollpane = new JScrollPane(MainPanel);
	
		this.add(scrollpane, BorderLayout.CENTER);

		HeaderPanel = new JPanel();
		HeaderPanel.setLayout(new BorderLayout(10 , 0));
		JLabel areaText = new JLabel("Area to text:");
		areaText.setFont(new Font("SansSerif", Font.BOLD, 14));
		 text = new JTextArea(3, 20);
		text.setFont(new Font("SansSerif", Font.BOLD, 16));
		HeaderPanel.add(areaText, BorderLayout.WEST);
		HeaderPanel.add(new JScrollPane(text), BorderLayout.CENTER);
//		Ajouter = new JButton("Ajouter");
//		Ajouter.setFocusable(false);
//		Ajouter.setBorderPainted(false);
		this.add(HeaderPanel , BorderLayout.NORTH);
		
		FooterPanel = new JPanel( new GridLayout(1 , 3 , 10 , 0));
		Ajouter = new JButton("Ajouter");
		Ajouter.setFocusable(false);
		Ajouter.setBorderPainted(false);
		FooterPanel.add(Ajouter);
		Supprimer = new JButton("Supprimer");
		Supprimer.setFocusable(false);
		Supprimer.setBorderPainted(false);
		FooterPanel.add(Supprimer);
		Valider = new JButton("Valider");
		Valider.setFocusable(false);
		Valider.setBorderPainted(false);
		FooterPanel.add(Valider);
		this.add(FooterPanel , BorderLayout.SOUTH);
		
		
		
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
	public JPanel getHeaderPanel() {
		return HeaderPanel;
	}
	public void setHeaderPanel(JPanel headerPanel) {
		HeaderPanel = headerPanel;
	}
	public JPanel getFooterPanel() {
		return FooterPanel;
	}
	public void setFooterPanel(JPanel footerPanel) {
		FooterPanel = footerPanel;
	}
	public JPanel getMainPanel() {
		return MainPanel;
	}
	public void setMainPanel(JPanel mainPanel) {
		MainPanel = mainPanel;
	}
	public JButton getAjouter() {
		return Ajouter;
	}
	public void setAjouter(JButton ajouter) {
		Ajouter = ajouter;
	}
	public JButton getSupprimer() {
		return Supprimer;
	}
	public void setSupprimer(JButton supprimer) {
		Supprimer = supprimer;
	}
	public JButton getValider() {
		return Valider;
	}
	public void setValider(JButton valider) {
		Valider = valider;
	}
	public JLabel getArea_Text() {
		return Area_Text;
	}
	public void setArea_Text(JLabel area_Text) {
		Area_Text = area_Text;
	}
	public JTextArea getTextarea() {
		return text;
	}
	public void setText(JTextArea text) {
		text = text;
	}
	public JPanel getSelectedPanel() {
		return selectedPanel;
	}
	public void setSelectedPanel(JPanel selectedPanel) {
		this.selectedPanel = selectedPanel;
	}
	public JLabel getSelectedLabel() {
		return SelectedLabel;
	}
	public void setSelectedLabel(JLabel selectedLabel) {
		SelectedLabel = selectedLabel;
	}
	
	
	
}
