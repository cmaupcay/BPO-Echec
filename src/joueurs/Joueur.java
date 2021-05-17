package joueurs;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.sun.source.tree.DoWhileLoopTree;
import com.sun.source.tree.WhileLoopTree;
import pieces.Couleur;
import pieces.IPiece;
import pieces.Roi;
import pieces.Tour;
import plateau.Case;
import plateau.Coord;
import plateau.Plateau;

public abstract class Joueur implements IJoueur {
	public Couleur couleur;
	private ArrayList<IPiece> pieces;

	protected Joueur(Couleur couleur, Plateau plateau) {
		this.couleur = couleur;
		this.construirePieces(plateau);
	}

	public IPiece getPieceByIndex(int i){
		return pieces.get(i);
	}

	public int getNbPieces(){
		return pieces.toArray().length;
	}

	@Override
	public Couleur getCouleur() { 
		return this.couleur; 
	}

	private void construirePieces(Plateau plateau) {
		pieces.add(new Roi(couleur, plateau.getCaseRandom()));
		pieces.add(new Tour(couleur, plateau.getCaseRandom()));
	}
	
	@Override
	public void jouerCoup(Plateau plateau)
	{
		IPiece p;
		String s = saisie();
		p = plateau.getCase(correspondance(s.charAt(0)),correspondance(s.charAt(1))).occupant();
		Boolean b = p.mouvement(plateau.getCase(correspondance(s.charAt(2)),correspondance(s.charAt(3))),plateau);
	}

	private String saisie(){
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}


	/* La fonction correspondance sert à trouver l'entier correspondant à la lettre ou au chiffre du plateau
	* Le programme fonctionne avec des x et y alors que le plateau s'affiche avec des lettres et des chiffres.
	*/
	private int correspondance(char c){
		char t1[] = {'a','b','c','d','e','f','g','h'};
		char t2[] = {'8','7','6','5','4','3','2','1'};
		if(getIndexOf(t1,c) < 0)
			return getIndexOf(t2,c);
		return getIndexOf(t1,c);
	}

	private int getIndexOf(char[] t, char c){
		for(int i = 0; i < t.length; ++i) {
			if (t[i] == c)
				return i;
		}
		return -1;
	}
}
