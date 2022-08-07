package app.storecms.model.shopping.basis.order;

import app.storecms.model.shopping.basis.product.ProductStack;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Document(collation = "orders")
public class Order {
    @Id @Getter
    final String id;
    @Getter
    final String ownerId; // required
    final List<ProductStack> productsList;
    public Order(String id, String ownerId) {
        this.id = id;
        this.ownerId = ownerId;
        this.productsList = new ArrayList<>();
    }
    public Flux<ProductStack> getItems() {
        return Flux.fromIterable(productsList);
    }
    public Mono<ProductStack> addItem(ProductStack item) {
        return productsList.add(item) ? Mono.just(item) : Mono.empty();
    }
    public Mono<ProductStack> removeItem(ProductStack item) {
        return productsList.remove(item) ? Mono.just(item) : Mono.empty();
    }
}