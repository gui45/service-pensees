package modele.reponse;

import javax.xml.bind.annotation.XmlRootElement;

import modele.Pensee;

@XmlRootElement(name="action")
public class ReponseAjouterPensee {
	
	protected String type;
	protected int succes;
	protected int moment;
	protected String message;
	protected Pensee pensee;
	
	public Pensee getPensee() {
		return pensee;
	}
	public void setPensee(Pensee pensee) {
		this.pensee = pensee;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSucces() {
		return succes;
	}
	public void setSucces(int succes) {
		this.succes = succes;
	}
	public int getMoment() {
		return moment;
	}
	public void setMoment(int moment) {
		this.moment = moment;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
