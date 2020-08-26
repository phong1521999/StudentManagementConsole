/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1LP0021;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author PhongFPT
 */
public class IsExistClass {

    //check if ID is already exist

    static public boolean isExistID(ArrayList<Student> studentList, String ID) {
        for (Student student : studentList) {
            if (ID.equalsIgnoreCase(student.getID())) {
                return true;
            }
        }
        return false;
    }

    static public boolean isExistUpdatedID(ArrayList<Student> studentList, String inputID, String updateID) {
        for (Student student : studentList) {
            if (inputID.equalsIgnoreCase(student.getID())) {
                return true;
            }
        }
        return false;
    }

    static public boolean isExistIdReportList(HashMap<String, Report> reportList, String ID) {
        Report report = reportList.get(ID);
        if (report == null) {
            return false;
        } else {
            return true;
        }
    }

    static public boolean isExistStudentInfo(ArrayList<Student> studentList, String ID,
            String studentName,String semester, String courseName) {
        for (Student student : studentList) {
            if (student.getID().equalsIgnoreCase(ID)&&student.getStudentName().equalsIgnoreCase(studentName)
                    &&student.getSemester().equalsIgnoreCase(semester)&&student.getCourseName().equalsIgnoreCase(courseName)) {
                return true;
            }
        }
        return false;
    }
}
