package plateau;

import java.util.ArrayList;
import java.util.Random;

public class Plateau {

	private ArrayList<Case> cases;
	// AFFICHAGE
	//private static final String DECALAGE_GAUCHE = "   ";
	private static final String SEPARATEUR_HORIZONTAL = " | ";
	
	private void construire()
	{
		// Construction des cases
		this.cases = new ArrayList<>();		
		for (int y = 0; y < Coord.MAX; y++)
			for (int x = 0; x < Coord.MAX; x++)
				this.cases.add(new Case(x, y));
	}
	
	public Plateau()
	{
		this.construire();
	}

	public Case getCase(int x, int y)
	{
		if (Coord.verifierCoordonnee(x) && Coord.verifierCoordonnee(y))
		{
			int index = y * Coord.MAX + x;
			return this.cases.get(index);
		}
		return null;
	}

	public Case getCaseRandom(){
		Random r = new Random();
		Case c = getCase(r.nextInt(Coord.MAX - Coord.MIN + 1) + Coord.MIN,r.nextInt(Coord.MAX - Coord.MIN + 1) + Coord.MIN);
		while (c.occupant() != null) {
			c = getCase(r.nextInt(Coord.MAX - Coord.MIN + 1) + Coord.MIN,r.nextInt(Coord.MAX - Coord.MIN + 1) + Coord.MIN);
		}
		return c;
	}
	
	private static String ligneSep(){
		StringBuilder str = new StringBuilder();

		str.append("   ");

		for (int x = 0; x < Coord.MAX; x++)
			str.append("--- ");

		str.append('\n');

		return str.toString();
	}
	
	private static String ligneLettres() {
		StringBuilder str = new StringBuilder();
		final int ASCII_DEBUT = 97;

		str.append("   ");

		for (int i = 0; i < Coord.MAX; i++)
		{
			str.append(" ");
			str.append((char)(ASCII_DEBUT + i));
			str.append("  ");
		}

		str.append('\n');

		return str.toString();
	}
	
	
	// Affichage du plateau
	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		
		str.append(ligneLettres());

		for (int x = 0; x < Coord.MAX; x++)
		{
			str.append(ligneSep()); // Ligne de séparation
			// Ligne
			str.append(Coord.MAX - x); // Index gauche
			for (int y = 0; y < Coord.MAX; y++)
			{
				str.append(SEPARATEUR_HORIZONTAL); // Séparateur
				// Pièce
				str.append(" ");
			}
			str.append(SEPARATEUR_HORIZONTAL); // Dernier séparateur
			str.append(Coord.MAX - x); // Index droite
			str.append('\n');	
		}
		str.append(ligneSep()); // Derniere ligne de séparation

		str.append(ligneLettres());
		
		return str.toString();
	}
	
}