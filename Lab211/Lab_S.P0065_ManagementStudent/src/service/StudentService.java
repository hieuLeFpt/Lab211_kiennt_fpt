package service;

import entity.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentService {

    private final List<Student> listStudent;

    public StudentService() {
        listStudent = new ArrayList<>();
    }

    public List<Student> getListStudent() {
        return listStudent;
    }

    public void createStudent(Student createStudent) {
        listStudent.add(createStudent);
    }

    public List<Student> averageStudent(List<Student> students) {
        for (Student student : students) {
            double average = (student.getMathMarks() + student.getChemistryMarks() + student.getPhysicalMarks()) / 3;
            student.setAverageMarks(average);

            if (average > 7.5) {
                student.setStudentType("A");
            } else if (average >= 6 && average <= 7.5) {
                student.setStudentType("B");
            } else if (average >= 4 && average < 6) {
                student.setStudentType("C");
            } else {
                student.setStudentType("D");
            }
        }
        return students;
    }

    //Calculate the percentage of students by grades A, B, C, D
    public HashMap<String, Double> getPercentTypeStudent(List<Student> students) {
        int totalStudents = students.size();
        HashMap<String, Integer> typeCounts = new HashMap<>();

        // initialization value for a, b, c, d type
        typeCounts.put("A", 0);
        typeCounts.put("B", 0);
        typeCounts.put("C", 0);
        typeCounts.put("D", 0);

        // count student of each type
        for (Student student : students) {
            String type = student.getStudentType();
            typeCounts.put(type, typeCounts.get(type) + 1);
        }

        // calc percent of each type
        HashMap<String, Double> percentageOfEachType = new HashMap<>();
        for (String type : typeCounts.keySet()) {
            percentageOfEachType.put(type, (typeCounts.get(type) / (double) totalStudents) * 100);
        }
        return percentageOfEachType;
    }

}
