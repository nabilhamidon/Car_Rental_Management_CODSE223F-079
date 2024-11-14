
package Model;

import View.CustomerRentView;
import View.LoginView;
import View.ManageVehicleView;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class LoginModel {
    ResultSet rst;
    public void userLogin(String username, String password)
    {   if(username.isBlank() || password.isBlank())
    {
        JOptionPane.showMessageDialog(null, "Please enter username and password");
    }
    else if("admin".equals(username) && "admin123".equals(password))
    {
        JOptionPane.showMessageDialog(null," Admin Login successful!");
        new ManageVehicleView().setVisible(true);
        LoginView lv= new LoginView();
        lv.dispose();
    }
    
    
    else{      
        try{
        Statement st=MDBConnection.createDBConnection().createStatement();
          rst= st.executeQuery("select * from usertbl where Username='"+username+"' AND Password='"+password+"'");
          if (rst.next()) {
                JOptionPane.showMessageDialog(null,"Login successful!");
                new CustomerRentView().setVisible(true);
                LoginView lv= new LoginView();
        lv.dispose();
                
            } else {
                JOptionPane.showMessageDialog(null,"Login failed. Invalid username or password.");
            }
           }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }
    }
}
