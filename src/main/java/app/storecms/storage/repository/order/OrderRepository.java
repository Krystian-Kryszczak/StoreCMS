package app.storecms.storage.repository.order;

import app.storecms.model.shopping.basis.order.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface OrderRepository extends ReactiveCrudRepository<Order, String> {
    Mono<Order> findFirstByIdAndOwnerName(String id, String ownerName);
    Flux<Order> findAllByOwnerName(String ownerName);
}