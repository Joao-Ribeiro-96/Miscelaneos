package gympass.sourcecode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Utils {
	
  public static List<Racer> getRacers(String filename){
	  // Creates a ArrayList of racers
	  
    List<Racer> racers = new ArrayList<Racer>();
    Racer racer = null;
    BufferedReader br = null;
    try {
    	 br = new BufferedReader(new FileReader(filename));
    	 String line ="";
    	 
    	 br.readLine();
    	 while((line = br.readLine())!= null) {
    		
    	
        if ((racer = createRacer(line)) != null) {
        	boolean found = false;
        	for(int i = 0 ; i < racers.size();i++) {
        		
        		if(racers.get(i).id() == racer.id) {
        			addLap(racers.get(i),line);
        			found = true;
        		}
        	}
          if(found == false) {
      // Add lap and racer	
        	  racers.add(racer);	  
          }
          
        }
    	 		}
    	 
    	 for(int r = 0; r < racers.size();r++) {
    		 String[] dnf = racers.get(r).laps();
    		 
    		 for(int i = 0 ; i < dnf.length;i++) {
    			 System.out.println(dnf[i]+ "");
    			 System.out.println(racers.get(r).name());
    		 }
    		 if(dnf[3].compareTo("null") >= 0 ) {
    			 System.out.println("thins");
    			 racers.get(r).laps(" Did not finished ");
    			 
    		 }
    	 }
        	br.close();
        } catch (IOException e) {
          e.printStackTrace();
          
        }
   
    return racers;
  }
  
  public static String[] formatLine(String line) {
	System.out.println(line);
	String otherLine = line.replace('–','%');
	String lines = otherLine.replaceAll("\\s+","%");
	String[] arr = lines.split("%");
	return arr;
  }
  
  	// Creates Object racer
  public static Racer createRacer(String line) {
	 String[] arr = formatLine(line);
//	for(int i = 0;i < arr.length ;i++ ) {
//		System.out.println(arr[i] +"   "+ i);
//	}
    int id = Integer.parseInt(arr[1]);
    String name = arr[4].trim();
    String lap = arr[6].trim();
    return new Racer(id, name, lap);
  }
  
  public static String addLap(Racer driver, String line) {
	  String [] arr = formatLine(line);	
	  driver.laps(arr[6]);	  
	  return "";
  }
}