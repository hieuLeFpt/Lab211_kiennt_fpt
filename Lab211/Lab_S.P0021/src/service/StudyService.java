package service;

import entity.Report;
import entity.Study;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudyService {

    private final ArrayList<Study> listStudy = new ArrayList<>();
    private final ArrayList<Report> listReport = new ArrayList<>();

    public StudyService() {
        listStudy.add(new Study(1, "hieu", 1, 1));
        listStudy.add(new Study(2, "nam", 2, 1));
        listStudy.add(new Study(2, "nam", 2, 2));
        listStudy.add(new Study(1, "hieu", 1, 2));
        listStudy.add(new Study(1, "hieu", 1, 3));
        listStudy.add(new Study(4, "phuong", 1, 1));
        listStudy.add(new Study(5, "hong", 1, 1));
        listStudy.add(new Study(5, "hong", 3, 2));
        listStudy.add(new Study(5, "hong", 3, 3));
    }

    public List<Study> getListStudy() {
        return listStudy;
    }

    public boolean create(Study newStudy) {
        if (checkDuplicate(newStudy)) {
            return false;
        }
        listStudy.add(newStudy);
        return true;
    }

    public boolean checkDuplicate(Study studyCheckDup) {
        for (Study study : listStudy) {
            if (study.getId() == studyCheckDup.getId()
                    && study.getName().equalsIgnoreCase(studyCheckDup.getName())
                    && study.getSemester() == studyCheckDup.getSemester()
                    && study.getCourse() == studyCheckDup.getCourse()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Study> findByName(String nameFind) {
        nameFind = nameFind.toLowerCase();
        ArrayList<Study> listFind = new ArrayList();
        for (Study study : listStudy) {
            if (study.getName().toLowerCase().contains(nameFind)) {
                listFind.add(study);
            }
        }
        sortByName(listFind);
        return listFind;
    }

    private void sortByName(ArrayList<Study> listFind) {
        int n = listFind.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (listFind.get(j).getName().compareToIgnoreCase(listFind.get(j + 1).getName()) > 0) {
                    Study temp = listFind.get(j);
                    listFind.set(j, listFind.get(j + 1));
                    listFind.set(j + 1, temp);
                }
            }
        }
    }

    public void delete(Study studyDelete) {
        listStudy.remove(studyDelete);
    }

    public Study getStudyById(int id) {
        for (Study study : listStudy) {
            if (study.getId() == id) {
                return study;
            }
        }
        return null;
    }

    public void updateStudy(int index, int idUpdate, String nameUpdate, int semesterUpdate, int courseUpdate) {
        Study studyUpdate = listStudy.get(index);
        studyUpdate.setId(idUpdate);
        updateAllName(idUpdate, nameUpdate);
        studyUpdate.setSemester(semesterUpdate);
        studyUpdate.setCourse(courseUpdate);
    }

    private void updateAllName(int id, String name) {
        for (Study study : listStudy) {
            if (study.getId() == id) {
                //study.setId(id);
                study.setName(name);
            }
        }
    }

    public boolean checkNotUpdate(int id, String name, int semester, int course, Study Study) {
        if (id == Study.getId()
                && name.equalsIgnoreCase(Study.getName())
                && semester == Study.getSemester()
                && course == Study.getCourse()) {
            return true;
        }
        return false;
    }

//    public ArrayList<Report> report() {
//        listReport.clear();
//
//        // Sort the listStudy by id and course to group the same student-course entries together
//        listStudy.sort((s1, s2) -> {
//            if (s1.getId() != s2.getId()) {
//                return Integer.compare(s1.getId(), s2.getId());
//            }
//            return Integer.compare(s1.getCourse(), s2.getCourse());
//        });
//
//        int currentId = -1;
//        int currentCourse = -1;
//        int totalCourse = 0;
//        String currentName = null;
//
//        for (Study study : listStudy) {
//            if (study.getId() != currentId || study.getCourse() != currentCourse) {
//                if (currentId != -1) {
//                    listReport.add(new Report(currentId, currentName, currentCourse, totalCourse));
//                }
//                currentId = study.getId();
//                currentCourse = study.getCourse();
//                currentName = study.getName();
//                totalCourse = 1;
//            } else {
//                totalCourse++;
//            }
//        }
//
//        if (currentId != -1) {
//            listReport.add(new Report(currentId, currentName, currentCourse, totalCourse));
//        }
//
//        return listReport;
//    }
    
    public ArrayList<Report> report() {
        listReport.clear();

        // Sử dụng HashMap để nhóm theo id và course
        Map<String, Report> reportMap = new HashMap<>();

        for (Study study : listStudy) {
            String key = study.getId() + "-" + study.getCourse(); // Tạo khóa dựa trên id và course

            // Nếu đã tồn tại khóa này, tăng totalCourse
            if (reportMap.containsKey(key)) {
                Report existingReport = reportMap.get(key);
                existingReport.setTotalCourse(existingReport.getTotalCourse() + 1);
            } else {
                // Nếu chưa tồn tại, tạo mới và đặt totalCourse là 1
                Report newReport = new Report(study.getId(), study.getName(), study.getCourse(), 1);
                reportMap.put(key, newReport);
            }
        }

        // Thêm tất cả các giá trị từ reportMap vào listReport
        listReport.addAll(reportMap.values());

        return listReport;
    }

    
}
