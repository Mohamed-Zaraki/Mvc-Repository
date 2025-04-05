package MVC1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class View extends JFrame {
	
	private JPanel Main_Panel ;
	private JPanel[][]panel;
	JLabel[][] label;
	JButton button;
	public View()
	{
		this.setTitle("Tic-Tac-Toe");
		this.setSize(800, 800);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		Main_Panel = new JPanel(new GridLayout(3, 3, 10, 10));
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		Main_Panel.setBorder(border);
		panel = new JPanel[3][3];
		label = new JLabel[3][3]; 
		for(int i = 0 ; i<3 ; i++)
			for(int j =0 ; j <3 ; j++)
			{
				panel[i][j] = new JPanel(new BorderLayout());
				panel[i][j].setBackground(Color.GRAY);

				label[i][j] = new JLabel("", JLabel.CENTER);  
				label[i][j].setFont(new Font("SansSerif", Font.BOLD, 200));
				panel[i][j].add(label[i][j], BorderLayout.CENTER); 

				Main_Panel.add(panel[i][j]);
				
			}
		button = new JButton("Reset Game");
		this.add(button  , BorderLayout.SOUTH);
		this.add(Main_Panel , BorderLayout.CENTER);
		
		
	
	}
	public JPanel getMain_Panel() {
		return Main_Panel;
	}
	public void setMain_Panel(JPanel main_Panel) {
		Main_Panel = main_Panel;
	}
	public JPanel[][] getPanel() {
		return panel;
	}
	public void setPanel(JPanel[][] panel) {
		this.panel = panel;
	}
	public JLabel[][] getLabel() {
		return label;
	}
	public void setLabel(JLabel[][] label) {
		this.label = label;
	}
	public JButton getButton() {
		return button;
	}
	public void setButton(JButton button) {
		this.button = button;
	}
	
	


}
