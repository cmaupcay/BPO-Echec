package plateau;

import pieces.Couleur;
import pieces.IPiece;

public class Case {
	
	private Coord coord;
	private Couleur couleur;
	private IPiece piece;
	
	public Couleur getCouleur() { 
		return this.couleur; 
	}

	public Coord getCoord() { 
		return this.coord; 
	}

	public Case(int x, int y)
	{
		this.coord = new Coord(x, y);
		this.calculerCouleur();

		this.piece = null;
	}

	// Determine la couleur de la case selon ses coordonnées.
	private void calculerCouleur()
	{
		if(coord.getX() % 2 == coord.getY() % 2 )
			this.couleur = Couleur.NOIR;
		else
			this.couleur = Couleur.BLANC;
	}

	public boolean estOccupee() { 
		return (this.piece != null); 
	}
	
	public IPiece occupant() { 
		return this.piece; 
	}
	
	public void occuper(IPiece piece) { 
		if (!this.estOccupee()) 
			this.piece = piece;
	}
	
	public void quitter() { 
		this.piece = null; 
	}
	
	public char afficher()
	{
		if (this.estOccupee())
			return this.piece.afficher();
		return ' ';
	}
	
}