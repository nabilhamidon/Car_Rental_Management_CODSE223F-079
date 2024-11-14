
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MDBConnection {
    private static Connection con;
    public static Connection createDBConnection()
    {   try{
        String dblc="jdbc:mysql://localhost:3306/vehiclerentalmanagementdb";
        con=DriverManager.getConnection(dblc,"root","");
    }
    catch(SQLException e)
    {
        System.err.println(e.getMessage());
    }
     return con;
    }
}
