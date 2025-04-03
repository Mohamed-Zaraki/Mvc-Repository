package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ContactController {

	private  View view;
	private   Contact Contact;
	public ContactController( View view ,  Contact Contact) {
		
		 this.Contact = Contact;
	        this.view = view;
	        AjouterContact();
	        ModifierContact();
	        SupprimerContact();
	}
	
	public String AjouterContact() {
	    this.view.getAjouter().addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (e.getSource() == view.getAjouter()) {
	                int confirm = JOptionPane.showConfirmDialog(view, 
	                        "Are you sure you want to add this to the contact?", 
	                        "Add Person to Contact", JOptionPane.YES_NO_OPTION);
	                
	                if (confirm == JOptionPane.YES_OPTION) {
	                    
	                    String selected = (String) view.Type.getSelectedItem();

	                    
	                    TypeContact selectedEnum;
	                    try {
	                        selectedEnum = TypeContact.valueOf(selected);
	                    } catch (IllegalArgumentException ex) {
	                        JOptionPane.showMessageDialog(view, "Invalid selection!", "Error", JOptionPane.ERROR_MESSAGE);
	                        return;
	                    }

	                    
	                    view.getModel().addRow(new Object[]{
	                        view.getPrenom().getText(),
	                        view.getNom().getText(), 
	                        view.getNumero().getText(), 
	                        selectedEnum
	                    });

	                   
	                    Contact newContact = new Contact(view.getPrenom().getText(), view.getNom().getText(), view.getNumero().getText(), selectedEnum);
	                   
	                    try {
							Contact.AjouterContact(newContact);
						} catch (PersonAlreadyExist e1) {
							
							e1.printStackTrace();
						}
	                    
	                    JOptionPane.showMessageDialog(view, "Contact added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
	                    view.getPrenom().setText("");
	                    view.getNom().setText("");
	                    view.getNumero().setText("");
	                    view.Type.setSelectedItem("DEFAULT");
	                }
	                else
	                {
	                	  JOptionPane.showMessageDialog(view, "Contact Not added!", "Success", JOptionPane.ERROR_MESSAGE); 
	                }
	            }
	        }
	    });

	    return null; 
	}

	
	public void ModifierContact() {
	    this.view.getModifier().addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (e.getSource() == view.getModifier()) {
	         
	                int row = view.getTable().getSelectedRow();

	              
	                if (row == -1) {
	                   
	                    JOptionPane.showMessageDialog(view, "Please select a contact to modify.", "Modifier", JOptionPane.ERROR_MESSAGE);
	                    return;
	                }

	                Contact updatedContact = new Contact(
	                    view.getPrenom().getText(),
	                    view.getNom().getText(),
	                    view.getNumero().getText(),
	                    TypeContact.valueOf(view.Type.getSelectedItem().toString())
	                );

	                Contact.ModifierContact(row, updatedContact);

	               
	                view.getModel().fireTableRowsUpdated(row, row);

	             
	                JOptionPane.showMessageDialog(view, "Contact modified successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
	            }
	        }
	    });
	}
	
	public void SupprimerContact()
	{
		view.getSupprimer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() ==view.getSupprimer())
				{
					int row =  view.getTable().getSelectedRow();
					 if (row == -1) {
	                    
	                    JOptionPane.showMessageDialog(view, "Please select a contact to remove.", "Error", JOptionPane.ERROR_MESSAGE);
					 }
					 else
					 {
					Contact.SupprimerContact(row);
				
					view.getModel().removeRow(row);

					JOptionPane.showMessageDialog(view, "Contact removed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

					 }
				
				
				
			}
			}
			
			
		});
		
		
	

		
		
	
	
}
}
