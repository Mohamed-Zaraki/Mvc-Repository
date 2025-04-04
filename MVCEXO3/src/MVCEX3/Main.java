package MVCEX3;

public class Main {
	
	public static void main(String[] args) {
		
		View view = new View();
		ModelFile model = new ModelFile();
		FileController Controller = new FileController(model, view);
		view.setVisible(true);
	}

}
