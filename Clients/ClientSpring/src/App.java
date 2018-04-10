import org.springframework.web.client.RestTemplate;

import modele.reponse.ReponseListePensees;

public class App {

	public static void main(String[] args) {

		
		RestTemplate service = new RestTemplate();
		ReponseListePensees reponse = service.getForObject("http://localhost/inspiration/src/pensee/liste/", ReponseListePensees.class);
		System.out.println("La reponse a " + reponse.getNombre() + " objets");
	}

}
