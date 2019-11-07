/*
 * Daryl Crosbie
 * ID: P453055
 */
package vehiclechassis;

import java.util.Date;

/**
 *
 * @author P453055
 */
public class Vehicle implements Engine, Chassis{
    
    public static Date d = new Date();
    private Date vehicleManufacturedDate;
    private String vehicleManufacturer;
    private String vehicleMake;
    private String vehicleModel;
    private Chassis vehicleFrame;
    private String vehicleType;
    private String driveTrain;
    private Engine vehicleEngine;
    
    public Vehicle(){
        this.vehicleManufacturedDate = d;
        this.vehicleManufacturer = "Generic";
        this.vehicleMake = "Generic";
        this.vehicleModel = "Generic";
        this.vehicleType = "Generic";
        this.driveTrain = "Generic";
        this.vehicleFrame = new VehicleFrame();
        this.vehicleEngine = new ManufacturedEngine();
    }
    public Vehicle(Date d, String vehicleManufacturer, String vehicleMake, String vehicleModel, Chassis vehicleFrame, String vehicleType, String driveTrain, Engine vehicleEngine){
        this.vehicleManufacturedDate = d;
        this.vehicleManufacturer = vehicleMake;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.vehicleFrame = vehicleFrame;
        this.vehicleType = vehicleType;
        this.driveTrain = driveTrain;
        this.vehicleEngine = vehicleEngine;
    }
    
    public void setVehicleManufacturedDate(Date d){
        this.vehicleManufacturedDate = d;
    }
    public void setVehicleManufacturer(String vehicleManufacturer){
        this.vehicleManufacturer = vehicleManufacturer;
    }
    public void setVehicleMake(String vehicleMake){
        this.vehicleMake = vehicleMake;
    }
    public void setVehicleModel(String vehicleModel){
        this.vehicleModel = vehicleModel;
    }
    public void setVehicleType(String vehicleType){
        this.vehicleType = vehicleType;
    }
    public void setVehicleFrame(Chassis vehicleFrame){
        this.vehicleFrame = vehicleFrame;
    }
    public void setVehicleEngine(Engine vehicleEngine){
        this.vehicleEngine = vehicleEngine;
    }

    @Override
    public void setEngineCylinders(int engineCylinders) {
       this.vehicleEngine.setEngineCylinders(engineCylinders); 
    }

    @Override
    public void setEngineManufacturedDate(Date date) {
       this.vehicleManufacturedDate = date;
    }

    @Override
    public void setEngineManufacturer(String manufacturer) {
        this.vehicleEngine.setEngineManufacturer(manufacturer);
    }

    @Override
    public void setEngineMake(String engineMake) {
        this.vehicleEngine.setEngineMake(engineMake);
    }

    @Override
    public void setEngineModel(String engineModel) {
        this.vehicleEngine.setEngineModel(engineModel);
    }

    @Override
    public void setDriveTrain(String driveTrain) {
        this.driveTrain = driveTrain;
    }

    @Override
    public void setEngineType(String fuel) {
        this.vehicleEngine.setEngineType(fuel);
    }

    @Override
    public Chassis getChassisType() {
        return this.vehicleFrame.getChassisType();
    }

    @Override
    public void setChassisType(String vehicleChassis) {
        this.vehicleFrame.setChassisType(vehicleChassis);
    }
    @Override
    public String toString(){
        return  "Manufacturer Name      :"+vehicleManufacturer+"\n"+
                "Manufacturer Date      :"+vehicleManufacturedDate+"\n"+
                "Vehicle Make           :"+vehicleMake+"\n"+
                "Vehicle Model          :"+vehicleModel+"\n"+
                "Vehicle Type           :"+vehicleType+"\n"+
                vehicleEngine.toString()+" : "+driveTrain;
    }
    public static void main(String[] args){
        Vehicle v1 = new Vehicle();
        Vehicle v2 = new Vehicle(d, "Honda", "Honda", "Integra", new VehicleFrame("Carbon"), "Coupe", "Two-Wheel Drive", new ManufacturedEngine("Honda",new Date(1998,1,1,2,30,10),
                "Honda","V-tec",4,"inline","2WD"));
        System.out.println(v1.toString()+"\n\n"+v2.toString());
        
    }
}
