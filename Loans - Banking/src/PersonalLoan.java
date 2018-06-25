/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myloan;

/**
 * Personal loan class extends loan and constructs personal loan with
 * the correct interest rate
 * @author P453055
 */
public class PersonalLoan extends Loan{
    
    public PersonalLoan(int loanNum, String lastName, double loanAmm, int term, 
            double intRate) {
        super(loanNum, lastName, loanAmm, term);
        this.intRate = intRate + 0.02;
    }  
}
