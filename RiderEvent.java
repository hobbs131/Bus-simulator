import java.util.Random;
import java.util.Stack;

public class RiderEvent implements Event{
  private int stopToAddPassenger;

  public RiderEvent(int stopToAddPassenger){
    this.stopToAddPassenger = stopToAddPassenger;
  }
  public void run(){
    Random random = new Random();
    int[] stopSelectEastBound = {1,1,14,14,2,3,4,5,6,7,8,9,10,11,12,13,15,15};
    int[] stopSelectWestBound = {29,29,16,16,17,18,19,20,21,22,23,24,25,26,27,28};
    int possibleStops = 0;
    Stack<Integer> tempStack = new Stack();
    int destinationStop;


    //Determines direction and destination of rider.
    if(stopToAddPassenger < 15){
      // Then it is a eastbound rider
      for(int i = 0; i < stopSelectEastBound.length; i++){
        // Push all possible stops to a temporary stack
        if (stopSelectEastBound[i] > stopToAddPassenger){
          possibleStops++;
          tempStack.push(stopSelectEastBound[i]);
        }
      }
      int[] stopSelecterEast = new int[possibleStops];
      // Transfer stack elements
      for(int j = 0; j < possibleStops; j++){
        stopSelecterEast[j] = tempStack.pop();
      }
      //Randomly select from possible stops
      destinationStop = stopSelecterEast[random.nextInt(possibleStops)];

    }
    else {
      // It is a westbound rider
      if(stopToAddPassenger > 14 && stopToAddPassenger < 29){
        for (int k = 0; k < stopSelectWestBound.length; k++){
          // Push all possible stops to temp stack
          if (stopSelectWestBound[k] > stopToAddPassenger){
            possibleStops++;
            tempStack.push(stopSelectWestBound[k]);
          }
        }
      }
      // Accounts for stop zero which is downtown (+ 2)
      possibleStops += 2;
      int[] stopSelecterWest = new int[possibleStops];
      // Transfer stack elements
      for(int l = 0; l < tempStack.size(); l++){
        stopSelecterWest[l] = tempStack.pop();
      }
      // Adds remaining two possible stops (stop zero)
      stopSelecterWest[possibleStops - 1] = 0;
      stopSelecterWest[possibleStops - 2] = 0;
      // Randomly select from possible stops
      destinationStop = stopSelecterWest[random.nextInt(possibleStops)];
    }
    Rider rider = new Rider(stopToAddPassenger, destinationStop);
    // Places rider in queue at respective stop
    Main.stops[stopToAddPassenger].getQueue().add(rider);//(stopToAddPassenger,rider);

    // Simulates inter-arrival time, adds to agenda
    double[] arrivalPercents = {.75,.75,.5,.5,.5,.2,.2,.2,.2,0,0,-.2,-.2,-.2,-.5,-.5,-.5,-.75,-.75};
    int randomPercent = random.nextInt(19);
    boolean isExpressStop = false;

    // Checks if downtown or regular inter-arrival rate and reschedules accordingly.
   for (int i = 0; i < Stop.expressStops.length; i++){
      if(stopToAddPassenger == Stop.expressStops[i]){
        double arrivalWait = (60 + arrivalPercents[randomPercent] * 60);
        RiderEvent eventToAdd = new RiderEvent(this.stopToAddPassenger);
        Main.agenda.add(eventToAdd, arrivalWait);
        isExpressStop = true;
      }
    }
    if(isExpressStop == false){
      double arrivalWait =  (120 + arrivalPercents[randomPercent] * 120);
      RiderEvent eventToAdd = new RiderEvent(this.stopToAddPassenger);
    }
  }
}
