
package Model;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;


public class CustomerRentModel {
    public void registerBooking(int bookid, String vehicle_reg, String cusname ,String book_date, Date return_date, float rentfee)
    {  LocalDate currentdate = LocalDate.now();
        DateTimeFormatter f=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        if(vehicle_reg.isBlank()  || cusname.isBlank() || book_date.isBlank() || return_date.before(return_date)|| rentfee == 0 )
       {
        JOptionPane.showMessageDialog(null,"Please fill all the details", "Missing details", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(rentfee ==0)
       {
           JOptionPane.showMessageDialog(null, "Please enter 'generate'");
       }
        else{
        try{
        Statement st =MDBConnection.createDBConnection().createStatement();
        int row_count=st.executeUpdate("insert into bookingtbl values('"+bookid+"','"+vehicle_reg+"', '"+cusname+"','"+book_date+"','"+return_date+"', '"+rentfee+"')");
        if(row_count>0)
        {
            JOptionPane.showMessageDialog(null,"Booking Confirmed", "VehicleRentalManagement", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
          }
      catch(SQLException e)
      {
          System.err.println(e.getMessage());
      }
        }
    }
    
    public void updateVehicle(String status, String vehicle_reg)
    {
       
        try{
        Statement st =MDBConnection.createDBConnection().createStatement();
        int row_count=st.executeUpdate("update vehicletbl set Availability = '"+status+"' where RegNo='"+vehicle_reg+"'");
        
            JOptionPane.showMessageDialog(null,"Vehicle updated", "VehicleRentalManagement", JOptionPane.INFORMATION_MESSAGE);
        
        
        
          }
      catch(SQLException e)
      {
          System.err.println(e.getMessage());
      }
    }
    
}
