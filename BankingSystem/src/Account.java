public class Account {
    private double balance=100; // this is by default
    private String account_nr;
    private boolean firstTime=true;

    public Account(String acc_nr){
        account_nr=acc_nr;

    }

    public Account(double bal, String acc_nr){ // the amount should be 100 or more. It is not allowed for a balance to be les than 100
        if (bal>100){
            balance=bal;
        }
        else{
            balance=100;
        }
        account_nr=acc_nr;
    }


    public String getNr(){
        return account_nr;
    }


  // if you add positive values, you can deposit. if you add negative values , you are not able to deposit
  public void deposit(double howMuch){
        if (howMuch>0){
            balance=balance+howMuch;
            System.out.println(howMuch + " is successfully deposited");
            System.out.println("The new balance in you account is: " + balance);
        }
        else{
            System.err.println("Enter a positive value! ");
        }
  }

  public void withdraw(double howMuch){
        //howMuch->ask the user how much money are you going to withdraw
        //if it is the first time of withdrawal (check), do not apply fee
        // if the money is negative you can not perform the transaction

        /*
        * if money is positive
        *   check if the amount of money after withdrawal remains 100 or more
        *   if yes, remove the money, else tell the user insufficent balance*/
        // ensure that the balance stays at 100, no matter how much you are going to remove

      if (howMuch>=0){ // check if the money is positive
          if (firstTime==true){ // check if it is the first time

              double tempBalance=balance;
              /*
              * Let  us say that Balance is 200 and also is temp
              *if howMuch is 50, then we execute 200-50=150. Thisvalue is allowed*/
              tempBalance=tempBalance-howMuch;
              if (tempBalance>=100){ // check if the remaining balance is >=100
                    balance=balance-howMuch; // or you can do balance=tempBalance
                  System.out.println("You have withdrawn $"+ howMuch +
                          "and you balance now is $"+ balance);

              }
              else{
                  System.err.println("Insufficent balance to remove $ "+ howMuch );
              }
              firstTime=false; // we have performed the first transaction , so you need to add also the transaction fees next time

          }

          // once the firsttime is turned to false, the other times that withdrawal is got called , it will
          // execute the else statement

          else{
              Bank bank=new Bank(); // we create the Bank Object in order to get the transaction fee
              double tempBalance=balance;
              tempBalance=tempBalance-howMuch-bank.getTranscationFee();
              if (tempBalance>=100){ // check if the remaining balance is >=100
                  balance=balance-howMuch-bank.getTranscationFee(); // or you can do balance=tempBalance
                  System.out.println("Your balance is $" +balance + " and the transcationfee is $ "+ bank.getTranscationFee());

              }
              else{
                  System.err.println("Insufficent balance to remove $ "+ howMuch );
              }

          }
      }
      else {
          System.err.println("Do not enter negative values !");
      }

  }

  public double getBalance(){
        return balance;

  }


}

