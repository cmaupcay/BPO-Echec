package pieces;

import plateau.Coord;
import plateau.Plateau;

public class Tour extends Piece {
    public Tour(Coord c, boolean equipeBlanche){
        super(c, equipeBlanche ? 'T' : 't');
    }

    @Override
    public boolean deplacementPossible(Coord c, Plateau p){
        return super.deplacementPossible(c,p) && (c.getX() == this.getXPos() || c.getY() == this.getYPos());
    }
}
