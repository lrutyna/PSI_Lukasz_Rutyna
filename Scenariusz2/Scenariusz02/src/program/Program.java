package program;


public class Program {
	
	public static void main(String[] args){
		
		double w[][]=new double[26][35];
		Dane dane = new Dane();
		w=dane.getW();
		
		Siec1 siec1 = new Siec1();
		siec1.setW(w);
		Siec2 siec2 = new Siec2();
		siec2.setW(w);
		
		//uczenie sieci dla argumentu, ktory jest indeksem wiersza w tablicy z literami
		//np. litera A to 0 wiersz z 26 odpowiedziami w kolumnach, ktore reprezentuja wlasciwa litre w alfabecie
		siec1.uczenie(2);
	
		//siec2.uczenie(1);
	}
	
}
