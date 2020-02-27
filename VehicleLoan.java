package originalbank;

import java.time.LocalDate;


public class VehicleLoan extends SecuredLoan {
    String vehicleCategory;
    String vehicleModelNo;
    String manufacturer;

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public String getVehicleModelNo() {
        return vehicleModelNo;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    int yearOfManufacture;
    double assetValue;

    public VehicleLoan(String loanType, double loanAmount, int tenure, double roi, double monthlySalary,
                       LocalDate loanDisposalDate, CustomerLoan customer, String vehicleCategory, String vehicleModelNo,
                       String manufacturer, int yearOfManufacture, double assetValue,double propertyValue) {
        super(  loanType,  loanAmount,  tenure, roi,  monthlySalary,
                loanDisposalDate, customer, propertyValue);
        this.vehicleCategory = vehicleCategory;
        this.vehicleModelNo = vehicleModelNo;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.assetValue = assetValue;
    }

    @Override
    public double calculateLoanToValueRatio() {
        return 0;
    }
}