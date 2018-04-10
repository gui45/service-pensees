
import java.util.List;

import org.springframework.web.client.RestTemplate;

import modele.Pensee;
import modele.reponse.ReponseListePensees;

public class App {

	public static void main(String[] args) {

		
		RestTemplate service = new RestTemplate();
		ReponseListePensees reponse = service.getForObject("http://localhost/inspiration/src/pensee/liste/", ReponseListePensees.class);
		System.out.println("La reponse indique " + reponse.getNombre() + " objets");
		
		List<Pensee> listePensees = reponse.getListePensees();
		System.out.println("La reponse a " + listePensees.size() + " objets");
		
	}

}
