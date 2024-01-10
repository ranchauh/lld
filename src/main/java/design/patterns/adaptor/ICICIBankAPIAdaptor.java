package design.patterns.adaptor;

import design.patterns.adaptor.thirdparty.ICICIBankAPI;

public class ICICIBankAPIAdaptor implements BankAPIAdaptor {

    private ICICIBankAPI iciciBankAPI = new ICICIBankAPI();

    @Override
    public void sendMoney(String fromAccount, String toAccount, double amount) {
        iciciBankAPI.sendMoney(amount, fromAccount, toAccount);
    }

    @Override
    public void register(String phoneNumber) {
        iciciBankAPI.createAccount(phoneNumber);
    }

    @Override
    public double checkBalance(String accountNumber) {
        return iciciBankAPI.viewBalance(accountNumber);
    }
}
