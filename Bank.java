package originalbank;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


import java.time.LocalDate;
import java.util.ArrayList;

public class Bank implements Maker,Checker {



     Bank() {

    }

    ArrayList<CustomerLoan> customer = new ArrayList<CustomerLoan>();
    ArrayList<Loan1> loan = new ArrayList<Loan1>();

    static int customerCount;
   static int loanCount;

    static int id = 0;

public void  Logger() {



    final Logger logger = LogManager.getLogger(BankMain.class);
    DOMConfigurator.configure("D\\Shameel\\Java\\OriginalBank");
    logger.info("Hello world");
    logger.info("we are in logger info mode");
    logger.warn("ALERT..!! Warning");
    logger.warn("It Might take sometimee");
    logger.warn("helllooo world");
    logger.debug("What is this");

}
    public int registerCustomer(String name, String newName, LocalDate newDate, String contactNumber, String emailAddress, double monthlyIncome,
                         String profession, double totalmonthlyExpenses, String designation, String companyName) {
        customer.add(customerCount, new CustomerLoan(name, newName, newDate, contactNumber, emailAddress, monthlyIncome,
                profession, totalmonthlyExpenses, designation, companyName));
        return customer.get(customerCount++).getCustomerId();
    }


    @Override
    public int applyLoan(int customerId, String loanType, LocalDate loanDisposalDate,
                         double maxEligibleLoanAmount, int repaymentFrequency, double loanAmount, double monthlySalary,
                         int tenure, double roi, String vehicleCategory, String vehicleModelNo,
                         String manufacturer, int yearOfManufacture, double assetValue, double propertyValue) {
        for (int i = 0; i < customerCount; i++) {
            if (customer.get(i).getCustomerId() == customerId) {
                loan.add(loanCount, new VehicleLoan(loanType, loanAmount, tenure, roi, monthlySalary,
                        loanDisposalDate, customer.get(i), vehicleCategory, vehicleModelNo,
                        manufacturer, yearOfManufacture, assetValue, propertyValue));
                loan.get(loanCount).setLaonStatus(Loan1.LaonStatus.Pending);
                return loan.get(loanCount++).getLoanId();

            }
        }
        return 0;


    }


    @Override
    public int applyLoan(int customerId, String loanType, LocalDate loanDisposalDate, double maxEligibleLoanAmount,
                         int repaymentFrequency, double loanAmount, int tenure, double roi,
                         double monthlySalary, String builderName, int propertySize, double propertyValue) {
        for (int i = 0; i < customerCount; i++) {
            if (customer.get(i).getCustomerId() == customerId) {
                loan.add(loanCount, new HomeLoan(loanType, loanAmount, tenure, roi, monthlySalary,
                        loanDisposalDate, builderName, propertySize, propertyValue, customer.get(i)));
                loan.get(loanCount).setLaonStatus(Loan1.LaonStatus.Pending);
                return loan.get(loanCount++).getLoanId();


            }

            //return loan[size++].getLoanId();

        }

        return 0;

    }

    @Override
    public int applyLoan(String loanType, int customerId, double loanAmount, int tenure, double roi, double emipermonth, double propertyValue,
                         LocalDate loanDisposalDate, String qualification, double monthlySalary, double workExperience) {
        for (int i = 0; i < customerCount; i++) {
            if (customer.get(i).getCustomerId() == customerId) {
                loan.add(loanCount, new PersonalLoan(loanType, loanAmount, tenure, roi, propertyValue,
                        loanDisposalDate, qualification, monthlySalary, workExperience, customer.get(i)));
                loan.get(loanCount).setLaonStatus(Loan1.LaonStatus.Pending);
                return loan.get(loanCount++).getLoanId();
            }

        }
        return 0;
    }

    @Override
    public String trackLoanStatus(int loanId) {
        String f;
        for (int i = 0; i < loanCount; i++) {
            if (loan.get(i).getLoanId() == loanId) {

                f = loan.get(i).getLaonStatus().toString();
                System.out.println(loan.get(i).getLoanId());
                return f;
            }
        }
        return "not found";

    }

    @Override
    public void approveRejectLoan(int loanId) {
        for (int i = 0; i < loanCount; i++) {
            if(loanId== loan.get(i).getLoanId()) {

                if (loan.get(i).getLoanAmount() > loan.get(i).getMaxEligibleLoanAmount()) {
                    loan.get(i).setLaonStatus(Loan1.LaonStatus.Approved);
                } else {
                    try {
                        loan.get(i).setLaonStatus(Loan1.LaonStatus.Rejected);
                        throw new LoanNotFoundException();

                    } catch (LoanNotFoundException e) {
                        System.out.println(e);
                    }

                }

                if(loan.get(i).getLoanType().equals("Vehicle"))
                {
                    VehicleLoan loans=(VehicleLoan)loan.get(i);
                    if (loans.calculateLoanToValueRatio() < .80)

                    {
                        loan.get(i).setLaonStatus(Loan1.LaonStatus.Rejected);
                    }
                }
                if(loan.get(i).getLoanType().equals("Home"))
                {
                    HomeLoan homeloan=(HomeLoan)loan.get(i);
                    if (homeloan.calculateLoanToValueRatio() < .80)
                    {
                        loan.get(i).setLaonStatus(Loan1.LaonStatus.Rejected);
                    }
                }

       /* if (loan.get(loanId).getLoanType().equals("Vehicle")  || loan.get(loanId).getLoanType() .equals("Home") ) {



           HomeLoan loans = (HomeLoan) loan.get(loanId);
            VehicleLoan loans1=(VehicleLoan) loan.get(loanId);

            if (loans.calculateLoanToValueRatio() < .80|| loans1.calculateLoanToValueRatio()<.80) {
                loan.get(loanId).setLaonStatus(Loan1.LaonStatus.Rejected);
            }
        } else {
            try {
                loan.get(loanId).setLaonStatus(Loan1.LaonStatus.Approved);
                throw new LoanNotFoundException();

            } catch (LoanNotFoundException e) {
                System.out.println(e);
            }

        }
*/

                if (loan.get(i).getLoanType() == "Personal") {
                    PersonalLoan loans = (PersonalLoan) loan.get(i);
                    if (((loans.getMonthlySalary()) * 12) > 500000) {
                        if (loans.getWorkExperience() > 5) {
                            loan.get(i).setLaonStatus(Loan1.LaonStatus.Rejected);
                        }

                    }
                } else {
                    try {
                        loan.get(i).setLaonStatus(Loan1.LaonStatus.Approved);
                        throw new LoanNotFoundException();

                    } catch (LoanNotFoundException e) {
                        System.out.println(e);
                    }

                }
                if (loan.get(i).customer.calculateDBR() > .40) {
                    loan.get(i).setLaonStatus(Loan1.LaonStatus.Rejected);
                } else {

                    try {
                        loan.get(i).setLaonStatus(Loan1.LaonStatus.Approved);
                        throw new LoanNotFoundException();

                    } catch (LoanNotFoundException e) {
                        System.out.println(e);
                    }
                }

            }
        }
    }

public CustomerLoan findCustomer(int CustomerId)
{
    boolean flag= false;
    int count=0;
    for(int i=0;i<loanCount;i++)
    {
        if(CustomerId== customer.get(i).getCustomerId()){


            flag= true;
            count++;
            break;

        }
    }
    if(flag== true)
    {
        return customer.get(count);
    }
    else
    {
        return null;
    }

}
    public void getAllActiveLoanDetails() {
        for (int i = 0; i < loanCount; i++) {
            if (loan.get(i).getLaonStatus() == "Approved") {
                System.out.println(loan.get(i).toString());
            }
        }
        System.out.println("Active laon");
    }


    @Override
    public boolean removeLoanAccount(int loanId) {
        boolean flag;
        flag = true;

        for (int i = 0; i < loanCount; i++) {
            if (loan.get(i).getLoanId() == loanId && loan.get(i).getLaonStatus().equals(Loan1.LaonStatus.Rejected)) {
                flag = true;
                break;
            }

            if (flag == true) {
                loan.remove(loan.get(i));
            }
        }
        return false;
    }



    public void getLoanDetails(int loanId)
    {
        for(int i=0;i<loanCount;i++) {

            if(loan.get(i).getLoanId()==loanId)

                System.out.println(loan.get(i).toString());

        }

        // System.out.println(true);
    }

  /*  boolean removeLoanAccoount(int loanAccountNumber)
    {
        return true;
    }*/


    public void loanDisbursal(int loanId)
    {
        for(int i=0;i<loanCount;i++) {

            if(loan.get(i).getLoanId()==loanId)
            {

                loan.get(i).setLaonStatus(Loan1.LaonStatus.Approved);
                double emi=loan.get(i).calculatEmi();

               LocalDate date = LocalDate.now();
               loan.get(i).setLoanDisposalDate(date);
                System.out.println(emi);
                System.out.println(loan.get(i).getLoanDisposalDate());


                loan.get(i).getLoanDisposalDate();
                loan.get(i).setLaonStatus(Loan1.LaonStatus.Approved);
                loan.get(i).generateRepaymentSchedule();
                LocalDate date1 = LocalDate.now();
                loan.get(i).setLoanDisposalDate(date1);
            }
        }
    }


    //singleton Pattern
    static  Bank b;
    static  Bank rebank()
    {
        if(b==null)
        {
            b=new Bank();
        }
        return b;
    }


}

