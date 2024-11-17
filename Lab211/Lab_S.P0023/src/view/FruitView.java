package view;

import entity.Fruit;
import entity.Order;
import java.util.ArrayList;
import java.util.Scanner;
import service.FruitService;

public class FruitView {

    private final Scanner scanner = new Scanner(System.in);
    private final FruitService fruitService = new FruitService();
    private final String wrongFormatInout = "Wrong format input!!";

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printError(String error) {
        System.err.println(error);
    }

    public void displayMenu() {
        printMessage("1. Create Fruit\n"
                + "2. View Orders\n"
                + "3. Shopping(for byer)\n"
                + "4. Exit\n");
    }

    public int inputInteger(String messageInput, String errorSpecialCharacter, int minValue, int maxValue) {
        while (true) {
            try {
                printMessage(messageInput);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    printError("Input cannot be empty!");
                } else {
                    int number = Integer.parseInt(input);
                    if (number < minValue || number > maxValue) {
                        printError("Invalid input must be in " + minValue + " - " + maxValue);
                    } else {
                        return number;
                    }
                }
            } catch (NumberFormatException e) {
                printError(errorSpecialCharacter);
            }
        }
    }

    public double inputDouble(String messageInput, String errorSpecialCharacter, double minValue, double maxValue) {
        while (true) {
            try {
                printMessage(messageInput);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    printError("Input cannot be empty!");
                } else {
                    double number = Double.parseDouble(input);
                    if (number < minValue || number > maxValue) {
                        printError("Invalid input must be in " + minValue + " - " + maxValue);
                    } else {
                        return number;
                    }
                }
            } catch (NumberFormatException e) {
                printError(errorSpecialCharacter);
            }
        }
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

    private boolean inputChoice(String message, String errorMessage) {
        while (true) {
            printMessage(message);
            String result = scanner.nextLine().toLowerCase();
            if (result.equals("y")) {
                return true;
            } else if (result.equals("n")) {
                return false;
            } else {
                printError(errorMessage);
            }
        }
    }

    public void inputFruit() {
        while (true) {
            String name, origin;
            double price;
            int quantity, id;

            id = inputInteger("Enter id: ", wrongFormatInout, 1, Integer.MAX_VALUE);
            name = inputString("Enter name: ", wrongFormatInout, 2, 30);
            price = inputDouble("Enter price: ", wrongFormatInout, 0, Double.MAX_VALUE);
            origin = inputString("Enter origin: ", wrongFormatInout, 1, 20);
            quantity = inputInteger("Enter quantity: ", wrongFormatInout, 0, Integer.MAX_VALUE);

            Fruit fruit = new Fruit(id, name, origin, price, quantity);
            if (fruitService.createFruit(fruit)) {
                printMessage("Create successfully!!\n");
            } else {
                printError("Duplicate!!");
            }

            if (!inputChoice("Do you want to continue(Y/N)?: ", wrongFormatInout)) {
                break;
            }
        }
        displayAllFruit(fruitService.getListFruit());
    }

    private void displayAllFruit(ArrayList<Fruit> listFruit) {
        System.out.format("%-15s %-15s %s  %-15s %-15s\n", "| ++ Item ++ ", "| ++ Name ++ ", "| ++ Price ++|", " ++ Quantity ++ |", " ++ Origin ++ |");
        for (Fruit fruit : listFruit) {
            System.out.println(fruit);
        }
    }

    public void shopping() {
        if (fruitService.getListFruit().isEmpty()) {
            printError("Empty shop!!");
            return;
        }
        Order order = new Order();
        while (true) {
            displayAllFruit(fruitService.getListFruit());

            // chose item to buy
            Fruit fruitChose;
            while (true) {
                int itemOrder = inputInteger("Enter item: ", wrongFormatInout, 1, Integer.MAX_VALUE);
                fruitChose = fruitService.getFruitById(itemOrder);
                if (fruitChose == null) {
                    printError("Invalid id!!");
                } else {
                    printMessage("You select: " + fruitChose.getName() + "\n");
                    break;
                }
            }

            //enter quantity to buy
            int quantityOrder = inputInteger("Enter quantity: ", wrongFormatInout, 1, fruitChose.getQunatity());
            // set quantity remaining
            fruitChose.setQunatity(fruitChose.getQunatity() - quantityOrder);
            // if quantity of fruit chose = 0 remove from list
            if (fruitChose.getQunatity() == 0) {
                fruitService.delete(fruitChose);
            }

            // new fruit with quantiy will buy in order
            Fruit fruitChangeQuantity = new Fruit(fruitChose.getId(), fruitChose.getName(),
                    fruitChose.getOrigin(), fruitChose.getPrice(), quantityOrder);
            // add to invoid
            order.addFruit(fruitChangeQuantity);

            if (inputChoice("Do you want to order now(Y/N)?: ", wrongFormatInout)) {
                break;
            }

            // check if byer buy all and do not have any thing in shop then must be invoice for buyer
            if (fruitService.getListFruit().isEmpty()) {
                printError("Empty shop!!");
                break;
            }
        }
        displayOrder(order);
        String nameCustomer = inputString("Enter name: ", wrongFormatInout, 2, 30);
        order.setNameCustomer(nameCustomer);
        fruitService.addOrder(order);
        printMessage("Create order successfully!!\n");
    }

    private void displayOrder(Order order) {
        printMessage(String.format("%-10s %-10s %-10s %-10s\n", "Product", "Quantity", "Price", "Amount"));
        for (Fruit fruit : order.getListFruitOrder()) {
            printMessage(String.format("%-10s %-10s %-10s %-10s\n", fruit.getName(), fruit.getQunatity(), fruit.getPrice(), fruit.getTotalPriceChose()));
        }
        printMessage("Total: " + order.getAmount() + "$\n");
    }

    public void viewOrder() {
        if (fruitService.getListOrder().isEmpty()) {
            printError("Empty order!!");
        }
        for (Order order : fruitService.getListOrder()) {
            printMessage("Customer " + order.getNameCustomer() + "\n");
            displayOrder(order);
            printMessage("--------------------------------------\n");
        }
    }

}
