import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		try {
			URL urlListePensees = new URL("http://localhost/inspiration/src/pensee/liste/");
			String derniereBalise = "</pensees>";
			InputStream flux = urlListePensees.openConnection().getInputStream();
			Scanner lecteur = new Scanner(flux);
			lecteur.useDelimiter(derniereBalise); 
			String xml = lecteur.next() + derniereBalise;
			System.out.println(xml);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
