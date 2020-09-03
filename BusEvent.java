public class BusEvent implements Event{
  private int currentStop;
  private Bus bus;
  private int expressStopTraverser = 0;


  public BusEvent(int currentStop, Bus bus){
    this.currentStop = currentStop;
    this.bus = bus;
  }

  public void run(){
    Rider[] removed = bus.removeRiderAtStop(currentStop);
    if (removed.length != 0){
      // 2 seconds per rider getting off
      Main.agenda.add(new BusEvent(currentStop,bus), 2*removed.length);
      return;
    }

    else {
      Statistics.queueSize += Main.stops[currentStop].getQueueSize();

      int ridersAdded = 0;
      // Add riders if bus is not full and bus stop queue is not empty
      while (!bus.isFull() && Main.stops[currentStop].getQueueSize() > 0) {
        // Checks to make sure rider being added isn't null
        if (Main.stops[currentStop].getQueue().peek() != null){
          // Checks if the rider is an express rider, adds to express bus if is
          if (Stop.isExpressRider(this.currentStop) && bus.getType().equals("express")){
            // Stats for average wait time
            Statistics.peopleAddedFromQ++;
            Statistics.waitTime += Main.agenda.getCurrentTime() - Main.stops[currentStop].getQueue().peek().getTime();

            bus.addRider(Main.stops[currentStop].getQueue().poll());
          }
          // Adds to regular bus
          else{
            bus.addRider(Main.stops[currentStop].getQueue().poll());
          }
        }
        ridersAdded++;
      }
      // Stats for average people on bus
      Statistics.totalRidersOnBus += bus.getRiderCount();
      Statistics.totalBusDepartures++;
      // Reschedules agenda larger of 15 seconds and amount of time it takes total riders to board
      if(ridersAdded > 0){
        if (ridersAdded * 3 > 15){
          Main.agenda.add(new BusEvent(this.currentStop, this.bus), ridersAdded * 3);
        }
        else{
          Main.agenda.add(new BusEvent(this.currentStop, this.bus), 15);
        }
        return;
      }
      else{
      // Move to next stop depending on type of bus (takes 240 seconds)
        if(bus.getType().equals("regular")){
          if(currentStop + 1 == 30){
            this.currentStop = 0;
          }
          else{
            this.currentStop++;
          }
          Main.agenda.add(new BusEvent(this.currentStop++, this.bus), 240);
        }
        else{
          // Is express bus
          Main.agenda.add(new BusEvent(Stop.expressStops[expressStopTraverser + 1],this.bus),240);
          if (expressStopTraverser + 1 == 9){
            expressStopTraverser = 0;
          }
          else{
            expressStopTraverser++;
          }
        }
      }
    }
  }
}
