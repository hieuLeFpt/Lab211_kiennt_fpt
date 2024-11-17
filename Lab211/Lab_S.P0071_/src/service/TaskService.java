package service;

import entity.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private final List<Task> listTask;

    int id = 0;

    public TaskService() {
        listTask = new ArrayList<>();
    }

    public List<Task> getListTask() {
        return listTask;
    }

    public void addTask(Task newTask) {
        newTask.setId(id += 1);
        listTask.add(newTask);
    }

    public boolean deleteTask(int idDelTask) {
        for (int i = 0; i < listTask.size(); i++) {
            if(listTask.get(i).getId() == idDelTask){
                listTask.remove(i);
                return true;
            }
        }
        return false;
    }

}
