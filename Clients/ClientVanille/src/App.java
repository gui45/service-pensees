import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.net.URL;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class App {

	public static void main(String[] args) {

		String xml = null;
		
		try {
			URL urlListePensees = new URL("http://localhost/inspiration/src/pensee/liste/");
			String derniereBalise = "</pensees>";
			InputStream flux = urlListePensees.openConnection().getInputStream();
			Scanner lecteur = new Scanner(flux);
			lecteur.useDelimiter(derniereBalise); 
			xml = lecteur.next() + derniereBalise;
			//System.out.println(xml);			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(null == xml) return;
		
		try 
		{
			DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			@SuppressWarnings("deprecation")
			Document document = parseur.parse(new StringBufferInputStream(xml));
			String racine = document.getDocumentElement().getNodeName();
			//System.out.println(racine);
			
			NodeList listePensees = document.getElementsByTagName("pensee");
			for(int position = 0; position < listePensees.getLength(); position++)// TODO : veille sur s'il devient iterable
			{
				//Node noeudPensee = listePensees.item(position);
				Element noeudPensee = (Element)listePensees.item(position);
				String id = noeudPensee.getElementsByTagName("id").item(0).getTextContent();
				System.out.println("Id : " + id);
				String auteur = noeudPensee.getElementsByTagName("auteur").item(0).getTextContent();
				System.out.println("Auteur : " + auteur);
				String message = noeudPensee.getElementsByTagName("message").item(0).getTextContent();
				System.out.println("Message : " + message);
				String annee = noeudPensee.getElementsByTagName("annee").item(0).getTextContent();
				System.out.println("Annee : " + annee);
								
			}
			
		} 
		catch (ParserConfigurationException e) 
		{	
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
