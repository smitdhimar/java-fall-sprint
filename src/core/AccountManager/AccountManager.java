package core.AccountManager;

class Account {
    static int accountNumberCounter = 0;
    private String name;
    private float amount = 0;
    private int accountNumber = 0;
    private int age;
    private String ssnNumber;

    Account(String name, float amount, int age, String ssnNumber)
    {
        this.name = name;
        this.amount = amount;
        this.age = age;
        this.ssnNumber = ssnNumber;
        this.accountNumber = ++accountNumberCounter;
    }
    float setAmount(float num){
        this.amount += num;
        return this.amount;
    }
    float getAmount(){
        return this.amount;
    }
}

public class AccountManager {
    Account createAccount(String name, float initialAmount, int age, String ssnNumber) {
        Account acc = new Account(name, initialAmount, age, ssnNumber);
        return acc;
    }

//    AccountManager(){
//        pass;
//    }

    float depositAmount(Account account, float amount) {
        float updatedAmount = account.setAmount(amount);
        return updatedAmount;
    }

    boolean withdrawAmount(String accountNumber, float amount) {
        return true;
    }

    public static void main(String[] args) {
        AccountManager accManager = new AccountManager();
        Account acc = accManager.createAccount("Smit Dhimar",  0, 21,  "999-99-9089");
        accManager.depositAmount(acc, 450);
    }
}
