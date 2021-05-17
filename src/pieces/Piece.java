package pieces;

import joueurs.IJoueur;
import plateau.Case;
import plateau.Plateau;

public abstract class Piece implements IPiece {

	private Couleur couleur;
	private Case refCase; // Reference à la case actuellement occupée
	
	@Override
	public Couleur getCouleur() { 
		return this.couleur; 
	}

	public Case getCase() {
		return refCase;
	}
	protected Piece(Couleur couleur, Case depart)
	{
		this.couleur = couleur;
		
		// Ajouter une erreur si la case de depart est occupée
		this.refCase = depart;
		this.refCase.occuper(this);
	}
	
	public boolean mouvementValide(Case destination, Plateau plateau){
		return true;
	}
	
	@Override
	public boolean mouvement(Case destination, Plateau plateau)
	{
		// La case destination est la case actuellement occupée
		if (destination.getCoord().equals(this.refCase.getCoord())) return false;
		
		// La case destination est occupée par une pièce de la même couleur
		if (destination.occupant().getCouleur() == this.couleur) return false;
		
		if (this.mouvementValide(destination, plateau))
		{
			this.refCase.quitter(); // Quitter la case courante
			this.refCase = destination; // Modifier la case courante par la case destination
			this.refCase.occuper(this); // Occuper la case destination
			return true;
		}
		else
			return false;
	}
	
	protected abstract char caractere(); // Caractère propre à chaque pièce
	@Override
	public char afficher()
	{
		char c = this.caractere();
		if (this.couleur == Couleur.BLANC)
			c = Character.toUpperCase(c);
		return c;
	}

	@Override
	public boolean estEnEchec(IJoueur j_adverse, Plateau plateau){
		return false;
	}
}