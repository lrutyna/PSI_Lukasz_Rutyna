package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
	
	private static int n = 2; //liczba danych wejsciowych dla jednego neuronu
	private static int k = 4; //liczba wzorcow (liczba uzytych neuronow)
	private static double u = 0.2; //wspolczynnik uczenia
	private static double theta=14;  //wartosc progowa
	
	//dane uczace i testujace dla f. logicznej OR
	private static List<Integer> x = new ArrayList<>(Arrays.asList(0,0,0,1,1,0,1,1));                //dane uczace
	private static List<Integer> t = new ArrayList<>(Arrays.asList(0,1,1,1));                        //dane sprawdzajace
	private static List<Double> w = new ArrayList<>(Arrays.asList(0.2,1.3,9.4,0.1,4.2,1.8,7.1,0.9)); //wagi
	private Random generator = new Random();
	
	
	public static void main(String args[]){
		int ip = 0, ik = 2;
		Main program = new Main();
		Perceptron perceptron = new Perceptron();

		//program.init();
		//program.wypisz();
		
		for(int i=0; i<k; i++){
			perceptron.setX(x);
			perceptron.setW(w);
			perceptron.setT(t);
			perceptron.setTheta(theta);;
			perceptron.setU(u);
			perceptron.uczenie(ip, ik, i);
			ip=ip+n;
			ik=ip+n;
		}
		//program.wypisz();
	}
	
	//inicjalizacja wag
	public void init(){
		for(int i=0; i < n*k; i++){
			w.add(generator.nextDouble());
		}
	}
	
	public void wypisz(){
		System.out.println("\n");
		for(int i=0; i < n*k; i++){
			System.out.println("Waga w" +i +": " +w.get(i));
		}
	}
}
