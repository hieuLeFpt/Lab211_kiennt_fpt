package main;

public class Main {

    public static void main(String[] args) {

        BubbleSort bs = new BubbleSort();
        
        int sizeArray = bs.inputNumberOfArray();
        bs.createArray(sizeArray);
        bs.generateRandomNumber();
        bs.displayArray("Unsorted array: ");
        bs.sortByBubbleSort();
        bs.displayArray("Sorted array: ");
        
    }

}
