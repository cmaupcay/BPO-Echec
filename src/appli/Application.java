package appli;

import joueurs.Partie;

public final class Application {
	
	public static void main(String[] args) {
		
		Partie partie = new Partie(null, null);
		boolean active = true;
		
		while (active)
		{
			System.out.print(partie);
			active = partie.coupSuivant();
		}
		
		System.out.println(partie.messageFin());
		
	}

}