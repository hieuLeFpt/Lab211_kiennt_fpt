package controller;

import view.AccountView;

public class AccountController {

    AccountView accountView = new AccountView();

    public void run() {
        accountView.printMessage("========= Login Program =========\n");
        while (true) {
            accountView.displayMenu();
            
            int choice = accountView.inputInteger("Please choice one option: ", "Wrong format choice!", 1, 3);
            
            switch (choice) {
                case 1:
                    accountView.inputAccount();
                    break;
                case 2:
                    accountView.login();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }

}
