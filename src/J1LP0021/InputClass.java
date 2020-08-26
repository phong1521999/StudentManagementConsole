/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1LP0021;

import java.util.Scanner;

/**
 *
 * @author PhongFPT
 */
public class InputClass {

    static public int inputNumbericalOrderNumber(int numbericalOrderRange) {
        Scanner sc = new Scanner(System.in);
        String inputString;
        int input;
        do {
            System.out.print("Select numberical order to update/delete: ");
            inputString = sc.nextLine().trim();
            try {
                input = Integer.parseInt(inputString);
                if (input >= 1 && input <= numbericalOrderRange) {
                    return input;
                } else {
                    System.out.println("Your input is not in list, please re-input");
                }
            } catch (NumberFormatException e) {
                if(inputString.isEmpty()) System.out.println("You input nothing");
                else System.out.println("Your input \"" + inputString + "\" is not a digit");
            }
        } while (true);
    }

    static public int inputMenuOption() {
        Scanner sc = new Scanner(System.in);
        String inputOptionString;
        int inputOption;
        do {
            System.out.print("Your option: ");
            inputOptionString = sc.nextLine().trim();
            try {
                inputOption = Integer.parseInt(inputOptionString);
                if (!(inputOption >= 1 && inputOption <= 5)) {
                    System.out.println("Your option does not available");
                } else {
                    return inputOption;
                }
            } catch (NumberFormatException e) {
                if(inputOptionString.isEmpty()) System.out.println("You input nothing");
                else System.out.println("Your input \"" + inputOptionString + "\" is not a digit");
            }
        } while (true);
    }

    //return valid StudentID

    static public String inputID() {
        Scanner sc = new Scanner(System.in);
        String ID;
        do {            
           System.out.print("Input StudentID: ");
           ID = sc.nextLine().trim(); 
           if(!ID.isEmpty()) return ID;
           System.out.println("You input nothing");
        } while (true);
        
       
       
    }

    //return valid course name
    static public String inputCourseName() {
        Scanner sc = new Scanner(System.in);
        String courseName;
        do {
            System.out.print("Input Student Course: ");
            courseName = sc.nextLine().trim();
            if (!(courseName.equalsIgnoreCase("Java") || courseName.equalsIgnoreCase(".Net")
                    || courseName.equalsIgnoreCase("c/c++"))) {
                System.out.println("There are only three courses: Java, .Net, C/C++");
            } else {
                return courseName;
            }
        } while (true);
    }

    //input student name
    static public String inputStudentName() {
        Scanner sc = new Scanner(System.in);
        String studentName;
        do {            
           System.out.print("Input Student Name: ");
           studentName = sc.nextLine().trim(); 
           if(!studentName.isEmpty()) return studentName;
            System.out.println("You input nothing");
           
        } while (true);
        

    }

    //input semester
    static public String inputSemester() {
        Scanner sc = new Scanner(System.in);
        String semesterName;
        do {            
           System.out.print("Input Semester Name: ");
           semesterName = sc.nextLine().trim(); 
           if(!semesterName.isEmpty()) return semesterName;
            System.out.println("You input nothing");
           
        } while (true);
        

    }

    //u to update, d to delete
    static public String inputUpdateOption() {
        String option;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Do you want to update(U) or delete(D) student ");
            System.out.print("Your option: ");
            option = sc.nextLine().toLowerCase().trim();
            if (option.equalsIgnoreCase("u") || option.equalsIgnoreCase("d")) {
                return option;
            } else {
                System.out.println("Your input \"" + option + "\" is not a choice, please re-input");
            }
        } while (true);
    }
}
