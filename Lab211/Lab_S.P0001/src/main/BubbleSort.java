package main;

import java.util.Random;
import java.util.Scanner;

public class BubbleSort {

    private int[] array;

    public int inputNumberOfArray() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter number of array: ");
                String input = sc.nextLine();
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty");
                } else {
                    int number = Integer.parseInt(input);
                    if (number >= 0 && number <= Integer.MAX_VALUE) {
                        return number;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Must be number!");
            }
        }
    }

    public void createArray(int sizeArray) {
        array = new int[sizeArray];
    }

    public void generateRandomNumber() {
        Random rd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(array.length);
        }
    }

    public void displayArray(String message) {
        System.out.print(message + "[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[array.length - 1]);
        System.out.println("]");
    }

    public void sortByBubbleSort() {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

}
