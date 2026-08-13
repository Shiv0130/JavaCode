//MY COPIED CODE FROM LECTURER AND CORRECTED/DEBBUGED WITH CHAT FOR MISSING PARTS
import javax.swing.plaf.nimbus.State;
import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Establish a connetcion to the server
            String url = "jdbc:mysql://localhost:3306/";
            String user = "root"; // Explain why it's root?
            String password = "";
           //create connection string based off our variables
           // this willl create a connection to the localhost server and nothing else
            Connection connectionString = DriverManager.getConnection(url,user,password);

            Statement createDB = connectionString.createStatement();

            //execute query
            String dbName = "Friday";
            String createDBQuery = "CREATE DATABASE IF NOT EXISTS " + dbName;
            //or
            //String createDBQuery = "CREATE DATABASE Friday " + dbName;

            createDB.executeUpdate(createDBQuery);
            System.out.println("Database created");

            Statement selectDB = connectionString.createStatement();

            String userDBStatement = "Use " + dbName;

            selectDB.executeUpdate(userDBStatement);
            System.out.println("DB:" + dbName + " is selected");

            //create a Table
            Statement createTable = connectionString.createStatement();

            String table = "Create Table IF NOT EXISTS CarDetails" +"("+
                    "CarID int AUTO_INCREMENT PRIMARY KEY," +
                    "Car_Name VARCHAR(50)," +
                    "Car_NoofDoors int, " +
                    "CarFuelType VARCHAR(50)" +
            ");";

            createTable.executeUpdate(table);
            System.out.println("Table created");

            //CRUD Functionality using PreparedStatements
            /* insert row 1
            String SQL_INSERT =
                    "INSERT INTO CarDetails(Car_Name,Car_NoofDoors,CarFuelType) VALUES(?,?,?)";//Because CarID autoincrements
            PreparedStatement preparedStatement = connectionString.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1,"Toyota");
            preparedStatement.setInt(2,5);
            preparedStatement.setString(3, "Hybrid-Petrol");

            int row = preparedStatement.executeUpdate();

            //insert row 2
            String SQL_INSERT2 =
                    "INSERT INTO CarDetails(Car_Name,Car_NoofDoors,CarFuelType) VALUES(?,?,?)";//Because CarID autoincrements
            PreparedStatement preparedInsertStatement = connectionString.prepareStatement(SQL_INSERT);
            preparedInsertStatement.setString(1,"Volkswagen");
            preparedInsertStatement.setInt(2,3);
            preparedInsertStatement.setString(3, "Petrol");

            int row2 = preparedInsertStatement.executeUpdate();
            //End Insert*/


            //SELECT
            /*
            String SELECT = "Select * From CarDetails Where CarFuelType=?";
            PreparedStatement selectStatement = connectionString.prepareStatement(SELECT);
            selectStatement.setString(1,"Petrol");
            ResultSet resultSet = selectStatement.executeQuery();

            while(resultSet.next()){
//                resultSet.getInt(4);
//                System.out.println(resultSet);
                System.out.println(resultSet.getString(1));




            }
            */


            /*
            //DELETE
            //should have two instances of toyota before execution
            String SQL_DELETE = "Delete From CarDetails Where Car_Name=?";
            PreparedStatement deleteStatement = connectionString.prepareStatement(SQL_DELETE);

            deleteStatement.setString(1,"Toyota");
            //After this it should delete all instances of toyota.
            int row = deleteStatement.executeUpdate();
            //End Delete*/


            //Update
            String SQL_UPDATE = "Update CarDetails SET Car_Name=? WHERE CarID =?";
            PreparedStatement updateStaement = connectionString.prepareStatement(SQL_UPDATE);
            updateStaement.setString(1,"BMW");
            updateStaement.setLong(2,3);

            int rowUpdate = updateStaement.executeUpdate();



        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }


    }
}

//Lecturer's actual code
//import java.sql.*;
//
////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    public static void main(String[] args) {
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            //establish a connection to the server
//            String url = "jdbc:mysql://localhost:3306/";
//            String user = "root";
//            String password="";
//
//            //create connection string based off our variables
//            //this will create a connection to the localhost server and nothing else
//            Connection connectionString = DriverManager.getConnection(url,user,password);
//
//            //create a query for DB creation.
//            Statement createDB = connectionString.createStatement();
//
//            //execute query
//            String dbName = "Friday";
//            String createDBQuery = "CREATE DATABASE IF NOT EXISTS " + dbName;
//            createDB.executeUpdate(createDBQuery);
//            System.out.println("Database created");
//
//            Statement selectDB = connectionString.createStatement();
//
//            String useDBStatement = "Use " + dbName;
//
//            selectDB.executeUpdate(useDBStatement);
//            System.out.println("DB: "+ dbName + " selected");
//
//
//            //create a Table
//            Statement createTable = connectionString.createStatement();
//
//            String table = "Create Table IF NOT EXISTS CarDetails" +"(" +
//                    "CarID int AUTO_INCREMENT PRIMARY KEY,"+
//                    "Car_Name VARCHAR(50)," +
//                    "Car_NoOfDoors int," +
//                    "Car_FuelType VARCHAR(50)"+
//                    ");";
//
//            createTable.executeUpdate(table);
//            System.out.println("Table created");
//
//            //CRUD Functionality using PreparedStatements
//            /*
//            String SQL_INSERT =
//            "INSERT INTO CarDetails(Car_Name, Car_NoOfDoors,Car_FuelType) VALUES(?,?,?)";
//
//            PreparedStatement preparedStatement = connectionString.prepareStatement(SQL_INSERT);
//            preparedStatement.setString(1,"Toyota");
//            preparedStatement.setInt(2,5);
//            preparedStatement.setString(3,"Hybrid-Petrol");
//
//            int row = preparedStatement.executeUpdate();
//
//            //insert row 2
//            String SQL_INSERT2 =
//                    "INSERT INTO CarDetails(Car_Name, Car_NoOfDoors,Car_FuelType) VALUES(?,?,?)";
//            PreparedStatement preparedInsertStatement = connectionString.prepareStatement(SQL_INSERT);
//            preparedInsertStatement.setString(1,"Volkswagen");
//            preparedInsertStatement.setInt(2,3);
//            preparedInsertStatement.setString(3,"Petrol");
//
//            int row2 = preparedInsertStatement.executeUpdate();
//
//            END INSERT
//             */
//
//            //SELECT
//            String SELECT = "Select * From CarDetails Where Car_FuelType=?";
//            PreparedStatement selectStatement = connectionString.prepareStatement(SELECT);
//            selectStatement.setString(1, "Petrol");
//
//            ResultSet resultSet = selectStatement.executeQuery();
//
//            while(resultSet.next()){
//                System.out.println( resultSet.getString(4));
//
//            }
//
//            /*
//            //DELETE
//            String SQL_DELETE = "DELETE FROM CarDetails Where Car_Name=?";
//
//            PreparedStatement deleteStatement = connectionString.prepareStatement(SQL_DELETE);
//            deleteStatement.setString(1,"Toyota");
//            int row = deleteStatement.executeUpdate();*/
//
//            //Update
//            String SQL_UPDATE = "Update CarDetails SET Car_Name=? WHERE CarID=?";
//            PreparedStatement updateStatement = connectionString.prepareStatement(SQL_UPDATE);
//            updateStatement.setString(1,"BMW");
//            updateStatement.setLong(2,3);
//
//            int rowUpdate = updateStatement.executeUpdate();
//
//        } catch (ClassNotFoundException | SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
// Is there a difference?