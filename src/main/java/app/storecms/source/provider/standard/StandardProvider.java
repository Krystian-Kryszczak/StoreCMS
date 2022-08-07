package app.storecms.source.provider.standard;

import app.storecms.model.shopping.basis.order.Order;
import app.storecms.model.shopping.basis.product.Product;
import app.storecms.source.provider.Provider;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class StandardProvider extends Provider {
    protected StandardProvider() {
        super("standard");
    }
    @Override
    public Mono<Boolean> submitOrder(Order order) {
        return Mono.just(false);
    }
    @Override
    public Mono<Boolean> validateProduct(Product product) {
        return Mono.just(false); // TODO
    }
    @Override
    public Flux<Product> fetchProducts() {
        return Flux.empty();
    }
}