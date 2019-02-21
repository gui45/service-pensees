package fxml;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import modele.Pensee;

public class VueAllo extends Application {
	Scene scene = null;
	private TextArea text = null;
	private static VueAllo instance = null;
	public static VueAllo getInstance() {
		if(instance == null) instance = new VueAllo();
		
	return instance;
	}
	@Override
	public void start(Stage stade) throws Exception {
		Parent racine = FXMLLoader.load(getClass().getResource("test.fxml"));
		//Pane racine = new StackPane();
		scene = new Scene(racine, 800, 600);
		stade.setScene(scene);
		stade.show();
	}	
	public void setText(TextArea text) {
		text = text;
	}
	public void afficherPensee(Pensee pensee)
	{
		if(text != null) {
			System.out.println("afficherPensee()");
			
			text.setText(pensee.getMessage() + " - " + pensee.getAuteur());
		}
	}
}
