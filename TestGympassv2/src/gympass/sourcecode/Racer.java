package gympass.sourcecode;

public class Racer {
  protected int id;
  protected String name;
  protected String laps[];
  
  // Standard constructor method
  public Racer() {
    init(0, "Racer","Time");
  }

  public Racer(int id, String name, String lap) {
    init(id, name, lap);
  }
  
  // Forces initialization of attributes
  private void init(int id, String name, String lap) {
    id(id).name(name).laps(lap);
  }
  
  //Gets and Sets
  public int id() {
    return this.id;
  }
  public Racer id(int id) {
    this.id = id;
    return this;
  }

  public String name() {
    return this.name;
  }
  public Racer name(String name) {
    this.name = name;
    return this;
  }

  public String[] laps() {
    String convert = String.join(",", laps);
    return convert.split(",");
  }
  
  // Insert lap time on laps array
  public Racer laps(String lap) {
	  try {
		  for(int i = 0;i < 4;i++) {
			  if(laps[i] == null) {
				 laps[i] = lap;
				 return this;
			  }
		 }
	  
	  }catch(NullPointerException e) {
		  laps = new String [4];
		  laps(lap);
	  }
	
	
    return this;
  }
  
  public Racer lapRemoval(Racer lapRemove) {
	  if(laps[3]!= null && laps[3]!= " Did not finished ") {
	  lapRemove.laps[3] = null;
	  }
	  return lapRemove;	  
  }
}