package entity;

public class Study extends Student {

    private int semester;

    public Study(int id, String name, int course, int semester) {
        super(id, name, course);
        this.semester = semester;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-10s %-10s\n", getId(), getName(), semester, getCourseString());
    }
}
