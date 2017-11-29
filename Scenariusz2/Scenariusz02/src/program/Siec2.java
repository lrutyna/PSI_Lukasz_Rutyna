package program;

public class Siec2 {
	private double u=0.1; //wspolczynnik uczenia
	private double theta=12;  //wartosc progowa
	private double mom=1;
	private int n=35;
	private int m=26;
	private int x[][]=new int[10][n];
	private int t[][]=new int[10][m];
	
	private int y[] = new int[n];            //odpowiedz perceptronu
	private double w[][]=new double[m][n];
	
	private Dane dane = new Dane();
	
	public Siec2(){
		x=dane.getAH();
		t=dane.getODP();
		dane.initW();
		w=dane.getW();
	}

	//uczenie dla k-tego wiersza z tablicy x[10][35]
	public void uczenie(int k){
		double s[] = new double[26];
		s=suma(k);
		System.out.println("\nWartosci przed uczeniem");
		wypisz();
		double p[][] = w;
		double r=0;
		int l=0;
		
		for(int i=0; i<m; i++){
			y[i]=fAktywacji(s[i]);
			while((t[k][i]-y[i])!=0){
				s=suma(k);
				y[i]=fAktywacji(s[i]);
				for(int j=0; j<n; j++){
					p[i][j]=w[i][j];
					w[i][j]=w[i][j]+u*(t[k][i]-y[i])*x[k][j] + mom*r;
					r=p[i][j]-w[i][j];
				}
				l++;
				theta=theta-(t[k][i]-y[i]);
			}
		}
		System.out.println("\nWartosci po uczeniu");
		wypisz();
		sprawdzenie(k);
	}
	
	public void sprawdzenie(int k){
		System.out.println("\nOdpowiedz po uczeniu: ");
		int sprY[]=new int[26];
		double s[]=suma(k);
		for(int i=0; i<26;i++){
			sprY[i]=fAktywacji(s[i]);
			System.out.println(sprY[i]+",");
		}
	}
	
	//suma dla k-tego wiersza w tablicy x[10][35]
	public double[] suma(int k){
		double s[] = new double[26];;
		for(int i=0; i<m; i++){
			s[i]=0;
			for(int j=0; j<n; j++){
				s[i] = s[i]+x[k][j]*w[i][j];
			}
		}
		return s;
	}
	
	//funkcja progowa unipolarna
	public int fAktywacji(double suma){
		if(suma>=theta){
			return 1;
		}else{
			return 0;
		}
	}
	
	public void wypisz(){
		for(int i=0; i < m; i++){
			for(int j=0; j < n; j++){
				System.out.println("Waga("+i+","+j+")="+w[i][j]);
			}
		}
	}

	public void setW(double[][] w) {
		this.w = w;
	}

}
