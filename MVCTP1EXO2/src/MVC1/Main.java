package MVC1;

public class Main {
public static void main(String[] args) {
	
		View view =new View();
		TacheModel Model = new TacheModel();
		TacheController Controller = new TacheController(Model, view);
}	
}
