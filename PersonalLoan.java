package originalbank;

import java.time.LocalDate;

public class PersonalLoan extends UnSecuredLoan {
    public String getQualification() {
        return Qualification;
    }

    String Qualification;
    double workExperience;


    public PersonalLoan(String loanType, double loanAmount, int tenure, double roi,double propertyValue,
                        LocalDate loanDisposalDate,String qualification,double monthlySalary,double workExperience,CustomerLoan customer) {
        super(   loanType,  loanAmount, tenure,  roi,   loanDisposalDate,
                propertyValue,monthlySalary ,customer);
        Qualification = qualification;
        this.workExperience = workExperience;
    }

    public double getWorkExperience() {
        return workExperience;
    }
}
