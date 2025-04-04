package MVC1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TacheController {
	
	
	private TacheModel Tache;
	private View view;
	 
	  
	public TacheController(TacheModel tache, View view) {
		
		Tache = tache;
		this.view = view;
		AjouterTache();
		SupprimerTache();
	}
	
	public void AjouterTache() {
	    view.getAjouter().addActionListener(e -> {
	        if (e.getSource() == view.getAjouter()) {
	            String taskText = view.getTextarea().getText().trim();
	            
	            if (!taskText.isEmpty()) {
	               
	            	
	            		
	            	
	                JPanel taskPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 5));
	                JLabel label = new JLabel(taskText);
	                
	               
	                label.setBackground(new Color(211, 211, 211)); 
	                label.setOpaque(true);
	                label.setFont(new Font("SansSerif", Font.BOLD, 30));
	                
	                label.addMouseListener(new MouseAdapter() {
	                    @Override
	                    public void mouseClicked(MouseEvent e) {
	                        
	                        if (view.getSelectedLabel() != null) {
	                            view.getSelectedLabel().setBackground(new Color(211, 211, 211));
	                        }
	                        
	                 
	                        label.setBackground(new Color(173, 216, 230)); 
	                        view.setSelectedLabel(label);
	                        view.setSelectedPanel(taskPanel); 
	                    }
	                });
	                int confirm = JOptionPane.showConfirmDialog(view, "You sure you want to add this to tache", "Confirmation", JOptionPane.YES_NO_OPTION);
	                JCheckBox box=new JCheckBox("Done");
	            	if(confirm == JOptionPane.YES_OPTION)
	            	{
	                
	                taskPanel.add(box);
	                box.setVisible(false);
	                taskPanel.add(label);
	            	}
	            	else
	            	{
	            		JOptionPane.showMessageDialog(view, "add canceled", "Canceling", JOptionPane.CANCEL_OPTION);
	            	}
	                view.getValider().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == view.getValider())
							{
//								JButton button = new JButton("Cancel");
//								view.getFooterPanel().add(button);
								box.setVisible(true);
								
							}
							
						}
	                	
	                });
	                
	                
	                
	                view.getMainPanel().add(taskPanel);
	                
	             
	                Tache.addTache(taskText);
	                
	               
	                view.revalidate();
	                view.repaint();
	                
	                
	                view.getTextarea().setText("");
	            }
	            
	            else
	            {
	            	JOptionPane.showMessageDialog(view, "the text is empty","Error",  JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    });
	}
	
	 void SupprimerTache() {
		    view.getSupprimer().addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		            JLabel selected = view.getSelectedLabel();
		            if (selected != null) {
		            
		                String taskText = selected.getText();
		                
		           
		                Tache.Supprimer(taskText);
		                
		               
		                view.getMainPanel().remove(view.getSelectedPanel());
		                
	
		                view.setSelectedLabel(null);
		                view.setSelectedLabel(null);
		                
		               
		                view.revalidate();
		                view.repaint();
		            } else {
		                JOptionPane.showMessageDialog(view, "Please select a task to delete", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        }
		    });
		}
	
}
	

	
	
	
	
	




