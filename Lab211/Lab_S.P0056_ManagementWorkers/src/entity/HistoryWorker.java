/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Trung Hieu
 */
public class HistoryWorker {

    private boolean status;
    private String date;
    private double amount;

    public HistoryWorker() {
    }

    public HistoryWorker(Boolean status, String date, double amount) {
        this.status = status;
        this.date = date;
        this.amount = amount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUpDownStatus(){
        return status == true ? "UP" : "DOWN";
    }
    
}
