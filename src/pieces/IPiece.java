package pieces;

import joueurs.IJoueur;
import plateau.Case;
import plateau.Plateau;

public interface IPiece {

	// Couleur de la piece
	public Couleur getCouleur();
	
	// Demande a la piece de bouger jusqu'a la case destination
	// Le retour est false si le mouvement ne peut aboutir
	boolean mouvement(Case destination, Plateau plateau);
	
	// Affichage de la piece
	char afficher();

	public boolean mouvementValide(Case destination, Plateau plateau);

	public boolean estEnEchec(IJoueur j_adverse, Plateau plateau);
	
}
