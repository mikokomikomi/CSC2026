
/**
 * Bank Account object constructor
 *
 * @author Miko Peszynski
 * @version V8 - 03/04/2026
 */
public class BankAccount
{
    private  String name;//the name of the customer who uses the account
    private  String accountNumber;// the account number of the customer who uses the account
    private  String address;// the address of the customer who uses the account
    private  String accountType;//The type of account it is. The types are Everyday, Savings, Current
    private  double balance;// the balance of the account

    /*
     * Constructor block
     **/
    public BankAccount (String name, String accountNumber, String address, String accountType, double balance){
        this.name = name;
        this.accountNumber = accountNumber;
        this.address = address;
        this.accountType = accountType;
        this.balance = balance;
    }

    /*
     * Getters block
     **/
    public String getName (){ //getter for the account's customer name
        return this.name;
    }

    public String getAccountNumber (){//getter for the account's account number
        return this.accountNumber;
    }

    public String getAddress (){//getter for the account's address
        return this.address;
    }

    public String getAccountType (){//getter for the account's type
        return this.accountType;
    }

    public double getBalance (){//getter for the account's balance
        return this.balance;
    }

    public String getAll (){//getter for all of the accounts values
        return this.name+";"+this.accountNumber+";"+this.address+";"+this.accountType+";"+String.valueOf(this.balance);
    }
    
    public double setBalance (double newBalance){//setter for account balance
    return this.balance = newBalance;
    }
}
