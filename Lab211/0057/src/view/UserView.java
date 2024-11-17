/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Trung Hieu
 */
public class UserView  extends BaseView{

    
    public void displayMainMenu() {
        System.out.println("====== USER MANAGEMENT SYSTEM ======");
        System.out.println("1. Create a new account");
        System.out.println("2. Login system");
        System.out.println("3. Exit");
    }

    public String InputUserName() {
        return getString("Enter Username: ", "You must enter least at 5 character, and no space!", 5, Integer.MAX_VALUE);
    }
    
    public String InputUserPass() {
        return getString("Enter Password: ", "You must enter least at 6 character, and no space!", 6, Integer.MAX_VALUE);
    }
       
}
