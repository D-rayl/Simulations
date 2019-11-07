/*
 * Daryl Crosbie
 * ID: P453055
 */
package vehiclechassis;

/**
 *
 * @author P453055
 */
public class ExteriorFeature implements Feature{

    private String exteriorFeature;
    
    public ExteriorFeature(){
        exteriorFeature = "Generic";
    }
    public ExteriorFeature(String exteriorFeature){
        this.exteriorFeature = exteriorFeature;
    }
    @Override
    public String getFeature() {
        return exteriorFeature;
    }
    @Override
    public void setFeature(String feature) {
        exteriorFeature = feature;
    }
    @Override
    public String toString(){
        return "                       :Exterior    ["+exteriorFeature+"]";
    }
    public static void main(String[] args){
        ExteriorFeature e1 = new ExteriorFeature();
        ExteriorFeature e2 = new ExteriorFeature("Spoiler");
        
        System.out.println(e1.toString()+"\n\n"+e2.toString());
        
    }
}
