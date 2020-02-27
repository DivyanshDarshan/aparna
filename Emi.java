package originalbank;

import java.util.Date;

public class Emi {

    double emiAmount;
    Date emiDueDate;
    String status;
    double principalComponent;
    double interestAmount;
    double penaltyCharges;

    enum Emistatus {paid,unpaid}


    public Emistatus getEmistatus() {
        return emistatus;
    }

    public void setEmistatus(Emistatus emistatus) {
        this.emistatus = emistatus;
    }

    Emistatus emistatus;


    public double getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(double emiAmount) {
        this.emiAmount = emiAmount;
    }

    public Date getEmiDueDate() {
        return emiDueDate;
    }

    public void setEmiDueDate(Date emiDueDate) {
        this.emiDueDate = emiDueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrincipalComponent() {
        return principalComponent;
    }

    public void setPrincipalComponent(double principalComponent) {
        this.principalComponent = principalComponent;
    }

    public double getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(double interestAmount) {
        this.interestAmount = interestAmount;
    }

    public double getPenaltyCharges() {
        return penaltyCharges;
    }

    public void setPenaltyCharges(double penaltyCharges) {
        this.penaltyCharges = penaltyCharges;
    }


}
