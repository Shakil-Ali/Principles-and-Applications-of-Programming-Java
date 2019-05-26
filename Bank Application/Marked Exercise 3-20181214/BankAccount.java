
public class BankAccount {

	protected String id;
	protected double balance;
	
	
	public BankAccount(String id, double balance) {

		this.id = id;
		this.balance = balance;
	}


	public String getId() {
		return id;
	}


	public double getBlance() {
		return balance;
	}
   
	public void deposit(double amount) {
		this.balance+=amount ;
	}
	public boolean withdraw(double amount) {
		this.balance -= amount;
		return true;
	}

	public String toString() {
		return "BankAccount [id=" + id + ", balance=" + balance + "]";
	}

}
