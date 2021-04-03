package pieces;

import plateau.*;

public class Piece {
    private Coord pos;
    private char symbole;

    public Piece(Coord coord, char c){
        this.pos = coord;
        this.symbole = c;
    }

    public void deplacer(Coord c, Plateau p) throws Exception {
        if(!deplacementPossible(c, p))
            throw new Exception("Déplacement impossible");
        p.set(c, this);
    }

    public boolean deplacementPossible(Coord c, Plateau p){
        return (c.getX() > 0 && c.getY() > 0 && c.getY() < p.getDimension() && c.getX() < p.getDimension());
    }

    public int getXPos(){
        return this.pos.getX();
    }

    public int getYPos(){
        return this.pos.getY();
    }

    public String toString(){
        return "" + symbole;
    }
}
