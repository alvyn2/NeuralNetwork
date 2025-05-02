import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {



    //deleted first row from csv
        //id,Low Temperature,High Temperature,Rain Inches,Snow Inches,Cloud Percent
    
        // predicts whether it will rain based on temperature and cloud percent
        Network network = new Network();  
        List<List<String>> csvdata = Network.readCSV("workspace/DailyWeather.csv");
        List<List<Integer>> data =new ArrayList<List<Integer>>();
        List<Double> answers =new ArrayList<Double>();

        for (List<String> a : csvdata){//copies data from the String array to data and answers variables
            
            
            String stringValue=a.get(3);
            double doubleValue = Double.parseDouble(stringValue);
            double booleanAnswer;
            if(doubleValue>0){
                booleanAnswer=1;
            }else{
                booleanAnswer=0;
            }
            answers.add(booleanAnswer);
            
             //stringValue=a.get(1);// low temp
            //doubleValue = Double.parseDouble(stringValue);
            //Integer intValue=(int) doubleValue;
            data.add(Arrays.asList((int) Double.parseDouble(a.get(1)), (int) Double.parseDouble(a.get(2)), (int) Double.parseDouble(a.get(5))));

/* 
            stringValue=a.get(2);//high temp
            doubleValue = Double.parseDouble(stringValue);
            intValue=(int) doubleValue;
           //data.add(1).add(intValue);


           stringValue=a.get(5);//cloud percemt
           doubleValue = Double.parseDouble(stringValue);
            intValue=(int) doubleValue;
           //data.add(1).add(intValue);
           */
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
    
    network.train(data, answers);



//Try making some predictions:

System.out.println("Should give no "+network.predict(43,68,13));
System.out.println("also no "+network.predict(41,58,49));
System.out.println("Should give yes "+network.predict(52,71,32));
System.out.println("Should give something random and different"+network.predict((int)(Math.random()*80), (int)(Math.random()*100),(int)(Math.random()*100)));



// questions and answers
/*
 * 
 * 
 *  1) Do these predictions seem reasonable to you? Why or why not? 
 * No because both quesses are often close to the same number as each other. 

                 2) What are some factors not accounted for by your data which may be affecting your outcomes which your model isn't accounting for?
                 The dataset includes data from various locatios around the us, but this could make the predictions less accurate because it is adapting to different locations throuhgought the dataset that trains it. It also might not account for the season as well as if it included the day of the year
                 3)  Given what you now know about neural networks and how they arrive at their predictions, what may be a specific question or kind of question which you should not rely on chatGPT to answer                                         accurately? Explain why. 
                        You shouldn't rely of chatGPT to answer a question that has answers not following a consistent pattern, such as creative art or location-specific questions
 * 
 */

    }
}
