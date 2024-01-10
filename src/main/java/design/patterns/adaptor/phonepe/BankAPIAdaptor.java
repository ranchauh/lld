package design.patterns.adaptor.phonepe;

public interface BankAPIAdaptor {
    void sendMoney(String fromAccount, String toAccount, double amount);
    void register(String phoneNumber);
    double checkBalance(String accountNumber);
}
