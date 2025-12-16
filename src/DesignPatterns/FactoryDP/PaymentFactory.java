package DesignPatterns.FactoryDP;

public class PaymentFactory {

    public static Payment getPayment(String type){
        if("CARD".equalsIgnoreCase(type)){
            return new CardPayment();
        }else if("UPI".equalsIgnoreCase(type)){
            return new UpiPayment();
        }
        throw  new IllegalArgumentException("Invalid payment type");
    }
}
