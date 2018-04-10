package accesseur;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import modele.Pensee;
import modele.reponse.ReponseListePensees;

public class PenseeDAO {
	
	
	public List<Pensee> listerPensees()
	{
		RestTemplate service = new RestTemplate();
		ReponseListePensees reponse = service.getForObject("http://localhost/inspiration/src/pensee/liste/", ReponseListePensees.class);
		System.out.println("La reponse indique " + reponse.getNombre() + " objets");
		
		List<Pensee> listePensees = reponse.getListePensees();
		System.out.println("La reponse a " + listePensees.size() + " objets");
				
		return listePensees;

	}
	

}
