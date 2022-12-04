/*
 *  @author Tahseen Zaman
 *  ID : 114332480
 *  Recitation : 03
 */
public class TrainCarNode {
    private TrainCarNode next;
    private TrainCarNode prev;
    private TrainCar car;
    public TrainCarNode(){
        next = null;
        prev = null;
    }
    public TrainCarNode(TrainCar car){
        this.car = car;
    }
    /* @ return
        It returns the next pointer of the TrainCarNode.
     */
    public TrainCarNode getNext(){
        return next;
    }
    /* @ return
        It returns the previous pointer of the TrainCarNode.
     */
    public TrainCarNode getPrev(){
        return prev;
    }
    /* @ return
        It returns the car as a TrainCar value.
     */
    public TrainCar getCar(){
        return car;
    }
    /* @ param next
        It can change the next pointer of the TrainCarNode.
     */
    public void setNext(TrainCarNode next){
        this.next = next;
    }
    /* @ param prev
        It can change the previous pointer of the TrainCarNode.
     */
    public void setPrev(TrainCarNode prev){
        this.prev = prev;
    }
    /* @ param car
    It can set a new TrainCar of the TrainCarNode
     */
    public void setCar(TrainCar car){
        this.car = car;
    }
    /* @ return
      It returns the string with concatenation.
   */
    public String toString() {
        return "Car " + car ;

    }
}

