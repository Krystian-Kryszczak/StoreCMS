package app.storecms.service.payment;

import app.storecms.exception.PaymentNotFoundException;
import app.storecms.model.shopping.basis.payment.Payment;
import app.storecms.model.shopping.basis.product.Product;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PaymentService {
    Mono<String> createPayment(List<Product> products, List<String> discountCodes);
    Mono<String> getPaymentUrl(String paymentId) throws PaymentNotFoundException;
    Mono<String> paymentHasBeenPaid(String paymentId) throws PaymentNotFoundException;
    Mono<Payment> getPayment(String paymentId) throws PaymentNotFoundException;
}