/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import entity.User;
import java.io.IOException;

/**
 *
 * @author Trung Hieu
 */
public class BaseService {

    private String filePath;

    public BaseService() {
    }

    public BaseService(String filePath) {
        this.filePath = filePath;
    }

//    public void writeFile(ArrayList<User> userList) {
//        if (userList != null) {
//            try {
//                FileOutputStream fos = new FileOutputStream(filePath);
//                ObjectOutputStream oos = new ObjectOutputStream(fos);
//                oos.writeObject(userList);
//                oos.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    public ArrayList<User> readFile() {
//
//        try {
//            FileInputStream fis = new FileInputStream(filePath);
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            ArrayList<User> userList = (ArrayList<User>) ois.readObject();
//            ois.close();
//            fis.close();
//            return userList;
//        } catch (IOException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
    public void writeFile(ArrayList<User> userList) {
        if (userList != null) {
            try {
                FileOutputStream fos = new FileOutputStream(filePath);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(userList);
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList readFile() {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<User> userList = (ArrayList<User>) ois.readObject();
            ois.close();
            fis.close();
            return userList;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
            }
        }    
}
