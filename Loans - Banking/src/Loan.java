/*
 * Daryl Crosbie
 * ID: P453055
 */
package myloan;

/**
 *Loan class implement loan constants
 * Contains a single overloaded constructor
 * @author P453055
 */
public abstract class Loan implements LoanConstants {

    protected int loanNum;
    protected String lastName;
    protected double loanAmm;
    protected double intRate;
    protected int term;
    protected double ammOwd;
    protected static double loanedOut;


    public Loan(int loanNum, String lastName, double loanAmm, int term) {
        
        this.loanNum = loanNum;
        this.lastName = lastName;
        this.loanAmm = loanAmm;
        if (!(term == SHORT || term == MEDIUM || term == LONG)) {
            this.term = SHORT;
        } else {
            this.term = term;
        }
        if(loanedOut + loanAmm > LOANSLIMIT){
            System.out.println("---------------------------------------------");
            System.out.println("Lending limit exceeded\n"+(LOANSLIMIT - loanedOut)
                    +" left in holdings.");
            System.out.println("---------------------------------------------");
            this.loanNum = -1;
        }else{
            loanedOut += loanAmm;
        }
    }
    
    public int getLoanNum(){
        return loanNum;
    }
    
    //Method, calculate total ammount owed for loan
    public void calculate() {
        ammOwd = loanAmm + ((loanAmm * intRate) * term);
        System.out.print(this);

    }
    //To string method for loans object
    @Override
    public String toString(){
        return "\n Loan: "+loanNum+
                "\n"
                + "Ammount owed: "+ammOwd+"\n"
                + "-------------------------------------------"; 
        
    }
}
