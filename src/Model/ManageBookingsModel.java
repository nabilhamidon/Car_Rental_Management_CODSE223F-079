
package Model;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class ManageBookingsModel {
    public void registerReturned(int rentid, String reg, String cusname , Date return_date, int delay, float fine)
    {  LocalDate currentdate = LocalDate.now();
        DateTimeFormatter f=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        if(rentid == 0  || reg.isBlank() || cusname.isBlank() || delay < 0 || fine < 0 )
       {
        JOptionPane.showMessageDialog(null,"Please fill all the details", "Missing details", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
    
        try{
        Statement st =MDBConnection.createDBConnection().createStatement();
        int row_count=st.executeUpdate("insert into paymenttbl values('"+rentid+"','"+reg+"', '"+cusname+"','"+return_date+"','"+delay+"', '"+fine+"')");
        if(row_count>0)
        {
            JOptionPane.showMessageDialog(null,"Booking Completed. payment completed", "VehicleRentalManagement", JOptionPane.INFORMATION_MESSAGE);
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
    
    
    
    public void deleteFromBooking(String reg_no)
    {
        if(reg_no.isBlank())
       {
        JOptionPane.showMessageDialog(null,"Please select a vehicle to be deleted", "VehicleRentalManagement", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
        try{
        Statement st =MDBConnection.createDBConnection().createStatement();
        int row_count=st.executeUpdate("delete from bookingtbl where BookingId = '"+reg_no+"'");
        
            JOptionPane.showMessageDialog(null,"Ongoing booking removed", "VehicleRentalManagement", JOptionPane.INFORMATION_MESSAGE);
        
        
        
          }
      catch(SQLException e)
      {
          System.err.println(e.getMessage());
      }
    }
    }
    
    
    
    
    
}

   
