/*
 * Daryl Crosbie
 * ID: P453055
 */
package vehiclechassis;

/**
 *
 * @author Daryl
 */
public class VehicleFrame implements Chassis{

    private String vehicleFrameType;
    
    public VehicleFrame(){
        vehicleFrameType = "UniBody";
    }
    public VehicleFrame(String frame){
        vehicleFrameType = frame;
    }
    @Override
    public Chassis getChassisType() {
        return this;
    }

    @Override
    public void setChassisType(String vehicleFrameType) {
        this.vehicleFrameType = vehicleFrameType;
    }
    @Override
    public String toString(){
        return "Chassis        :"+chassis+"\n"+
               "Vehicle Frame  :"+vehicleFrameType;
    }
    public static void main(String[] args){
        
        VehicleFrame v1 = new VehicleFrame();
        VehicleFrame v2 = new VehicleFrame("Custom");
        
        System.out.println(v1.toString()+"\n");
        System.out.println(v2.toString());
        
        
    }
    
}
