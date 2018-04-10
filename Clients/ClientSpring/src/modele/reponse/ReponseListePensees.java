package modele.reponse;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pensees")
public class ReponseListePensees {
	
	protected int nombre;

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

}
