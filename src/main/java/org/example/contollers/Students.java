package org.example.contollers;

import org.example.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Students {
    static Connection connection = Database.DbConn();
    static PreparedStatement ps;
    static ResultSet rs;
    static Scanner scanner = new Scanner(System.in);

    public static void createStudentsTable() {
        try {
            ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS students(" +
                    "student_id serial PRIMARY KEY," +
                    "name varchar(255) NOT NULL," +
                    "age int)");
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean createNewStudent() {
        //Add prompts to tell the user what data they need to enter next
        System.out.print("Enter the students name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the students age: ");
        int age = scanner.nextInt();



        try {
            ps = connection.prepareStatement("INSERT INTO students(name, age) " +
                    "VALUES('" + name + "', " + age +")");

            ps.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static void getAllStudents(){



        try{
            ps = connection.prepareStatement("SELECT * FROM students");
            rs = ps.executeQuery();

            //Loop through the result set
            while (rs.next()) {
                String id = "student_id: " + rs.getInt("student_id");
                String name = "name: " + rs.getString("name");
                String age = "age: " + rs.getString("age");



                System.out.println(id + " " + name + " " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean deleteStudent() {

        //Prompts - user info

        System.out.print("Enter the student's id you want to delete: ");
        int id = scanner.nextInt();


        try {

            ps = connection.prepareStatement("DELETE FROM grades WHERE student_id =" +id);
            ps.execute();

            ps = connection.prepareStatement("DELETE FROM students WHERE student_id = "+id+"");
            ps.execute();


            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
