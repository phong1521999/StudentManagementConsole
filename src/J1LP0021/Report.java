/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1LP0021;

/**
 *
 * @author PhongFPT
 */
public class Report implements Comparable<Report>{
    //Student name, Course and Total of Course
    String studentName;
    int totalJavaCourse, totalNetCourse, total_C_Course;
    String ID;
    public Report() {
    }

    public Report( String ID,String studentName, int totalJavaCourse, int totalNetCourse, int total_C_Course) {
        this.ID=ID;
        this.studentName = studentName;
        this.totalJavaCourse = totalJavaCourse;
        this.totalNetCourse = totalNetCourse;
        this.total_C_Course = total_C_Course;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getTotalJavaCourse() {
        return totalJavaCourse;
    }

    public void setTotalJavaCourse(int totalJavaCourse) {
        this.totalJavaCourse = totalJavaCourse;
    }

    public int getTotalNetCourse() {
        return totalNetCourse;
    }

    public void setTotalNetCourse(int totalNetCourse) {
        this.totalNetCourse = totalNetCourse;
    }

    public int getTotal_C_Course() {
        return total_C_Course;
    }

    public void setTotal_C_Course(int total_C_Course) {
        this.total_C_Course = total_C_Course;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


    @Override
    public String toString() {
        return "Report{" + "studentName=" + studentName + ", totalJavaCourse=" + totalJavaCourse + ", totalNetCourse=" + totalNetCourse + ", total_C_Course=" + total_C_Course + '}';
    }

    @Override
    public int compareTo(Report o) {
        return studentName.toLowerCase().compareTo(o.studentName.toLowerCase());
    }
     
    

    
    
}
