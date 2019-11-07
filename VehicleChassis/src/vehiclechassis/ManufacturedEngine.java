/*
 * Daryl Crosbie
 * ID: P453055
 */
package vehiclechassis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Daryl
 */
public class ManufacturedEngine implements Engine {
    
    public static Date d = new Date();
    
    private String engineManufacturer;
    private Date engineManufacturedDate;
    private String engineMake;
    private String engineModel;
    private int engineCylinders;
    private String engineType;
    private String driveTrain;
    
    public ManufacturedEngine(){
        engineManufacturer = "Generic";
        engineManufacturedDate = d;
        engineMake = "Generic";
        engineModel = "Generic";
        engineCylinders = 4;
        engineType = "Generic";
        driveTrain = "2WD"; 
    }
    public ManufacturedEngine(String eManu, Date date, String eMake, String eModel, int cyl,
            String eType, String drive){
        engineManufacturer = eManu;
        engineManufacturedDate = date;
        engineMake = eMake;
        engineModel = eModel;
        engineCylinders = cyl;
        engineType = eType;
        driveTrain = drive;
    }
    @Override
    public String toString(){
        return  "Engine Manufacturer    :"+engineManufacturer+"\n" +
                "Engine Manufactured    :"+engineManufacturedDate+"\n" +
                "Engine Make            :"+engineMake+"\n" +
                "Engine Model           :"+engineModel+"\n" +
                "Engine Type            :"+engineType+"\n" +
                "Engine Cylinders       :"+engineCylinders+"\n" +
                "Drive Train            :"+driveTrain;
    }
    
    @Override
    public void setEngineCylinders(int engineCylinders) {
        this.engineCylinders = engineCylinders;
    }

    @Override
    public void setEngineManufacturer(String manufacturer) {
        this.engineManufacturer = manufacturer;
    }

    @Override
    public void setEngineMake(String engineMake) {
        this.engineMake = engineMake;
    }

    @Override
    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    @Override
    public void setDriveTrain(String driveTrain) {
        this.driveTrain = driveTrain;
    }

    @Override
    public void setEngineType(String fuel) {
        this.engineType = fuel;
    }

    @Override
    public void setEngineManufacturedDate(Date date) {
        this.engineManufacturedDate = date;
    }
    
    public static void main(String[] args){
        
        ManufacturedEngine m1 = new ManufacturedEngine();
        ManufacturedEngine m2 = new ManufacturedEngine("Subaru", d, "Subaru", "Impreza", 4, "Boxer", "4WD");
        
        System.out.println(m1.toString()+"\n");
        System.out.println(m2.toString());
    }
    
}
