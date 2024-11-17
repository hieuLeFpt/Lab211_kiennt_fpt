package service;

import entity.User;

import java.util.ArrayList;

public class UserService extends BaseService {

    private ArrayList<User> userList = new ArrayList<>();

    public UserService(String filePath) {
        super(filePath);
    }

    public void create(User newUser) {
        this.userList.add(newUser);
        writeFile(userList);
        
    }

    public User find(String nameUser) {
        for (User user : this.userList) {
            if (user.getUserName().equals(nameUser)) {
                return user;
            }
        }
        return null;
    }

    public boolean login(String userName, String password) {
        this.userList = readFile();
        for (User user : this.userList) {
            if (user.getUserName().equalsIgnoreCase(userName) && user.getPassword().equalsIgnoreCase(password)) {
                return true;
            }
        }
        return false;
    }
}
