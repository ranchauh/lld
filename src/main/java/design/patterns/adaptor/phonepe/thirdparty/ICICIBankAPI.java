package design.patterns.adaptor.phonepe.thirdparty;

public class ICICIBankAPI {
    public void sendMoney(double amount, String fromAccount, String toAccount) {
        System.out.println("Transferring " + amount + " from account: " + fromAccount + " to account: " + toAccount);
    }
    public void createAccount(String phoneNumber) {
        System.out.println("Register account with phone: "  + phoneNumber);
    }
    public double viewBalance(String accountNumber){
        System.out.println("Checking Balance of :  " + accountNumber);
        return 0.0;
    }
}
