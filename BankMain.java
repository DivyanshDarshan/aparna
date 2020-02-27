package originalbank;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

public class BankMain {
    public static void main(String[] args) throws IOException {

        BankFactory bf=new BankFactory();
        Checker c=bf.rebank();
        Maker m=bf.rebank();
     /*   Bank b=new Bank();
        b.Logger();*/

        int uniqueCustomerId=m.registerCustomer("101","Shameel",LocalDate.of(1997,9,30),"9005915049",
                "s@gjash", 35000, "Engineer",30000,
                "Manager","Nucleus");
        System.out.println(uniqueCustomerId);


        int LoanId=m.applyLoan(1,"Vehicle",LocalDate.of(2021,4,12),12000,12,5000,50000,
                12,.08,"HashBack","HashBack12","Ford",2016,50000,40000);
        System.out.println("Vehicle Loan Id = "+LoanId+  "CustomerId = "+uniqueCustomerId);



        int uniqueCustomerId2=m.registerCustomer("101","Shameel",LocalDate.of(2020,1,3),"9005915049",
                "s@gjash", 35000, "Engineer",30000,
                "Manager","Nucleus");
        LoanId=m.applyLoan(1,"Vehicle",LocalDate.of(2021,4,12),12000,12,5000,50000,
                12,.08,"HashBack","HashBack12","Ford",2016,50000,40000);
        System.out.println("Home Loan Id  "+LoanId+  " CustomerId = "+uniqueCustomerId2);


        int uniqueCustomerId3=m.registerCustomer("101","Shameel",LocalDate.of(2020,1,3),"9005915049",
                "s@gjash", 35000, "Engineer",30000,
                "Manager","Nucleus");
        LoanId=m.applyLoan("Personal",1,2000,5,.08,1200,50000,LocalDate.of(2019,12,12),"Engg",50000.5,5);
        System.out.println("PersonalLoan  "+LoanId+  "  CustomerId = "+uniqueCustomerId3);

      System.out.println( m.trackLoanStatus(1));


       m.getLoanDetails(2);


        m.getAllActiveLoanDetails();

        c.approveRejectLoan(1);

        m.trackLoanStatus(1);



/*
      bank.loggerData();
       m.loanDisbursal(1);

        CustomerLoan customerLoan = new CustomerLoan("Ali","Shameel",LocalDate.of(2020,4,3),"90059421","hasdgs@123",42148,"IT",7000,"India","Nucleus");

        System.out.println( c.findCustomer(8));*/
    }
}
