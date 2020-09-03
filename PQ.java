// PQ.java
// Priority Queue and Simulation
// Modified April 2019

// A Priority Queue is used for an agenda
// Assumes that priorities are times and new items cannot be added at a
// time previous to current time; so you cannot go back in time.
// Additions are always made at a time specified relative to current time
// indicated by time stamp in first time segment (queue) in the priority queue.
// Uses class Q1Gen (Queue class using linked list) and class Segment.

public class PQ {

    // constructor

    public PQ() {
        seg = new Segment<Event>(0);
    }
    public int getSeg(){
      return seg.getEvents().length();
    }

    // methods

    public void add(Event o, double time) {

        time += getCurrentTime();

        if (time < seg.getTime())
          System.out.println("Error: trying to go back in time");
        else if (time == seg.getTime())
          seg.getEvents().add(o);
        else {  // search list for correct insertion point, then insert
          Segment<Event> trailer = seg, ptr = seg.getNext();
          while (ptr != null && time > ptr.getTime()) { //search
              ptr = ptr.getNext();
              trailer = trailer.getNext();
          }  // search
          if (ptr != null && time == ptr.getTime())
            ptr.getEvents().add(o);
          else {  // add new segment after trailer and before ptr
            Segment<Event> temp = new Segment<Event>(time);
            temp.getEvents().add(o);
            temp.setNext(ptr);
            trailer.setNext(temp);
          }  // add new segment after trailer and before ptr
        }  // search list for correct insertion point, then insert
    }  // add method

    public Event remove() {
        if (this.isEmpty()) {
          System.out.println("Error: removing from empty queue");
          return null;
        }
        else if (seg.getEvents().length() == 0) {
          seg = seg.getNext();
          return seg.getEvents().remove();
        }
        else return seg.getEvents().remove();
    }

    public boolean isEmpty() {
        return (seg.getEvents().length() == 0 && seg.getNext() == null);
    }

    public double getCurrentTime() {
        return seg.getTime();
    }

    // instance variables

    private Segment<Event> seg;  // front of list representing priority queue

}  // PQ class
