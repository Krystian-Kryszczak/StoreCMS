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
    public Mono<Boolean> submitOrder(Order order) {
        return Mono.just(false); // TODO
    }
    public Mono<Boolean> validateProducts(List<Product> list) {
        return null; // TODO
    }
    public Flux<Product> fetchProducts() {
        return null; // TODO
    }
}