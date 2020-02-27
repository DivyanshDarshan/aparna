package originalbank;

import java.time.LocalDate;

public class CustomerLoan {


        private  int  customerId;
        private static int Id=0;
        private String customerName;
        private LocalDate date;
        private String contactNumber;
        private String emailAddress;
        private double monthlyIncome;
        private String Profession;
        private double totalmonthlyExpenses;
        private String designation;
        private String companyName;





        CustomerLoan(String name, String newName, LocalDate newDate, String contactNumber, String emailAddress, double monthlyIncome,
                     String profession, double totalmonthlyExpenses, String designation, String companyName) {
            customerId=++Id;
            this.customerName = newName;
            this.date = newDate;
            this.contactNumber = contactNumber;
            this.emailAddress = emailAddress;
            this.monthlyIncome = monthlyIncome;
            this.Profession = profession;
            this.totalmonthlyExpenses = totalmonthlyExpenses;
            this.designation = designation;
            this.companyName = companyName;
        }

        public static int getId() {
            return Id;
        }


        public String getCustomerName() {
            return customerName;
        }

        public int getCustomerId() {
            return customerId;
        }

        public LocalDate getDate() {
            return date;
        }

        public String getContactNumber() {
            return contactNumber;
        }

        public String emailAddress() {
            return emailAddress;
        }

        public double getMonthlyIncome() {
            return monthlyIncome;
        }

        public String getProfession() {
            return Profession;
        }

        public double getTotalmonthlyExpensesn() {
            return totalmonthlyExpenses;
        }

        public String getdesignation() {
            return designation;
        }

        public String getCompanyName() {
            return companyName;
        }


        double  calculateDBR() {
            double Dbr = totalmonthlyExpenses / monthlyIncome;
            return Dbr;

            // System.out.println(Dbr);

        }

        double calculateMaxEligibleEMI(double r,double t)
        {
            double Dbr = totalmonthlyExpenses / monthlyIncome;
            double dbr = Dbr*.20;
            double deductedsal = monthlyIncome - dbr;
            double E = deductedsal - (.5 * monthlyIncome);
            double Emi = E * ((Math.pow((1 + r), t)) - 1) / (r * (Math.pow((1 + r), t)));

            return Emi;
        }
    }

