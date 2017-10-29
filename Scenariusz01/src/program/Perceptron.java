package program;

import java.util.List;

public class Perceptron {
	private double u; //wspolczynnik uczenia
	private double theta;  //wartosc progowa
	private double y;  //odpowiedz perceptronu
	private int indexp;
	private int indexk;

	List<Integer> x;
	List<Integer> t; //odpowiedzi testujace
	List<Double> w;
	
	public Perceptron(){
	}
	
	public void uczenie(int ip, int ik, int it){
		double s=0;
		this.indexp=ip;
		this.indexk=ik;
		
		s=suma();
		y=fAktywacji(s);
		
		System.out.println("\nWartosci przed uczeniem");
		wypisz(it);
		while((t.get(it)-y)>0){
			s=suma();
			y=fAktywacji(s);
			for(int i=indexp; i < indexk; i++){
				w.set(i, Double.valueOf((w.get(i) + u*(t.get(it)-y)*x.get(i))));
			}
			theta=theta-(t.get(it)-y);
		}
		System.out.println("\nWartosci po uczeniu");
		wypisz(it);
	}
	
	public double suma(){
		double s = 0;
		for(int i=indexp; i < indexk; i++){
			s = s+ x.get(i)*w.get(i);
		}
		return s;
	}
	
	//funkcja progowa unipolarna
	public double fAktywacji(double suma){
		if(suma>=theta){
			return 1;
		}else{
			return 0;
		}
	}
	
	public void wypisz(int it){
		int l=1;
		System.out.println("Zestaw" +(it+1)+ ":");
		for(int i=indexp; i < indexk; i++){
			System.out.println("Waga w" +l +": " +w.get(i));
			l++;
		}
		 System.out.println("Wartosc progowa: " +theta);
		 System.out.println("Odpowiedz y: " +y);
		 System.out.println("Blad neuronu: "+(t.get(it)-y));
	}
	
	public List<Integer> getX() {
		return x;
	}

	public void setX(List<Integer> x) {
		this.x = x;
	}

	public List<Double> getW() {
		return w;
	}

	public void setW(List<Double> w) {
		this.w = w;
	}
	
	public List<Integer> getT() {
		return t;
	}

	public void setT(List<Integer> t) {
		this.t = t;
	}
	
	public double getU() {
		return u;
	}

	public void setU(double u) {
		this.u = u;
	}

	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}
}
