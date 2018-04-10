package modele.reponse;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import modele.Pensee;

@XmlRootElement(name="pensees")
public class ReponseListePensees {
	
	protected int nombre;

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	
	protected List<Pensee> listePensees = new ArrayList<Pensee>();

	@XmlElement(name="pensee")
	public List<Pensee> getListePensees() {
		return listePensees;
	}

	public void setListePensees(List<Pensee> listePensees) {
		this.listePensees = listePensees;
	}

}
