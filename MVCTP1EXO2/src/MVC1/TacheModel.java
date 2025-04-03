package MVC1;

import java.util.ArrayList;
import java.util.List;

public class TacheModel {
	
	private List<String> Taches = new ArrayList<>();
	
	public TacheModel()
	{
		
	}
	public List<String> getTaches() {
		return Taches;
	}
	public void setTaches(List<String> taches) {
		Taches = taches;
	}
	
	
	public void addTache(String Contenu)
	{
		Taches.add(Contenu);
	}
	
	public void Supprimer(String Contenu)
	{
		Taches.remove(Contenu);
	}
	
	
	

}
