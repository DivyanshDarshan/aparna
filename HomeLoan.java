package originalbank;

import java.time.LocalDate;

public class HomeLoan extends SecuredLoan {
    private String builderName;
    int propertySize;
    double propertyValue;

    public int getPropertySize() {
        return propertySize;
    }

    @Override
    public double getPropertyValue() {
        return propertyValue;
    }

    public String getBuilderName() {
        return builderName;
    }

    public HomeLoan(String loanType, double loanAmount, int tenure, double roi  , double monthlySalary,
                    LocalDate loanDisposalDate, String builderName, int propertySize, double propertyValue, CustomerLoan customer) {
        super(  loanType,  loanAmount,  tenure,  roi,  monthlySalary,
                loanDisposalDate, customer,propertyValue);
        this.builderName = builderName;
        this.propertySize = propertySize;
        this.propertyValue = propertyValue;
    }

/*public static  void main(String args[]) {

  SecuredLoan hm = new HomeLoan(452, "HomeLoan", LocalDate.of(2020, 02, 10), 4852,
          4, 4565, 5, 5.5, 1305, "Sammy", 130,
          18000);
  hm.calculateLoanToValueRatio();
}*/

    @Override
    public double calculateLoanToValueRatio() {
        double ltv;
        double PropertyAmount =propertyValue;
        ltv=(loanAmount/PropertyAmount);
        System.out.println("LTV  =  "+ltv);
        return ltv;
    }
}

