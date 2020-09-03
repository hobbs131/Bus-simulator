import java.util.Queue;
import java.util.ArrayDeque;

public class Main{
  public static PQ agenda;
  public static Stop[] stops = new Stop[30];

  public static void main(String[] args){
    Statistics stats = new Statistics();
    int[] stopNumbers = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29};
    String[] stopNames = {"Ramp B","4th & Nicollet", "Anderson Hall","Jones Hall", "Kasota Circle", "Como & Eustis", "Como & Cleveland", "Como & Snelling", "Como and Hamline",
    "MaryLand and Dale", "Maryland and Rice", "Front and Lexington", "Front and Dale", "Capitol", "Cedar", "Union Depot", "Cedar", "Capitol", "Front and Dale", "Front and Lexington",
     "Maryland and Rice", "Maryland and Dale", "Como and Hamline", "Como & Snelling", "Como & Cleveland", "Como & Eustis", "Kasota Circle", "Jones Hall", "Anderson Hall","4th & Nicollet"};

     // All credit for PQ goes to "CSci 1933 Lecture Examples"
    agenda = new PQ();
    Bus bus1 = new Bus("regular");
    Bus bus2 = new Bus("regular");
    Bus bus3 = new Bus("regular");
    Bus bus4 = new Bus("express");
    Bus bus5 = new Bus("express");
    Bus bus6 = new Bus("express");
    Bus bus7 = new Bus("regular");
    //Bus bus8 = new Bus("express");
    //Bus bus9 = new Bus("regular");
    //Bus bus10 = new Bus("regular");
    //Bus bus11 = new Bus("express");
    // bus12 = new Bus("express");
    //Bus bus13 = new Bus("express");
    //Bus bus14 = new Bus("express");

    BusEvent busEvent = new BusEvent(0,bus1);
    BusEvent busEvent2 = new BusEvent(2,bus2);
    BusEvent busEvent3 = new BusEvent(4, bus3);
    BusEvent busEvent4 = new BusEvent(6,bus4);
    BusEvent busEvent5 = new BusEvent(8,bus5);

    BusEvent busEvent6 = new BusEvent(10, bus6);
    BusEvent busEvent7 = new BusEvent(12,bus7);
    /*
    BusEvent busEvent8 = new BusEvent(14,bus8);
    BusEvent busEvent9 = new BusEvent(16,bus9);
    BusEvent busEvent10 = new BusEvent(18, bus10);
    BusEvent busEvent11 = new BusEvent(20,bus11);

    BusEvent busEvent12 = new BusEvent(22,bus12);
    BusEvent busEvent13 = new BusEvent(24,bus13);
    BusEvent busEvent14 = new BusEvent(26,bus14);
    */

    for (int i = 0; i < 30; i++){
      stops[i] = new Stop(stopNames[i],stopNumbers[i],new ArrayDeque<>(0));
    }

    for(int j = 0; j < 30; j++){
      agenda.add(new RiderEvent(j),120);
    }
    agenda.add(busEvent,240);
    agenda.add(busEvent2,240);
    agenda.add(busEvent3,240);
    agenda.add(busEvent4,240);
    agenda.add(busEvent5,240);

    agenda.add(busEvent6,240);
    agenda.add(busEvent7,240);
    /*
    agenda.add(busEvent8,240);
    agenda.add(busEvent9,240);
    agenda.add(busEvent10,240);
    agenda.add(busEvent11,240);
    agenda.add(busEvent12,240);
    agenda.add(busEvent13,240);
    agenda.add(busEvent14,240);
    */


    while (agenda.getCurrentTime() < 10000){
      agenda.remove().run();
    }
    System.out.println("Average amount of people on Bus: " + stats.averageBusCapacity());
    System.out.println("Average size of line: " + stats.averageQueueSize());
    System.out.println("Average wait time: " + stats.averageWaitTime());
  }
}
