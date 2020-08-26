/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1LP0021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author AD
 */
public class Manager {
    //menu 
    void studentManageMentMenu() {
        System.out.println("1.Create");
        System.out.println("2.Find and Sort");
        System.out.println("3.Update/Delete");
        System.out.println("4.Report");
        System.out.println("5.Exit");
    }
    
    //find index by ID
    private int findIndexByID(ArrayList<Student> studentList, String ID) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getID().equalsIgnoreCase(ID)) {
                return i;
            }
        }
        return -1;
    }


    //perform option 1: create student information
    
    void inputStudentInformation(ArrayList<Student> studentList) {
        System.out.println("-----Start input student information-----");
        String ID, studentName, semester, courseName;
        //ID = inputID(); 
        ID = InputClass.inputID();
        //    if (isExistID(studentList, ID)) {
        if (IsExistClass.isExistID(studentList, ID)) {
            int studentInfoIndex = findIndexByID(studentList, ID);
            studentName = studentList.get(studentInfoIndex).getStudentName();
            //    semester = inputSemester();
            semester = InputClass.inputSemester();
            //        courseName = inputCourseName();
            courseName = InputClass.inputCourseName();
            //   if (isExistCourse(studentList, courseName, ID) && isExistSemester(studentList, semester, ID)) {
            if(IsExistClass.isExistStudentInfo(studentList, ID, studentName, semester, courseName)){
                System.out.println("Data existed");
                return;
            }
        } else {
            studentName = InputClass.inputStudentName();
            semester = InputClass.inputSemester();
            courseName = InputClass.inputCourseName();
        }
        studentList.add(new Student(ID, studentName, semester, courseName));
    }

    //Perform option 2: search student(s) and sort result by student name
    void findAndSort(ArrayList<Student> studentList) {
       
        Scanner sc = new Scanner(System.in);
        String studentName;
        ArrayList<Student> studentListTemp = new ArrayList<>();
        if (studentList.isEmpty()) {
            System.out.println("There is nothing to find");
        } else {
            System.out.println("--------Find and Sort--------");
            System.out.print("Input student name: ");
            studentName = sc.nextLine().trim();
            for (Student student : studentList) {
                if (student.getStudentName().toLowerCase().contains(studentName.toLowerCase())) {
                    studentListTemp.add(student);
                }
            }
            if (studentListTemp.isEmpty()) {
                System.out.println("This name not found");
            } else {
                //, it should display: Student name, semester and Course Name. 
                Collections.sort(studentListTemp);
                for (Student student : studentListTemp) {
                    student.display();
                }
            }
        }
    }

    //perform option 3: update or delete student
    void updateOrDelete(ArrayList<Student> studentList) {
        //store updated student into a map name "studentModifyMap"
        HashMap<Integer, Student> studentModifyMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String ID;
        String option;
        int stt = 1;
        if (studentList.isEmpty()) {
            System.out.println("There is nothing in student list");
        } else {
            System.out.println("-----------Update or Delete-----------");
            //  ID = sc.nextLine().trim();
            ID = InputClass.inputID();
            for (Student student : studentList) {
                //if student in "studentList" match user-input-ID, put it into  "studentModifyMap"
                if (ID.equalsIgnoreCase(student.getID())) {
                    studentModifyMap.put(stt, student);
//                    System.out.println(student.toString());
                    stt++;
                }
            }
            if (studentModifyMap.isEmpty()) {
                System.out.println("ID \"" + ID + "\" is not exist");
            } else {
                System.out.println("Result found");
                //display the student(s) will be modified
                System.out.format("%-20s|%-5s|%-15s|%-10s|%-15s\n", "Numberical Order", "ID", "Student Name", "Semester", "Course");
                for (int i = 1; i <= studentModifyMap.size(); i++) {
                    System.out.format("%-20s|%-5s|%-15s|%-10s|%-15s\n",
                            i, studentModifyMap.get(i).getID(), studentModifyMap.get(i).getStudentName(), studentModifyMap.get(i).getSemester(), studentModifyMap.get(i).getCourseName());
                }
                //ask user to select option: update or delete student
                switch (InputClass.inputUpdateOption().toLowerCase()) {
                    case "u":
                        updateOptionPerform(studentModifyMap, studentList);
                        break;
                    case "d":
                        deleteOptionPerform(studentModifyMap, studentList);
                        break;
                }

            }
        }
    }

    //delete option perform
    void deleteOptionPerform(HashMap<Integer, Student> studentModifyMap, ArrayList<Student> studentList) {
        int numbericalOrderRange = studentModifyMap.size();
        //find deleted student in "studentModifyMap"
        Student studentDeleted = studentModifyMap.get(InputClass.inputNumbericalOrderNumber(numbericalOrderRange));
        //remove student in "studentList"
        studentList.remove(studentDeleted);
        System.out.println("Delete sucessfully");
    }


    //update option perform
    void updateOptionPerform(HashMap<Integer, Student> studentModifyMap, ArrayList<Student> studentList) {
        int numbericalOrderRange = studentModifyMap.size();
        int indexUpdate;
        String IDUpdate;
        String studentNameUpdate;
        String semesterUpdate;
        String courseNameUpdate;
        Student studentUpdated = studentModifyMap.get(InputClass.inputNumbericalOrderNumber(numbericalOrderRange));
        //find student be updated index in "studentList"
        indexUpdate = findIndexByID(studentList, studentUpdated.getID());
        System.out.println("Start updating");
        //user update ID first
        IDUpdate = InputClass.inputID();
        //ID update matches studentUpdate's ID
        if (IDUpdate.equalsIgnoreCase(studentUpdated.getID())) {
            //student name update is student be updated name
            studentNameUpdate = studentUpdated.getStudentName();
            semesterUpdate = InputClass.inputSemester();
            courseNameUpdate = InputClass.inputCourseName();
            Student update = new Student(IDUpdate, studentNameUpdate, semesterUpdate, courseNameUpdate);
            //notify user if date update have already exist
            if (IsExistClass.isExistStudentInfo(studentList, IDUpdate,studentNameUpdate,semesterUpdate,courseNameUpdate)) {
                System.out.println("Data existed");
                return;
            }
        } //ID update matches the existed-ID in "studentList"
        else if (IsExistClass.isExistUpdatedID(studentList, IDUpdate, studentUpdated.getID())) {
            //student update name is studentName of existed-ID student
            studentNameUpdate = studentList.get(findIndexByID(studentList, IDUpdate)).getStudentName();
            semesterUpdate = InputClass.inputSemester();
            courseNameUpdate = InputClass.inputCourseName();
            Student update = new Student(IDUpdate, studentNameUpdate, semesterUpdate, courseNameUpdate);
            if (IsExistClass.isExistStudentInfo(studentList, IDUpdate,studentNameUpdate,semesterUpdate,courseNameUpdate)) {
                System.out.println("Data existed");
                return;
            }
        } //Id update is new
        else {
            studentNameUpdate = InputClass.inputStudentName();
            semesterUpdate = InputClass.inputSemester();
            courseNameUpdate = InputClass.inputCourseName();
        }
        //create updatedStudent
        Student afterUpdate = new Student(IDUpdate, studentNameUpdate, semesterUpdate, courseNameUpdate);
        studentList.set(indexUpdate, afterUpdate);
        System.out.println("Update successfully");
    }

    //return a list of student ID
    ArrayList<String> studentIDList(ArrayList<Student> studentReportList) {
        ArrayList<String> studentIDList = new ArrayList<>();
        for (int i = 0; i < studentReportList.size(); i++) {
            String studentID = studentReportList.get(i).getID();
            try {
                //if the next studentID does match the recent studentID
                //store studentID into "studentIDList"
                if (!(studentID.equalsIgnoreCase(studentReportList.get(i + 1).getID()))) {
                    studentIDList.add(studentID);
                }
            } //if recent StudentID is the last element of "studentReportList", store it into "studentIDList"
            catch (IndexOutOfBoundsException e) {
                studentIDList.add(studentID);

            }
        }
        return studentIDList;
    }

    
    //Perform option 4: report student
    void reportStudent(ArrayList<Student> studentList) {
        //student report ArrayList
        ArrayList<Student> studentReportList = new ArrayList<>();
        //student ID ArrayList
        ArrayList<String> studentIDList = new ArrayList<>();
        //student report HashMap map
        HashMap<String, Report> reportTotalCourseHashMap = new HashMap<>();
        if (studentList.isEmpty()) {
            System.out.println("There is nothing in list");
            return;
        }
        System.out.println("---------Report---------");
        //copy all element in "studentList" to "studentReportList"
        for (Student student : studentList) {
            studentReportList.add(student);
        }
        //sort "studentReportList" by id
        Collections.sort(studentReportList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getID().compareTo(o2.getID());
            }
        });
        
        studentIDList = studentIDList(studentReportList);
        //store report instance into reportHashMap
        //studentIDList studentReportList reportHashMap
        reportTotalCourseHashMap=reportTotalcourse(studentReportList, studentIDList);
        //copy all element from "reportHashMap" to "reportArrayList"
        ArrayList<Report> reportTotalCourseArrayList = new ArrayList<>();
        for (int i = 0; i < studentIDList.size(); i++) {
            reportTotalCourseArrayList.add(reportTotalCourseHashMap.get(studentIDList.get(i)));
        }
        //sort "reportArrayList" by name
        Collections.sort(reportTotalCourseArrayList);
        //display Student report as: student name, courseName, total course
        for (Report reportInfo : reportTotalCourseArrayList) {
            if (reportInfo.getTotalJavaCourse() > 0) {
                System.out.println(reportInfo.getStudentName() + " | " + "Java" + " | " + reportInfo.getTotalJavaCourse());
            }
            if (reportInfo.getTotalNetCourse() > 0) {
                System.out.println(reportInfo.getStudentName() + " | " + ".Net" + " | " + reportInfo.getTotalNetCourse());
            }
            if (reportInfo.getTotal_C_Course() > 0) {
                System.out.println(reportInfo.getStudentName() + " | " + "C/C++" + " | " + reportInfo.getTotal_C_Course());

            }
        }
    }
    HashMap<String, Report> reportTotalcourse(ArrayList<Student> studentReportList,ArrayList<String> studentIDList ){
        //store report instance into reportHashMap
        //studentIDList studentReportList reportHashMap
         //student report HashMap map
        HashMap<String, Report> reportTotalCourseHashMap = new HashMap<>();
        for (int i = 0; i < studentIDList.size(); i++) {
            String ID = studentIDList.get(i);
            for (Student student : studentReportList) {
                if (ID.equalsIgnoreCase(student.getID())) {
                    String courseName = student.getCourseName();
                    //if this student is not in "reportListMap"
                    if (!IsExistClass.isExistIdReportList(reportTotalCourseHashMap, ID)) {
                        //if course name is "Java",                
                        if (courseName.equalsIgnoreCase("Java")) {
                            //declare and intialize new Report instance with total java course = 1
                            //store it into reportHashMap
                            reportTotalCourseHashMap.put(ID, new Report(ID, student.getStudentName(), 1, 0, 0));
                        } //if course name is ".net",                      
                        else if (courseName.equalsIgnoreCase(".Net")) {
                            //declare and intialize new Report instance with total .net course = 1
                            //store it into reportHashMap
                            reportTotalCourseHashMap.put(ID, new Report(ID, student.getStudentName(), 0, 1, 0));
                        } //if course name is "C/C++", 
                        //declare and intialize new Report instance with total c/c++ course = 1
                        else {
                            //declare and intialize new Report instance with total c/c++ course = 1
                            //store it into reportHashMap
                            reportTotalCourseHashMap.put(ID, new Report(ID, student.getStudentName(), 0, 0, 1));
                        }
                    } 
                    //if this studend has already in "reportListMap"
                    else {
                        //if course name is "Java"
                        if (courseName.equalsIgnoreCase("Java")) {
                           //create new Report instance with the same field as current studentReport, 
                            //increase total java course by 1 
                            Report report = new Report(ID, reportTotalCourseHashMap.get(ID).getStudentName(),
                                    reportTotalCourseHashMap.get(ID).getTotalJavaCourse() + 1,
                                    reportTotalCourseHashMap.get(ID).totalNetCourse,
                                    reportTotalCourseHashMap.get(ID).total_C_Course);
                            //update current studentReport
                            reportTotalCourseHashMap.replace(ID, reportTotalCourseHashMap.get(ID), report);
                        } 
                        //if course name is ".Net"
                        else if (courseName.equalsIgnoreCase(".Net")) {
                            //create new Report instance with the same field as current studentReport, 
                            //increase total .Net course by 1
                            Report report = new Report(ID, reportTotalCourseHashMap.get(ID).getStudentName(),
                                    reportTotalCourseHashMap.get(ID).getTotalJavaCourse(), reportTotalCourseHashMap.get(ID).totalNetCourse + 1,
                                    reportTotalCourseHashMap.get(ID).total_C_Course);
                            //update current studentReport
                            reportTotalCourseHashMap.replace(ID, reportTotalCourseHashMap.get(ID), report);
                        }
                        //if course name is "C/C++"
                        else {
                            //create new Report instance with the same field as current studentReport, 
                            //increase total C/C++ course by 1
                            Report report = new Report(ID, reportTotalCourseHashMap.get(ID).getStudentName(),
                                    reportTotalCourseHashMap.get(ID).getTotalJavaCourse(), reportTotalCourseHashMap.get(ID).totalNetCourse,
                                    reportTotalCourseHashMap.get(ID).total_C_Course + 1);
                            //update current studentReport
                            reportTotalCourseHashMap.replace(ID, reportTotalCourseHashMap.get(ID), report);
                        }
                    }
                }
            }
        }
        return reportTotalCourseHashMap;
    }
}
