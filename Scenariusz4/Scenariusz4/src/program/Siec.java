package program;


public class Siec {
	double u=0.4;                         //wspolczynnik uczenia
	double gamma=0.3;                     //wspolczynnik zapominania
    int x[][] =new int[35][];             //dane treningowe
    Neuron neurons[]=new Neuron[35];

    //n-liczba neuronow
    public Siec(int n,int trainingdata[][]){
        neurons=new Neuron[n];
        for(int j=0;j<neurons.length;j++){
            neurons[j]=new Neuron();
        }
        x=trainingdata;
    }

    public void training(){
        for(int i=0;i<x.length;i++){
            int inputs[]= x[i];
            double output=getNeuralNetOutput(neurons,inputs);   

            //aktualizacja wag
            for(int j=0;j<neurons.length;j++){
                neurons[j].updateWeight(neurons[j].getWeight() * (1 - gamma) + output * u * inputs[j]);
            }
            
        }
    }

    public double getNeuralNetOutput(Neuron[] neurons,int inputs[]){
        //suma wszystkich wyjsc     
        double output=0;
        for(int j=0;j<neurons.length;j++){
            output+=neurons[j].getOutput(inputs[j]);
        }
        return output;
    }

    public void testing (int[] inputs){
        System.out.println(getNeuralNetOutput(neurons,inputs));
    }
	
}
