/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1LP0021;

import java.util.ArrayList;

/**
 *
 * @author AD
 */
public class Main {
    public static void main(String[] args) {
        Manager test= new Manager();
        ArrayList<Student> studentList= new ArrayList<>();
        int option;
        do {            
            test.studentManageMentMenu();
            option=InputClass.inputMenuOption();
            switch(option){
                case 1: test.inputStudentInformation(studentList);
                    break;
                case 2: test.findAndSort(studentList);
                    break;
                case 3: test.updateOrDelete(studentList);
                    break;
                case 4: test.reportStudent(studentList);
                    break;
                case 5: System.out.println("Good Bye");
                    break;
            }
        } while (option!=5);
    }
}
