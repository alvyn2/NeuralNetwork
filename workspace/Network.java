import java.util.*;

class Network {
    List<Neuron> neurons = Arrays.asList(
      new Neuron(), new Neuron(), new Neuron(), /* input nodes */
      new Neuron(), new Neuron(),               /* hidden nodes */
      new Neuron()                           /* output node */
      ); 

    int epoch=0;



      public Double predict(Integer input1, Integer input2){
        return neurons.get(5).compute(
          neurons.get(4).compute(
            neurons.get(2).compute(input1, input2),
            neurons.get(1).compute(input1, input2)
          ),
          neurons.get(3).compute(
            neurons.get(1).compute(input1, input2),
            neurons.get(0).compute(input1, input2)
          )
        );
      }


      public static void main(String [] args){
        Network network = new Network();
        Double prediction = network.predict(2,30);
        
        System.out.println("prediction: " + prediction);
        }

        public void train(List<List<Integer>> data, List<Double> answers){
            Double bestLoss = null;
            for (int iteration = 0; iteration < 1000; iteration ++){
              // adapt neuron
              Neuron neuron = neurons.get(iteration % 6);
              neuron.mutate();
          
              List<Double> predictions = new ArrayList<Double>();
              for (int i = 0; i < data.size(); i++){
                predictions.add(i, this.predict(data.get(i).get(0), data.get(i).get(1)));
              }
              Double thisLoss = meanSquareLoss(answers, predictions);
          
          // Logging:
          if (epoch % 10 == 0){
           System.out.println("Iteration: "+iteration+" best loss: "+bestLoss+" this loss: "+thisLoss);
              if (bestLoss == null){
                bestLoss = thisLoss;
                  neuron.remember();
                } else {
                    if (thisLoss < bestLoss){
                        bestLoss = thisLoss;
                        neuron.remember();
                    } else {
                        neuron.forget();
                    }
          
                }
        }
        epoch++;
        }
    }//end train function 
          
          public static Double meanSquareLoss(List<Double> correctAnswers,   List<Double> predictedAnswers){
            double sumSquare = 0;
            for (int i = 0; i < correctAnswers.size(); i++){
              double error = correctAnswers.get(i) - predictedAnswers.get(i);
              sumSquare += (error * error);
            }
            return sumSquare / (correctAnswers.size());
          }
          
        
      
}//end class
