package DesignPatterns.FactoryDP;

public class FactoryDemo {

    public static void main(String[] args) {

        Payment p1 = PaymentFactory.getPayment("UPI");
        p1.pay();

        Payment p2 = PaymentFactory.getPayment("CARD");
        p2.pay();
    }
}
