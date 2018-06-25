/*
 * Daryl Crosbie
 * ID: P453055
 */
package soccer.league;

public class Team {
    //Properties for every team
    private final String NAME;
    private int win;
    private int loss;
    private int tie;
    private int goalScored;
    private int goalAllow;
    
    //Team constuctor, accept string for initialising its name
    public Team(String name){
        this.NAME = name;
    }
    //Getter and setter methods for teams private properties
    public String gName(){
        return NAME;
    }
    public int gWin(){
        return win;
    }
    public void sWin(int s){
        win = s;
    }
    public int gLoss(){
        return loss;
    }
    public void sLoss(int s){
        loss = s;
    }
    public int gTie(){
        return tie;
    }
    public void sTie(int s){
        tie = s;
    }
    public int gGoalScored(){
        return goalScored;
    }
    public void sGoalScored(int s){
        goalScored = s;
    }
    public int gGoalAllow(){
        return goalAllow;
    }
    public void sGoalAllow(int s){
        goalAllow = s;
    } 
    
}
