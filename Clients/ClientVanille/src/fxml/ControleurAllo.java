package fxml;

import java.util.Iterator;
import java.util.List;

import accesseur.PenseeDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import modele.Pensee;
import javafx.scene.control.TextArea;

public class ControleurAllo {
	
    @FXML
    private TextArea listePensee;
	public ControleurAllo() {
		PenseeDAO dao = new PenseeDAO();
		
		Pensee pensee = dao.chargerPenseeAleatoire();
		VueAllo.getInstance().afficherPensee(pensee);
	}
    @FXML
    void trouverInspiration(ActionEvent event) {
    	VueAllo.getInstance().setText(listePensee);
    	PenseeDAO penseeDAO = new PenseeDAO();
    	Pensee pensee = penseeDAO.chargerPenseeAleatoire();
		VueAllo.getInstance().afficherPensee(pensee);
    }
}
