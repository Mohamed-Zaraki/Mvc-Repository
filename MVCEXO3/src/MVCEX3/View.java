package MVCEX3;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class View extends JFrame {
	JButton Move , Delete , Browse ;
	JPanel Buttons , Area;
	JTextArea Textarea;
    private JFileChooser fileChooser;
	public View()
	{
		this.setTitle("Gestion des fichiers");
		this.setSize(600, 600);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		Buttons = new JPanel();
		Move = new JButton("Move File");
		Delete = new JButton("Delete File");
		Browse = new JButton("Browse to a File");
		
		Buttons.add(Browse);
		Buttons.add(Delete);
		Buttons.add(Move);
		this.add(Buttons , BorderLayout.SOUTH);
		Area = new JPanel();
		Area.setLayout(new GridLayout( 1 , 1 ));
		fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		Textarea = new JTextArea();
		Textarea.setFont(new Font("Arial", Font.PLAIN, 25));
		Textarea.setLineWrap(true); 
		Textarea.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(Textarea);
		Area.add(scrollPane);
		
		this.add(Area , BorderLayout.CENTER);
		
		
		
		
		
	}
	public JButton getMove() {
		return Move;
	}
	public void setMove(JButton Move) {
		this.Move = Move;
	}
	public JButton getDelete() {
		return Delete;
	}
	public void setDelete(JButton Delete) {
		this.Delete = Delete;
	}
	public JButton getBrowse() {
		return Browse;
	}
	public void setBrowse(JButton browse) {
		Browse = browse;
	}
	public JPanel getButtons() {
		return Buttons;
	}
	public void setButtons(JPanel buttons) {
		Buttons = buttons;
	}
	public JPanel getArea() {
		return Area;
	}
	public void setArea(JPanel area) {
		Area = area;
	}
	public JTextArea getTextarea() {
		return Textarea;
	}
	public void setTextarea(JTextArea textarea) {
		Textarea = textarea;
	}
	public JFileChooser getFileChooser() {
		return fileChooser;
	}
	public void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}
	
}
