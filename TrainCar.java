/*
 *  @author Tahseen Zaman
 *  ID : 114332480
 *  Recitation : 03
 */
public class TrainCar {
    private double carLength;
    private double carWeight;
    private ProductLoad load = null;

    public TrainCar() {
    }
    public TrainCar(double carLength, double carWeight) {
        this.carLength = carLength;
        this.carWeight = carWeight;
        this.load = new ProductLoad("Empty", 0.0, 0.00, false);
    }
    /* @return
       It returns the length of the trainCar as a double value.
     */
    public double getCarLength() {
        return carLength;
    }
    /* @return
       It returns the weight of the trainCar as a double value.
     */
    public double getCarWeight() {
        return carWeight;
    }
    /* @return
       It returns the load of the trainCar.
     */
    public ProductLoad getLoad() {
        return load;
    }
    /* @param load
      It can set a new load for the trainCar.
    */
    public void setLoad(ProductLoad load) {
        this.load = load;
    }
    /*
      It checks whether the trainCar is empty or not.
     */
    public boolean isEmpty() {
        if (load == null) {
            return true;
        }
        return false;
    }
    /* @ return
       It returns the string with concatenation.
    */
    public String toString(){
        return carWeight + " " + carLength;
    }
}
