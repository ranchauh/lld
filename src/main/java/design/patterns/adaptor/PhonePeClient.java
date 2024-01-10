package design.patterns.adaptor;

public class PhonePeClient {
    public static void main(String[] args) {
        BankAPIAdaptor bankAPIAdaptor = new YesBankAPIAdaptor();
        bankAPIAdaptor.register("9898999");
        bankAPIAdaptor.checkBalance("1238909sd");
        bankAPIAdaptor.sendMoney("2398u89lkll", "12398lkjsdf", 100);
        bankAPIAdaptor.checkBalance("1238909sd");
    }
}
