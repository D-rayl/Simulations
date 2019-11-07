/*
 * Daryl Crosbie
 * ID: P453055
 */
package vehiclechassis;

/**
 *
 * @author Daryl
 */
public class InteriorFeature implements Feature {
    
    private String interiorFeature;
    
    public InteriorFeature(){
        interiorFeature = "Generic";
    }
    public InteriorFeature(String interiorFeature){
        this.interiorFeature = interiorFeature;
    }
    @Override
    public String getFeature(){
        return interiorFeature;
    }
    @Override
    public void setFeature(String interiorFeature){
        this.interiorFeature = interiorFeature;
    }
    @Override
    public String toString(){
        return "                       :Interior    ["+interiorFeature+"]";
    }
    public static void main(String[] args){
        
        InteriorFeature i1 = new InteriorFeature();
        InteriorFeature i2 = new InteriorFeature("Leather");
        
        System.out.println(i1.toString()+"\n\n"+i2.toString());
        
    }
}
