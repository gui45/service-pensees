package accesseur;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import modele.DecodeurPenseesXML;
import modele.Pensee;
import outils.Journal;
import outils.JournalDesactivable;

public class PenseeDAO implements PenseeURL{

	protected DecodeurPenseesXML decodeur = new DecodeurPenseesXML();	
	
	public List<Pensee> listerPensees()
	{
		JournalDesactivable.ecrire("listerPensees()");			
		String xml = null;		
		
		try {
			URL urlListePensees = new URL(URL_LISTE_PENSEES);
			String derniereBalise = "</pensees>";
			InputStream flux = urlListePensees.openConnection().getInputStream();
			Scanner lecteur = new Scanner(flux);
			lecteur.useDelimiter(derniereBalise); 
			xml = lecteur.next() + derniereBalise;
			lecteur.close();
			Journal.ecrire(2, "xml : " + xml);			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(null == xml) return null;
		
		return decodeur.decoderListe(xml);
	}
	
	public void ajouterPensee(Pensee pensee)
	{
		Journal.ecrire(1, "ajouterPensee()");			
		String xml = "";
		try {
						
			URL urlAjouterPensee = new URL(URL_AJOUTER_PENSEE);
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
			Journal.ecrire(2, "Code de réponse " + codeReponse);
			
			InputStream fluxLecture = connection.getInputStream();
			Scanner lecteur = new Scanner(fluxLecture);
			
			String derniereBalise = "</action>";
			lecteur.useDelimiter(derniereBalise);
			xml = lecteur.next() + derniereBalise;
			lecteur.close();
			connection.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		decodeur.decoderReponseAction(xml);

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
