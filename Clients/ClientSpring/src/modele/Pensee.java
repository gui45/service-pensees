package modele;

public class Pensee {
	
	protected int idPensee;
	protected String auteur;
	protected String message;
	protected int annee;
	
	
	public Pensee(String auteur, String message) {
		super();
		this.auteur = auteur;
		this.message = message;
	}
	
	public int getId() {
		return idPensee;
	}
	public void setId(int idPensee) {
		this.idPensee = idPensee;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}

}
