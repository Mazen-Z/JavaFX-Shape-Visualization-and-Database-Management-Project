package com.example.jdbc;

interface StudentsDatabaseInterface {
    String ddlCreateTableStudents = "CREATE TABLE Students(" +
            "empID VARCHAR(8) NOT NULL UNIQUE, " +
            "firstName VARCHAR(20), " +
            "lastName VARCHAR(20), " +
            "email VARCHAR(30), " +
            "gender VARCHAR(1), " +
            "PRIMARY KEY(empID))";

    String ddlCreateTableCourses = "CREATE TABLE Courses(" +
            "courseID VARCHAR(100) PRIMARY KEY REFERENCES scheduleSpring2022(courseID), " +
            "courseTitle VARCHAR(100), " +
            "department VARCHAR(100))";

    String ddlCreateTableClasses = "CREATE TABLE Classes(" +
            "courseID VARCHAR(100) REFERENCES scheduleSpring2022(courseID)," +
            "empID INT REFERENCES Students(empID), " +
            "sectionNo INT REFERENCES scheduleSpring2022(sectionNo), " +
            "yearr INT, " +
            "semester VARCHAR(100), " +
            "grade CHAR(100), " +
            "PRIMARY KEY(courseID, empID, sectionNo))";

    String ddlCreateTableAggregateGrades = "CREATE TABLE AggregateGrades(" +
            "grade CHAR(100), " +
            "numberStudents INT))";

    String ddlInsertTableStudents = "INSERT INTO Students (empID, firstName, lastName, email, gender)" +
            "VALUES(?, ?, ?, ?, ?)";

    String ddlInsertTableCourses = "INSERT INTO Courses (courseID, title, department)" +
            "VALUES(?, ?, ?)";

    String ddlInsertTableClasses = "INSERT INTO Classes (courseID, empID, sectionNo, yearr, semester, grade)" +
            "VALUES(?, ?, ?, ?, ?, ?)";
    String ddlInsertTableAggregateGrades = "INSERT INTO AggregateGrades SELECT grade, count(grade) FROM Classes GROUP BY grade";
}


