package main;

import java.util.Random;
import java.util.Scanner;

public class SelectionSort {

    private int[] array;

    public int inputNumberOfArray() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter the number of array: ");
                String input = sc.nextLine();
                if (input.isEmpty()) {
                    System.out.println("Input can not empty!");
                } else {
                    int number = Integer.parseInt(input);
                    if(number >= 0 && number <= Integer.MAX_VALUE) {
                        return number;
                    }
                }
            } catch(NumberFormatException e) {
                System.out.println("Must be number!");
            }
        }
    }

    public void createArray(int size) {
        array = new int[size];
    }
    
    public void generateRandom() {
        Random rd = new Random();
        for(int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(array.length);
        }
    }
    
    public void displayArray(String message) {
        System.out.print(message + "[");
        for(int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        
        System.out.print(array[array.length - 1]);
        System.out.println("]");
    }
    
    public void sortBySelectionSort() {
        int temp = 0;
        for(int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                
            }
        }
    }
}
