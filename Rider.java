public class Rider{
  private int boardingStopNumber;
  private int destinationStopNumber;
  private double boardTime;



  public Rider(int boardingStopNumber, int destinationStopNumber){
    this.boardingStopNumber = boardingStopNumber;
    this.destinationStopNumber = destinationStopNumber;
    this.boardTime = Main.agenda.getCurrentTime();
  }
  public int getBoardingStop(){
    return boardingStopNumber;
  }
  public int getDestinationStop(){
    return destinationStopNumber;
  }
  public double getTime(){
    return boardTime;
  }
}
