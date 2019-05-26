import java.util.*;

public class SavingAccount extends BankAccount{

	public SavingAccount(String id, double initialBalance) {
		super(id, initialBalance);
		if(initialBalance>=1000) this.balance +=10;
		
	}

  public boolean withdraw(double amount) {
        double fund= this.balance-amount - 3;
     if(fund < 10) {
    	 System.out.println("not enough fund available to withdraw " + amount);
    	   return false;
    	 }
     else { 

    	    this.balance = fund;
    	    System.out.println("the transaction was successful");
    	    return true;
     }
}
 public double addInterest(double interestRate) {
	  double interest = balance * interestRate / 100;
	  balance = balance + interest;
	  return interest;  
  }
 
 public static void main(String args[]) {
	BankAccount acc1 = new SavingAccount("s1", 1000);
	BankAccount acc2 = new SavingAccount("s2", 100);
	 System.out.println(acc1.toString());
	 System.out.println(acc2.toString());
	 acc1.deposit(50);
	 acc2.withdraw(50);
	 System.out.println(acc1.toString());
	 System.out.println(acc2.toString());
	 ((SavingAccount)acc1).addInterest(10);
	 System.out.println(acc1.toString());
	 
	 
	 
 }
}
