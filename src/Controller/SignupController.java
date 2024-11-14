/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.SignupModel;

/**
 *
 * @author Nabeel
 */
public class SignupController {
    public void signupUser(int userid,String uname,String pword, String email)
    {
        SignupModel sm=new SignupModel();
        sm.signupUser(userid,uname,pword,email);
        
    }
}
