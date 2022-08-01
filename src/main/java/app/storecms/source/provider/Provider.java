package app.storecms.source.provider;

import app.storecms.model.shopping.basis.order.Order;
import app.storecms.model.shopping.basis.product.Product;
import app.storecms.service.provider.ProviderService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Data
public abstract class Provider {
    @SuppressWarnings("all")
    static @Autowired ProviderService providerService;
    private final String providerLabel;
    protected Provider(String providerLabel) {
        this.providerLabel = providerLabel;
        providerService.registerProvider(this);
    }
    public abstract Mono<Boolean> submitOrder(Order order);
    public Mono<Boolean> submitAllOrders(List<Order> orders) {
        return Flux.fromIterable(orders).flatMap(this::submitOrder).all(Boolean::booleanValue);
    }
    public abstract Mono<Boolean> validateProduct(Product product);
    public Mono<Boolean> validateProducts(List<Product> products) {
        return Flux.fromIterable(products).flatMap(this::validateProduct).all(Boolean::booleanValue);
    }
    public abstract Flux<Product> fetchProducts();
}