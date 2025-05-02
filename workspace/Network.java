import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Network {
    List<Neuron> neurons = Arrays.asList(
      new Neuron(), new Neuron(), new Neuron(), new Neuron(), new Neuron(), new Neuron(),new Neuron(), new Neuron(), new Neuron(), /* input nodes */
      new Neuron(), new Neuron(),new Neuron(),            /* hidden nodes */
      new Neuron()                           /* output node */
      ); 





      public Double predict(Integer input1, Integer input2,Integer input3){
        return neurons.get(12).compute(
          neurons.get(9).compute(
            neurons.get(2).compute(input1, input2, input3),
            neurons.get(1).compute(input1, input2, input3),
            neurons.get(0).compute(input1, input2, input3)
          ),neurons.get(10).compute(
            neurons.get(5).compute(input1, input2, input3),
            neurons.get(4).compute(input1, input2, input3),
            neurons.get(3).compute(input1, input2, input3)
          ),
          neurons.get(11).compute(
            neurons.get(6).compute(input1, input2, input3),
            neurons.get(7).compute(input1, input2, input3),
            neurons.get(8).compute(input1, input2, input3)
          )
        );
      }


      public static void main(String [] args){
        Network network = new Network();
        Double prediction = network.predict(2,30,50);
        


        
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
              predictions.add(i, this.predict(data.get(i).get(0), data.get(i).get(1), data.get(i).get(2)));
            }
            Double thisLoss = meanSquareLoss(answers, predictions);
        
        // Logging:
        if (iteration % 10 == 0){
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
        
      }//end for loop

    }//end train function
          public static Double meanSquareLoss(List<Double> correctAnswers,   List<Double> predictedAnswers){
            double sumSquare = 0;
            for (int i = 0; i < correctAnswers.size(); i++){
              double error = correctAnswers.get(i) - predictedAnswers.get(i);
              sumSquare += (error * error);
            }
            return sumSquare / (correctAnswers.size());
          }
          
public static List<List<String>> readCSV(String filePath) {
List<List<String>> data = new ArrayList<>();

try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
String line;
while ((line = br.readLine()) != null) {
String[] values = line.split(",");

data.add(Arrays.asList(values));
}
} catch (IOException e) {
e.printStackTrace();
}
return data;
}//end readCSV
      
}//end class
