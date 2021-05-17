package pieces;

import joueurs.IJoueur;
import plateau.Case;
import plateau.Coord;
import plateau.Plateau;

public class Roi extends Piece {

	public Roi (Couleur couleur, Case depart) {
	 super(couleur, depart);
	}

	@Override
    public char caractere() {
		return getCouleur() == Couleur.BLANC ? 'R' : 'r';
	}
	
	@Override
	public boolean mouvementValide(Case destination, Plateau plateau) {
		return  Coord.verifierCoordonnee(destination.getCoord()) 
				&& (destination.getCoord().getX() < (this.getCase().getCoord().getX() + 2)
				&& destination.getCoord().getX() > (this.getCase().getCoord().getX() - 1))
                && (destination.getCoord().getX() < (this.getCase().getCoord().getY() + 2) 
                && destination.getCoord().getY() > (this.getCase().getCoord().getY() - 1));
	}

	@Override
	public boolean estEnEchec(IJoueur j_adverse, Plateau plateau){
		IPiece p;
		for(int i = 0; i < j_adverse.getNbPieces(); ++i) {
			p = j_adverse.getPieceByIndex(i);
			if (p.mouvementValide(this.getCase(), plateau))
				return true;
		}
		return false;
	}
}
