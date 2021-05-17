package joueurs;

import pieces.Couleur;
import pieces.IPiece;
import plateau.Plateau;

public interface IJoueur {

	// Couleur du joueur
	public Couleur getCouleur();
	
	// Coup suivant
	public void jouerCoup(Plateau plateau);

	public int getNbPieces();

	public IPiece getPieceByIndex(int i);
	
}