package payment;

public class CashPayment implements PaymentStrategy{
    @Override
    public void processPayment(double amount){
        System.out.println("Processing payment using cash payment of $" + amount);
    }
}
