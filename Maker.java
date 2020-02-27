package originalbank;



import java.time.LocalDate;

public interface Maker {

    int applyLoan(int customerId, String loanType, LocalDate loanDisposalDate,
                  double maxEligibleLoanAmount, int repaymentFrequency, double loanAmount,double monthlySalary,
                  int tenure, double roi,  String vehicleCategory,   String vehicleModelNo,
                  String manufacturer, int yearOfManufacture, double assetValue,double propertyValue);

    public int applyLoan(int customerId, String loanType, LocalDate loanDisposalDate, double maxEligibleLoanAmount,
                         int repaymentFrequency, double loanAmount, int tenure, double roi,
                         double monthlySalary, String builderName, int propertySize, double propertyValue);

    public int applyLoan(String loanType,int customerId, double loanAmount, int tenure, double roi,  double emipermonth,double propertyValue,
                         LocalDate loanDisposalDate,String qualification,double monthlySalary,double workExperience);


    int registerCustomer(String name, String newName, LocalDate newDate, String contactNumber, String emailAddress, double monthlyIncome,
                         String profession, double totalmonthlyExpenses, String designation, String companyName);

    public String trackLoanStatus(int id);

    public void getAllActiveLoanDetails();

    public void  getLoanDetails(int loanId);

    public void loanDisbursal(int loanId);

}
