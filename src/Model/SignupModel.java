/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Nabeel
 */
public class SignupModel {
   public void signupUser(int userid,String username, String password, String email)
    {   if(username.isBlank() || password.isBlank() || email.isBlank())
    {
        JOptionPane.showMessageDialog(null, "Please fill all the details" ,"Signup", JOptionPane.INFORMATION_MESSAGE);
    }
    else if(containsNumbers(username))
    {
         JOptionPane.showMessageDialog(null, "Username cannot have numbers" ,"Signup", JOptionPane.INFORMATION_MESSAGE);
   
    }
    else if(password.length() > 10)
    {
         JOptionPane.showMessageDialog(null, "Password can only have 10 characters" ,"Signup", JOptionPane.INFORMATION_MESSAGE);
   
    }
    
    else{ 
        try{
        Statement st =MDBConnection.createDBConnection().createStatement();
        int row_count=st.executeUpdate("insert into usertbl values('"+userid+"','"+username+"','"+password+"', '"+email+"')");
        if(row_count>0)
        {
            JOptionPane.showMessageDialog(null,"User registered", "Registration", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
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
