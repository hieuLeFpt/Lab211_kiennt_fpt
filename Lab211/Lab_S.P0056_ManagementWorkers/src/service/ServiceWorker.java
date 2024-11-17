package service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import entity.HistoryWorker;
import java.util.ArrayList;
import entity.Worker;
import entity.HistoryWorker;

/**
 *
 * @author Trung Hieu
 */
public class ServiceWorker {

    private ArrayList<Worker> workerList;
    private ArrayList<HistoryWorker> historyWorkerList;

    public ServiceWorker() {
        workerList = new ArrayList<>();
        historyWorkerList = new ArrayList<>();
    }

    public Worker getWorkerByCode(String code) {
        for (Worker worker : workerList) {
            if (worker.getCode().equalsIgnoreCase(code)) {
                return worker;
            }
        }
        return null;
    }

    public void addWorker(Worker AddWorker) {
        workerList.add(AddWorker);
    }

    public void changeSalaryWorker(Worker changeSalaryWorker, boolean status, String date, double amount) {
        double newSalary = status ? changeSalaryWorker.getSalary() + amount : changeSalaryWorker.getSalary() - amount;
        changeSalaryWorker.setSalary(newSalary);
        HistoryWorker historyWorker = new HistoryWorker(status, date, amount);
        changeSalaryWorker.addHistorySalary(historyWorker);
    }

}
