import java.io.IOException;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws IOException {


        try {

            // Register and load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            String url = "jdbc:mysql://localhost:3306/";
            String user = "root";
            String password = "";

            Connection connection = DriverManager.getConnection(url, user, password);

            // Create DB if not exists
            Statement createDB = connection.createStatement();
            String dbName = "vehicles";
            String createDBQuery = "CREATE DATABASE IF NOT EXISTS " + dbName;
            createDB.executeUpdate(createDBQuery);
            System.out.println("Database created: " + dbName);

            // Select DB
            Statement selectDB = connection.createStatement();
            String selectDBQuery = "USE " + dbName;
            selectDB.executeUpdate(selectDBQuery);
            System.out.println("DB selected: " + dbName);

            // Create Table
            Statement createTable = connection.createStatement();
            String tableQuery = "CREATE TABLE IF NOT EXISTS CarDetails (" +
                    "ID INT AUTO_INCREMENT PRIMARY KEY," +
                    "Car_Name VARCHAR(50)," +
                    "Car_NoOfDoors INT," +
                    "Car_FuelType VARCHAR(50)" +
                    ");";
            createTable.executeUpdate(tableQuery);
            System.out.println("Table created: CarDetails");

            // INSERT row 1
            String SQL_INSERT = "INSERT INTO CarDetails(Car_Name, Car_NoOfDoors, Car_FuelType) VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, "Toyota");
            preparedStatement.setInt(2, 5);
            preparedStatement.setString(3, "Hybrid-Petrol");
            int row1 = preparedStatement.executeUpdate();
            System.out.println("Inserted row 1: " + row1);

            // INSERT row 2
            PreparedStatement preparedStatement2 = connection.prepareStatement(SQL_INSERT);
            preparedStatement2.setString(1, "Volkswagen");
            preparedStatement2.setInt(2, 3);
            preparedStatement2.setString(3, "Petrol");
            int row2 = preparedStatement2.executeUpdate();
            System.out.println("Inserted row 2: " + row2);

            // SELECT
            String SELECT = "SELECT ID, Car_Name, Car_NoOfDoors, Car_FuelType FROM CarDetails WHERE Car_FuelType=?";
            PreparedStatement selectStatement = connection.prepareStatement(SELECT);
            selectStatement.setString(1, "Petrol");
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("ID") + " | " +
                        resultSet.getString("Car_Name") + " | " +
                        resultSet.getInt("Car_NoOfDoors") + " | " +
                        resultSet.getString("Car_FuelType"));
            }

            // DELETE
            String SQL_Delete = "DELETE FROM CarDetails WHERE Car_Name=?";
            PreparedStatement deleteStatement = connection.prepareStatement(SQL_Delete);
            deleteStatement.setString(1, "Toyota");
            int delRow = deleteStatement.executeUpdate();
            System.out.println("Deleted rows: " + delRow);

            // UPDATE
            String SQL_UPDATE = "UPDATE CarDetails SET Car_Name=? WHERE ID=?";
            PreparedStatement updateStatement = connection.prepareStatement(SQL_UPDATE);
            updateStatement.setString(1, "BMW");
            updateStatement.setInt(2, 2);
            int rowUpdate = updateStatement.executeUpdate();
            System.out.println("Updated rows: " + rowUpdate);

            connection.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}