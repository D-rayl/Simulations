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
public class Car extends Vehicle {
    
    private Feature[] feature = new Feature[10];
    private int carAxle;
    
    public Car(){
        super();
        carAxle = 2; 
    
    }
    public Car(String vManu, String vMake, String vModel, String type, String drive, String frame, String eManu, 
            Date date, String eMake, String eModel, int cyl,String eType, String drive2, int axle, Feature[] f){
        super(d, vManu, vMake, vModel, new VehicleFrame(frame), type, drive, new ManufacturedEngine(eManu, date, 
                eMake, eModel, cyl, eType, drive2));
        carAxle = axle;
        feature = f;
        
    }
    public String getExteriorFeature(){
        String feat = "";
        for(int i=0; i < feature.length; i++){
            if(feature[i] == null){
                break;
            }
            if(feature[0].getClass() == ExteriorFeature.class){
                feat += feature[i]+"\n";
            }
        }
        return feat;
    }
    public String getInteriorFeature(){
                String feat = "";
        for(int i=0; i < feature.length; i++){
            if(feature[i] == null){
                break;
            }
            if(feature[0].getClass() == InteriorFeature.class){
                feat += feature[i]+"\n";
            }
        }
        return feat;
    }
    public String toString(Car c){
        return c.toString()+"\n"+c.getExteriorFeature()+"\n"+c.getInteriorFeature();
    }
    public static void main(String[] args){
        Feature[] f = new Feature[10];
        f[0] = new ExteriorFeature("Spoiler");
        f[1] = new InteriorFeature("Leather");
        f[2] = new ExteriorFeature("Scoop");
        f[3] = new InteriorFeature("Bucket Seats");
        f[4] = new ExteriorFeature("Bull Bar");
        f[5] = new InteriorFeature("Air-Con");
        
        Car c = new Car();
        Car c2 = new Car("Nissan","Nissan","GTR","Carbon","Sport","Four-Wheel Drive","Nissan",d,"Nissan","Turbo",4,"inline","4WD",2,f);
        System.out.println(c.toString(c));
        System.out.println(c2.toString(c2));
        
        
    } 
}
