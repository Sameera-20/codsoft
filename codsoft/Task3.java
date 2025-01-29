//ATM INTERFACE


import java.util.Scanner;

class bankAccount 
{
    private double balance;
    public bankAccount(double initialBalance)
    {
        this.balance = initialBalance;
    }
    public void deposit(double amount)
    {
        if (amount>0) 
        {
            balance+=amount;
            System.out.println("Successfully deposited: "+amount);
        } 
        else
        {
            System.out.println("Invalid deposit amount.");
        }
    }
    public boolean withdraw(double amount)
    {
        if (amount<=balance && amount>0)
        {
            balance-=amount;
            System.out.println("Successfully withdraw: "+amount);
            return true;
        } 
        else if (amount<=0)
        {
            System.out.println("Invalid withdrawal amount.");
            return false;
        } 
        else
        {
            System.out.println("Insufficient funds. Current balance: "+balance);
            return false;
        }
    }
    public double getBalance()
    {
        return balance;
    }
}
class ATM 
{
    private bankAccount acct;
    public ATM(bankAccount account) 
    {
        this.acct = account;
    }
    public void showMenu() 
    {
        Scanner s = new Scanner(System.in);
        int ch;
        do 
        {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your option: ");
            ch= s.nextInt();
            switch (ch) 
            {
                case 1:System.out.print("Enter amount to withdraw: ");
                       double withdrawAmt = s.nextDouble();
                       acct.withdraw(withdrawAmt);
                       break;
                case 2:System.out.print("Enter amount to deposit: ");
                       double depositAmt= s.nextDouble();
                       acct.deposit(depositAmt);
                       break;
                case 3:System.out.println("Current balance: " + acct.getBalance());
                       break;
                case 4:System.out.println("Thank You!");return;
                default:System.out.println("Invalid option.Please try again.");
            }
        } while (ch!= 4);
    }
}

class Task3 
{
    public static void main(String args[])
    {
        Scanner s1 = new Scanner(System.in);
        System.out.print("Enter initial balance for the account: ");
        double initialBalance = s1.nextDouble();
        bankAccount userAccount = new bankAccount(initialBalance);
        ATM atm = new ATM(userAccount);
        atm.showMenu();
    }
}
