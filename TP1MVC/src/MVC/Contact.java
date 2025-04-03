package MVC;

import java.util.ArrayList;
import java.util.List;

public class Contact {
	
	private String Prenom;
	private String Nom;
	private String Numero;
	private TypeContact Type;
	private List<Contact> Contacts = new ArrayList<>();;
	public Contact(String prenom, String nom , String numero , TypeContact type) {
		Prenom = prenom;
		Nom = nom;
		Numero = numero;
		Type = type;
	
	}
	public Contact()
	{
		
	}
	
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getNumero() {
		return Numero;
	}
	public void setNumero(String numero) {
		Numero = numero;
	}
	public TypeContact getType() {
		return Type;
	}
	public void setType(TypeContact type) {
		Type = type;
	}
	
	
	public void AjouterContact(Contact contact) throws PersonAlreadyExist
	{
		if(Contacts.contains(contact)) 
		{
			throw new PersonAlreadyExist("Personne not found");		}
		Contacts.add(contact);
	
	
	}
	
	public void ModifierContact(int row,Contact Contact )
	{
		Contacts.set(row, Contact);
								
	}
				
			
			
			
		
	
	public  void  SupprimerContact(int row) 
	{
		
		Contacts.remove(row);
	}
	
	public void AfficherContact()
	{
		for(Contact contact : Contacts)
		{
			System.out.println(contact);
		}
	}
	
	
	
	
	
}
