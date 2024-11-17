package view;

import entity.Account;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import service.AccountService;
import java.util.Scanner;

public class AccountView {

    private final Scanner scanner = new Scanner(System.in);
    private final AccountService accountService = new AccountService();

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printError(String error) {
        System.err.println(error);
    }

    public void displayMenu() {
        printMessage("1. Add Account\n"
                + "2. Login\n"
                + "3. Exit\n");
    }

    public String inputString(String messageInput, String errorSpecialCharacter, int minLength, int maxLength) {
        while (true) {
            printMessage(messageInput);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                printError("Input cannot be empty !!");
            } else {
                if (input.length() >= minLength && input.length() <= maxLength && !input.contains(" ")) {
                    return input;
                } else {
                    printError(errorSpecialCharacter);
                }
            }
        }
    }

    public String inputName(String messageInput, String errorSpecialCharacter, int minLength, int maxLength) {
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

    public String inputDate(String messageInput, String errorWrongFormat, String errorInvalidDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false); // Kiểm tra định dạng chặt chẽ

        while (true) {
            printMessage(messageInput); // Hiển thị lời nhắc nhập
            String input = scanner.nextLine(); // Đọc đầu vào từ người dùng

            try {
                // Kiểm tra định dạng và tính hợp lệ của ngày
                Date dateInput = dateFormat.parse(input);

                // Lấy ngày hiện tại không bao gồm thời gian (00:00 của hôm nay)
                Date currentDate = dateFormat.parse(dateFormat.format(new Date()));

                // So sánh ngày nhập với ngày hiện tại
                if (dateInput.after(currentDate)) {
                    printError(errorInvalidDate);
                } else {
                    return input; // Trả về ngày hợp lệ
                }

            } catch (ParseException e) {
                printError(errorWrongFormat); // Xử lý nếu định dạng sai hoặc ngày không tồn tại
            }
        }
    }

    public String inputPhoneNumber(String messageInput, String errorWrongFormat) {
        while (true) {
            printMessage(messageInput);
            String input = scanner.nextLine().trim();
            boolean statusValid = true;
            if (input.length() == 10 || input.length() == 11) {
                for (char c : input.toCharArray()) {
                    if(!Character.isDigit(c)){
                        statusValid = false;
                        printError(errorWrongFormat);
                        break;
                    }
                }
                if(statusValid){
                    return input;
                }
            } else {
                printError(errorWrongFormat);
            }
        }
    }

    public String inputEmail(String messageInput, String errorWrongFormat) {
        while (true) {
            printMessage(messageInput);
            String result = scanner.nextLine().trim();
            if (result.contains("@") && result.contains(".") && result.indexOf('@') < result.lastIndexOf('.') && !result.startsWith("@") && !result.endsWith(".")) {
                return result;
            } else {
                printError(errorWrongFormat);
            }
        }
    }

    public void inputAccount() {
        String accountName, password, name, phone, email, address, dateOfBirth;

        accountName = inputString("Account: ", "Wrong format input!", 5, 20);
        password = inputString("Password: ", "Wrong format input!", 6, 20);
        name = inputName("Name: ", "Wrong format input!", 2, 50);
        phone = inputPhoneNumber("Phone: ", "Wrong format input!");
        email = inputEmail("Email: ", "Wrong format input!");
        address = inputName("Address: ", "Wrong format input!", 5, 30);
        dateOfBirth = inputDate("DOB: ", "Wrong format date, must be dd/mm/yyyy!", "Date is invalid!");

        Account accountNew = new Account(accountName, password, name, phone, email, address, dateOfBirth);
        boolean status = accountService.addAccount(accountNew);
        if (status) {
            printMessage("Account add successfully!\n");
        } else {
            printError("Account Name already exist!");
        }
    }

    public void login() {
        String accountName = inputString("Account: ", "Wrong format input!", 5, 20);
        String password = inputString("Password: ", "Wrong format input!", 6, 20);
        Account accountLogin = accountService.login(accountName, password);
        if (accountLogin != null) {
            printMessage("Hi " + accountLogin.getName()
                    + ", do you want chage password now? Y/N: ");
            changePassword(accountLogin);
        } else {
            printError("Invalid username or password!");
        }
    }
    
    private void changePassword(Account accoutLogin) {
        String choice;
        while (true) {
            choice = scanner.nextLine().trim();
            if (choice.length() == 0) {
                System.err.println("Not empty!!!");
            } else if (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N")) {
                break;
            } else {
                System.err.println("Re-input");
            }
        }

        if (choice.equalsIgnoreCase("Y")) {
            while (true) {
                String oldPassword = inputString("Old password: ", "Wrong format input", 6, 20);
                String newPassword = inputString("New password: ", "Wrong format input", 6, 20);
                String renewPassword = inputString("Renew password: ", "Wrong format input", 6, 20);

                if (!accountService.MD5Encryption(oldPassword).equalsIgnoreCase(accoutLogin.getPassword())) {
                    System.err.println("Old password incorrect. Please try again.");
                    continue;
                }
                if (!newPassword.equalsIgnoreCase(renewPassword)) {
                    System.err.println("New password and Renew password do not match. Please try again.");
                    continue;
                }
                accoutLogin.setPassword(accountService.MD5Encryption(newPassword));
                System.out.println("Change password success.");
                break; 
            }
        }
    }

}
