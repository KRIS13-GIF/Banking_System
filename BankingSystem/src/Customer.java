
public class Customer {

   private String name;
    private Account account;

    public Customer(String n, Account a){
        name=n;
        account=a;

    }

public void display(){
    System.out.println("Name: "+ name+ " , Account number: "+ account.getNr()+"," +
            " Balance: "+account.getBalance());


}

public String getName(){

    return name;
}

public Account getAccount(){
        return account;

}

}


