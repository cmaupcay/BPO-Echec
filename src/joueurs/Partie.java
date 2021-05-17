package joueurs;

import plateau.*;
import pieces.IPiece;

public final class Partie {

	private IJoueur joueurA;
	private IJoueur joueurB;

	private int coups;
	
	private int vainqueur; 
	// < 0 -> joueur A 
	// > 0 -> joueur B 
	// = 0 -> match nul
	
	private Plateau plateau;
	
	public Partie(IJoueur joueurA, IJoueur joueurB)
	{
		this.plateau = new Plateau();
		
		this.coups = 0;
		
		this.joueurA = joueurA;
		this.joueurB = joueurB;
		
		this.vainqueur = 0;
	}
	
	private boolean verifierPat(IJoueur j) {
		IPiece p;
		for (int i = 0; i < j.getNbPieces(); ++i) {
			p = j.getPieceByIndex(i);
			for (int x = 0; x < Coord.MAX; ++x)
				for (int y = 0; y < Coord.MAX; ++y)
					if (p.mouvementValide(plateau.getCase(x, y), plateau))
						return false;
		}
			return true;
	}
	
	private boolean EchecEtMat(IJoueur j) {
		IJoueur j_adverse = j == joueurA ? joueurB : joueurA;
		if(j.getPieceByIndex(0).estEnEchec(j_adverse, plateau)) {
			for (int x = 0; x < Coord.MAX; ++x)
				for (int y = 0; y < Coord.MAX; ++y)
					if (j.getPieceByIndex(0).mouvementValide(plateau.getCase(x, y), plateau))
						return false;
			return true;
		}
		return false;
	}

	// Verifie si le plateau correspond a une position de match nul
	// false = pas de match nul / true = match nul
	// Ne modifie pas la variable this.vainqueur !
	private boolean verifierMatchNul(){
		boolean matchNul = false;

		if (!matchNul)
			matchNul = this.verifierPat(joueurA) || this.verifierPat(joueurB);
		
		return matchNul;
	}
	
	// Verifie si le plateau correspond a une position de victoire.
	// Si oui, designe le vainqueur dans la variable this.vainqueur et renvoie true.
	// Sinon, renvoie false.
	private boolean verifierVainqueur() {
		// A completer
		if(verifierPat(joueurA) || verifierPat(joueurB) || verifierMatchNul()) {
			this.vainqueur = 0;
			return true;
		} else if (EchecEtMat(joueurA) || EchecEtMat(joueurB)) {
			vainqueur = EchecEtMat(joueurA) ? 1 : -1; // si joueurA est échec et mat, alors B est vainqueur et inversement
			// pas besoin de revérifier EchecEtMat(joueurB) puisque le if ne s'active que si l'un des deux est en échec et mat
			return true;
		}
		return false;
	}
	
	private boolean actualiserEtat()
	{
		boolean etat = this.verifierMatchNul();
		
		if (etat) // Match nul
		{
			this.vainqueur = 0;
			return false; 
		}
		
		// Pas de match nul	
		return this.verifierVainqueur();
	}
	
	public boolean coupSuivant() {
		// Jouer le coup du joueur suivant
		if (this.coups % 2 == 0)
			this.joueurA.jouerCoup(this.plateau);
		else
			this.joueurB.jouerCoup(this.plateau);
		
		this.coups++;
		return this.actualiserEtat();
	}
	
	public String messageFin() {
		if (this.vainqueur < 0) // Joueur A vainqueur
			return "Joueur A vainqueur !";
		else if (this.vainqueur > 0) // Joueur B vainqueur
			return "Joueur B vainqueur !";
		else // Match nul
			return "Match nul !";
	}
	
	public String toString() { 
		return this.plateau.toString(); 
	}
	
}