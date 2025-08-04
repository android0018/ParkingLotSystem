package payment;

public class CreditCardPayment implements PaymentStrategy{
    @Override
    public void processPayment(double amount){
        System.out.println("Processing payment using Card of $"+ amount);
    }
}
