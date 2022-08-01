package app.storecms.service.order;

import app.storecms.model.shopping.basis.order.Order;
import app.storecms.model.shopping.basis.product.Product;
import app.storecms.service.provider.ProviderService;
import app.storecms.storage.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.security.Principal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepo;
    ProviderService providerService;
    public OrderServiceImpl(@Autowired OrderRepository orderRepo, @Autowired ProviderService providerService) {
        this.orderRepo = orderRepo;
        this.providerService = providerService;
    }
    // -------------------------------------------------- //
    public Mono<Boolean> validateProducts(List<Product> list) {
        return Flux.fromIterable(list)
                .flatMap(product -> providerService.getProviderByLabel(product.getProviderLabel()).validateProduct(product))
                .all(Boolean::booleanValue);
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