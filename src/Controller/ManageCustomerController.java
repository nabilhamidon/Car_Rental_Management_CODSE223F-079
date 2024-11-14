
package Controller;

import Model.ManageCustomerModel;
import Model.ManageVehicleModel;


public class ManageCustomerController {
    public void registerCustomer(String cusid, String cusname,String address,String email, String phone)
    {
        ManageCustomerModel mcm=new ManageCustomerModel();
        mcm.registerCustomer( cusid, cusname, address, email, phone);
        
        
    }
    
    public void deleteCustomer(String cusid)
    {
        ManageCustomerModel mcm=new ManageCustomerModel();
        mcm.deleteCustomer( cusid);
        
        
    }
    
    public void editCustomer(String cusid, String cusname,String address,String email, String phone)
    {
        ManageCustomerModel mcm=new ManageCustomerModel();
        mcm.editCustomer( cusid, cusname, address, email, phone);
        
        
    }
}
