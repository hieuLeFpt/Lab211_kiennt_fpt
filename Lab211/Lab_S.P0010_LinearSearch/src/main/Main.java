package main;

public class Main {

    public static void main(String[] args) {
        LinearSearch ls = new LinearSearch();

        int sizeArray = ls.inputNumberOfArray();

        ls.createArray(sizeArray);

        ls.generateRandomNumber();

        ls.displayArray("The array: ");

        int searchValue = ls.inputSearchvalue();

        ls.displayIndexOfSearchNumber(searchValue);

    }

}
