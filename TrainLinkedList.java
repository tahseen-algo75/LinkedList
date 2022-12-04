/*
 *  @author Tahseen Zaman
 *  ID : 114332480
 *  Recitation : 03
 */
public class TrainLinkedList {
    private TrainCarNode head;
    private TrainCarNode tail;
    private TrainCarNode cursor;
    private double size;
    private double totalLength;
    private double totalWeight;
    private double totalValue;
    private double isDangerous;

    public TrainLinkedList() {
        head = null;
        tail = null;
        cursor = null;
        size = 0;
        totalLength = 0;
        totalWeight = 0;
        totalValue = 0;
        isDangerous = 0;
    }
    /*
     @return
      It returns a pointer to the TrainCar at the node that the cursor is currently referencing.
      */
    public TrainCar getCursorData() throws EmptyListException {
        if (cursor == null) throw new EmptyListException("The list is empty..");
        return (cursor.getCar());
    }
    /*@param car
       If the cursor is empty then it throws an exception
       It sets the car in the node that cursor is currently pointing at.
     */
    public void setCursorData(TrainCar car) throws EmptyListException {
        if (cursor == null) throw new EmptyListException();
        cursor.setCar(car);
    }
    // If the cursor is empty or cursor is equal to tail then it throws an exception
    // It points the cursor at the following TrainCarNode
    public void cursorForward() throws EmptyListException {
        if (cursor == null || cursor == tail) throw new EmptyListException("The list is empty..");
        cursor = cursor.getNext();
    }
    // If the cursor is empty or cursor is equal to head then it throws an exception
    // It points the cursor at the previous TrainCarNode
    public void cursorBackward() throws EmptyListException {
        if (cursor == null || cursor == head) throw new EmptyListException("The list is empty..");
        cursor = cursor.getPrev();
    }
    /*
    @param newCar
    The new TrainCarNode object are created for insertion.
    This method checks for three different cases :
    case 1 : if the cursor is empty, then the head, tail and cursor equals to the newNode.
    case 2 : if the next pointer after the cursor is not empty then it's add a newNode to the list.
    case 3 : if the next pointer after the cursor is empty then it's add a newNode to the list.
     */
    public void insertAfterCursor(TrainCar newCar) {
        TrainCarNode newNode = new TrainCarNode(newCar);
        if (cursor == null) {
            head = newNode;
            tail = newNode;
            cursor = newNode;
        } else if (cursor.getNext() != null) {
            cursor.getNext().setPrev(newNode);
            newNode.setNext(cursor.getNext());
            cursor.setNext(newNode);
            newNode.setPrev(cursor);
            cursor = cursor.getNext();
        } else {
            cursor.setNext(newNode);
            newNode.setPrev(cursor);
            tail = newNode;
            cursor = cursor.getNext();
        }
        size++;
        totalLength += cursor.getCar().getCarLength();
        totalWeight += cursor.getCar().getCarWeight();
        totalValue += cursor.getCar().getLoad().getValue();
    }
    /*
    @return
    This method checks for five different cases :
    case 1 : If the cursor is empty then it throws an exception.
    case 2 : If the cursor is in the middle then it removes the cursor by pointing previous node of the
    cursor to the next node of the cursor and vice versa. Then it makes the cursor equal to null and the cursor
    moves to the next pointer.
    case 3 : If the head equals to tail then it makes head, tail and cursor equal to null.
    case 4 : If the cursor equals to head then it removes the cursor from the beginning.
    case 5 : If the cursor equals to tail then it removes the cursor from the end.
    */
    public TrainCar removeCursor() throws EmptyListException {

        if (cursor == null) throw new EmptyListException("The list is empty..");

        else if ((cursor.getNext() != null) && (cursor.getPrev() != null)) {
            cursor.getPrev().setNext(cursor.getNext());
            cursor.getNext().setPrev(cursor.getPrev());
            cursor = null;
            cursor = cursor.getNext();
        } else if (head == tail) {
            head = null;
            tail = null;
            cursor = null;
        } else if (cursor == head) {
            cursor = cursor.getNext();
            head = cursor;
            cursor.setPrev(null);
        } else {
            cursor = cursor.getPrev();
            tail = cursor;
            cursor.setNext(null);
        }
        size--;
        totalLength -= cursor.getCar().getCarLength();
        totalWeight -= cursor.getCar().getCarWeight();
        totalValue -= cursor.getCar().getLoad().getValue();

        return getCursorData();
    }
    /* @ return
    It returns the size with the time complexity of O(1)
     */
    public int size() {
        return (int) size;
    }
    /* @ return
    It returns the totalLength with the time complexity of O(1)
     */
    public double getLength() {
        return totalLength;
    }
    /* @ return
    It returns the totalValue with the time complexity of O(1).
     */
    public double getValue() {
        return totalValue;
    }
    /* @ return
    It returns the totalWeight with the time complexity of O(1)
     */
    public double getWeight() {
        return totalWeight;
    }
    /* @return
    It returns false if the train doesn't have at least one TrainCar. Otherwise, it returns true.
    */
    public boolean isDangerous() {
        if(isDangerous < 0)
        return false;
        return true;
    }
    public void findProduct(String name) {
        TrainCarNode ptr = new TrainCarNode();
        ptr = head;
        double totalWeight = 0;
        double totalValue = 0;
        boolean isDangerous = false;
        int count = 0;

        while (ptr != null) {
            if (name.equals(ptr.getCar().getLoad().getName())) {
                totalWeight += ptr.getCar().getCarWeight();
                totalValue += ptr.getCar().getLoad().getValue();
                isDangerous = ptr.getCar().getLoad().getIsDangerous();
                count++;
            }
            ptr = ptr.getNext();
        }
        if(totalWeight == 0 && totalValue == 0){
            System.out.println("No Products are found");
        }else{
            System.out.println("The following products were found on" + count + "cars");
        }
    }
    public void removeDangerousCars() throws EmptyListException {
        cursor = head;
        while (cursor != null) {
            boolean isDangerous = cursor.getCar().getLoad().getIsDangerous();
            if (isDangerous) {
                removeCursor();
                System.out.println("Dangerous cars successfully removed from the train");
            }
            cursor = cursor.getNext();
        }
    }
    public void printManifest () {
            System.out.println(toString());
    }

    public String toString () {
            int num = 0;
            System.out.println("Car:\t\t\t\t\t\t\t\t\tLoad:");
            String st1 = (String.format("%-9s%-9s%9s%17s%16s%12s%12s", "Num", "Length", "Weight", "Name", "Weight", "Value", "Dangerous"));
            st1 += "\n";
            System.out.println("=====================================================================================");
            TrainCarNode newNode = new TrainCarNode();
            newNode = head;

            while (newNode != null) {
                num++;

                String st2 = (String.format("%-9s%-9s%9s%17s%15s%12s%12s\n", num, newNode.getCar().getCarLength(), newNode.getCar().getCarWeight(),
                        newNode.getCar().getLoad().getName(), newNode.getCar().getLoad().getWeight(), newNode.getCar().getLoad().getValue(),
                        newNode.getCar().getLoad().getIsDangerous()));
                newNode = newNode.getNext();

                st1 += st2;
            }
            return st1;
    }
}


