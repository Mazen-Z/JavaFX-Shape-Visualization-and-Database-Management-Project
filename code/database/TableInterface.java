package com.example.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

interface TableInterface {
Connection getConnection(String url, String username, String password);

    static void createSchema(Connection connection, String nameSchema) throws SQLException {
        PreparedStatement psCreateTable = connection.prepareStatement("CREATE SCHEMA " + nameSchema);
        try {
        psCreateTable.executeUpdate();
        }
        catch(SQLException e){
        System.out.println(e);
        }
    }

    static void createTable(Connection connection, String ddlCreateTable) throws SQLException{
        PreparedStatement psCreateTable = connection.prepareStatement(ddlCreateTable);
        try{
            psCreateTable.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }

    }

    static void populateTable(Connection connection, String ddlPopulateTable) throws SQLException{
        PreparedStatement psInsertTable = connection.prepareStatement(ddlPopulateTable);
        try{
            psInsertTable.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    static void dropTable(Connection connection, String nameTable) throws SQLException {
        PreparedStatement psDropTable = connection.prepareStatement("DROP TABLE IF EXISTS" + nameTable);
        try{
            psDropTable.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    static void setLocalInFileLoading(Connection connection) throws SQLException{
        PreparedStatement psSetLocalInFileLoading = connection.prepareStatement("SET GLOBAL local_infile = 1");
        try{
            psSetLocalInFileLoading.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    static String loadDataInFileTable(String nameFile, String nameTable){
        return  "LOAD DATA LOCAL INFILE" + nameFile + " INTO TABLE " + nameTable +
                " COLUMNS TERMINATED BY " + " LINES TERMINATED BY " + " IGNORE 1 LINES";
        }
}
