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

		
		String xml;
		try {
			Pensee pensee = new Pensee("Rossetti","Ce qui est plus triste qu une oeuvre inachevee, c est une oeuvre jamais commencee.");
			
			URL urlAjouterPensee = new URL("http://localhost/inspiration/src/pensee/ajouter/");
			HttpURLConnection connection = (HttpURLConnection) urlAjouterPensee.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			//connection.setRequestProperty("User-Agent", "Java client");
	        //connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			
			OutputStream fluxEcriture = connection.getOutputStream();
			OutputStreamWriter envoyeur = new OutputStreamWriter(fluxEcriture);
			
			envoyeur.write("auteur="+pensee.getAuteur()+"&message="+pensee.getMessage()+"&annee=" + pensee.getAnnee());
			envoyeur.close();
			
			int codeReponse = connection.getResponseCode();
			System.out.println("Code de réponse " + codeReponse);
			
			InputStream fluxLecture = connection.getInputStream();
			Scanner lecteur = new Scanner(fluxLecture);
			
			String derniereBalise = "</action>";
			lecteur.useDelimiter(derniereBalise);
			xml = lecteur.next() + derniereBalise;
			lecteur.close();
			System.out.println(xml); // prouve que le script a bien recu les donnees en POST
			
			connection.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	

	}
	

}

/*
 * 
 
Code de réponse 200
ajouterPensee()
stdClass Object
(
    [auteur] => Rossetti
    [message] => Ce qui est plus triste qu’une œuvre inachevée, c’est une œuvre jamais commencée.
    [annee] => 0
)
<?xml version="1.0" encoding="UTF-8"?><action>
	<type>ajouter</type>
	<moment>1523972018</moment>
	<succes>1</succes>
	<message>POST : Array
(
    [auteur] => Rossetti
    [message] => Ce qui est plus triste qu’une œuvre inachevée, c’est une œuvre jamais commencée.
    [annee] => 0
)
</message>
</action>
 
 *
 */
