/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author Trung Hieu
 */
public class BaseView {

    public String getStringInput(String message, String error, String regex) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty !!");
            } else {
                if (input.matches(regex)) {
                    return input;
                } else {
                    //tell error
                    System.out.println(error);
                }
            }
        }
    }

    public int getIntInput(String message, String error, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.out.println("Input can not empty!!");
                } else {
                    int number = Integer.parseInt(input);
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.out.println(error);
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }
    }

    public double getDoubleInput(String message, String error, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.out.println("Input can not empty!!");
                } else {
                    double number = Double.parseDouble(input);
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.out.println(error);
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }
    }

    public String getDateInput(String message, String error) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input can not empty!!");
            } else {
                try {
                    dateFormat.parse(input);
                    return input;
                } catch (ParseException e) {
                    System.out.println(error);
                }
            }
        }
    }

}
