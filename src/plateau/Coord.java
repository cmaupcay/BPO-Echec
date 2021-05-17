package plateau;

public class Coord {

	public static final int MIN = 0;
	public static final int MAX = 8;
	
	private int x;
	private int y;
	
	//Vérifier les 2 coordonnées
	public static boolean verifierCoordonnee(Coord coord) { 
		return (coord.getX() >= MIN && coord.getX() < MAX && coord.getY() >= MIN && coord.getY() < MAX); 
	}
	
	//Vérifier UNE coordonnée (x ou y)
	public static boolean verifierCoordonnee(int a) { 
		return (a >= MIN && a < MAX); 
	}
	
	public Coord(int x, int y)
	{
		if (verifierCoordonnee(x)) this.x = x;
		else this.x = MIN;
		
		if (verifierCoordonnee(y)) this.y = y;
		else this.y = MIN;
	}

	public int getX() { 
		return this.x; 
	}
	
	public int getY() { 
		return this.y; 
	}
}
