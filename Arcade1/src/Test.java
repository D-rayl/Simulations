/**
 * Daryl Crosbie
 * 
 * This program simulates being at an arcade 
 * Credits can be bought to top up a card
 * The credit can then be used to play games
 * Tickets are then won from playing games, 
 * which can then be exchanged for prizes 
 */
package test;

public class Test {

    public static void main(String[] args) {
        //Create two instances of the card class
        //Create a terminal object
        //Create a game object
        Card c1 = new Card();
        Card c2 = new Card();
        Terminal t = new Terminal();
        Game g = new Game();
        
        //Add credit to both cards
        t.buyCredit(c1, 10);
        t.buyCredit(c2, 10);
        
        //Play 5 games with each card
        for(int i=0; i<5; i++){
            g.play(c1);
        }
        for(int i=0; i<5; i++){
            g.play(c2);
        }
        
        //Transfer credit and tictets from card 1 to card 2
        t.transferCredit(c2, c1);
        t.transferTicket(c2, c1);
        
        //Claim prize with card 2
        //Try play a game with card 1
        //Try claim a prize with card 1
        t.claimPrize(c2);
        g.play(c1);
        t.claimPrize(c1);
    } 
}
