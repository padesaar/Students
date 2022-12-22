package org.example.contollers;

import org.example.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Grades {

    static Connection connection = Database.DbConn();
    static PreparedStatement ps;
    static ResultSet rs;
    static Scanner scanner = new Scanner(System.in);


    public static void createGradesTable() {
        try {
            ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS grades(" +
                    "grade_id serial PRIMARY KEY," +
                    "student_id int," +
                    "score INT," +
                    "grade VARCHAR(1) NOT NULL," +
                    "FOREIGN KEY(student_id) REFERENCES students(student_id))");
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean createNewGrade() {
        //Add prompts to tell the user what data they need to enter next
        System.out.print("Enter the score: ");
        int score = scanner.nextInt();
        String grade = null;

        if (score <= 40) {
            grade = "F";
            System.out.println(grade);
        } else if (score > 40 && score <= 49) {
            grade = "D";
            System.out.println(grade);
        } else if (score > 49 && score <= 59) {
            grade = "C";
            System.out.println(grade);
        } else if (score > 59 && score <= 69) {
            grade = "B";
            System.out.println(grade);
        } else if (score > 69 && score <= 100) {
            grade = "A";
            System.out.println(grade);
        }


        System.out.print("Enter the student's id: ");
        int studentId = scanner.nextInt();


        try {
            ps = connection.prepareStatement("INSERT INTO grades(score, grade, student_id) " +
                    "VALUES(" + score + ", '" + grade + "', " + studentId + ")");

            ps.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static void getAllGrades(){



        try{
            ps = connection.prepareStatement("SELECT * FROM grades");
            rs = ps.executeQuery();

            //Loop through the result set
            while (rs.next()) {
                String id = "grade_id: " + rs.getInt("grade_id");
                String studentId = "student_id" + rs.getInt("student_id");
                String score = "score: " + rs.getString("score");
                String grade = "grade: " + rs.getString("grade");



                System.out.println(id + " " + studentId + " " + score + " " + grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static boolean deleteGrade() {

        //Prompts - user info

        System.out.print("Enter the grades id you want to delete: ");
        int id = scanner.nextInt();


        try {
            ps = connection.prepareStatement("DELETE FROM grades WHERE id = "+id+"");

            ps.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}

