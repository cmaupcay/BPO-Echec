package plateau;

public class Plateau {

	private static final int DIMENSION = 8;
	
	// AFFICHAGE
	private static final String DECALAGE_GAUCHE = "   ";
	private static final String SEPARATEUR_HORIZONTAL = " | ";

	private static String ligneLettres()
	{
		StringBuilder str = new StringBuilder();
		final int ASCII_DEBUT = 97;

		str.append(DECALAGE_GAUCHE);
		
		for (int i = 0; i < DIMENSION; i++)
		{
			str.append(" ");
			str.append((char)(ASCII_DEBUT + i));
			str.append("  ");
		}

		str.append('\n');
		
		return str.toString();
	}
	
	private static String ligneSep()
	{
		StringBuilder str = new StringBuilder();

		str.append(DECALAGE_GAUCHE);
		
		for (int x = 0; x < DIMENSION; x++)
			str.append("--- ");
		
		str.append('\n');
		
		return str.toString();
	}

	public String toString()
	{
		StringBuilder str = new StringBuilder();
		
		str.append(ligneLettres());
		
		for (int x = 0; x < DIMENSION; x++)
		{
			str.append(ligneSep()); // Ligne de séparation
			// Ligne
			str.append(DIMENSION - x); // Index gauche
			for (int y = 0; y < DIMENSION; y++)
			{
				str.append(SEPARATEUR_HORIZONTAL); // Séparateur
				// Pièce
				str.append(" ");
			}
			str.append(SEPARATEUR_HORIZONTAL); // Dernier séparateur
			str.append(DIMENSION - x); // Index droite
			str.append('\n');	
		}
		str.append(ligneSep()); // Derniere ligne de séparation
		
		str.append(ligneLettres());
		
		return str.toString();
	}
	
}
