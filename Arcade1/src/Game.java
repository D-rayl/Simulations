/**
 * Daryl Crosbie
 * ID: P453055
 */
package test;
import java.util.Random;

public class Game {
    Random r = new Random();
    
    //Method, accepts a card for playing a game
    //Generates a random cost up to 5
    //Checks if cards credit is greater than cost
    //Sets the new credit balance
    //Generates tickets won from 5 to 15
    //Sets the new ticket balance
    //Displays results
    public void play(Card c){
        
        int cost = r.nextInt(5)+1;
        
        if(c.getCredit() >= cost){
            c.setCredit(c.getCredit() - cost);
            int win = r.nextInt(15-5)+5;
            c.setTicket(c.getTicket() + win);
            System.out.println("Card number: "+c.getNum()+"\n Tickets won: "+win+
                    "\n Total: "+c.getTicket());  
        }
        else{
            System.out.println("Sorry, not enough credit to play");
        }
    } 
}
