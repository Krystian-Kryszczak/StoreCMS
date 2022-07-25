package app.storecms.service.order;

import app.storecms.model.shopping.basis.order.Order;
import app.storecms.model.shopping.basis.product.Product;
import app.storecms.storage.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.security.Principal;
import java.util.List;

@Service
public class OrderService {
    OrderRepository orderRepo;
    public OrderService(@Autowired OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }
    // -------------------------------------------------- //
    public boolean validateProducts(List<Product> list) {
        // TODO validation
        return false;
    }
    public Mono<Order> getOrderInfo(String id, Principal principal) {
        return orderRepo.findFirstByIdAndOwnerName(id, principal.getName());
    }
    public Mono<String> submitOrder(Order order) {
        return orderRepo.save(order).map(Order::getId);
    }
    public Flux<Order> getOrders(Principal principal) {
        return orderRepo.findAllByOwnerName(principal.getName());
    }
}