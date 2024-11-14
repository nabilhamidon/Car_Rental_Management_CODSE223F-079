
package Controller;

import Model.LoginModel;


public class LoginController {
    public void userLogin(String uname,String pword)
    {
        LoginModel lm=new LoginModel();
        lm.userLogin(uname,pword);
    }

    
}
