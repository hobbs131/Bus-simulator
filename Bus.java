import java.util.ArrayList;

public class Bus{
  private ArrayList<Rider> riders = new ArrayList();
  private int riderCount = 0;
  private String busType;

  public Bus(String busType){
    this.busType = busType;
  }

  public void addRider(Rider rider){
    if (riderCount < 50){
      riders.add(rider);
      this.riderCount++;
    }
  }

  public Rider[] removeRiderAtStop(int stop){
    int ridersRemovedCount = 0;

    for (int i = 0; i < riders.size(); i++){
      if (riders.get(i).getDestinationStop() == stop){
        riders.remove(riders.get(i));
        this.riderCount--;
        ridersRemovedCount++;
      }
    }
    Rider[] ridersRemoved = new Rider[ridersRemovedCount];
    return ridersRemoved;
  }

  public boolean isFull(){
    if (this.riderCount == 50){
      return true;
    }
    else{
      return false;
    }
  }

  public int getRiderCount(){
    return riderCount;
  }

  public String getType(){
    return busType;
  }
}
