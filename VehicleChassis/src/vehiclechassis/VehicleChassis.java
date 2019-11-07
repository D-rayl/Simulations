/*
 * Daryl Crosbie
 * ID: P453055
 */
package vehiclechassis;


public class VehicleChassis implements Chassis{

    private String chassisName;
    
    public VehicleChassis(){
        this.chassisName = chassis;
    }
    public VehicleChassis(String chassisName){
        this.chassisName = chassisName;
    }
    @Override
    public Chassis getChassisType() {
        return this;
    }

    @Override
    public void setChassisType(String vehicleChassis) {
       chassisName = vehicleChassis;
    }
    @Override
    public String toString(){
        return "Chassis Name    :"+chassisName;
    }
    
    public static void main(String[] args) {
        
        VehicleChassis v1 = new VehicleChassis();
        VehicleChassis v2 = new VehicleChassis("Custom");
        
        String name = v1.toString();
        System.out.println(name);
        name = v2.toString();
        System.out.println(name);
    }
}
