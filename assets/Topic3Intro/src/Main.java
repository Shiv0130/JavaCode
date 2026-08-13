import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //attempt to connect to our db
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //this line "registers" the jdbc driver -> so that
            //our IDE knows what its using to make/attempt the connection

            //establish connection to our db
           Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/monday",
                   "root","");

           //create a statement to get data from our db -> this statement is executed by using the connection string.
            Statement selectStatement = connection.createStatement();

            ResultSet set = selectStatement.executeQuery("Select * From student");
            //in the line above, to execute our statement, we make a provision for any results we might get
            //and contain them in a cursor object (ResultSet) -> going to return a row / rows

            //here we read the result contained in our ResultSet
            /* we're saying, as long as the cursor can get to the next object/ item, we want to display it.
            *
            * we get the columns and their data types
            *
            * */
            while(set.next()){
                System.out.println(set.getInt(1)
                + " " + set.getString(2) + " " + set.getString(3) );
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}