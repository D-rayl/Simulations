/**
 * Daryl Crosbie
 * ID: P453055
 */
package test;

public class Prize {
    private final String type;
    private final int cost;
    private int count = 10;
    
    //Constructs a new prize with the type and cost passed in
    public Prize(String type, int cost){
        this.type = type;
        this.cost = cost;
    }
    public String getType(){
        return type;
    }
    public int getCost(){
        return cost;
    }
    public int getCount(){
        return count;
    }
    public void setCount(int c){
        count = c;
    }
}
