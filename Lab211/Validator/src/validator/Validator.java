/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package validator;

import java.util.Scanner;

/**
 *
 * @author Trung Hieu
 */
public class Validator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

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

    public static double getDouble(String message, String error, double min, double max) {
        Scanner scanner = new Scanner(System.in);

        //- Yêu cầu người dùng nhập vào một số nguyên
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.err.println("Input can not empty!!");
                } else {
                    double number = Double.parseDouble(input);
                    //check number in range
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.err.println("You must input in " + min + "-" + max);
                    }
                }
            } catch (Exception e) {
                System.err.println(error);
            }
        }
    }

    public static float getFloat(String message, String error, float min, float max) {
        Scanner scanner = new Scanner(System.in);

        //- Yêu cầu người dùng nhập vào một số nguyên
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.err.println("Input can not empty!!");
                } else {
                    float number = Float.parseFloat(input);
                    //check number in range
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.err.println("You must input in " + min + "-" + max);
                    }
                }
            } catch (Exception e) {
                System.err.println(error);
            }
        }
    }

    public static String getString(String message, String error, String regex) {
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
                if (input.matches(regex)) {
                    return input;
                } else {
                    //tell error
                    System.out.println(error);
                }
            }
        }
    }

    public static int InputIntegerValidation(String message, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(message);
                String input = scanner.nextLine();
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Error: Input is empty!");
                }

                if (input.contains(".")) {
                    throw new IllegalArgumentException("Error: Input is floating-point number, please enter an integer!");
                }

                if (!input.matches("\\d+")) {
                    throw new IllegalArgumentException("Error: Input contains letters, please enter an integer!");
                }

                long inputParseInt = Long.parseLong(input);

//                if (inputParseInt <= 0) {
//                    throw new IllegalArgumentException("Error: The input is not a positive integer!");
//                }
                if (inputParseInt < min || inputParseInt > max) {
                    throw new IllegalArgumentException("Error: Input must be in " + min + " - " + max + ", please reinput!");
                }

//                if (inputParseInt > Integer.MAX_VALUE) {
//                    throw new IllegalArgumentException("Error: The input exceeds Integer!");
//                }
                return (int) inputParseInt;
            } catch (NumberFormatException e) {
                System.out.println("Error: Input is not a valid number!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static double InputDoubleValidation(String message, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(message);
                String input = scanner.nextLine();

                // Kiểm tra đầu vào trống
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Error: Input is empty!");
                }

                // Thay thế dấu phẩy ',' bằng dấu chấm '.' đồng nhất input
                input = input.replace(",", ".");

                // Kiểm tra đầu vào có chứa ký tự không hợp lệ
                if (!input.matches("-?\\d+(\\.\\d+)?")) {
                    throw new IllegalArgumentException("Error: Input is not a double number!");
                }

                // Chuyển chuỗi thành kiểu double
                double inputParsed = Double.parseDouble(input);

                // Kiểm tra giá trị trong khoảng min và max
                if (inputParsed < min || inputParsed > max) {
                    throw new IllegalArgumentException("Error: Input must be in " + min + " - " + max + ", please reinput!");
                }

                return inputParsed;  // Trả về giá trị hợp lệ
            } catch (NumberFormatException e) {
                System.out.println("Error: Input is not a valid number!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static float InputFloatValidation(String message, float min, float max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(message);
                String input = scanner.nextLine();

                // Kiểm tra đầu vào trống
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Error: Input is empty!");
                }

                // Thay thế dấu phẩy ',' bằng dấu chấm '.' đồng nhất input
                input = input.replace(",", ".");

                // Kiểm tra đầu vào có chứa ký tự không hợp lệ
                if (!input.matches("-?\\d+(\\.\\d+)?")) {
                    throw new IllegalArgumentException("Error: Input is not a float number!!");
                }

                // Chuyển chuỗi thành kiểu float
                float inputParsed = Float.parseFloat(input);

                // Kiểm tra giá trị trong khoảng min và max
                if (inputParsed < min || inputParsed > max) {
                    throw new IllegalArgumentException("Error: Input must be in " + min + " đến " + max + "!");
                }

                return inputParsed;  // Trả về giá trị hợp lệ
            } catch (NumberFormatException e) {
                System.out.println("Error: Input is not a valid number!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}