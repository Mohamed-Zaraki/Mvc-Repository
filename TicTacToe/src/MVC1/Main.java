package MVC1;

public class Main {
public static void main(String[] args) {
	View view = new View();
	ModelTic model = new ModelTic();
	view.setVisible(true);
	 new ControllerTic(model, view);
}
	
}
