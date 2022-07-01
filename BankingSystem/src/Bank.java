public class Bank {
    private  double interestRate=8.5;
    private  double transaction=10;
    private Customer[] customers= new Customer[1000]; // Object array. A bank has many customers


    // ask which customer
    //get the customer's account
    // get the account's balance
    // calculate interest amount on that balance and show the user what can be their total
    // you need to find which customer are you going to find interest for

    public  void calculateInterest(Customer customer){
     Account a= customer.getAccount();
     double bal=a.getBalance();
     double interestAmount=bal*interestRate/100;
     double totalBalance=bal+interestAmount;
        System.out.println("Interest amount: " +interestAmount
        + " Total money after adding interest rates: "+ totalBalance);
    }

    public Customer[] getCustomers(){
        return customers;
    }

    public double getInterest(){
        return interestRate;
    }

    public double getTranscationFee(){

        return transaction;
    }




}
