/*
 * Daryl Crosbie
 * ID: P453055
 */
package soccer.league;
import java.util.Scanner;
import java.util.Random;
public class Scheduler {
    
    Scanner s = new Scanner(System.in);
    Random r = new Random();
    private double temp;
    //Integer cold made static to ensure its only altered when neccessary
    private static int cold=0;
    
    //Prompts user for the temperature
    //Try parse user input as double, store it in temp
    //Check if temp is -1, if so call the method again
    //Create 4 int placeholders for team referencing
    //Create a default game object for accessing the ArrayList
    //Check if temperature is above 20, if so, assign a random number
    //to each team ensuring no 2 teams are the same
    public void schedule(Team[] t){
        do{
            System.out.print("Enter todays temperature: ");
            temp = tryParse(s.next());
        }while(temp == -100);   
        int team1, team2, team3=0, team4=0;
        
        Game gdef = new Game(t[0], t[1]);
        
        if(temp >= 20){
           do{
                team1 = r.nextInt(3);
                team2 = r.nextInt(3);
           }while(team1 == team2);
           for(int i =0; i<4; i++){
               if((!(i==team1 || i==team2))&& team3==0){
                   team3 = i;
               }
               else if(!(i==team1 || i==team2 || i==team3)){
                   team4 = i;
               }
           }
    //Create 2 game object passing in the 4 team and temperature
    //Add both instances to the Array list
    //Ensure the cold varialble is set to 0 and call the shedule method again
           Game g = new Game(t[team1],t[team2], temp);
           Game g2 = new Game(t[team3],t[team4], temp);
           Game.games.add(g);
           Game.games.add(g2);
           
           System.out.println("Games played.");
           cold=0;
           schedule(t);
        }
    //If temperature under 20, increment the cold variable by 1
    //If cold = 3, call results method passing in the teams array
    //and the default game object
    //Else call the shedule method again
        else{
            System.out.println("To cold to play.");
            cold++;
            if(cold==3){
                System.out.println("Season is over.");
                results(t, gdef);
            }
            else{
                schedule(t);
            }
        } 
    }
    
    //Method that accepts and array and a game object
    //Loop through the team array calling the display team method for each
    //Repeat for the games in the Array list
    //Display hottest day and Average temperature
    public void results(Team[] t, Game g){
        System.out.println("\n**********Results***********\n");
        for(int i = 0; i<t.length; i++){
            displayTeam(t[i]);
            System.out.println("");
        }
        for(int i = 0; i<Game.games.size(); i++){
            displayGame(Game.games.get(i));
            System.out.println("");
        }
        System.out.println("Hottest Temp: "+hotTemp(g));
        System.out.println("Average Temp: "+avTemp(g));
    }
    
    //Method, accepts team object
    //Displays details
    public void displayTeam(Team t){
        System.out.println("Team "+t.gName()+"\n"
                + "Wins: "+t.gWin()+", Losses: "+t.gLoss()+", Ties: "+t.gTie()+
                "\nGoals Scored: "+t.gGoalScored()+", Goals Allowed: "
                +t.gGoalAllow());
    }
    
    //Method, accepts game object
    //Displays details
    public void displayGame(Game g){
        System.out.println("Game #"+g.gID()+"\nTemperature: "+g.gTemp()+
                "\nAway Team: Team "+g.gAwayTName()+", Scored goals: "+
                g.gAwayScore()+"\nHome Team: Team "+g.gHomeTName()+
                ", Scored goals: "+g.gHomeScore());
    }
    
    //Method accepts game object, returns a double
    //Loop through games list 
    //Add each record to the total
    //return the total divided by the size of the list, to 1 decimal place
    public double avTemp(Game g){
        double total=0;
        
        for(int i =0; i<Game.games.size(); i++){
            total += Game.games.get(i).gTemp();
        }
        return Math.round(total / Game.games.size()*10)/10.0;
    }
    
    //Method, accepts game object, returns a double
    //Loop through games list 
    //Assign game temperature to variable if higher 
    //return variable
    public double hotTemp(Game g){
        double hottest=0;
        for(int i =0; i<Game.games.size(); i++){
            if(Game.games.get(i).gTemp() > hottest){
                hottest = Game.games.get(i).gTemp();
            }
        }
        return hottest;
    }
    
    //Method, accepts a string and returns a double
    //tries to parse the string as a double
    //catches any exception
    public double tryParse(String s){
        double val;
        try{
            val = Double.parseDouble(s);
        }catch(NumberFormatException e){
            val = -100;
        }
        return val;
    }
}
