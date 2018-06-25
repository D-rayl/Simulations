/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myloan;

/**
 * Business loan extends loan and construct business loans with 
 * the correct interest rate
 * @author P453055
 */
public class BusinessLoan extends Loan {
     
    public BusinessLoan(int loanNum, String lastName, double loanAmm, int term,
            double intRate) {
        super(loanNum, lastName, loanAmm, term);
        this.intRate = intRate + 0.01;
    }
}
