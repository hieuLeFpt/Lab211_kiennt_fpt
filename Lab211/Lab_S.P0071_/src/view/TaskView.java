package view;

import entity.Task;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import service.TaskService;

public class TaskView {

    private final Scanner scanner = new Scanner(System.in);
    private final TaskService taskSerVice = new TaskService();

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printError(String error) {
        System.err.println(error);
    }

    public void displayMenu() {
        printMessage("1. Add Task\n"
                + "2. Delete Task\n"
                + "3. Display Task\n"
                + "4. Exit\n");
    }

    public String inputString(String messageInput, String errorSpecialCharacter, int minLength, int maxLength) {
        while (true) {
            printMessage(messageInput);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                printError("Input cannot be empty !!");
            } else {
                if (input.length() >= minLength && input.length() <= maxLength) {
                    return input;
                } else {
                    printError(errorSpecialCharacter);
                }
            }
        }
    }

    public int inputInteger(String messageInput, String errorSpecialCharacter, int minValue, int maxValue) {
        while (true) {
            try {
                System.out.print(messageInput);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    printError("Input cannot be empty !!");
                } else {
                    int number = Integer.parseInt(input);
                    if (number < minValue || number > maxValue) {
                        printError("Invalid input must be in " + minValue + " - " + maxValue);
                    } else {
                        return number;
                    }
                }
            } catch (NumberFormatException e) {
                printError(errorSpecialCharacter);
            }
        }
    }

    public double inputTime(String messageInput, String errorSpecialCharacter, double minValue, double maxValue) {
        while (true) {
            try {
                System.out.print(messageInput);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    printError("Input cannot be empty !!");
                } else {
                    double number = Double.parseDouble(input);
                    if (number > maxValue || number < minValue) {
                        printError("Time is over limit!");
                    } else if (number < minValue) {
                        printError("Wrong time!");
                    } else if (number % 0.5 != 0) {
                        printError("Invalid time!");
                    } else {
                        return number;
                    }
                }
            } catch (NumberFormatException e) {
                printError(errorSpecialCharacter);
            }
        }
    }

    public String inputDate(String messageInput, String errorWrongFormat, String errorInvalidDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false); // Kiểm tra định dạng chặt chẽ

        while (true) {
            printMessage(messageInput); // Hiển thị lời nhắc nhập
            String input = scanner.nextLine(); // Đọc đầu vào từ người dùng

            try {
                // Kiểm tra định dạng và tính hợp lệ của ngày
                Date dateInput = dateFormat.parse(input);

                // Lấy ngày hiện tại không bao gồm thời gian (00:00 của hôm nay)
                Date currentDate = dateFormat.parse(dateFormat.format(new Date()));

                // So sánh ngày nhập với ngày hiện tại
                if (dateInput.before(currentDate)) {
                    printError("Ngày nhập vào phải lớn hơn hoặc bằng ngày hiện tại!");
                } else {
                    return input; // Trả về ngày hợp lệ
                }

            } catch (ParseException e) {
                printError(errorWrongFormat); // Xử lý nếu định dạng sai hoặc ngày không tồn tại
            }
        }
    }

    

    public void inputTask() {
        String requirementName, date, asssignee, reviewer;
        int taskType;
        double planFrom, planTo;

        requirementName = inputString("Requirement Name: ", "Wrong format input!", 0, Integer.MAX_VALUE);
        taskType = inputInteger("Task Type: ", "Please get from 1 - 4", 1, 4);
        date = inputDate("Date: ", "Wrong format date, must be dd-mm-yyyy!", "Date is invalid!");
        planFrom = inputTime("From: ", "Wrong format input!", 8, 17);
        planTo = inputTime("To: ", "Wrong format input!", planFrom + 0.5, 17.5);
        asssignee = inputString("Asssignee: ", "Wrong format input!", 2, Integer.MAX_VALUE);
        reviewer = inputString("Reviewer: ", "Wrong format input!", 2, Integer.MAX_VALUE);

        Task task = new Task();
        task.setRequirementName(requirementName);
        task.setTaskType(taskType);
        task.setDate(date);
        task.setPlanFrom(planFrom);
        task.setPlanTo(planTo);
        task.setAssignee(asssignee);
        task.setReviewer(reviewer);
        
        taskSerVice.addTask(task);
        printMessage("Add successfully!!\n");
    }

    public void deleteTask() {
        int idDeleteTask = inputInteger("ID: ", "Wrong format id!", 1, 10);
        if(taskSerVice.deleteTask(idDeleteTask)){
            printMessage("Delete successfully!!\n");
        } else {
            printError("Not found task!");
        }
    }

    public void displayTask(){
        List<Task> listDisplayTask = taskSerVice.getListTask();
        printMessage(String.format("%-10s %-15s %-10s %-15s %-5s %-5s %-15s %-15s\n", "ID", "Name", "Task Type", "Date", "From", "To", "Assignee", "Reviewer"));
        for(Task task : listDisplayTask){
            System.out.println(task);
        }
    }
    
}
