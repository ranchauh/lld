package design.patterns.adaptor.phonepe.thirdparty;

public class YesBankAPI {
    public void transferMoney(String fromAccount, String toAccount, double amount) {
        System.out.println("Transferring " + amount + " from account: " + fromAccount + " to account: " + toAccount);
    }
    public void registerAccount(String phoneNumber) {
        System.out.println("Register account with phone: "  + phoneNumber);
    }
    public double getBalance(String accountNumber){
        System.out.println("Checking Balance of :  " + accountNumber);
        return 0.0;
    }
}
