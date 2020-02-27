package originalbank;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public  abstract class Loan1 {

    private  int loanId;
    private static int Id=0;
    String loanType;
    double loanAmount;
    int tenure;
    double roi;

    double emipermonth;

    public double getMonthlyExpenses() {
        return monthlyExpenses;
    }

    public void setMonthlyExpenses(double monthlyExpenses) {
        this.monthlyExpenses = monthlyExpenses;
    }

    double monthlyExpenses;

    public void setLoanDisposalDate(LocalDate loanDisposalDate) {
        this.loanDisposalDate = loanDisposalDate;
    }

    LocalDate loanDisposalDate;
    double maxEligibleLoanAmount;
    int repaymentFrequency;

    public CustomerLoan getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerLoan customer) {
        this.customer = customer;
    }

    CustomerLoan customer;
    private double propertyValue;

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    private double monthlySalary;


    public double getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(double propertyValue) {
        this.propertyValue = propertyValue;
    }

    enum LaonStatus{
        Approved,Pending,Rejected,Closed
    }

    public String getLaonStatus() {
        return laonStatus.toString();
    }

    public void setLaonStatus(LaonStatus laonStatus) {
        this.laonStatus = laonStatus;
    }

    private  LaonStatus laonStatus;





    public int getLoanId() {

        return  loanId;
    }

    public String getLoanType() {
        return loanType;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public int getTenure() {
        return tenure;
    }

    public double getRoi() {
        return roi;
    }

    public double getEmipermonth() {
        return emipermonth;
    }

    public LocalDate getLoanDisposalDate() {
        return loanDisposalDate;
    }

    public double getMaxEligibleLoanAmount() {
        return maxEligibleLoanAmount;
    }

    public int getRepaymentFrequency() {
        return repaymentFrequency;
    }



    public Loan1(String loanType, double loanAmount, int tenure, double roi,double monthlySalary,
                 LocalDate loanDisposalDate,CustomerLoan customer,double propertyValue)
    {


        this.loanId=++Id;
        this.loanType=loanType;
        this.loanAmount=loanAmount;
        this.tenure=tenure;
        this.roi=roi;
        this.emipermonth=calculatEmi();
        this.loanDisposalDate=loanDisposalDate;
        this.customer=customer;
        this.monthlySalary=monthlySalary;
        this.propertyValue=propertyValue;
    }

    public static int getId() {
        return Id;
    }
    @Override
    public String toString() {
        return "Loan1{" +
                "loanId=" + loanId +
                ", loanType='" + loanType + '\'' +
                ", loanAmount=" + loanAmount +
                ", tenure=" + tenure +
                ", roi=" + roi +
                ", emipermonth=" + emipermonth +
                ", loanDisposalDate=" + loanDisposalDate +
                ", maxEligibleLoanAmount=" + maxEligibleLoanAmount +
                ", repaymentFrequency=" + repaymentFrequency +
                ", customer=" + customer +
                ", laonStatus=" + laonStatus +
                '}';
    }



    double calculatEmi ()
    {
        int numberOfPayment=12;
        int RV=0;
        double Q = loanAmount * (roi*(.01) / numberOfPayment) - (RV * (roi *.01/ numberOfPayment)) / Math.pow(1 + (roi*.01 / numberOfPayment), tenure);

        double R = (1 - (1 / Math.pow(1 + (roi *.01/ numberOfPayment), tenure)));

        double emiPerMonth = Math.round(Q / R);

        return emiPerMonth;

    }
    void generateRepaymentSchedule()
    {  while(loanAmount>0)
    {

        double In = ( loanAmount * (roi ) * (1.0 / 12));
        double Pn = emipermonth - In;
        System.out.println("Principal Component " + Math.round(Pn));
        loanAmount=loanAmount-Pn;

        System.out.println("Interest Component " + Math.round(In));

     }
    }

    double calculateLatePenalty (LocalDate currentDate)
    {
        return .02*emipermonth*(Math.abs(currentDate.get(ChronoField.DAY_OF_MONTH)-loanDisposalDate.get(ChronoField.DAY_OF_MONTH)));
    }

    double maxEligibleLoanAmount (double MaxEMi)
    {
        double maxEligibleLoanAmount =Math.round (MaxEMi* ((Math.pow((1 + roi), tenure)) - 1) / (roi * (Math.pow((1 + roi), tenure))));
        return maxEligibleLoanAmount
                ;

    }
    public double calculateLoanToValueRatio() {
        double ltv;
        double PropertyAmount =propertyValue;
        ltv=(loanAmount/PropertyAmount);

        return ltv;
    }

    public double Dbr()
    {
        double dbr;
        double Expenses= monthlyExpenses;
        double monthlyIncome=monthlySalary;

        dbr=Expenses/monthlyIncome;
        return  dbr;

    }



}



