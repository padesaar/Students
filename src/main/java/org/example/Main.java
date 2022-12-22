/*
// Exercise
    // Create a table that is called Students and another table
    // called Grades.
    // The columns on the students table should be: id, name, age
    // Complete the controllers for the Students table by adding
    // methods to handle CRD operations on each record in the table.
    // On the Grades table, store the student's id, score and the
    // Grade where for each Grade:
    // 0-40 F, 41-49 D, 50-59 C, 60-69 B, 70-100 A. //
    // Complete the controller on tge Grades table to have CRD operations.
    // For the read operation you should be able to see the students
    // information as well.


 */

package org.example;


import org.example.contollers.Grades;
import org.example.contollers.Students;

public class Main {
    public static void main(String[] args) {


        Students.createStudentsTable();
        Grades.createGradesTable();

     //Students.createNewStudent();
      Students.getAllStudents();
      Grades.getAllGrades();
       //Grades.createNewGrade();
      //  Grades.getAllGrades();
       // Students.deleteStudent();


    }
}