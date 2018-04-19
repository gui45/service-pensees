package outils;

public class Journal {
	
	protected static boolean actif = false;
	public static void activer() {Journal.actif = true;}
	public static void desactiver() {Journal.actif = false;}
	
	public static void ecrire(String message)
	{
		if(Journal.actif) System.out.println(message);
	}
}
