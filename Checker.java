package originalbank;

public interface Checker {

    public void approveRejectLoan(int loanId);

    public void getAllActiveLoanDetails();

    public void  getLoanDetails(int loanId);

    public boolean removeLoanAccount(int loanId);

   public abstract CustomerLoan findCustomer(int CustomerId);



}
