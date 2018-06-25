/**
 * Daryl Crosbie
 * ID: P453055
 */
package test;
import java.util.Random;

public class Card {
    Random r = new Random();
    
    private final int cardNum;
    private int credit;
    private int ticket;
    
    //Constructs a random 3 digit card number when new card is created
    //Initialises credit and ticket balances to zero
    public Card(){
       cardNum = r.nextInt(1000)+100; 
       credit = 0;
       ticket = 0;
    }
    public int getNum(){
        return cardNum;
    }
    public int getCredit(){
        return credit;
    }
    public void setCredit(int cred){
        credit = cred;
    }
    public int getTicket(){
        return ticket;
    }
    public void setTicket(int tickets){
        ticket = tickets;
    }     
}
