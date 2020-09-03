// Segment.java
// Priority Queue and Simulation
// Segment class used in priority queue (PQ.java)
// Uses queue class Q1Gen.java
// Modified April 2019

public class Segment<T> {

    private double time;
    private QGen<T> q;
    private Segment<T> next;

    // constructor

    public Segment(double t) {
        time = t;
        q = new Q1Gen<T>();
        next = null;
    }

    // methods

    public double getTime() {
        return time;
    }

    public QGen<T> getEvents() {
        return q;
    }

    public Segment<T> getNext() {
        return next;
    }

    public void setNext(Segment<T> nextSegment) {
        next = nextSegment;
    }

}  // Segment class
