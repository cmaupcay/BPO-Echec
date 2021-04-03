package pieces;

import plateau.*;

public class Roi extends Piece {
    public Roi(Coord c, boolean equipeBlanche){
        super(c, equipeBlanche ? 'R' : 'r');
    }

    @Override
    public boolean deplacementPossible(Coord c, Plateau p){
        return super.deplacementPossible(c,p) && (c.getX() < (this.getXPos() + 2) && c.getX() > (this.getXPos() - 1))
                                              && (c.getY() < (this.getYPos() + 2) && c.getY() > (this.getYPos() - 1));
    }
}
