package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDatabase implements StudentsDatabaseInterface, TableInterface {
    private static Connection cc;
    public static void connect(){
        cc = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to database");

                    cc=DriverManager.getConnection("jdbc:mysql://localhost:3306/applications", "root", "10272002");
            if (cc != null) {
                System.out.println("Database successfully connected");
            }
        } catch (SQLException e){
            System.out.println("SQLException: "+e.getMessage());
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection(String url, String username, String password) {
        return null;
    }

    public static class Schedule {
        public Schedule() {
            try {
                PreparedStatement state = cc.prepareStatement("CREATE TABLE scheduleSpring2022(" +
                        "    courseID VARCHAR(100), " +
                        "    sectionNo INT, " +
                        "    PRIMARY KEY (courseID, sectionNo))");
                state.executeUpdate();

                state = cc.prepareStatement("INSERT INTO scheduleSpring2022 (courseID, sectionNo) VALUES(?, ?)");
                state.setString(1, "22100 F");
                state.setInt(2, 32131);
                state.executeUpdate();
                state.close();

            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
        public static void create(){
            try{
                PreparedStatement state = cc.prepareStatement("CREATE TABLE scheduleSpring2022(" +
                        "    courseID VARCHAR(100), " +
                        "    sectionNo INT, " +
                        "    PRIMARY KEY (courseID, sectionNo))");
                state.executeUpdate();
            } catch (SQLException e){
                System.out.println(e);
            }
        }
        public static void populate(){
            try {
                PreparedStatement state = cc.prepareStatement("INSERT INTO scheduleSpring2022 (courseID, sectionNo) VALUES " +
                        " ('22100 F', 32131");
                state.executeUpdate();
            } catch (SQLException e){
                System.out.println(e);
            }
        }

        public static void drop(){
            try{
                PreparedStatement state = cc.prepareStatement("DROP TABLE scheduleSpring2022");
                state.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

    }
        public static class Students {
            public Students() {
                try {
                    PreparedStatement state = cc.prepareStatement(ddlCreateTableStudents);
                    state.executeUpdate();

                    state = cc.prepareStatement(ddlInsertTableStudents);
                    state.setInt(1, 24285315);
                    state.setString(2, "Rick");
                    state.setString(3, "Harrison");
                    state.setString(4, "rharris000@citymail.cuny.edu");
                    state.setString(5, "M");
                    state.executeUpdate();
                    state.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            public static void create(){
                try{
                    PreparedStatement state = cc.prepareStatement(ddlCreateTableStudents);
                    state.executeUpdate();
                }catch (SQLException e){
                    System.out.println(e);
                }
            }
            public static void populate(){
                try{
                    PreparedStatement state = cc.prepareStatement("INSERT INTO Students (empID, firstName, lastName, email, gender) VALUES " +
                            "(24285315, 'Rick', 'Harrison', 'rharris000@citymail.cuny.edu', 'M')");
                    state.executeUpdate();
                }catch (SQLException e){
                    System.out.println(e);
                }
            }
            public static void drop(){
                try{
                    PreparedStatement state = cc.prepareStatement("DROP TABLE Students ");
                    state.executeUpdate();
                }catch (SQLException e){
                    System.out.println(e);
                }
            }
        }
        public static class Courses {
            public Courses() {
                try {
                    PreparedStatement state = cc.prepareStatement(ddlCreateTableCourses);
                    state.executeUpdate();

                    state = cc.prepareStatement(ddlInsertTableCourses);
                    state.setString(1, "10200 MM1");
                    state.setString(2, "Introduction to Programming & Computer Science");
                    state.setString(3, "Computer Science");
                    state.executeUpdate();
                    state.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            public static void create(){
                try{
                    PreparedStatement state = cc.prepareStatement(ddlCreateTableCourses);
                    state.executeUpdate();
                }catch (SQLException e){
                    System.out.println(e);
                }
            }
            public static void populate(){
                try{
                    PreparedStatement state = cc.prepareStatement("INSERT INTO Courses (courseID, title, department) " +
                            "VALUES ('10200 MM1', 'Introduction to Programming & Computer Science', 'Computer Science' )");
                    state.executeUpdate();
                }catch (SQLException e){
                    System.out.println(e);
                }
            }
            public static void drop() {
                try {
                    PreparedStatement state = cc.prepareStatement("DROP TABLE Courses ");
                    state.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
        public static class Classes {
            public Classes() {
                try {
                    PreparedStatement state = cc.prepareStatement(ddlCreateTableClasses);
                    state.executeUpdate();

                    state = cc.prepareStatement(ddlInsertTableClasses);
                    state.setString(1, "22000 D");
                    state.setInt(2, 24285315);
                    state.setInt(3, 32148);
                    state.setInt(4, 2021);
                    state.setString(5, "Spring");
                    state.setString(6, "A");
                    state.executeUpdate();
                    state.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            public static void create(){
                try{
                    PreparedStatement state = cc.prepareStatement(ddlCreateTableClasses);
                    state.executeUpdate();
                }catch (SQLException e){
                    System.out.println(e);
                }
            }
            public static void populate(){
                try{
                    PreparedStatement state = cc.prepareStatement("INSERT INTO Classes (courseID, empID, sectionNo, yearr, semester, grade)" +
                            " VALUES ('22000 d', 24285315, 32148, 2021, 'Spring', 'A')");
                    state.executeUpdate();
                }catch (SQLException e){
                    System.out.println(e);
                }
            }
            public static void drop(){
                try{
                    PreparedStatement state = cc.prepareStatement("DROP TABLE Courses ");
                    state.executeUpdate();
                }catch (SQLException e){
                    System.out.println(e);
                }
            }
        }
        public static class AggregateGrades {
            public AggregateGrades() {
                try {
                    PreparedStatement state = cc.prepareStatement(ddlCreateTableAggregateGrades);
                    state.executeUpdate();

                    state = cc.prepareStatement(ddlInsertTableAggregateGrades);
                    state.setString(1, "F");
                    state.setInt(2, 2);
                    state.executeUpdate();
                    state.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            public static void create(){
                try{
                    PreparedStatement state = cc.prepareStatement(ddlCreateTableAggregateGrades);
                    state.executeUpdate();
                }catch (SQLException e){
                    System.out.println(e);
                }
            }
            public static void populate(){
                try{
                    PreparedStatement state = cc.prepareStatement(ddlInsertTableAggregateGrades);
                    state.executeUpdate();
                }catch (SQLException e){
                    System.out.println(e);
                }
            }

            public static void drop(){
                try{
                    PreparedStatement state = cc.prepareStatement("DROP TABLE AggregateGrades");
                    state.executeUpdate();
                }catch (SQLException e){
                    System.out.println(e);
                }
            }
        }


}



