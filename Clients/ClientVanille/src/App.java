import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringBufferInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import accesseur.PenseeDAO;
import modele.Pensee;
import outils.JournalDesactivable;
import outils.Journal;

public class App {

	public static void main(String[] args) {

		//Journal.activer();
		Journal.activerNiveau(0);
		
		PenseeDAO penseeDAO = new PenseeDAO();
		List<Pensee> listePensees = penseeDAO.listerPensees();
		
		for(Iterator<Pensee> visiteur = listePensees.iterator(); visiteur.hasNext(); )
		{
			Pensee pensee = visiteur.next();		
			Journal.ecrire(5, pensee.getMessage() + "(" + pensee.getAuteur() + ")");
		}

		Pensee pensee = new Pensee("Rossetti","Ce qui est plus triste qu une oeuvre inachevee, c est une oeuvre jamais commencee.");
		penseeDAO.ajouterPensee(pensee);

	}
	

}

