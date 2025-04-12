package MVC;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class View1 extends JFrame {
	private CardLayout cardlayout;
	private JPanel Header,main , dashbord ,mainContent  , login;
	private JButton Submit , Decconection ;
	private JLabel Bienvenu;
	private JPasswordField password ;
	private JTextField UserName;
	public View1() {
	    this.setTitle("Utilisateur Information");
	    this.setSize(600, 600);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	    cardlayout = new CardLayout();
	    main = new JPanel(cardlayout);
	    mainContent = new JPanel(new BorderLayout());

	  
	    Bienvenu = new JLabel("Bienvenu !!");
	    Bienvenu.setFont(new Font("SansSerif", Font.PLAIN, 40));
	    Bienvenu.setHorizontalAlignment(JLabel.CENTER);
	    mainContent.add(Bienvenu, BorderLayout.NORTH);

	   
	    login = new JPanel(new GridLayout(3, 1, 0, 20));
	    UserName = new JTextField();
	    UserName.setPreferredSize(new Dimension(200, 30));
	    login.add(createComponentPanel("UserName :", UserName));

	    password = new JPasswordField();
	    password.setPreferredSize(new Dimension(200, 30));
	    login.add(createComponentPanel("Password :", password));

	    Submit = new JButton("Submit");
	    login.add(Submit);

	   
	    JPanel loginWrapper = new JPanel();
	    loginWrapper.add(login); 

	    mainContent.add(loginWrapper, BorderLayout.CENTER);
	    main.add(mainContent);

	    add(main);
	   

	    dashbord = new JPanel(new BorderLayout());
	    
	    
	}

	private  <T extends JComponent>  JPanel createComponentPanel(String labelText , T text) {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel(labelText);
		label.setFont(new Font("SansSerif" , Font.BOLD ,14));
		panel.add(label, BorderLayout.WEST);
		panel.add(text, BorderLayout.CENTER);
		return panel;

}
	public static void main(String[] args) {
		new View(); 
	}
	
	
}
