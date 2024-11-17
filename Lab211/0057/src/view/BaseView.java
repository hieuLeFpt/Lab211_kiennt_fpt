package view;

import java.util.Scanner;

public class BaseView {

    
    
    public int getInteger(String message, String error, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.err.println("Input can not empty!!");
                } else {
                    int number = Integer.parseInt(input);
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.err.println("You must input in " + min + "-" + max);
                    }
                }
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    public String getString(String message, String error, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            //kiem tra xem input co rong hay khong
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty !!");
            } else {
                //kiem tra xem input co matches regex hay ko
                //neu nhu matches voi regex => return string
                if (input.length() >= min && input.length() <= max && !input.contains(" ")) {
                    return input;
                } else {
                    //tell error
                    System.out.println(error);
                }
            }
        }
    }

}
