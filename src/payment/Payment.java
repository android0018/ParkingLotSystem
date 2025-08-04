package payment;

public class Payment {
    private double amount;
    private PaymentStrategy paymentStrategy;
    public Payment(double amount,PaymentStrategy paymentStrategy){
        this.amount=amount;
        this.paymentStrategy=paymentStrategy;
    }

    public void paymentProcess(){
        if(amount<=0){
            System.out.println("Invalid payment amount");
        }
        else{
            paymentStrategy.processPayment(amount);
        }
    }
}
