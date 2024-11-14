
package Controller;

import Model.CustomerRentModel;
import Model.ManageBookingsModel;
import java.util.Date;


public class ManageBookingsController {
     public void registerReturned(int rentid, String reg, String cusname , Date return_date, int delay, float fine)
    {
        ManageBookingsModel mbm=new ManageBookingsModel();
        mbm.registerReturned(rentid,  reg,  cusname ,  return_date,  delay,  fine);
        
        
    }
     
     public void updateVehicle(String status, String vehicle_reg)
     {
         ManageBookingsModel mbm=new ManageBookingsModel();
         mbm.updateVehicle(status, vehicle_reg);
     }
     
     public void deleteFromBooking(String bookid)
     {
         ManageBookingsModel mbm=new ManageBookingsModel();
         mbm.deleteFromBooking(bookid);
     }
}
