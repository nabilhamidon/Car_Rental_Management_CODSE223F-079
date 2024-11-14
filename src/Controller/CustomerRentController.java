
package Controller;

import Model.CustomerRentModel;
import Model.ManageCustomerModel;
import java.util.Date;


public class CustomerRentController {
     public void registerBooking(int bookid, String vehicle_reg, String cusname ,String book_date, Date return_date, float rentfee)
    {
        CustomerRentModel crm=new CustomerRentModel();
        crm.registerBooking(bookid, vehicle_reg, cusname , book_date, return_date, rentfee);
        
        
    }
     
     public void updateVehicle(String status, String vehicle_reg)
     {
         CustomerRentModel crm=new CustomerRentModel();
         crm.updateVehicle(status, vehicle_reg);
     }
     
}
