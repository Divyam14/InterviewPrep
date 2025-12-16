package DesignPatterns.FactoryDP;

public class UpiPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Payment done with upi payment");
    }
}
