import java.util.Queue;
import java.util.ArrayDeque;

public class Stop{
  private String name;
  private int stopNumber;
  private ArrayDeque<Rider> stopQueue;

  public static int[] expressStops = {0,1,4,8,12,14,15,16,20,24,28,29};

  public Stop(String name, int stopNumber, ArrayDeque<Rider> stopQueue){
    this.name = name;
    this.stopNumber = stopNumber;
    this.stopQueue = stopQueue;
  }
  public String getName(){
    return this.name;
  }
  public int getStopNumber(){
    return this.stopNumber;
  }
  public ArrayDeque<Rider> getQueue(){
    return stopQueue;
  }
  public void addToStop(int stopNumber, Rider rider){
    Main.stops[stopNumber].getQueue().add(rider);
  }
  public Rider removeFromStop(int stopNumber){
    return Main.stops[stopNumber].getQueue().poll();
  }
  public static boolean isExpressRider(int stopNumber){
    for(int i = 0; i < expressStops.length; i++){
      if (Main.stops[stopNumber].getQueue().getFirst().getDestinationStop() == expressStops[i]){
        return true;
      }
    }
    return false;
  }
  public int getQueueSize(){
    return stopQueue.size();
  }
  public static boolean peekStopQueue(int stopNumber){
    if (Main.stops[stopNumber].getQueue().peek() != null){
      return true;
    }
    return false;
  }
}
