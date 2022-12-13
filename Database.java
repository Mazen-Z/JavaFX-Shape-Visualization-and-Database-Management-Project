package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database implements StudentsDatabaseInterface, TableInterface {
    private Connection cc;

    public Database() throws SQLException {
        // Establish a connection to the SQL database using the DriverManager class
        cc = DriverManager.getConnection("jdbc:mysql://localhost:3306/applications", "root", "10272002");
    }

    // Method for creating the schema
    public void createSchema(String nameSchema) {
        try {
            PreparedStatement psCreateTable = cc.prepareStatement("CREATE SCHEMA " + nameSchema);
            psCreateTable.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Method for creating the database tables
    public void createTable(String ddlCreateTable) {
        try {
            PreparedStatement psCreateTable = cc.prepareStatement(ddlCreateTable);
            psCreateTable.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Method for populating the database tables
    public void populateTable(String ddlPopulateTable) {
        try {
            PreparedStatement psInsertTable = cc.prepareStatement(ddlPopulateTable);
            psInsertTable.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Method for dropping a database table
    public void dropTable(String nameTable) {
        try {
            PreparedStatement psDropTable = cc.prepareStatement("DROP TABLE IF EXISTS " + nameTable);
            psDropTable.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Method for enabling local infile loading
    public void setLocalInFileLoading() {
        try{
            PreparedStatement psSetLocalInFileLoading = cc.prepareStatement("SET GLOBAL local_infile = 1");
            psSetLocalInFileLoading.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public Connection getConnection(String url, String username, String password) {
        return null;
    }
}

