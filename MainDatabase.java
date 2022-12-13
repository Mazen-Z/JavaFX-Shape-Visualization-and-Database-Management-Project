package com.example.jdbc;
import java.sql.SQLException;

public class MainDatabase {
    public static void main(String[] args) {
        try {
            // Create a new Database object
            Database db = new Database();

            // Create a new schema named "testStudent"
            db.createSchema("testStudent");

            // Create a new table named "testStudent"
            //String ddlCreateTable = "CREATE TABLE testStudent (id INT, name VARCHAR(100))";
            db.createTable(ddlCreateTable);

            // Populate the "testStudent" table with data
            String ddlPopulateTable = "INSERT INTO testStudent (id, name) VALUES (1, 'John Doe'), (2, 'Jane Doe')";
            db.populateTable(ddlPopulateTable);

            // Drop the "testStudent" table
            db.dropTable("testStudent");

            // Enable local infile loading
            db.setLocalInFileLoading();

            // Connect to the SQL database
            StudentDatabase.connect();

            // Create a new table named "scheduleSpring2022"
            // REMOVE '//' to utilize the function
            StudentDatabase.Schedule.create();


            // Populate the "scheduleSpring2022" table with data
            // REMOVE '//' to utilize the function
            StudentDatabase.Schedule.populate();

            // Drop the "scheduleSpring2022" table
            // REMOVE '//' to utilize the function
            StudentDatabase.Schedule.drop();

            // Creates the "Students" table
            // REMOVE '//' to utilize the function below
            StudentDatabase.Students.create();

            // Populates the "Students" table
            // REMOVE '//' to utilize the function below
            StudentDatabase.Students.populate();

            // Drops the "Students" table
            // REMOVE '//' to utilize the function below
            StudentDatabase.Students.drop();

            // Creates the "Courses" table
            // REMOVE '//' to utilize the function below
            StudentDatabase.Courses.create();

            // Populates the "Courses" table
            // REMOVE '//' to utilize the function below
            StudentDatabase.Courses.populate();

            // Drops the "Courses" table
            // REMOVE '//' to utilize the function below
            StudentDatabase.Courses.drop();

            // Creates the "Classes" table
            // REMOVE '//' to utilize the function below
            StudentDatabase.Classes.create();

            // Populates the "Classes" table
            // REMOVE '//' to utilize the function below
            StudentDatabase.Classes.populate();

            // Drops the "Classes" table
            // REMOVE '//' to utilize the function below
            StudentDatabase.Classes.drop();

            // Creates the "AggregateGrades" table
            // REMOVE '//' to utilize the function below
            StudentDatabase.AggregateGrades.create();

            // Populates the "AggregateGrades" table
            // REMOVE '//' to utilize the function below
            StudentDatabase.AggregateGrades.populate();

            // Drops the "AggregateGrades" table
            // REMOVE '//' to utilize the function below
            StudentDatabase.AggregateGrades.drop();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

