import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    //deleted first row from csv
        //id,Low Temperature,High Temperature,Rain Inches,Snow Inches,Cloud Percent
    
        Network network = new Network();  
        List<List<String>> csvdata = Network.readCSV("workspace/DailyWeather.csv");
        List<List<Double>> data = null;
        List<Double> answers =new List<Double>();

        for (List<String> a : csvdata){
            String stringValue=a.get(3);
            double doubleValue = Double.parseDouble(stringValue);
            answers.add(doubleValue);
            
             stringValue=a.get(1);// low temp
             doubleValue = Double.parseDouble(stringValue);
            data.get(0).add(doubleValue);


            stringValue=a.get(2);//high temp
            doubleValue = Double.parseDouble(stringValue);
           data.get(1).add(doubleValue);


           stringValue=a.get(5);//cloud percemt
            doubleValue = Double.parseDouble(stringValue);
           data.get(1).add(doubleValue);
            }
            System.out.println(answers);
            System.out.println(data);
        //System.out.println(csvdata);
        
       // for (List<String> d : csvdata){
            
       // } 

        
    
    
    /* 
    original testing code
        List<List<Integer>> data = new ArrayList<List<Integer>>();
    data.add(Arrays.asList(115, 66));
    data.add(Arrays.asList(20, 32));
    data.add(Arrays.asList(325, 29));
    data.add(Arrays.asList(200, 88));
    data.add(Arrays.asList(115, 66));
    data.add(Arrays.asList(20, 32));
    data.add(Arrays.asList(325, 29));
    data.add(Arrays.asList(200, 88));
    List<Double> answers = Arrays.asList(0.0,1.0,1.0,0.0,0.0,1.0,1.0,0.0);  
*/
    
    //network.train(data, answers);

//Try making some predictions:
/* 
System.out.println("Should give no "+network.predict(167, 73));
System.out.println("Should give yes "+network.predict(30, 25));
System.out.println("Should give something else"+network.predict(365, 0));
*/

    }
}
