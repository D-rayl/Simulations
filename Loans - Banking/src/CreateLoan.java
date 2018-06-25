/*
 * Daryl Crosbie
 * ID:P453055
 */
package myloan;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  Create loan class gets loan details and constructs loans storing them 
 * in an array list
 * @author P453055
 */
public class CreateLoan {
    //Static array list stores the loans
    public static ArrayList<Loan> loan = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Get the interest rate
        double rate = getRate();
        //Loop for 5 loan requests
        for(int i=0; i<5; i++){
            enterDetails(i+1,rate);
        } 
        //Save to binary file
        toBinFile(loan);
        //Display to console
        show();
    }
    
    /**
     * This method gets user input for the current interest rate
     * @return interest rate 
     */
    public static double getRate(){
        Scanner s = new Scanner(System.in);
        double rate;
        do{
            System.out.print("Enter the current prime interest rate: ");
            rate = parseDouble(s.next());
            rate = rate * 0.01;
        }while(rate == -1);
            System.out.println("---------------------------------------------");
            return rate;
    }
    
    /**
     * Method, gets details from user for a new loan
     * Checks loan does not exceed limit
     * Constructs appropriate loan type
     * @param num
     * @param interest 
     */
    public static void enterDetails(int num, double interest){
        Scanner s = new Scanner(System.in);
        String name;
        double amm=0;
        int term=-1;
        
        int loanType;
        
        do{
            System.out.println("Press 1: Business Loan\n"
                            + "Press 2: Personal Loan");
                    loanType = parseInt(s.next());
        }while(!(loanType == 1 || loanType == 2));
        
        while(amm <= 0 || amm > 100000){
            System.out.print("Enter loan ammount: ");
            amm = parseDouble(s.next());
            if(amm > 100000){
                System.out.println("Loan exceeds limit");
            }
        }
        System.out.print("Enter the term in years: ");
        term = parseInt(s.next());
        if(!(term==3 || term==5)){
            System.out.println("Loan term set to 1 year");
        }
        
        System.out.print("Enter last name: ");
        name = s.next();
          
        switch (loanType) {
            case 1:
                BusinessLoan b = new BusinessLoan(num, name, amm, term, interest);
                if(b.loanNum!=-1){
                    loan.add(b);
                    System.out.println("Loan approved");
                }    
                break;
            case 2:
                PersonalLoan p = new PersonalLoan(num, name, amm, term, interest);
                if(p.loanNum!=-1){
                    loan.add(p);
                    System.out.println("Loan approved");
                }
                break;
        }
            System.out.println("---------------------------------------------");
    }
    
    //Method, displays loan info 
    public static void show(){
        for(int i =0; i<loan.size(); i++){
            loan.get(i).calculate();
        }
    }
    
    /**
     * Try parse user string as double
     * @param s user input
     * @return value 
     */
    public static double parseDouble(String s){
        double v=-1;
        try{
            v = Double.parseDouble(s);
        }catch(NumberFormatException e){
            System.out.println("Invalid input");
        }
        return v;
    }
    
    /**
     * Try parse user input as integer
     * @param s user input
     * @return value
     */
    public static int parseInt(String s){
        int v=-1;
        try{
            v = Integer.parseInt(s);
        }catch(NumberFormatException e){
            
        }
        return v;
    }
    
    /**
     * Write to binary file
     * @param l Array List 
     */
    public static void toBinFile(ArrayList<Loan> l){
        for(int i = 0; i < l.size(); i++){
            try{
                FileOutputStream fileOut = new FileOutputStream("loans.bin");
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                objectOut.write(i);
                
            }catch(IOException e){
                System.out.println(e);
            }
        }
        System.out.println("All loans stored to file\n");
    }
    
   /* public static void loadBinFile(){
        try{
            ObjectInputStream objectIn = new ObjectInputStream(
                    new FileInputStream("loans.bin"));
            Boolean i = true;
            while(i){
                
                try{
                   
                }catch(Exception e){
                    System.out.print(e);
                }
              
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }*/
}
