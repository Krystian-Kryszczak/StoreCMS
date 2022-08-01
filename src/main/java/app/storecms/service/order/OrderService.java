package app.storecms.service.order;

import app.storecms.model.shopping.basis.order.Order;
import app.storecms.model.shopping.basis.product.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.security.Principal;
import java.util.List;

public interface OrderService {
    Mono<Boolean> validateProducts(List<Product> list);
    Mono<Order> getOrderInfo(String id, Principal principal);
    Mono<String> submitOrder(Order order);
    Flux<Order> getOrders(Principal principal);
}