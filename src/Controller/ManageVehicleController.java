
package Controller;

import Model.ManageVehicleModel;


public class ManageVehicleController {
    public void registerVehicle(String reg_no, String brand,String model,String availability, String type, float price)
    {
        ManageVehicleModel mvm=new ManageVehicleModel();
        mvm.registerVehicle( reg_no,  brand, model, availability,  type,  price);
        
        
    }
    
    public void deleteVehicle(String reg_no)
    {
        ManageVehicleModel mvm=new ManageVehicleModel();
        mvm.deleteVehicle( reg_no);
        
        
    }
    
    public void editVehicle(String reg_no, String brand,String model,String availability, String type, float price)
    {
        ManageVehicleModel mvm=new ManageVehicleModel();
        mvm.editVehicle( reg_no,  brand, model, availability,  type,  price);
        
        
    }
}
