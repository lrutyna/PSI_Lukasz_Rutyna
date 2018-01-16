package program;

public class Program {
	private static Dane dane = new Dane();
	
	public static void main(String a[]){
		
        int x[][] = dane.getAT();      //dane treningowe
        
        Siec siec = new Siec(35,x);
        siec.training();
        
        for(int i=0; i<20;i++){
            System.out.print((char)(i+65) + ": ");
            siec.testing(x[i]);
        }
    }
}

