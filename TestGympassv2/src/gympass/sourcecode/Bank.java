package gympass.sourcecode;
import java.util.List;

import javax.swing.JOptionPane;

public class Bank {
  protected List<Racer> racers;
  private String output;

  public Bank() {
   // String filename = JOptionPane.showInputDialog("Insert file path");
	  String filename = "C:\\Users\\ezribjo\\eclipse-workspace\\TestGympassv2\\bin\\gympass\\sourcecode\\Results.txt";

    racers = Utils.getRacers(filename);
    output = createList();
    JOptionPane.showMessageDialog(null, output);
    
  }
  
  public String createList() {
	  String header = "Posição de chegada || "
	  		+ "Código Piloto || "
	  		+ "Nome Piloto || "
	  		+ "Qtde Voltas Completadas ||"
	  		+ " Tempo Total de Prova \n" ;
	  output += header;
	  position(output);
	  return output;
  }
  
  
  
  public String position(String output) {
	  int position;
	  Racer currentRacer = null;
	  for(int c = 0; c < racers.size(); c++) {
	  try {  
		  position = c + 1;
		  String currentAhead = "9:99:999";
		  for(int i = 0; i < racers.size(); i++ ) {
			  	if(racers.get(i).laps[3] != null) {
			  	String form = racers.get(i).laps[3].trim().replace(".",":");
			  	String []transfer = form.split(":");
			  	
			//  	for(int v = 0; v < transfer.length;v++) {
			//  		System.out.println(transfer[v]);
			//  	}
				String lapFormated = transfer[0]+":"+transfer[1]+":"+transfer[2];
			//	System.out.println(lapFormated+"buaaaa");
			//	System.out.println(lapFormated + " antes de comparar Lapformated");
			//	System.out.println(currentAhead +" antes de comparar, currentAhead");

				//ver isso comparar com 0 da < lap formated
				if( lapFormated != null && compareLaps(lapFormated, currentAhead) == true) {
					currentAhead = lapFormated;
			//		System.out.println(currentAhead +" depois de comparar, currentAhead");
					currentRacer = racers.get(i);
				}
			 }
		  }
		  output += position +"||"; 
		  output += completesInfo(currentRacer, output);
		  output += overallTime(currentRacer) + "\n";
		  currentRacer.lapRemoval(currentRacer);
		  
	     }catch(Exception e) {
		  e.getMessage();
		  System.out.println(e);
	  }
	  
	  }
	  
	return output;
	  
  }
  
  public String completesInfo(Racer racer, String output) {
	  String outputString = output;
	  
	  outputString += racer.id() + "||" +
			          racer.name() + "||" +
			          racer.laps().length + "||";
	  return outputString;
			          
			  		  
  }
  
  public String overallTime(Racer currentRacer) {
	try { 
	  String overall;
	  int mm = 00, ss = 00, ms = 00;
	  String[] array = currentRacer.laps();
	  for(int j = 0 ; j < array.length;j++) {
		String arrayPosi = array[j].replace(".",":");
		
		String[] time = arrayPosi.split(":");
		mm += Integer.parseInt(time[0]);
	
		ss += Integer.parseInt(time[1]);
		if(ss >= 60) {
			mm ++;
			ss = ss - 60;
		}
		
		
		ms += Integer.parseInt(time[2]);
		if(ms >= 1000) {
			ss ++;
			ms = ms - 1000;
		}
		
		
	  }
	  	overall = "" + mm +":" + ss + ":" + ms;
	  	return overall;
	}catch(NumberFormatException e){
		return " Did not finished ";
	}
  }

  public boolean compareLaps(String lapFormated, String currentAhead) {
	  String[] decomposedLap  = lapFormated.split(":");
	  String[] decomposedAhead  = currentAhead.split(":");
	  
	  if(Integer.parseInt(decomposedLap[0]) <= Integer.parseInt(decomposedAhead[0])) {
		  if(Integer.parseInt(decomposedLap[1]) <= Integer.parseInt(decomposedAhead[1])) {
			  if(Integer.parseInt(decomposedLap[2]) <= Integer.parseInt(decomposedAhead[2])){
		  return true;
			  }
			 }
	  }else {
		  return false;
		  
	  }
	  return false;
  }
  

  public static void main(String[] args) {
    new Bank();
  }
}