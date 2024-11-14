
package Model;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class ManageCustomerModel {
    public void registerCustomer(String cusid, String cusname,String address,String email, String phone)
    {  if(cusid.isBlank() || cusname.isBlank() || address.isBlank() || email.isBlank() || phone.isBlank() )
       {
        JOptionPane.showMessageDialog(null,"Please fill all the details", "Missing details", JOptionPane.INFORMATION_MESSAGE);
        }
    else if(containsNumbers(cusname))
    {
        JOptionPane.showMessageDialog(null,"Customer name cannot have numbers", "Missing details", JOptionPane.INFORMATION_MESSAGE);
       
    }
    
    else{
        try{
        Statement st =MDBConnection.createDBConnection().createStatement();
        int row_count=st.executeUpdate("insert into customertbl values('"+cusid+"','"+cusname+"', '"+address+"','"+phone+"','"+email+"')");
        if(row_count>0)
        {
            JOptionPane.showMessageDialog(null,"Customer registered", "Registration", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
          }
      catch(SQLException e)
      {
          System.err.println(e.getMessage());
      }
    }
    }
    
    public void deleteCustomer(String cusid)
    {
        if(cusid.isBlank())
       {
        JOptionPane.showMessageDialog(null,"Please select a Customer to be deleted", "VehicleRentalManagement", JOptionPane.INFORMATION_MESSAGE);
        }
    
        try{
        Statement st =MDBConnection.createDBConnection().createStatement();
        int row_count=st.executeUpdate("delete from customertbl where CustId = '"+cusid+"'");
        
            JOptionPane.showMessageDialog(null,"Customer deleted", "VehicleRentalManagement", JOptionPane.INFORMATION_MESSAGE);
        
        
        
          }
      catch(SQLException e)
      {
          System.err.println(e.getMessage());
      }
    }
    
    public void editCustomer(String cusid, String cusname,String address,String email, String phone)
    {
        if(cusid.isBlank())
       {
        JOptionPane.showMessageDialog(null,"Please select a vehicle to be edited", "VehicleRentalManagement", JOptionPane.INFORMATION_MESSAGE);
        }
        
        else if(cusname.isBlank() || address.isBlank() || email.isBlank() || phone.isBlank())
        {
        JOptionPane.showMessageDialog(null,"Please fill all the details", "Missing details", JOptionPane.INFORMATION_MESSAGE);
        }
         else if(containsNumbers(cusname))
    {
        JOptionPane.showMessageDialog(null,"Customer name cannot have numbers", "Missing details", JOptionPane.INFORMATION_MESSAGE);
       
    }
         else{
        try{
        Statement st =MDBConnection.createDBConnection().createStatement();
        int row_count=st.executeUpdate("update customertbl set CustName = '"+cusname+"', CustAdd='"+address+"',CustPhone='"+phone+"',Email='"+email+"' where CustId= '"+cusid+"'");
        
            JOptionPane.showMessageDialog(null,"Customer updated", "VehicleRentalManagement", JOptionPane.INFORMATION_MESSAGE);
        
        
        
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
