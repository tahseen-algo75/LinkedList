/*
 *  @author Tahseen Zaman
 *  ID : 114332480
 *  Recitation : 03
 */
public class ProductLoad {
    private String name;
    private double weight;
    private double value;
    private boolean isDangerous;

    public ProductLoad(String name, double weight, double value, boolean isDangerous){
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.isDangerous = isDangerous;
    }
    /* @return
       It returns the name of the Product as a String value.
     */
    public String getName(){
        return name;
    }
    /* @return
       It returns the weight in tons as a double value.
     */
    public double getWeight(){
        return weight;
    }
    /* @return
       It returns the value in dollars as a double value.
     */
    public double getValue(){
        return value;
    }
    /* @return
       It returns a boolean value to check whether the product is dangerous or not.
     */
    public boolean getIsDangerous(){
        return isDangerous;
    }
    /* @param name
       It can set a new Product name.
     */
    public void setName(String name){
        this.name = name;
    }
    /* @param weight
       It can set a new Weight in tons.
       If the weight in tons is negative then throws an IllegalArgumentException.
    */
    public void setWeight(double weight){
        this.weight = weight;
        if(weight < 0) throw new IllegalArgumentException("The weight in tons can't be negative");
    }
    /* @param value
       It can set a new value in dollars.
       If the value in dollars is negative then throws an IllegalArgumentException.
    */
    public void setValue(double value){
        this.value = value;
        if(value < 0) throw new IllegalArgumentException("The value in dollar can't be negative");
    }
    /* @param isDangerous
       It can set a new boolean value for the productLoad.
    */
    public void setIsDangerous(boolean isDangerous){
        this.isDangerous = isDangerous;
    }
}
