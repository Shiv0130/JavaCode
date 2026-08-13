import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class MainServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, RuntimeException {


        ServletOutputStream servletOutputStream = response.getOutputStream();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String carName = request.getParameter("carName");
            int numDoors =Integer.parseInt(request.getParameter("noOfDoors"));
            String fuelType = request.getParameter("fuelType");

            Connection connectionString = DriverManager.getConnection("jdbc:mysql://localhost:3306/friday","root","");

            String INSERT = "INSERT INTO CarDetails(Car_Name, Car_NoOfDoors,Car_FuelType) VALUES(?,?,?)";
            PreparedStatement insertStatement = connectionString.prepareStatement(INSERT);
            insertStatement.setString(1,carName);
            insertStatement.setInt(2,numDoors);
            insertStatement.setString(3,fuelType);

            int row = insertStatement.executeUpdate();
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            if(response.getStatus() == 200){
              servletOutputStream.println("Data Inserted");
            }
            else{servletOutputStream.println("Error");}
            //

        }catch  (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
