package main;

public class Main {

    public static void main(String[] args) {

        SelectionSort ss = new SelectionSort();
        
        int sizeArray = ss.inputNumberOfArray();
        ss.createArray(sizeArray);
        ss.generateRandom();
        ss.displayArray("Unsorted array: ");
        ss.sortBySelectionSort();
        ss.displayArray("Sorted array: ");
        
    }

}
