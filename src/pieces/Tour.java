package pieces;

import plateau.Case;
import plateau.Coord;
import plateau.Plateau;

public class Tour extends Piece {
    public Tour (Couleur couleur, Case depart) {
        super(couleur, depart);
    }

    @Override
    public char caractere() {
        return getCouleur() == Couleur.BLANC ? 'T' : 't';
    }

    @Override
    public boolean mouvementValide(Case destination, Plateau plateau) {
        return  Coord.verifierCoordonnee(destination.getCoord())
                && ((destination.getCoord().getX() == this.getCase().getCoord().getX())
                    ^ destination.getCoord().getY() == this.getCase().getCoord().getY());
    }
}
