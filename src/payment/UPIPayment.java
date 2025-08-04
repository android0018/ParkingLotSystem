package payment;

public class UPIPayment implements PaymentStrategy{
    @Override
    public void processPayment(double amount){
        System.out.println("Processing payment using UPI Payment of $"+amount);
    }
}
