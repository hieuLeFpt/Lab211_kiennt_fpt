package view;

import entity.Car;
import java.util.Scanner;

public class CarView {

    private final Scanner scanner = new Scanner(System.in);

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printError(String error) {
        System.err.println(error);
    }

    public String inputString(String messageInput, String errorSpecialCharacter, int minLength, int maxLength) {
        while (true) {
            printMessage(messageInput);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                printError("Input cannot be empty !!");
            } else {
                if (input.length() >= minLength && input.length() <= maxLength) {
                    return input;
                } else {
                    printError(errorSpecialCharacter);
                }
            }
        }
    }

    public boolean inputYesOrNo(String message) {
        while (true) {
            printMessage(message);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y")) {
                return true;
            } else if (input.equals("n")) {
                return false;
            } else {
                printError("Please enter 'Y' for Yes or 'N' for No.");
            }
        }
    }

    public int inputInteger(String messageInput, String errorSpecialCharacter, int minValue, int maxValue) {
        while (true) {
            try {
                System.out.print(messageInput);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    printError("Input cannot be empty !!");
                } else {
                    int number = Integer.parseInt(input);
                    if (number < minValue) {
                        printError("Price greater than zero");
                    } else {
                        return number;
                    }
                }
            } catch (NumberFormatException e) {
                printError(errorSpecialCharacter);
            }
        }
    }
    
    public Car inputCar() {
        Car car = new Car();
        String name = inputString("Name: ", "Wrong format input!", 2, Integer.MAX_VALUE);
        car.setName(name);
        
        String color = inputString("Color: ", "Wrong format input!", 3, 10);
        car.setColors(new String[]{color});
        
        int price = inputInteger("Price: ", "Price is digit", 0, Integer.MAX_VALUE);
        car.setPrices(new int[] {price});
        
        String soldOnDay = inputString("Today: ", "Wrong format input!", 6, 9);
        car.setSoldOnDays(new String[] {soldOnDay});
        
        return car;
    }   
    
}
