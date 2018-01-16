package program;

import java.util.Random;

public class Neuron {

	double w;

    public Neuron(){
    	 Random random = new Random();
         w = random.nextDouble();
    }

    public double getOutput(int x){
        return x*w;
    }

    public void updateWeight(double update){
    	w=update;
    }
    
    public double getWeight(){
        return this.w;
    }
}
