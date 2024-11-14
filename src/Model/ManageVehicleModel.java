
package Model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class ManageVehicleModel {
    public void registerVehicle(String reg_no, String brand,String model,String availability, String type, float price)
    {  if(reg_no.isBlank() || brand.isBlank() || model.isBlank() || availability.isBlank() || type.isBlank() || price == 0)
       {
        JOptionPane.showMessageDialog(null,"Please fill all the details", "Missing details", JOptionPane.INFORMATION_MESSAGE);
        }
    else if(containsNumbers(brand) || containsNumbers(type))
    {
         JOptionPane.showMessageDialog(null,"Brand and Type cannot have numbers", "Missing details", JOptionPane.INFORMATION_MESSAGE);
      
    }
       
    
    
    else{
        try{
        Statement st =MDBConnection.createDBConnection().createStatement();
        int row_count=st.executeUpdate("insert into vehicletbl values('"+reg_no+"','"+brand+"', '"+model+"','"+availability+"','"+type+"','"+price+"')");
        if(row_count>0)
        {
            JOptionPane.showMessageDialog(null,"Vehicle registered", "Registration", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
          }
      catch(SQLException e)
      {
          System.err.println(e.getMessage());
      }
    }
    }
    
    public void deleteVehicle(String reg_no)
    {
        if(reg_no.isBlank())
       {
        JOptionPane.showMessageDialog(null,"Please select a vehicle to be deleted", "VehicleRentalManagement", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
        try{
        Statement st =MDBConnection.createDBConnection().createStatement();
        int row_count=st.executeUpdate("delete from vehicletbl where RegNo = '"+reg_no+"'");
        
            JOptionPane.showMessageDialog(null,"Vehicle deleted", "VehicleRentalManagement", JOptionPane.INFORMATION_MESSAGE);
        
        
        
          }
      catch(SQLException e)
      {
          System.err.println(e.getMessage());
      }
    }
    }
    
    public void editVehicle(String reg_no, String brand,String model,String availability, String type, float price)
    {
        if(reg_no.isBlank())
       {
        JOptionPane.showMessageDialog(null,"Please select a vehicle to be edited", "VehicleRentalManagement", JOptionPane.INFORMATION_MESSAGE);
        }
        
        else if(brand.isBlank() || model.isBlank() || availability.isBlank() || type.isBlank() || price == 0)
        {
        JOptionPane.showMessageDialog(null,"Please fill all the details", "Missing details", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(containsNumbers(brand) || containsNumbers(type))
    {
         JOptionPane.showMessageDialog(null,"Brand and Type cannot have numbers", "Missing details", JOptionPane.INFORMATION_MESSAGE);
      
    }
        else{
        try{
        Statement st =MDBConnection.createDBConnection().createStatement();
        int row_count=st.executeUpdate("update vehicletbl set Brand = '"+brand+"', Model='"+model+"',Availability='"+availability+"',Type='"+type+"',Price='"+price+"' where RegNo= '"+reg_no+"'");
        
            JOptionPane.showMessageDialog(null,"Vehicle updated", "VehicleRentalManagement", JOptionPane.INFORMATION_MESSAGE);
        
        
        
          }
      catch(SQLException e)
      {
          System.err.println(e.getMessage());
      }
    }
    }
    
    public static boolean containsNumbers(String input)
   {
       String regex = ".*\\d.*";
       Pattern p=Pattern.compile(regex);
       Matcher m=p.matcher(input);
       return m.matches();
   }
    
    
    
}
