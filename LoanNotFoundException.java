package originalbank;


    public class LoanNotFoundException extends Exception
    {
        @Override
        public String getMessage()
        {
            return "Rejected";
        }
    }


