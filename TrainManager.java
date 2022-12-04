/*
 *  @author  Tahseen Zaman
 *  ID : 114332480
 *  Recitation : 03
 */
import java.util.*;
public class TrainManager {
    public static void main(String[] args) {
        TrainLinkedList trainLinkedList = new TrainLinkedList();
        String mainMenu = "(F) Cursor Forward\n(B) Cursor Backward\n(I) Insert Car After Cursor\n" +
                "(R) Remove Car At Cursor\n" + "(L) Set Product Load\n(S) Search For Product\n(T) Display Train\n" +
                "(M) Display Manifest\n(D) Remove Dangerous Cars\n" + "(Q) Quit";
        String selection = "";
        while (selection != "Q") {
            System.out.println(mainMenu);
            Scanner reader = new Scanner(System.in);
            System.out.println("Enter a selection : ");
            selection = reader.nextLine().toUpperCase();
            switch (selection) {
                case "F":
                    try {
                        trainLinkedList.cursorForward();
                        System.out.println("Cursor moved to Forward");
                    } catch (Exception e) {
                        System.out.println("Can't move cursor forward");
                    }
                    break;
                case "B":
                    try {
                        trainLinkedList.cursorBackward();
                        System.out.println("Cursor moved to backward");
                    } catch (Exception e) {
                        System.out.println("Can't move cursor backward ");
                    }
                    break;
                case "I":
                    System.out.println("Enter car length in meters : ");
                    double carLength = reader.nextDouble();
                    System.out.println("Enter car Weight in tons : ");
                    double carWeight = reader.nextDouble();
                    trainLinkedList.insertAfterCursor(new TrainCar(carLength, carWeight));
                    System.out.println("New train car " + carLength + " meters" + " " + carWeight + " tons inserted into the train");
                    break;
                case "R":
                    try {
                        trainLinkedList.removeCursor();
                        System.out.println("Car successfully unlinked. The following load is removed from the train.");
                    } catch (Exception e) {
                        System.out.println("Exception : " + e);
                    }
                    break;
                case "M":
                    trainLinkedList.printManifest();
                    break;
                case "S":
                    System.out.println("Enter a Product name : ");
                    String productName = reader.nextLine();
                    trainLinkedList.findProduct(productName);
                    break;
                case "L":
                    System.out.println("Enter Produce name : ");
                    String produceName = reader.nextLine();
                    System.out.println("Enter product weight in tons : ");
                    double productWeight = reader.nextDouble();
                    System.out.println("Enter product value in dollars :");
                    double productValue = reader.nextDouble();
                    reader.nextLine();
                    System.out.println("Enter is Product dangerous? (y/n) : ");
                    String st = reader.nextLine();
                    boolean productDangerous = false;
                    if(st.equals("y")){
                        productDangerous = true;
                    }else{
                        productDangerous = false;
                    }
                    ProductLoad load = new ProductLoad(produceName, productWeight, productValue, productDangerous);
                    try {
                        trainLinkedList.getCursorData().setLoad(load);
                        System.out.println(productWeight + " tons of " + produceName + " added to the current car");
                    } catch (Exception e) {
                        System.out.println("Exception : " + e);
                    }
                    break;
                    case "T":
                    System.out.println(trainLinkedList.size() + " cars " +trainLinkedList.getLength() + " meters "+
                            trainLinkedList.getWeight()+ " tons " + trainLinkedList.getValue() + " value " );
                    break;
                case "D":
                    try{
                        trainLinkedList.removeDangerousCars();
                    System.out.println("Dangerous cars successfully removed from the train. ");
                    } catch (Exception e) {
                        System.out.println("Exception : " + e);
                    }
                    break;
                case "Q":
                    System.out.println("Program terminating successfully");
                    System.exit(0);
            }
        }
    }
}




