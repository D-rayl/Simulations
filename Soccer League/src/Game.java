/*
 * Daryl Crosbie
 * ID: P453055
 */
package soccer.league;
import java.util.Random;
import java.util.ArrayList;

public class Game {
    Random r = new Random();
    //Create a static Array List for game entries
    public static ArrayList<Game> games = new ArrayList<>();
    
    //Properties of each game
    private final Team HOME_TEAM;
    private final Team AWAY_TEAM;
    private final double TEMP;
    private final int HOME_T_SCORE;
    private final int AWAY_T_SCORE;
    
    private int gameID = 100;
    //Static counter variable for unique game ID
    private static int count =0;
    
    //Default contructor
    public Game(Team h, Team a){
        HOME_TEAM = h;
        AWAY_TEAM = a;
        TEMP = 0;
        HOME_T_SCORE = 0;
        AWAY_T_SCORE = 0;
    }
    
    //Overloaded contructor, accepts 2 teams, and a double
    //Increments static counter and assign game ID
    //Assign temperature variable
    //Get home team score, call play method
    //Update home teams total goals scored
    //Repeat for away team
    //Update each teams goals allowed
    //Assign the home and away team to the game properties
    //Call results method passing in the teams and scores
    public Game(Team home, Team away, double temp){
        count++;
        gameID += count;
        this.TEMP = temp;
        
        HOME_T_SCORE = PLAY(temp);
        home.sGoalScored(home.gGoalScored()+HOME_T_SCORE);
        AWAY_T_SCORE = PLAY(temp);
        away.sGoalScored(away.gGoalScored()+AWAY_T_SCORE);
        
        home.sGoalAllow(home.gGoalAllow()+AWAY_T_SCORE);
        away.sGoalAllow(away.gGoalAllow()+HOME_T_SCORE);
        HOME_TEAM = home;
        AWAY_TEAM = away;
        RESULTS(HOME_TEAM, AWAY_TEAM, HOME_T_SCORE, AWAY_T_SCORE);
        
    }
    
    //Getters for games private properties
    public String gHomeTName(){
        return HOME_TEAM.gName();
    }
    public String gAwayTName(){
        return AWAY_TEAM.gName();
    }
    public int gID(){
        return gameID;
    }
    public double gTemp(){
        return TEMP;
    }
    public int gHomeScore(){
        return HOME_T_SCORE;
    }
    public int gAwayScore(){
        return AWAY_T_SCORE;
    }
    //Method, accepts 2 teams and 2 integers
    //Checks who won
    //Assign appropriate win loss values to each team
    public final void RESULTS(Team ho, Team aw, int home, int away)
    {
        if(home > away){
            ho.sWin(ho.gWin()+1);
            aw.sLoss(aw.gLoss()+1);
        }
        else if(away > home){
            aw.sWin(aw.gWin()+1);
            ho.sLoss(ho.gLoss()+1);
        }
        else{
            aw.sTie(aw.gTie()+1);
            ho.sTie(ho.gTie()+1);
        }
    }
    //Method, accepts a double, return an integer
    //Checks teperature range
    //return a random integer to fit temperature range
    public final int PLAY(double temp){
        if(temp >= 40){
            return r.nextInt(9)+1;
        }
        else if(temp >= 30){
            return r.nextInt(6)+1;
        }
        else{
            return r.nextInt(3)+1;
        }
    }
}
