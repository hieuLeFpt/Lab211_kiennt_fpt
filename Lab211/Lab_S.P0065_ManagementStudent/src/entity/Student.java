package entity;

public class Student {
    
    private String studentName;
    private String className;
    private double mathMarks;
    private double physicalMarks;
    private double chemistryMarks;
    private double averageMarks;
    private String studentType;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMathMarks() {
        return mathMarks;
    }

    public void setMathMarks(double mathMarks) {
        this.mathMarks = mathMarks;
    }

    public double getPhysicalMarks() {
        return physicalMarks;
    }

    public void setPhysicalMarks(double physicalMarks) {
        this.physicalMarks = physicalMarks;
    }

    public double getChemistryMarks() {
        return chemistryMarks;
    }

    public void setChemistryMarks(double chemistryMarks) {
        this.chemistryMarks = chemistryMarks;
    }

    public double getAverageMarks() {
        return averageMarks;
    }

    public void setAverageMarks(double averageMarks) {
        this.averageMarks = averageMarks;
    }

    public String getStudentType() {
        return studentType;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }
    
}


