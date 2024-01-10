package design.patterns.adaptor;

import design.patterns.adaptor.thirdparty.YesBankAPI;

public class YesBankAPIAdaptor implements BankAPIAdaptor {

    private YesBankAPI yesBankAPI = new YesBankAPI();

    @Override
    public void sendMoney(String fromAccount, String toAccount, double amount) {
        yesBankAPI.transferMoney(fromAccount, toAccount, amount);
    }

    @Override
    public void register(String phoneNumber) {
        yesBankAPI.registerAccount(phoneNumber);
    }

    @Override
    public double checkBalance(String accountNumber) {
        return yesBankAPI.getBalance(accountNumber);
    }
}
