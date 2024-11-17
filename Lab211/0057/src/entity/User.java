package entity;

import java.io.Serializable;


public class User implements Serializable{
    
    private String UserName, Password;

    public User() {
    }

    public User(String UserName, String Password) {
        this.UserName = UserName;
        this.Password = Password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
    
}
