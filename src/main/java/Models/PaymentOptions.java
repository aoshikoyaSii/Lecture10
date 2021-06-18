package Models;

import java.util.Random;

public enum PaymentOptions {
    payByBankWire, payByCheck;

    public static PaymentOptions getSelectedPaymentOptions(){
       return values()[new Random().nextInt(values().length)];
    }

}
