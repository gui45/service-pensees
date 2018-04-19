import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringBufferInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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

public class App {

	public static void main(String[] args) {
		
		PenseeDAO penseeDAO = new PenseeDAO();
		penseeDAO.listerPensees();

		//Pensee pensee = new Pensee("Rossetti","Ce qui est plus triste qu une oeuvre inachevee, c est une oeuvre jamais commencee.");
		//penseeDAO.ajouterPensee(pensee);

	}
	

}

