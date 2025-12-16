package DesignPatterns.FactoryDP;

public class CardPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Payment done with card payment");
    }
}
