/**
 * Daryl Crosbie
 * ID: P453055
 */
package test;
import java.util.Scanner;

public class Terminal {
    int ans;
    //Three prize types are created in the terminal
    Prize candy = new Prize("Candy", 30);
    Prize toy = new Prize("Toy", 40);
    Prize teddy = new Prize("Teddy", 50);
    
    Scanner s = new Scanner(System.in);
    
    //Method, accepts a card and displays its information
    public void checkBal(Card c){
        int a = c.getNum();
        int b = c.getCredit();
        int d = c.getTicket();
        System.out.println("Card number: "+a+"\n Credit: "+b+"\n Tickets: "+d);
    }
    
    //Method, accepts a card and the amount of money
    //Sets the new credit balance
    //Dislays the card info
    public void buyCredit(Card c, int m){
        c.setCredit(c.getCredit() + m*2);
        checkBal(c);
    }
    
    //Method, accepts 2 cards and tranfers credits 
    //Display the credits available for transfer
    //Prompt user for amount to transfer
    //Check if answer is 0, if so transfer all the credit
    //If an amount is entered, check its less than or equal to available credit
    //If amount is negative or more than available, have method call itself
    //Display both cards info
    public void transferCredit(Card a, Card b){
        
        System.out.println(b.getCredit()+" credits available.");
        
            System.out.print("Credit transfer amount. Press 0 for all "
                    + "or enter amount: ");
        
        ans = s.nextInt();
        
        if(ans==0){
            a.setCredit(a.getCredit()+b.getCredit());
            b.setCredit(0);
        }
        else if(ans > 0 && ans <= b.getCredit()){
            a.setCredit(a.getCredit()+ ans);
            b.setCredit(b.getCredit()-ans);
        }
        else{
            System.out.println("Invalid amount.");
            transferCredit(a,b);
        }
        checkBal(a);
        checkBal(b);
    }
    
    //Method, accept 2 cards and transfers tickets
    //Display available tickets for transfer
    //Prompt user for amount to transfer
    //Check if answer is 0, if so transfer all the tickets
    //If an amount is entered, check its less than or equal to available tickets
    //If amount is negative or more than available, have method call itself
    //Display both cards info
    public void transferTicket(Card a, Card b){
        System.out.println(b.getTicket()+" tickets available.");
        
            System.out.print("Ticket transfer amount. Press 0 for all "
                    + "or enter amount: ");
        ans = s.nextInt();
        if(ans==0){
            a.setTicket(a.getTicket()+b.getTicket());
            b.setTicket(0);
        }
        else if(ans > 0 && ans <= b.getTicket()){
            a.setTicket(a.getTicket()+ ans);
            b.setTicket(b.getTicket()-ans);
        }
        else{
            System.out.println("Invalid amount.");
            transferTicket(a,b);
        }
        checkBal(a);
        checkBal(b);
    }
    
    //Method, accept a card for claiming a prize
    //Loop for valid answer for prize selection
    //For each prize check availability
    //Call method to exchange tickets for prize
    public void claimPrize(Card c){
        do{
            System.out.print("Pick a prize\n1. For Teddy\n2. For Toy\n3. "
                    + "For Candy\n");
            ans = s.nextInt();
        }while(!((ans==1)||(ans==2)||(ans==3)));
      
        switch(ans){
                case 1:
                    if(teddy.getCount()>0){
                        prizeDeal(c, teddy);
                    }
                    else{
                        System.out.println("Sorry, no teddies left.");
                    }
                break;
                case 2:
                     if(toy.getCount()>0){
                        prizeDeal(c, toy);
                    }
                    else{
                        System.out.println("Sorry, no toys left.");
                    }
                break;
                case 3:
                     if(candy.getCount()>0){
                        prizeDeal(c, candy);
                    }
                    else{
                        System.out.println("Sorry, no candies left.");
                    }
                break; 
            }
        } 
    
    //Method, accepts a card and a prize
    //Check if card has enough tickets for selected prize
    //Display prize received
    //Set new prize count
    //Set new ticket balance
    //Display prizes left and tickets left
    //Display if not enough tickets
    public void prizeDeal(Card c, Prize p){
        
        if(c.getTicket()>= p.getCost()){
            System.out.println("You received a "+p.getType());
            p.setCount(p.getCount()-1);
            c.setTicket(c.getTicket()-p.getCost());
            System.out.println("There are "+p.getCount()+" "+p.getType()
                    +" left.");
            }
            else{
                System.out.println("Sorry, not enough tickets.");
            }
        }
    }

    
    
    
    /*public void terminalOptions(Card c1, Card c2){
        int opt;
        
        do{
            System.out.println("Please select from the options below.");
            System.out.println("1. To check balance");
            System.out.println("2. To buy credit");
            System.out.println("3. To transfer credit");
            System.out.println("4. To transfer tickets");
            System.out.println("5. To claim prize");
            opt = s.nextInt();
            
        }while(opt < 1 || opt > 5);
        if(opt == 1){
            checkBal(c1);
        }
        else if(opt == 2){
            System.out.print("Enter credit amount: ");
            buyCredit(c1, s.nextInt());
        }
        else if(opt == 3){
            System.out.print("Enter amount to transfer: ");
            transferCredit(c1, c2, s.nextInt());
        }
        else if(opt == 4){
            System.out.print("Enter amount to transfer: ");
            transferTicket(c1, c2, s.nextInt());
        }
    }
}*/


