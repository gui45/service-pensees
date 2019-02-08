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

public class ControleurAllo {
	    @FXML private ListView<String> ListeInspiration;

	    public ControleurAllo() {
	    	PenseeDAO penseeDAO = new PenseeDAO();
			List<Pensee> listePensees = penseeDAO.listerPensees();
			Iterator<Pensee> iterateur = listePensees.iterator();
			ObservableList<String> liste = ListeInspiration.getItems();
			while(iterateur.hasNext()) {
				Pensee pensee = iterateur.next();
				String penseeString = pensee.getAnnee() + " " + pensee.getAuteur() + " : " + pensee.getMessage();
				liste.add("penseeString");
				System.out.println(penseeString);
			}
	    }
}
