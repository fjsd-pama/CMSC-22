import java.lang.*;

/**
* Created by Arniel Pama, 09/13/16;
*/

public class Account{

	private int accountNumber;
	private double balance = 0.0;

	public Account( int accountNumber, int balance ){
		setBalance(balance);
	}

	public Account( int accountNumber ){

	}

	public int getAccountNumber(){
		return this.accountNumber;
	}

	public double getBalance(){
		return this.balance;
	}

	public void setBalance( double balance ){
		if ( balance < 0 ){
			throw new IllegalArgumentException("Negative balance is not allowed!");
		}

		this.balance = balance;
	}

	public void credit( double amount ){
		if ( amount < 0 ){
			throw new IllegalArgumentException("Negative amount not allowed!");
		}

		this.balance += amount;
	}

	public void debit( double amount ){
		if ( this.balance >= amount ){
			this.balance -= amount;
		} else{
			System.out.printf("amount withdrawn exceeds the current balance!\n");
		}
	}

	public String toString( ){
		return String.format("A/C no: %d, Balance=$%.2f", getAccountNumber(), getBalance());
	}
}