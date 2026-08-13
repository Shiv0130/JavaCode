//import javax.swing.*;
//import javax.swing.border.Border;
//import java.awt.*;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//
////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main  {
//    public static void main(String[] args) {
////        JFrame frame = new JFrame("Panel coloring");
////        frame.setSize(500,500);
////        frame.setVisible(true);
////        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        frame.setLayout(new FlowLayout(2));
////        JPanel panel = new JPanel();
////        panel.setVisible(true);
////        panel.setSize(100,100);
////        panel.setBorder((Border) Color.black);
////        frame.add(panel);
//    }
//
////    @Override
////    public void mouseClicked(MouseEvent e) {
////
////    }
////
////    @Override
////    public void mousePressed(MouseEvent e) {
////        JPanel panel = new JPanel();
////        panel.setBackground(Color.blue);
////    }
////
////    @Override
////    public void mouseReleased(MouseEvent e) {
////
////    }
////
////    @Override
////    public void mouseEntered(MouseEvent e) {
////
////    }
////
////    @Override
////    public void mouseExited(MouseEvent e) {
////        JPanel panel = new JPanel();
////        panel.setBackground(Color.green);
////
////    }
//
//}

//import javax.swing.*;
//import javax.swing.border.Border;
//import java.awt.*;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.sql.*;
//
////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main  {
//    public static void main(String[] args) throws RuntimeException {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/";
//            String user = "root";
//            String password = "";
//
//           Connection connectionString = DriverManager.getConnection(url,user,password);
//
//            Statement createDB = connectionString.createStatement();
//
//            String dbName = "Exam";
//            String createDBQuery = "CREATE DATABASE IF NOT EXISTS" + dbName;
//
//            createDB.executeUpdate(createDBQuery);
//            System.out.println("Database Created");
//
//            Statement selectDB = connectionString.createStatement();
//
//            String userDBStatement = "Use" + dbName;
//
//            selectDB.executeUpdate(userDBStatement);
//            System.out.println("DB:" + dbName + "is selected");
//
//            Statement createTable = connectionString.createStatement();
//
//            String table = "Create Table IF NOT EXISTS Users" + "("+
//                           "userID int AUTO_INCREMENT PRIMARY KEY,"+
//                           "userName Varchar(50),"+
//                           "userSurname varchar(50)" +
//            ")";
//
//            createTable.executeUpdate(table);
//            System.out.println("Table created");
//
//            //CRUD Functionality using PreparedStatements
//            String SQLInsert = "INSERT INTO Users(userName,userSurname) VALUES(?,?,?)";
//            PreparedStatement preparedStatement = connectionString.prepareStatement(SQLInsert);
//            preparedStatement.setString(1,"Shivek");
//            preparedStatement.setString(2,"Sewnarain");
//
//            int row = preparedStatement.executeUpdate();
//
//            String SQLINSERT2 = "INSERT INTO Users(userName,userSurname) VALUES(?,?,?)";
//            PreparedStatement preparedStatement2 = connectionString.prepareStatement(SQLINSERT2);
//            preparedStatement.setString(1,"Shivaar");
//            preparedStatement.setString(2,"Sewnarain");
//
//            int row2 = preparedStatement2.executeUpdate();
//
//            String SELECT = "Select * From Users";
//            PreparedStatement selectStatement = connectionString.prepareStatement(SELECT);
//            ResultSet resultSet = selectStatement.executeQuery();
//
//            while(resultSet.next()){
//                resultSet.getInt(2);
//                System.out.println(resultSet);
//            }
//
//
//
//
//
//
//        } catch (ClassNotFoundException | SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//
//
//    }
//
//
//
//}

//Correction


// 2.2.
//import java.sql.*;                    // Required for database connectivity
//
//public class Main {
//    public static void main(String[] args) {
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            // Loads the MySQL JDBC driver into memory
//
//            String url = "jdbc:mysql://localhost:3306/Exam";
//            // Full JDBC connection string pointing directly to Exam DB
//
//            String user = "root";
//            String password = "";
//
//            Connection connectionString = DriverManager.getConnection(url, user, password);
//            // Establishes the connection to the database
//
//            Statement createTable = connectionString.createStatement();
//
//            String table = "CREATE TABLE IF NOT EXISTS Users (" +
//                    "userID INT AUTO_INCREMENT PRIMARY KEY, " +
//                    "userName VARCHAR(50), " +
//                    "userSurname VARCHAR(50))";
//
//            createTable.execute(table);
//            // Runs SQL to create table if it does not exist
//
//            String SQLInsert = "INSERT INTO Users(userName,userSurname) VALUES(?,?)";
//            PreparedStatement ps = connectionString.prepareStatement(SQLInsert);
//
//            ps.setString(1, "Shivaar");
//            ps.setString(2, "Sewnarain");
//            ps.executeUpdate();
//            // Inserts a record safely without SQL injection risk
//
//            PreparedStatement selectStatement = connectionString.prepareStatement("SELECT * FROM Users");
//            ResultSet rs = selectStatement.executeQuery();
//            // Retrieves all users from database
//
//            while (rs.next()) {
//                System.out.println(
//                        "ID: " + rs.getInt(1) +
//                                " Name: " + rs.getString(2) +
//                                " Surname: " + rs.getString(3)
//                );
//                // Correct way of printing result values from ResultSet
//            }
//
//            connectionString.close();
//            // Closes database connection
//
//        } catch (Exception e) {
//            System.out.println("Database Error: " + e);
//            // Handles and prints any database or driver exception
//        }
//    }
//}

//3.1.
//import javax.swing.*;
//import javax.swing.border.LineBorder;
//import java.awt.*;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//
//public class Main extends JFrame implements MouseListener {
//
//    JPanel panel = new JPanel();
//    // Declares ONE reusable JPanel instead of creating new ones
//
//    public Main() {
//        panel.setPreferredSize(new Dimension(100, 100));
//        // Ensures initial size is 100x100 but allows resizing later
//
//        panel.setBorder(new LineBorder(Color.BLACK, 10));
//        // Adds 10-pixel thick black border
//
//        panel.addMouseListener(this);
//        // Registers mouse listener to this panel
//
//        add(panel, BorderLayout.CENTER);
//        // Places panel in the center of JFrame
//
//        setSize(500, 500);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//        panel.setBackground(Color.BLUE);
//        // Changes panel color to blue when mouse is pressed
//        panel.repaint();
//        // Forces GUI redraw
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//        panel.setBackground(Color.GREEN);
//        // Changes panel to green when released
//        panel.repaint();
//    }
//
//    public static void main(String[] args) {
//        new Main();
//        // Launches JFrame GUI
//    }
//
//    // Unused listener methods are kept empty but must exist
//    @Override public void mouseClicked(MouseEvent e) {}
//    @Override public void mouseEntered(MouseEvent e) {}
//    @Override public void mouseExited(MouseEvent e) {}
//}

