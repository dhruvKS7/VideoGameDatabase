/*
Dhruv K. Saligram
10/13/18
This class creates database, tables, does select, and creates connections to database
*/
package videogameapplication;
//Imports below:
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//Creating class below:
public class DBMySQLAccess {
    //Declarations below:
    private String dbName;
    private Object[][] data;
    private Connection dbConn;
    //Setting values below:
    public DBMySQLAccess(String dbName) {
        this.dbName = dbName;
        this.data = null;
        setDbConn();
    }
    //Setting all values to null beow:
    public DBMySQLAccess() {
        this.dbName = "";
        this.data = null;
        this.dbConn = null;
    }
    //Using get method for database name below:
    public String getDbName() {
        return dbName;
    }
    //Using set method for database name below:
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
    //Executing select statement below:
    public Object[][] getData(String tableName, String[] tableHeaders) {
        //Creating variables below:
        int columnCount = tableHeaders.length;
        ResultSet rs = null;
        Statement s = null;
        String dbQuery = "SELECT * FROM " + tableName;
        ArrayList<ArrayList<String>> dataList = new ArrayList<>();
        try {
            //Adding values to 2D array from array list below:
            s = this.dbConn.createStatement();
            rs = s.executeQuery(dbQuery);
            while (rs.next()) {
                ArrayList<String> row = new ArrayList<>();
                for (int i = 0; i < columnCount; i++) {
                    row.add(rs.getString(tableHeaders[i]));
                }
                dataList.add(row);
            }
            //Creating Object 2D array with values below:
            this.data = new Object[dataList.size()][columnCount];
            for (int i = 0; i < dataList.size(); i++) {
                ArrayList<String> row;
                row = dataList.get(i);
                for (int j = 0; j < columnCount; j++) {
                    this.data[i][j] = row.get(j);
                }
            }
        }
        //Catching SQL exceptions below:
        catch (SQLException e) {
            //Giving user error message below:
            System.out.println("Error getting data from database!");
            System.exit(0);
        }
        return this.data;
    }
    //Setting data below:
    public void setData(Object[][] data) {
        this.data = data;
    }
    //Setting connection below:
    public Connection getDbConn() {
        return dbConn;
    }
    //Setting database connection below:
    public void setDbConn() {
        String connectionURL = "jdbc:mysql://localhost:3306/" + this.dbName;
        this.dbConn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.dbConn = DriverManager.getConnection(connectionURL, "root", "mysql1");
        } catch (SQLException a) {
            System.out.println("SQL Connection error");
            System.exit(0);
        } catch (ClassNotFoundException i) {
            System.out.println("Class name not found");
            System.exit(0);
        }
    }
    //Creating database below:
    public void createDb(String newDbName) {
        String connectionURL = "jdbc:mysql://localhost:3306/";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.dbConn = DriverManager.getConnection(connectionURL, "root", "mysql1");
            Statement s = this.dbConn.createStatement();
            int Result = s.executeUpdate("Create DATABASE " + newDbName);
            System.out.println("New database created.");
            this.dbConn.close();
        } catch (Exception e) {
            System.out.println("Error creating databse: " + newDbName);
            System.exit(0);
        }
    }
    //Creating tables below:
    public void createTable(String newTable, String dbName) {
        Statement s;
        setDbName(dbName);
        setDbConn();
        try {
            s = this.dbConn.createStatement();
            s.execute(newTable);
            System.out.println("New table created.");
            this.dbConn.close();
        } catch (SQLException e) {
            System.out.println("Error creating table:" + newTable);
            System.exit(0);
        }
    }
}