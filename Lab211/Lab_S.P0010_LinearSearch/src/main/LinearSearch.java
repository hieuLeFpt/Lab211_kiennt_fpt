package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class LinearSearch {

    private int[] array;

    public int inputNumberOfArray() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter number of array: ");
                String input = sc.nextLine();
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty!");
                } else {
                    int number = Integer.parseInt(input);
                    if (number >= 0 && number <= Integer.MAX_VALUE) {
                        return number;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
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

    public int inputSearchvalue() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter search number: ");
                String input = sc.nextLine();
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty!");
                } else {
                    int number = Integer.parseInt(input);
                    if (number >= Integer.MIN_VALUE && number <= Integer.MAX_VALUE) {
                        return number;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
    }

    public void displayArray(String message) {
        System.out.print(message + "[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1] + "]");
    }

    private List<Integer> searchByLinearSearch(int searchValue) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchValue) {
                list.add(i);
            }
        }
        return list;
    }

    public void displayIndexOfSearchNumber(int searchValue) {
        List<Integer> list = searchByLinearSearch(searchValue);
        if (list.isEmpty()) {
            System.out.println("Not found!");
        } else {
            System.out.println("Index is: " + list.toString());
        }
    }

}
