/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1LP0021;

/**
 *
 * @author AD
 */
public class Student implements Comparable<Student>{
    private String ID;
    private String StudentName;
    private String Semester;
    private String courseName;

    public Student(String ID, String StudentName, String Semester, String courseName) {
        this.ID = ID;
        this.StudentName = StudentName;
        this.Semester = Semester;
        this.courseName = courseName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String Semester) {
        this.Semester = Semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public int compareTo(Student o) {
        return StudentName.toLowerCase().compareTo(o.getStudentName().toLowerCase());
    }
    public void display(){
        System.out.format("%-15s%-15s%-15s\n", getStudentName(),getSemester(),getCourseName());  
        
    }

    @Override
    public String toString() {
        return "Student{" + "ID=" + ID + ", StudentName=" + StudentName + ", Semester=" + Semester + ", courseName=" + courseName + '}';
    }
    
}
