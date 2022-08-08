package app.storecms.exception;

public class PaymentNotFoundException extends NotFoundException {
    public PaymentNotFoundException(String paymentId) {
        super("Payment with ID \"" + paymentId + "\" not found!");
    }
}