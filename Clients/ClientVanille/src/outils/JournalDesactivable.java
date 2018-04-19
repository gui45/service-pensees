package outils;

public class JournalDesactivable {
	
	protected static boolean actif = false;
	
	public static void activer() {JournalDesactivable.actif = true;}
	public static void desactiver() {JournalDesactivable.actif = false;}
	
	public static void ecrire(String message)
	{
		if(JournalDesactivable.actif) System.out.println(message);
	}
}
