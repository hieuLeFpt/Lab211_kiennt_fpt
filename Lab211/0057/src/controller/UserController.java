package controller;

import view.UserView;
import service.UserService;
import entity.User;

public class UserController {

    UserService userService = new UserService("user.dat");
    UserView userView = new UserView();

    public void run() {
        while (true) {
            userView.displayMainMenu();
            int choice = userView.getInteger("> Choose: ", "Wrong format choice!", 1, 3);
            switch (choice) {
                case 1:
                    addNewUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }

    public void addNewUser() {

        User createUser = new User();

        String nameCreate = userView.InputUserName();
        String passCreate = userView.InputUserPass();

        if (userService.find(nameCreate) == null) {
            createUser.setUserName(nameCreate);
            createUser.setPassword(passCreate);
            userService.create(createUser);
            System.out.println("Create successfully!");
        } else {
            System.out.println("User is exist! Please reinput new user name for create!");
        }
    }

    public void loginUser() {

        String loginName = userView.InputUserName();
        String loginPass = userView.InputUserPass();

        if (userService.login(loginName, loginPass)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid user name or password!");
        }
    }

}
