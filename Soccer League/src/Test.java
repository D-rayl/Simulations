/*
 * Daryl Crosbie
 * 
 * This program ramdomly asigns teams to play a match
 * The number of possible goals scored increases due to higher temperatures
 * which are entered by the user
 * The season runs until 3 consecutive days are below 20degrees
 * Then the results of the season are displayed
 * */
package soccer.league;

public class Test {

    public static void main(String[] args) {
        
        //Create scheduler object, to work with
        Scheduler sc = new Scheduler();
        //Create and array to store 4 teams
        Team[] teams = new Team[4];
        //Loop to populate the teams array with teams
        for(int i=0; i<4; i++){
            String s = Integer.toString(i+1);
            teams[i] = new Team(s);
        }
        //Call the shedule method with schedule object 
        //Passing in the teams array
        sc.schedule(teams);
        System.out.println("\nWinter has arrived.");
    }  
}
