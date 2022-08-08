package app.storecms.service.payment;

import app.storecms.exception.PaymentNotFoundException;
import app.storecms.model.shopping.basis.payment.Payment;
import app.storecms.model.shopping.basis.product.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public Mono<String> createPayment(List<Product> products, List<String> discountCodes) {
        return Mono.empty(); // TODO
    }
    @Override
    public Mono<String> getPaymentUrl(String paymentId) throws PaymentNotFoundException {
        return Mono.empty(); // TODO
    }
    @Override
    public Mono<String> paymentHasBeenPaid(String paymentId) throws PaymentNotFoundException {
        return Mono.empty(); // TODO
    }
    @Override
    public Mono<Payment> getPayment(String paymentId) throws PaymentNotFoundException {
        return Mono.empty(); // TODO
    }
}