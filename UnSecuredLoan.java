package originalbank;

import java.time.LocalDate;

public abstract  class UnSecuredLoan extends Loan1 {
    public UnSecuredLoan(String loanType, double loanAmount, int tenure, double roi,
                         LocalDate loanDisposalDate,double monthlySalary,double propertyValue,CustomerLoan customer) {
        super(loanType,  loanAmount, tenure,  roi,   monthlySalary,
                loanDisposalDate, customer,propertyValue);
    }
}
