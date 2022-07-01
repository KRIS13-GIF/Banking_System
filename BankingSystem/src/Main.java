import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press any number to open the menu except 6(exit the program): ");
        int choice = scanner.nextInt();
        Bank bank = new Bank(); // we need this object in order to invoke the array
        int numberOfCustomers = 0;
        Customer[] c = bank.getCustomers();
        while (true) {
            menu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    /*
                     * Ask the amount of money the person wants to deposit
                     * Asks the person to enter th Account number
                     * Create the Account Object that contains the money and the account number
                     * Ask the customer's name and create the customer object with that name and use
                     * the account object created above
                     * Add this newly created customer to the list of customers the bank has
                     * Print the details of the newly added customer */

                    System.out.println("Creating a new account for a new customer: ");
                    System.out.println("Please enter the initial amount in your account: ");
                    double bal = scanner.nextDouble();
                    System.out.println("Please enter your account number: ");
                    String accNr = scanner.next();

                    for (int i = 0; i < numberOfCustomers; i++) {
                        Account temp = c[i].getAccount();
                        String accTemp = temp.getNr();
                        while (accTemp.equals(accNr)) {
                            System.out.println("Enter a new account number please");
                            accNr = scanner.next();

                        }
                    }
                    Account account = new Account(bal, accNr);
                    System.out.println("Please enter your name: ");
                    String name = bufferedReader.readLine();
                    Customer customer = new Customer(name, account); // Customer object
                    c[numberOfCustomers] = customer; // insert in the array   c[0]=customer
                    numberOfCustomers++; // increases the   [++]   c[1]
                    System.err.println("Number of customers " + numberOfCustomers);
                    for (int i = 0; i < numberOfCustomers; i++) {
                        System.err.println(c[i].getName() + " NAME");
                    }
                    break;


                case 2:
                    System.out.println("Enter account number: ");
                    accNr = bufferedReader.readLine();
                    if (numberOfCustomers == 0) {
                        System.out.println("Account number not found");
                    } else {
                        boolean found = false;
                        for (int i = 0; i < numberOfCustomers; i++) {
                            Account temp = c[i].getAccount();
                            String accTemp = temp.getNr();
                            if (accTemp.equals(accNr)) {
                                System.out.println("Please enter the amount for deposit: ");
                                double money = scanner.nextDouble();
                                temp.deposit(money);
                                found = true;
                            }

                        }
                        if (found == false) {
                            System.err.println("Account Number not found");
                        }
                    }
                    break;


                case 3:
                    System.out.println("Enter account number: ");
                    accNr = bufferedReader.readLine();
                    if (numberOfCustomers == 0) {
                        System.out.println("Account number not found");
                    } else {
                        boolean found = false;
                        for (int i = 0; i < numberOfCustomers; i++) {
                            Account temp = c[i].getAccount();
                            String accTemp = temp.getNr();
                            if (accTemp.equals(accNr)) {
                                System.out.println("Please enter the amount to withdraw: ");
                                double money = scanner.nextDouble();
                                temp.withdraw(money);
                                found = true;
                            }

                        }
                        if (found == false) {
                            System.err.println("Account Number not found");
                        }
                    }
                    break;


                case 4:
                    System.out.println("Enter the Account number: ");
                    String acc = scanner.next();
                    for (int i = 0; i < numberOfCustomers; i++) {
                        Account temp = c[i].getAccount(); // each element of the array inherits the properties of the Account class
                        String accTemp = temp.getNr();
                        if (accTemp.equals(acc)) {
                            double temp2 = temp.getBalance(); // use a temporary variable only for retrieving info
                            System.out.println(temp2);
                        }
                    }
            break;

            case 5:
                System.out.println("Enter the Account number: ");
                String accr = scanner.next();
                for (int i = 0; i < numberOfCustomers; i++) {
                    Account temp = c[i].getAccount(); // each element of the array inherits the properties of the Account class
                    String accTemp = temp.getNr(); // this one takes the =account number properties and uses it for checking
                    if (accTemp.equals(accr)) {
                        bank.calculateInterest(c[i]);
                    }
                }
                break;
            case 6:
                System.exit(0);
                break;
            default:
                break;
        }
    }


}






    public static void menu(){
        System.out.println("Please enter your choice: ");
        System.out.println("1: Add Customer");
        System.out.println("2: Deposit Money");
        System.out.println("3: Withdraw money");
        System.out.println("4: Check balance");
        System.out.println("5: Calculate interest rates");
        System.out.println("6 Exit");
    }


}
