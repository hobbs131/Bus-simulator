public class Statistics{
  public static int totalBusDepartures = 0;
  public static int totalRidersOnBus = 0;
  public static double waitTime = 0;
  public static int queueSize = 0;
  public static int peopleAddedFromQ = 0;


  public int averageBusCapacity(){
    return this.totalRidersOnBus/this.totalBusDepartures;
  }
  public double averageWaitTime(){
    return this.waitTime / this.peopleAddedFromQ;
  }

  public int averageQueueSize(){
    return this.queueSize / this.totalBusDepartures;
  }
}
