/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Trung Hieu
 */
public class Worker {

    private String Code, Name, workLocation;
    private int Age;
    private double Salary;
    private List<HistoryWorker> listHistorySalarys = new ArrayList<>();

    public Worker() {
    }

    public Worker(String Code, String Name, int Age, double Salary, String workLocation) {
        this.Code = Code;
        this.Name = Name;
        this.Age = Age;
        this.Salary = Salary;
        this.workLocation = workLocation;
    }

    public List<HistoryWorker> getListHistorySalarys() {
        return listHistorySalarys;
    }

    public void setListHistorySalarys(List<HistoryWorker> listHistorySalarys) {
        this.listHistorySalarys = listHistorySalarys;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public void addHistorySalary(HistoryWorker historySalaryWorker) {
        listHistorySalarys.add(historySalaryWorker);
    }

}
