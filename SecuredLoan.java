package originalbank;

import originalbank.Loan1;

import java.time.LocalDate;

public abstract  class SecuredLoan extends Loan1 {

    protected double propertyValue;

    public SecuredLoan(String loanType, double loanAmount, int tenure, double roi,  double monthlySalary,
                       LocalDate loanDisposalDate, CustomerLoan customer,double propertyValue) {
        super(loanType,  loanAmount, tenure,  roi,   monthlySalary,
                loanDisposalDate, customer, propertyValue);
    }


    public abstract double calculateLoanToValueRatio();
}