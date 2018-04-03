import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		try {
			URL urlListePensees = new URL("http://localhost/inspiration/src/pensee/liste/");
			InputStream flux = urlListePensees.openConnection().getInputStream();
			Scanner lecteur = new Scanner(flux);
			lecteur.useDelimiter("\\A"); // delimiteur inexistant pour recuperer tout le flux
			String xml = lecteur.next();
			System.out.println(xml);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
