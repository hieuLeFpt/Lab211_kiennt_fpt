package entity;

public class Task {

    private int id;
    private int taskType;
    private String requirementName;
    private String date;
    private double planFrom, planTo;
    private String assignee;
    private String Reviewer;

    public Task() {
    }

    public Task(int id, int taskType, String requirementName, String date, double planFrom, double planTo, String assignee, String Reviewer) {
        this.id = id;
        this.taskType = taskType;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.Reviewer = Reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskType() {
        return taskType;
    }

    public String getTaskTypeString() {
        String result = null;

        switch (taskType) {
            case 1:
                result = "Code";
                break;
            case 2:
                result = "Test";
                break;
            case 3:
                result = "Design";
                break;
            case 4:
                result = "Review";
                break;
        }
        return result;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return Reviewer;
    }

    public void setReviewer(String Reviewer) {
        this.Reviewer = Reviewer;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-10s %-15s %-5s %-5s %-15s %-15s", 
                id, requirementName, getTaskTypeString(), date, planFrom, planTo, assignee, Reviewer);
    }

    
    
}
